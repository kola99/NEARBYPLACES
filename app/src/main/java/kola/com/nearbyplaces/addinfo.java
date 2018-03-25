package kola.com.nearbyplaces;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by acer on 1/30/2018.





/*package kola.com.nearbyplaces;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by acer on 1/30/2018.
 */



public class addinfo extends AsyncTask<String,Void,String> {
    String info;
    @Override
    protected void onPreExecute() {

        info="http://robustious-forties.000webhostapp.com/info.php";
    }

    @Override
    protected String doInBackground(String... params) {
        String address=params[0];
        String rating=params[1];
        try
        {
            URL url=new URL(info);
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream=httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            String data= URLEncoder.encode("address","UTF-8")+"="+URLEncoder.encode(address,"UTF-8")+
                    "&"+URLEncoder.encode("rating","UTF-8")+"="+URLEncoder.encode(rating,"UTF-8"); //Log.d("vicinity","bject ="+data);
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            String result="";String line=bufferedReader.readLine();
            while(bufferedReader.readLine()!=null){result+=line;}
            inputStream.close();
            httpURLConnection.disconnect();  // Log.d("vicinity","bject ="+result);
            return result;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        //Toast.makeText(this,result, Toast.LENGTH_LONG).show();
     //   Log.d("vicinity","bject ="+result);
    }
}


