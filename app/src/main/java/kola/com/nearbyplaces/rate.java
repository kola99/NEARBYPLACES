 package kola.com.nearbyplaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class rate extends AppCompatActivity {TextView textView;String ra="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        Intent intent=getIntent();String x="";
        String name=intent.getStringExtra("data");
        rate g=new rate();
        retrieve r=new retrieve();
            // Log.d("fucked","ject ="+r.address);
        ra="";String p="";
        String a=r.re();System.out.print(a);
        String rate=r.ra();String v=a,m=rate;int h=0,n=0,k=0,c=0,b=0;
        retrieve ret=new retrieve();


    }
}
