package com.example.sideraljourney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Login extends AppCompatActivity {

    Button buttonLogin;
    EditText val_user_name, val_user_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonLogin = findViewById(R.id.buttonLogin);
        val_user_name = findViewById(R.id.editTextUsername);
        val_user_password = findViewById(R.id.editTextPassword);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Código que se ejecutará cuando se haga clic en el botón
                APIRequest apiRequest = new APIRequest();
                List<User> users = null;

                try {
                    users = apiRequest.execute().get();
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                if(existUser(users)){
                    for (User user : users) {
                        if(user.getUser_name().equals(val_user_name.getText().toString())){
                            if(val_user_password.getText().toString().equals(user.getUser_password())){
                                startActivity(new Intent(Login.this, MainActivity.class));
                            }else{
                                Toast.makeText(Login.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                            }
                        }

                        //Log.d("Usuario", "Nombre de usuario: " + usuario.getUser_name() + "Contraseña: " + usuario.getUser_password());
                    }
                }else{
                    Toast.makeText(Login.this, "User Doesn't Exist", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean existUser(List<User> users){
        for(User user : users){
            if(user.getUser_name().equals(val_user_name.getText().toString())){
                return true;
            }
        }
        return false;
    }
}