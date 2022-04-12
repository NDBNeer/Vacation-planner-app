package com.ndb345.touristplaces;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;

public class PlacesAdapter extends BaseAdapter {
    private ArrayList<Places> data;
    private LayoutInflater inflater;//we need it to connect with the list_row.xml
    private Context mContext;

    public PlacesAdapter(Context context, ArrayList<Places> data)
    {
        this.data=data;
        inflater=LayoutInflater.from(context);
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null)
        {
            view=inflater.inflate(R.layout.list_detail,null);
            holder=new ViewHolder();
            holder.plc_name=view.findViewById(R.id.plc_name);
            holder.desc=view.findViewById(R.id.desc);
            holder.cost=view.findViewById(R.id.cost);
            holder.place_img=view.findViewById(R.id.place_img);
            holder.more=view.findViewById(R.id.more);
            view.setTag(holder);
        }
        else
        holder=(ViewHolder) view.getTag();
        holder.plc_name.setText(data.get(i).getName());
        holder.desc.setText(data.get(i).getDescription());
        holder.cost.setText(String.valueOf(data.get(i).getLiving_cost()));
        holder.place_img.setImageResource(data.get(i).getImage1());
        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii=new Intent(mContext,DetailActivity.class);
                ii.putExtra("name",data.get(i).getName());
                ii.putExtra("desc",data.get(i).getDescription());
                ii.putExtra("cost",data.get(i).getLiving_cost());
                ii.putExtra("category",data.get(i).getCategory());
                ii.putExtra("images",data.get(i).getImage());
                mContext.startActivity(ii);
            }
        });
        return view;
    }
    static class ViewHolder{
        private TextView plc_name,desc,cost;
        private ImageView place_img;
        private Button more;
    }
}
