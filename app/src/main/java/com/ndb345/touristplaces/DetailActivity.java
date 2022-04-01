package com.ndb345.touristplaces;

import static com.ndb345.touristplaces.MainActivity.obj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    ImageView place_img;
    TextView plc_name,desc;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        place_img=findViewById(R.id.place_img);
        plc_name=findViewById(R.id.plc_name);
        desc=findViewById(R.id.desc);
        back=findViewById(R.id.back);
        place_img.setImageResource(MainActivity.obj.getImage());
        plc_name.setText(MainActivity.obj.getName());
        desc.setText(MainActivity.obj.getDescription());
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailActivity.this,MainActivity.class));
            }
        });
    }
}