package com.ndb345.touristplaces;

import static com.ndb345.touristplaces.MainActivity.obj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
   // ImageView place_img;
    ViewPager viewPage;
    TextView plc_name,desc,costt;
    Button back,addplace;
    ImageView cart;
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
        addplace=findViewById(R.id.addplace);
        cart=findViewById(R.id.cart);
        Intent i=getIntent();
        name=i.getStringExtra("name");
        idesc=i.getStringExtra("desc");
        cost=i.getStringExtra("cost");
       // Log.d("costcost",cost);
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
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DetailActivity.this, BookedPlaceActivity.class);
                startActivity(intent);
            }
        });
        addplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (PlacesAdapter.bookedplace.contains(name))
                    Toast.makeText(DetailActivity.this,"You've already added this place",Toast.LENGTH_LONG).show();
                else
                {
                    PlacesAdapter.bookedplace.add(name);
                    Log.d("costtt",cost);
                    PlacesAdapter.bookedcost.add(Double.parseDouble(cost));
                    // bookedno.add(visitorno.getText().toString());
                }
            }
        });

    }
}