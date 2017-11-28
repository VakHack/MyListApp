package async.example.com.myapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<DataItem> items = ItemsGetter.getInstance().get();
        //ItemsGetter.getInstance().runAsyncClientTest();

        TextView title = findViewById(R.id.title);
        title.setTypeface(Typeface.createFromAsset(getAssets(), "Anabelle Script.ttf"));

        DataItemAdapter adapter = new DataItemAdapter(items, this);
        RecyclerView recyclerView = findViewById(R.id.itemsRV);
        recyclerView.setAdapter(adapter);
    }
}
