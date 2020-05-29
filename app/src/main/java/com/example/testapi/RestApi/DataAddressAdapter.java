package com.example.testapi.RestApi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testapi.R;

import java.util.ArrayList;
import java.util.List;

public class DataAddressAdapter extends BaseAdapter {
    List<DataAddress> dataAddressList;
    Context context;
    private boolean isChecks = false;
    List<DataPlus> dataPlusList;
    DataPlusAdapter dataPlusAdapter;
    public DataAddressAdapter(List<DataAddress> dataAddressList, Context context) {
        this.dataAddressList = dataAddressList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataAddressList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataAddressList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Viewholer viewholer;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.dataaddress, parent, false);
            viewholer = new Viewholer(convertView);
            convertView.setTag(viewholer);
        }else {
            viewholer = (Viewholer) convertView.getTag();
        }
        DataAddress dataAddress = (DataAddress) getItem(position);
        viewholer.tvStreet.setText(dataAddress.getStreet());
        viewholer.tvCity.setText(dataAddress.getCity());


//        viewholer.line1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!isChecks){
//                    viewholer.lvDataPlus.setVisibility(View.VISIBLE);
//                    isChecks = true;
//                }else {
//                    viewholer.lvDataPlus.setVisibility(View.GONE);
//                    isChecks = false;
//                };
//            }
//        });


        dataPlusList = new ArrayList<>();
        dataPlusAdapter = new DataPlusAdapter(dataPlusList, context);
        final DataPlus dataPlus = new DataPlus();
        for (int i = 0; i <5 ; i++) {
            dataPlus.setHomeTow("Việt nam");
            dataPlusList.add(dataPlus);
        }
        viewholer.lvDataPlus.setAdapter(dataPlusAdapter);
        viewholer.line1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dataPlus.ischeck){
                    viewholer.lvDataPlus.setVisibility(View.VISIBLE);
                    dataPlus.ischeck = false;
                }else {
                    viewholer.lvDataPlus.setVisibility(View.GONE);
                    dataPlus.ischeck = true;
                }
            }
        });

        return convertView;
    }


    private class Viewholer {
        TextView tvStreet,tvCity;
        ListView lvDataPlus;
        LinearLayout line1;
        public Viewholer(View convertView) {
            tvStreet = convertView.findViewById(R.id.tvStreet);
            tvCity = convertView.findViewById(R.id.tvCity);
            lvDataPlus = convertView.findViewById(R.id.lvDataPlus);
            line1 = convertView.findViewById(R.id.line1);
        }
    }
}
