package com.example.sideraljourney;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.ExecutionException;
import android.content.SharedPreferences;
import android.widget.Toast;


public class UserFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user, container, false);
        init(rootView);

        Button logOutButton = rootView.findViewById(R.id.log_out_btn);

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteSharedPreferences();
                getActivity().finish();
                startActivity(new Intent(getActivity(), Login.class));
            }
        });


        return rootView;
    }

    private void init(View rootView){
        TextView user_tv = rootView.findViewById(R.id.user_user);
        TextView name_tv = rootView.findViewById(R.id.user_name);
        TextView lastname_tv = rootView.findViewById(R.id.user_lastname);
        TextView country_tv = rootView.findViewById(R.id.user_country);
        TextView city_tv = rootView.findViewById(R.id.user_city);
        TextView height_tv = rootView.findViewById(R.id.user_height);
        TextView weight_tv = rootView.findViewById(R.id.user_weight);
        TextView born_tv = rootView.findViewById(R.id.user_born);

        User myUser = getMyUser();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formatedDate = dateFormat.format(myUser.getUser_born());


        name_tv.setText(myUser.getUser_name());
        user_tv.setText(myUser.getUser_user());
        lastname_tv.setText(myUser.getUser_lastname());
        country_tv.setText(myUser.getUser_country());
        city_tv.setText(myUser.getUser_city());
        height_tv.setText(myUser.getUser_height().toString());
        weight_tv.setText(myUser.getUser_weight().toString());
        born_tv.setText(formatedDate.toString());
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

    private String getSavedUser() {
        SharedPreferences prefs = getActivity().getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
        return prefs.getString("USER", null);
    }

    private User getMyUser(){

        User newUser = new User();

        List<User> users = getUsers();

        String savedUser = getSavedUser();

        for (User user: users){
            if(user.getUser_user().equals(savedUser)){
                newUser = user;
            }
        }
        return newUser;
    }

    private void deleteSharedPreferences(){
        SharedPreferences prefs = getActivity().getSharedPreferences("LOGIN", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.remove("USER");
        editor.remove("PASSWORD");
        editor.apply();
    }
}