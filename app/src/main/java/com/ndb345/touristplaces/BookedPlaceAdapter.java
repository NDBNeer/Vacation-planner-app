package com.ndb345.touristplaces;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class BookedPlaceAdapter extends BaseAdapter {
    private ArrayList<BookedPlaceList> data;
    private LayoutInflater inflater;//we need it to connect with the list_row.xml

    public BookedPlaceAdapter(Context context, ArrayList<BookedPlaceList> data)
    {
        this.data=data;
        inflater=LayoutInflater.from(context);
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
            view=inflater.inflate(R.layout.bookedplace_list,null);
            holder=new ViewHolder();
            holder.title=view.findViewById(R.id.plc_name);
            holder.noofvisitors=view.findViewById(R.id.noofvisitors);
            holder.cost=view.findViewById(R.id.cost);
            holder.delete=view.findViewById(R.id.btnDelete);
            view.setTag(holder);
        }
        else
            holder=(ViewHolder) view.getTag();
            holder.title.setText(data.get(i).getName());
            holder.cost.setText(String.valueOf(data.get(i).getLiving_cost()));
            holder.noofvisitors.setText(data.get(i).getNovisitors());
            holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.remove(i);
                notifyDataSetChanged();
            }
        });
        return view;
    }
    static class ViewHolder{
        private TextView title,noofvisitors,cost;
        private ImageButton delete;
    }
}
