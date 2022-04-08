package com.ndb345.touristplaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String countrylist[]={"India","Canada","New York","USA"};
    ArrayList<Places> plclist=new ArrayList<>();
    ArrayList<Places>tempList=new ArrayList<>();
    ArrayList<String>tempNames=new ArrayList<>();
    Spinner country,places;
    ImageView place_img,cart;
    TextView plc_name,desc,cost;
    Button more,addplace;
    EditText visitorno,budget;
    public static Places obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        country=findViewById(R.id.country);
        places=findViewById(R.id.places);
        place_img=findViewById(R.id.place_img);
        plc_name=findViewById(R.id.plc_name);
        desc=findViewById(R.id.desc);
        more=findViewById(R.id.more);
        cost=findViewById(R.id.cost);
        cart=findViewById(R.id.cart);
        budget=findViewById(R.id.budget);
        visitorno=findViewById(R.id.visitorno);
        addplace=findViewById(R.id.addplace);
        fillData();
        fillTemp(countrylist[0]);
        ArrayAdapter aa1=new ArrayAdapter(this, R.layout.myspin,countrylist);
        country.setAdapter(aa1);
        ArrayAdapter aa2=new ArrayAdapter(this, R.layout.myspin,tempNames);
        places.setAdapter(aa2);
        country.setOnItemSelectedListener(new SpinnerAction());
        places.setOnItemSelectedListener(new SpinnerAction());
        more.setOnClickListener(this);
        addplace.setOnClickListener(this);
    }

    public Places verify(String name)
    {
        for(Places prs:plclist)
            if(name.equalsIgnoreCase(prs.getName()))
                return prs;
        return null;
    }
    public void fillData()
    {
        plclist.add(new Places(countrylist[0],"Taj Mahal","The Taj Mahal is an ivory-white marble mausoleum on the right bank of the river Yamuna in the Indian city of Agra. It was commissioned in 1632 by the Mughal",R.drawable.tajmahal,10000.00));
        plclist.add(new Places(countrylist[0],"India Gate","The India Gate is a war memorial located astride the Rajpath, on the eastern edge of the \"ceremonial axis\" of New Delhi",R.drawable.delhi,15000.00));
        plclist.add(new Places(countrylist[0],"Gold Temple","The Golden Temple is a gurdwara located in the city of Amritsar, Punjab, India. ",R.drawable.goldtemple,30000.00));
        plclist.add(new Places(countrylist[1],"CN Tower","On the shores of Lake Ontario in Canada's biggest city is the iconic CN Tower, one of Canada's most famous landmarks.",R.drawable.cntower,150000.00));
        plclist.add(new Places(countrylist[1],"Niagra Falls","Niagara Falls is Canada's most famous natural attraction, bringing in millions of visitors each year.",R.drawable.niagarafalls,200000.00));
        plclist.add(new Places(countrylist[2],"Statue of Liberty","New York City is like no other city in the world, and one that must be experienced to be fully appreciated.",R.drawable.statue,500000.00));
        plclist.add(new Places(countrylist[2],"Steven Frame","Perhaps the most unmistakably American landmark is Mount Rushmore, a national memorial located in South Dakota. ",R.drawable.stevenframe,600000.00));

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.more)
        {
            obj=verify(plc_name.getText().toString());
            Intent i=new Intent(MainActivity.this,DetailActivity.class);
            startActivity(i);
        }
        else
        {
            if(visitorno.getText().toString().isEmpty())
                visitorno.setError("Enter Visitor's number");
            else visitorno.setError(null);

             if (budget.getText().toString().isEmpty())
                budget.setError("Enter your budget");
            else
             { if(Integer.parseInt(budget.getText().toString()) < Integer.parseInt(cost.getText().toString()))
                 budget.setError("Your budget is exceed");
                else
                    budget.setError(null);
             }
        }

    }

    private class SpinnerAction implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            if(adapterView.equals(country))
            {
                fillTemp(countrylist[i]);
                ArrayAdapter aa2=new ArrayAdapter(MainActivity.this, R.layout.myspin,tempNames);
                places.setAdapter(aa2);
            }
            else if(adapterView.equals(places))
            {
                plc_name.setText(String.valueOf(tempList.get(i).getName()));
                place_img.setImageResource(tempList.get(i).getImage());
                desc.setText(String.valueOf(tempList.get(i).getDescription()));
                cost.setText(String.valueOf(tempList.get(i).getLiving_cost()));
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }
    //a method to refill the temp list upon the category
    public void fillTemp(String cat)
    {
        tempList.clear();//remove all items in the temp list
        tempNames.clear();
        for(Places prd:plclist)
            if(prd.getCategory().equals(cat)) {
                tempList.add(prd);
                tempNames.add(prd.getName());
            }
    }
}