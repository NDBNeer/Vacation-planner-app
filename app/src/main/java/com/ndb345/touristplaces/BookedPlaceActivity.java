package com.ndb345.touristplaces;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class BookedPlaceActivity extends AppCompatActivity {
    ListView lv;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoppingcart);
        lv=findViewById(R.id.lv);
        back=findViewById(R.id.back);
        lv.setAdapter(new BookedPlaceAdapter(this,PlacesAdapter.bpl));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BookedPlaceActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}