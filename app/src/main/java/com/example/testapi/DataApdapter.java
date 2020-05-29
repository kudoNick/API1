package com.example.testapi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.adapters.AdapterViewBindingAdapter;
import androidx.fragment.app.Fragment;

import com.example.testapi.RestApi.Main2Activity;

import java.util.List;

public class DataApdapter extends BaseAdapter {


    List<Data> dataList;
    Context context;

    public DataApdapter(List<Data> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.data,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Data data = (Data) getItem(position);

        viewHolder.tvName.setText(data.getName());
        viewHolder.tvUserName.setText(data.getUserName());
        viewHolder.tvGmail.setText(data.getEmail());

        viewHolder.tvStreet.setText(data.getStreet());
        viewHolder.tvCity.setText(data.getCity());

        return convertView;
    }



    private class ViewHolder{
        TextView tvName,tvUserName,tvStreet,tvCity,tvGmail;
        public ViewHolder(View convertView) {
            tvName = convertView.findViewById(R.id.tvName);
            tvUserName = convertView.findViewById(R.id.tvUserName);
            tvStreet = convertView.findViewById(R.id.tvStreet);
            tvCity = convertView.findViewById(R.id.tvCity);
            tvGmail = convertView.findViewById(R.id.tvGmail);
        }
    }
}
