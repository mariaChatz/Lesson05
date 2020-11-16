package gr.uom.myfirstrestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="RestApp";
    private static final String REMOTE_API = "https://jsonplaceholder.typicode.com/posts/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"onCreate: Starting Downloading of Web Service Data");

        GetDataTask getDataTaskObject = new GetDataTask();
        getDataTaskObject.execute(REMOTE_API);

        Log.d(TAG,"STARTED Downloading of Web Service Data");

    }
}
