

package com.example.zendetta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zendetta.Interface.api;
import com.example.zendetta.Model.loginModel;
import com.example.zendetta.Model.patientModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Console;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    EditText editTextPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = findViewById(R.id.btnLogin);
        editTextPhone = findViewById(R.id.editTextPhone);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editTextPhone.getText().equals("")){
                    try {
                        login();
                    }catch (Exception t){
                        Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }else{

                }
            }
        });
    }

    private void login(){
        Gson gson = new GsonBuilder().setLenient().create();

        OkHttpClient okHttpClient = new OkHttpClient();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
        api api = retrofit.create(api.class);

        Call<loginModel> call = api.LoginStatus();

        call.enqueue(new Callback<loginModel>() {
            @Override
            public void onResponse(Call<loginModel> call, Response<loginModel> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "gagal", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent mtintent = new Intent(LoginActivity.this, SideBarActivity.class);
                mtintent.putExtra("id")
                startActivity(mtintent);
                finish();
            }

            @Override
            public void onFailure(Call<loginModel> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }



}