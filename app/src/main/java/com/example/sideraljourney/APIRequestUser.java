package com.example.sideraljourney;

import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class APIRequestUser extends AsyncTask<Void, Void, List<User>> {
    private String apiUrl = "http://siderealjourney.online/user_show.php";

    @Override
    protected List<User> doInBackground(Void... voids) {
        List<User> users = null;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(apiUrl)
                .build();
        try {
            Response response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();

            if (response.isSuccessful() && responseBody != null) {
                String json = responseBody.string();
                Type listType = new TypeToken<List<User>>() {}.getType();
                users = new Gson().fromJson(json, listType);
            } else {
                System.out.println("ERROR DESCONOCIDO");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }
}
