package com.ndb345.touristplaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String countrylist[]={"All","India","Canada","New York","USA"};
    ArrayList<Places> plclist=new ArrayList<>();
    ArrayList<Places>tempList=new ArrayList<>();
    public static ArrayList<String>bookedplace=new ArrayList<>();
    public static ArrayList<Double>bookedcost=new ArrayList<>();
    public static ArrayList<String>bookedno=new ArrayList<>();
    Spinner country;
    ListView places;
    ImageView cart;
    //Button addplace;
    EditText visitorno,budget;
    public static Places obj;
    String plcTitle;
    int index;
    double cst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();
        fillData();
        ArrayAdapter aa1=new ArrayAdapter(this, R.layout.myspin,countrylist);
        country.setAdapter(aa1);
        places.setAdapter(new PlacesAdapter(this,plclist,index));
      //  addplace.setOnClickListener(this);
        cart.setOnClickListener(this);
        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    index=0;
                    places.setAdapter(new PlacesAdapter(MainActivity.this,plclist,index));
                }
                else {
                    fillTemp(countrylist[i]);
                    places.setAdapter(new PlacesAdapter(MainActivity.this,tempList,index));
                    index=i;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        places.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(index==0)
                {
                    plcTitle=plclist.get(i).getName();
                    cst=plclist.get(i).getLiving_cost();
                    Log.d("cst1",String.valueOf(cst));}
                else
                {
                    plcTitle=tempList.get(i).getName();
                    cst=tempList.get(i).getLiving_cost();
                    Log.d("cst2",String.valueOf(cst));
                }
            }
        });
    }
    private void findId() {
        country=findViewById(R.id.country);
        places=findViewById(R.id.places);
        cart=findViewById(R.id.cart);
        budget=findViewById(R.id.budget);
        visitorno=findViewById(R.id.visitorno);
      //  addplace=findViewById(R.id.addplace);
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
        ArrayList<Integer> i1=new ArrayList<>();
        i1.add(R.drawable.tajmahal);
        i1.add(R.drawable.t1);
        i1.add(R.drawable.t2);

        ArrayList<Integer> i2=new ArrayList<>();
        i2.add(R.drawable.delhi);
        i2.add(R.drawable.i1);
        i2.add(R.drawable.i2);

        ArrayList<Integer> i3=new ArrayList<>();
        i3.add(R.drawable.goldtemple);
        i3.add(R.drawable.g1);
        i3.add(R.drawable.g2);

        ArrayList<Integer> i4=new ArrayList<>();
        i4.add(R.drawable.cntower);
        i4.add(R.drawable.c1);
        i4.add(R.drawable.c2);

        ArrayList<Integer> i5=new ArrayList<>();
        i5.add(R.drawable.niagarafalls);
        i5.add(R.drawable.n1);
        i5.add(R.drawable.niagarafalls);

        ArrayList<Integer> i6=new ArrayList<>();
        i6.add(R.drawable.statue);
        i6.add(R.drawable.s1);
        i6.add(R.drawable.statue);

        ArrayList<Integer> i7=new ArrayList<>();
        i7.add(R.drawable.stevenframe);
        i7.add(R.drawable.stevenframe);
        i7.add(R.drawable.stevenframe);

        plclist.add(new Places(countrylist[1],"Taj Mahal","The Taj Mahal is an ivory-white marble mausoleum on the right bank of the river Yamuna in the Indian city of Agra. It was commissioned in 1632 by the Mughal",R.drawable.tajmahal,i1,10000.00));
        plclist.add(new Places(countrylist[1],"India Gate","The India Gate is a war memorial located astride the Rajpath, on the eastern edge of the \"ceremonial axis\" of New Delhi",R.drawable.delhi,i2,15000.00));
        plclist.add(new Places(countrylist[1],"Gold Temple","The Golden Temple is a gurdwara located in the city of Amritsar, Punjab, India. ",R.drawable.goldtemple,i3,30000.00));
        plclist.add(new Places(countrylist[2],"CN Tower","On the shores of Lake Ontario in Canada's biggest city is the iconic CN Tower, one of Canada's most famous landmarks.",R.drawable.cntower,i4,150000.00));
        plclist.add(new Places(countrylist[2],"Niagra Falls","Niagara Falls is Canada's most famous natural attraction, bringing in millions of visitors each year.",R.drawable.niagarafalls,i5,200000.00));
        plclist.add(new Places(countrylist[3],"Statue of Liberty","New York City is like no other city in the world, and one that must be experienced to be fully appreciated.",R.drawable.statue,i6,500000.00));
        plclist.add(new Places(countrylist[4],"Steven Frame","Perhaps the most unmistakably American landmark is Mount Rushmore, a national memorial located in South Dakota. ",R.drawable.stevenframe,i7,600000.00));
    }

    @Override
    public void onClick(View view) {
        /*if (view.getId()==R.id.addplace)
        {
            if(visitorno.getText().toString().isEmpty())
                visitorno.setError("Enter Visitor's number");
            else visitorno.setError(null);

            if (budget.getText().toString().isEmpty())
                budget.setError("Enter your budget");
            else
            {
                Log.d("cst",String.valueOf(cst));
                if(Integer.parseInt(budget.getText().toString()) > cst)
                    budget.setError("Your budget is exceed");
                else
                    budget.setError(null);
            }

           // obj=verify(plc_name.getText().toString());
            if (bookedplace.contains(plcTitle))
                Toast.makeText(getBaseContext(),"You've already added this place",Toast.LENGTH_LONG).show();
            else
            {
                 bookedplace.add(plcTitle);
                 bookedcost.add(cst);
                 bookedno.add(visitorno.getText().toString());
            }
        }*/
        if (view.getId()==R.id.cart)
        {
            Intent intent=new Intent(this, BookedPlaceActivity.class);
            startActivity(intent);
        }

    }
    //method to fill the temp list upon the given topic
    public void fillTemp(String topic)
    {
        tempList.clear();//empty the list
        for(Places bk:plclist)
            if(bk.getCategory().equals(topic))
                tempList.add(bk);
    }
}