package com.example.testapi.RestApi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.testapi.R;

import java.util.List;

public class DataPlusAdapter extends BaseAdapter {
    List<DataPlus> dataPlusList;
    Context context;

    TextView tvHomeTow;
    public DataPlusAdapter(List<DataPlus> dataPlusList, Context context) {
        this.dataPlusList = dataPlusList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataPlusList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataPlusList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.dataplus, parent, false);

        tvHomeTow = view.findViewById(R.id.tvHomeTow);
        DataPlus dataPlus = (DataPlus) getItem(position);

        tvHomeTow.setText(dataPlus.getHomeTow());
        return view;
    }
}
