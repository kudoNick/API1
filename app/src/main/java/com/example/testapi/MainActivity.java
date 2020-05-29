package com.example.testapi;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.example.testapi.RestApi.Main2Activity;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView lvData;
    Button btnLoadData;
    DataApdapter dataApdapter;
    List<Data> dataList;
    ProgressBar process;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        getData();


        //button loadData
//        btnLoadData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getData();
//
//            }
//        });
        lvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Data data = (Data) dataApdapter.getItem(position);
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("id",data.getId());
                System.out.println("click 2");
                startActivity(intent);
            }
        });
    }

    public void getData(){
        System.out.println("click 1");
        dataList = new ArrayList<>();
        dataApdapter = new DataApdapter(dataList, this);
        AndroidNetworking.get("https://jsonplaceholder.typicode.com/users")
                .setTag("data")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("DATA",response.toString());
                        for (int i = 0; i <response.length() ; i++) {
                            try {
                                process.setVisibility(View.GONE);
                                Data data = new Data(response.getJSONObject(i));
                                dataList.add(data);
                                lvData.setAdapter(dataApdapter);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    @Override
                    public void onError(ANError anError) {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    private void anhXa(){
        lvData = findViewById(R.id.lvData);
        btnLoadData = findViewById(R.id.btnLoadData);
        process = findViewById(R.id.progress);
    }
}
