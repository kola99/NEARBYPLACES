package kola.com.nearbyplaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class listfrag extends AppCompatActivity {GetNearbyPlacesData getNearbyPlacesData=new GetNearbyPlacesData();
       static  ArrayList<String> names = new ArrayList<String>();TextView textView;
      // String a[]={"alok","tom","fuvn"};String b[]={"ada","sgsf"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_listfrag);    // textView=(TextView)findViewById(R.id.tex);textView.setText(""+a[0]);
        ListView listView=(ListView)findViewById(R.id.li);
       ArrayAdapter<String>  list = new ArrayAdapter<String>(getApplicationContext(),R.layout.la,R.id.la,names);
        listView.setAdapter(list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),rate.class);
               intent.putExtra("data",names.get(position).toString());
                startActivity(intent);
            }
        });
    }
    public static void getu(List<HashMap<String, String>> nearbyPlaceList)
    {
        for(int i = 0; i < nearbyPlaceList.size(); i++)
        {

            HashMap<String, String> googlePlace = nearbyPlaceList.get(i);
            String vicinity = googlePlace.get("vicinity");
            names.add(vicinity);
         //  a[i]=vicinity;
           // System.out.println(a[i]);

        }




    }
}
