package com.example.sideraljourney;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.ExecutionException;


import android.content.SharedPreferences;


public class Login extends AppCompatActivity {

    Button buttonLogin;
    EditText val_user_user, val_user_password;

    String val_user_user_text, val_user_password_text;

    List<User> users = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (!NetworkUtils.isNetworkAvailable(this)) {
            showAdvise();
        } else {
            buttonLogin = findViewById(R.id.buttonLogin);
            val_user_user = findViewById(R.id.editTextUsername);
            val_user_password = findViewById(R.id.editTextPassword);
            users = getUsers();

            session();

            buttonLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    val_user_user_text = val_user_user.getText().toString();
                    val_user_password_text = val_user_password.getText().toString();

                    if(existUser(users, val_user_user_text)){
                        for (User user : users) {
                            if(user.getUser_user().equals(val_user_user_text)){
                                if(val_user_password_text.equals(user.getUser_password())){
                                    savePassword(val_user_password_text);
                                    saveUser(val_user_user_text);
                                    finish();
                                    startActivity(new Intent(Login.this, MainActivity.class));
                                }else{
                                    Toast.makeText(Login.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }else{
                        Toast.makeText(Login.this, "User Doesn't Exist", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void showAdvise() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("You have no connection!")
                .setMessage("This application uses internet connection. Please try later")
                .setCancelable(false)
                .setPositiveButton("Close APP", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        finish();
                    }
                })
                .show();
    }


    private List<User> getUsers(){
        APIRequestUser apiRequest = new APIRequestUser();
        List<User> users = null;

        try {
            users = apiRequest.execute().get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return users;
    }


     public boolean existUser(List<User> users, String miniUser) {
        return users.stream()
                .anyMatch(user -> user.getUser_user().equals(miniUser));
    }

    private void savePassword(String pass){
        SharedPreferences.Editor editor = getSharedPreferences("LOGIN", Context.MODE_PRIVATE).edit();
        editor.putString("PASSWORD", pass );
        editor.apply();
    }

    private void saveUser(String user){
        SharedPreferences.Editor editor = getSharedPreferences("LOGIN", Context.MODE_PRIVATE).edit();
        editor.putString("USER", user);
        editor.apply();
    }

    private boolean isPasswordSaved() {
        SharedPreferences prefs = getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        return prefs.contains("PASSWORD");
    }

    private boolean isUserSaved() {
        SharedPreferences prefs = getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        return prefs.contains("USER");
    }

    private String getSavedPassword() {
        SharedPreferences prefs = getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        return prefs.getString("PASSWORD", null);
    }

    private String getSavedUser() {
        SharedPreferences prefs = getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        return prefs.getString("USER", null);
    }

    private void session(){
        if (isUserSaved() && isPasswordSaved()) {
            String savedUser = getSavedUser();
            String savedPassword = getSavedPassword();
            if(existUser(users, savedUser)){
                for (User user : users) {
                    if(user.getUser_user().equals(savedUser)){
                        if(savedPassword.equals(user.getUser_password())){
                            finish();
                            startActivity(new Intent(Login.this, MainActivity.class));
                        }
                    }
                }
            }
            finish();
        }
    }
}