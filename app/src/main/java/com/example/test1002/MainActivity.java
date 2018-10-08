package com.example.test1002;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    TextView textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setRetrofit();
    }

    private void init(){
        textView = findViewById(R.id.text1);
        textView2 = findViewById(R.id.text2);
        textView3 = findViewById(R.id.text3);

    }

    private void setRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.hansei.us/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final ApiService apiService = retrofit.create(ApiService.class);
        Call<TestRepo> call = apiService.ApiService();
        call.enqueue(new Callback<TestRepo>() {

            @Override
            public void onResponse(Call<TestRepo> call, Response<TestRepo> response) {
                try {
                Log.d("logtest","OK");
                String Date = response.body().getDate();
                String Menu = response.body().getMenu();
                String Day = response.body().getDay();


                textView.setText(Date);
                textView2.setText(Menu);
                textView3.setText(Day);

                }catch (Exception e){
                    Log.d("OR", "Error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<TestRepo> call, Throwable t) {
                Log.e("Error", t.getMessage());
                textView.setText("Fail Sever Connect");
            }
        });

    }
}
