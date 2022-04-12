package com.ndb345.touristplaces;

import static com.ndb345.touristplaces.MainActivity.obj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
   // ImageView place_img;
    ViewPager viewPage;
    TextView plc_name,desc,costt;
    Button back;
    String name,idesc,cost,category;
    ArrayList<Integer> imag=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
       // place_img=findViewById(R.id.place_img);
        viewPage=findViewById(R.id.viewPage);
        plc_name=findViewById(R.id.plc_name);
        desc=findViewById(R.id.desc);
        costt=findViewById(R.id.cost);
        back=findViewById(R.id.back);
        Intent i=getIntent();
        name=i.getStringExtra("name");
        idesc=i.getStringExtra("desc");
        cost=i.getStringExtra("cost");
        category=i.getStringExtra("category");
        imag=i.getIntegerArrayListExtra("images");
        ImageAdapter adapterView = new ImageAdapter(this,imag);
        viewPage.setAdapter(adapterView);

//      place_img.setImageResource(MainActivity.obj.getImage());
        plc_name.setText(category+" - "+name);
        desc.setText(idesc);
        costt.setText(cost);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailActivity.this,MainActivity.class));
            }
        });
    }
}