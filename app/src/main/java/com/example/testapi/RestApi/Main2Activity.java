package com.example.testapi.RestApi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.testapi.R;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    TextView textView;
    ListView lvDataAddress;
    ProgressBar progress;
    List<DataAddress> dataAddressList;
    DataAddressAdapter dataAddressAdapter;
    String url = "https://jsonplaceholder.typicode.com/users/";
    String url1;
    boolean icheckd = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lvDataAddress = findViewById(R.id.lvDataAddress);
        textView = findViewById(R.id.tuananh);
        progress = findViewById(R.id.progress);
        Intent intent = getIntent();
        int a = intent.getIntExtra("id",0);
        final String b = String.valueOf(a);
        url1 = url +b;
        dataAddressList = new ArrayList<>();
        dataAddressAdapter = new DataAddressAdapter(dataAddressList, this);
        getdata();



    }

    private void getdata(){

        AndroidNetworking.get(url1)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        for (int i = 0; i <response.length() ; i++) {
                            progress.setVisibility(View.GONE);
                            DataAddress dataAddress = new DataAddress(response);
                            dataAddressList.add(dataAddress);
                            lvDataAddress.setAdapter(dataAddressAdapter);
                        }
                    }
                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(Main2Activity.this, "that bai", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
