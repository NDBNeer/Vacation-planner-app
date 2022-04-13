package com.ndb345.touristplaces;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Stack;

public class PlacesAdapter extends BaseAdapter {
    private ArrayList<Places> data;
    private LayoutInflater inflater;//we need it to connect with the list_row.xml
    private Context mContext;
    String plcTitle;
    int index;
    double cst;
    public static ArrayList<String>bookedplace=new ArrayList<>();
    public static ArrayList<Double>bookedcost=new ArrayList<>();
    public static ArrayList<BookedPlaceList> bpl=new ArrayList<>();

    public PlacesAdapter(Context context, ArrayList<Places> data,int index)
    {
        this.data=data;
        inflater=LayoutInflater.from(context);
        this.mContext = context;
        this.index = index;
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
            holder.addplace=view.findViewById(R.id.addplace);
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
                Log.d("costy",String.valueOf(data.get(i).getLiving_cost()));
                Intent ii=new Intent(mContext,DetailActivity.class);
                ii.putExtra("name",data.get(i).getName());
                ii.putExtra("desc",data.get(i).getDescription());
                ii.putExtra("cost",String.valueOf(data.get(i).getLiving_cost()));
                ii.putExtra("category",data.get(i).getCategory());
                ii.putExtra("images",data.get(i).getImage());
               // ii.putExtra("images",data.get(i).getImage1());
                mContext.startActivity(ii);
            }
        });
        holder.addplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if(index==0)
                {*/
                    plcTitle=data.get(i).getName();
                    cst=data.get(i).getLiving_cost();
                    Log.d("cst1",String.valueOf(cst));

                    if (bookedplace.contains(plcTitle))
                    Toast.makeText(mContext,"You've already added this place",Toast.LENGTH_LONG).show();
                    else
                    {
                        bpl.add(new BookedPlaceList(cst,plcTitle,index));
                        bookedplace.add(plcTitle);
                        //bookedcost.add(cst);
                       // bookedno.add(visitorno.getText().toString());
                    }

            //}
               /* else
                {
                    plcTitle=tempList.get(i).getName();
                    cst=tempList.get(i).getLiving_cost();
                    Log.d("cst2",String.valueOf(cst));
                }*/
            }
        });
        return view;
    }
    static class ViewHolder{
        private TextView plc_name,desc,cost;
        private ImageView place_img;
        private Button more,addplace;
    }
}
