package kola.com.nearbyplaces;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

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
import java.util.ArrayList;

/**
 * Created by acer on 1/31/2018.
 */



public class retrieve extends AsyncTask<Void,Void,String> {
    String info;JSONArray jsonArray;JSONObject jsonObject;
    ArrayList<String> addr = new ArrayList<String>();public String address="";public String result="",rate="";public String rating="";
    @Override
    protected void onPreExecute() {

        info="http://robustious-forties.000webhostapp.com/retrieve.php";
    }

    @Override
    protected String doInBackground(Void... params) {
       // String address=params[0];

        //String rating=params[1];
        try
        {
            URL url=new URL(info);
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("POST");
            //httpURLConnection.setDoOutput(true);
            //OutputStream outputStream=httpURLConnection.getOutputStream();
            //BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            //String data= URLEncoder.encode("address","UTF-8")+"="+URLEncoder.encode(address,"UTF-8")+
            //      "&"+URLEncoder.encode("rating","UTF-8")+"="+URLEncoder.encode(rating,"UTF-8"); Log.d("vicinity","bject ="+data);
            // bufferedWriter.write(data);
            // bufferedWriter.flush();
            //bufferedWriter.close();
            //outputStream.close();
           // InputStream inputStream=httpURLConnection.getInputStream();
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream=httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            String data= URLEncoder.encode("address","UTF-8")+"="+URLEncoder.encode(address,"UTF-8")

                   + "&"+URLEncoder.encode("rating","UTF-8")+"="+URLEncoder.encode(rating,"UTF-8"); //Log.d("vicinity","bject ="+data);
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
           InputStream inputStream=httpURLConnection.getInputStream();
           // InputStream inputStream=httpURLConnection.getInputStream();
           // BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            //String result="";String line=bufferedReader.readLine();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            String response="";
           // String result=bufferedReader.readLine();
            while((response=bufferedReader.readLine())!=null){
                //stringBuilder.append(result+"\n");

            result+=response;}
          Log.d("fucked","ject ="+result);


           try{
                jsonObject=new JSONObject(result);
                jsonArray=jsonObject.getJSONArray("server_response");
                // jsonArray  = new JSONObject(json_string).getJSONArray("server_response");
                int count=0;

                while(count<jsonArray.length())
                {
                    JSONObject jo=jsonArray.getJSONObject(count);
                  //  addr.add(jo.getString("address"));
                    if(jo.getString("address")!="" || jo.getString("rating")!="")
                    {  address+=jo.getString("address");
                    //address.toString();
                   // addr.add(address);
                    Log.d("vici","ject ="+address);
                    rating+=jo.getString("rating");
                    if(count>=1)
                    {address+="$";rating+="$";}
                    Log.d("vici","ject ="+rating);
                    count++;
                }}
                String rate=re();
               Log.d("aman","ject ="+rate);

             /*for(int i=0;i<jsonArray.length();i++)
              {JSONObject jo=jsonArray.getJSONObject(i);
                address=jo.getString("address");
                  rating=jo.getString("rating");

                 // stringBuilder.append(address);
               //  Log.d("vici","ject ="+address);

              }*/



            } catch (JSONException e) {
                e.printStackTrace();
            }

           inputStream.close();bufferedReader.close();
            httpURLConnection.disconnect();


            return rate;

        }


        catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return address;
    }

    @Override
    protected void onPostExecute(String result) {
        //Toast.makeText(this,result, Toast.LENGTH_LONG).show();
        //Log.d("vicinity","bject ="+result);


    }
    public String re()
    {
        return address;
    }
    public String ra()
    {System.out.print(rating);
        return rating;
    }
}
