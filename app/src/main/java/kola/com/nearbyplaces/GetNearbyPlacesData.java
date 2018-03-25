package kola.com.nearbyplaces;





import android.os.AsyncTask;
         import android.util.Log;
import android.widget.ArrayAdapter;


import com.google.android.gms.maps.CameraUpdateFactory;
         import com.google.android.gms.maps.GoogleMap;
         import com.google.android.gms.maps.model.BitmapDescriptorFactory;
         import com.google.android.gms.maps.model.LatLng;
         import com.google.android.gms.maps.model.MarkerOptions;


         import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
         import java.util.List;

import static android.R.layout.simple_dropdown_item_1line;


class GetNearbyPlacesData extends AsyncTask<Object, String, String> {


           private String googlePlacesData;
     private GoogleMap mMap;int n;List<Double> lati = new ArrayList<Double>();
    String url;List<Double> longi=new ArrayList<Double>();




             @Override
     protected String doInBackground(Object... objects){
                 mMap = (GoogleMap)objects[0];
                 url = (String)objects[1];


                 DownloadURL downloadURL = new DownloadURL();
                 try {
                         googlePlacesData = downloadURL.readUrl(url);
                     } catch (IOException e) {
                         e.printStackTrace();
                     }


                 return googlePlacesData;
             }

             @Override
     protected void onPostExecute(String s){listfrag ls=new listfrag();


                 List<HashMap<String, String>> nearbyPlaceList;
                 DataParser parser = new DataParser();
                 nearbyPlaceList = parser.parse(s);
                 Log.d("nearbyplacesdata","called parse method");
                 showNearbyPlaces(nearbyPlaceList);
                 listfrag.getu(nearbyPlaceList);
             }


           public void showNearbyPlaces(List<HashMap<String, String>> nearbyPlaceList)
    {         n=nearbyPlaceList.size();

               for(int i = 0; i < nearbyPlaceList.size(); i++)
                     {
                         MarkerOptions markerOptions = new MarkerOptions();
                         HashMap<String, String> googlePlace = nearbyPlaceList.get(i);

                        String placeName = googlePlace.get("place_name");
                         String vicinity = googlePlace.get("vicinity");
                         double lat = Double.parseDouble( googlePlace.get("lat"));
                         double lng = Double.parseDouble( googlePlace.get("lng"));

                       lati.add(lat);
                         longi.add(lng);int ca=0;

                         Log.d("vicinity","bject ="+lati);addinfo info=new addinfo();//retrieve r=new retrieve();
                      /*   for(int j=0;j<r.addr.size();j++)
                         {
                           String s=r.addr.get(j).toString();// Log.d("vicinity","bct ="+s);
                             if(s==vicinity)
                             { ca++;
                         }s="";
                         }*/

                         if(ca==0)
                         {
                         info.execute(vicinity,"not available");}
                         LatLng latLng = new LatLng( lat, lng);
                         //a[i]=names.toString();

                         markerOptions.position(latLng);
                         
                         markerOptions.title(placeName + " : "+ vicinity);
                         markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));


                         mMap.addMarker(markerOptions);
                         mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                         mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
                     }

        //ArrayAdapter<String> list;
        //list = new ArrayAdapter<String>(this, simple_dropdown_item_1line,names.toString();
             }
      ///public List<String> geti()
       //{
          // for(int i = 0; i < names.size(); i++)
         //  {
             /*  MarkerOptions markerOptions = new MarkerOptions();
               // HashMap<String, String> googlePlace = nearbyPlaceList.get(i);

               //String placeName =names.get("place_name");
               String vicinity = names.get(i);
               a[i]=vicinity;*/
        /* for(String x:names){System.out.println(x);




         }
           }

   return names;
 }*/





}
