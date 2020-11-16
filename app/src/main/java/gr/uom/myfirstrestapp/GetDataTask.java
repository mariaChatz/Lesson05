package gr.uom.myfirstrestapp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetDataTask extends AsyncTask<String,Void,String> {

    public static final String TAG="RestApp";
    public String jsonResult;

    public String downloadRestData(String remoteUrl){
        Log.d(TAG,"Downloading data...");

        //In this StringBuilder obgject will be stored the object that is read by reader.
        StringBuilder sb = new StringBuilder();

        try{
            URL url= new URL(remoteUrl);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            int responseCode=connection.getResponseCode();
            if(responseCode==HttpURLConnection.HTTP_OK) {
                Log.d(TAG, "Request Accepted");

                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                //Reading the inputstream line by line
                //Firstly I read the first line
                String line = reader.readLine();
                while(line!=null){
                    sb.append(line).append("\n");
                    //Reading next line
                    line=reader.readLine();
                }
                reader.close();
                return sb.toString();
            }
            else
                Log.d(TAG,"Something went wrong.Response code was " +responseCode);

        }
        catch(Exception e) {
            Log.e(TAG, "Error happened!", e);
            return "";
        }
        return "";

    }


    @Override
    protected String doInBackground(String... strings) {
        String url = strings[0];
        Log.d(TAG,"Doing task in background for url " +url);

        return downloadRestData(url);
    }

    @Override
    protected void onPostExecute(String result){
        jsonResult=result;
        Log.d(TAG,"Just got results!");
        Log.d(TAG,jsonResult);
    }
}
