package async.example.com.myapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class ListScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<DataItem> items = ItemsGetter.getInstance().get();

        TextView title = findViewById(R.id.title);
        title.setTypeface(Typeface.createFromAsset(getAssets(), "Anabelle Script.ttf"));

        DataItemAdapter adapter = new DataItemAdapter(items, this);
        RecyclerView recyclerView = findViewById(R.id.itemsRV);
        recyclerView.setAdapter(adapter);
    }

    //    public void runAsyncClientTest(){
//
//        AsyncHttpClient client = new AsyncHttpClient();
//        client.get("http://api.open-notify.org/astros.json", new JsonHttpResponseHandler() {
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
//                super.onSuccess(statusCode, headers, response);
//
//                Log.e("myappLog", response.toString());
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
//                super.onFailure(statusCode, headers, throwable, errorResponse);
//
//                Log.e("myappLog", "failed:" + statusCode);
//            }
//        });
//    }

//    public void runAsyncClientTest(){
//
//        AsyncHttpClient client = new AsyncHttpClient();
//        client.get("http://freetexthost.in/paste.php?raw&id=162010", new TextHttpResponseHandler(){
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
//                Log.e("myappLog", "failed");
//
//            }
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, String responseString) {
//                Log.e("myappLog", responseString);
//            }
//        });
//    }
}
