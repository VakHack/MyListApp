package async.example.com.myapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataZoom extends AppCompatActivity {

    private void callNextIfWithinBounds(int nextPos){

         if(nextPos < ItemsGetter.getInstance().get().size() && nextPos >= 0){

             Intent next = new Intent(this, DataZoom.class);
             next.putExtra("itemNum", nextPos);

             startActivity(next);
         }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_zoom);

        final int itemPosition = getIntent().getExtras().getInt("itemNum");
        DataItem item = ItemsGetter.getInstance().get().get(itemPosition);

        TextView name = findViewById(R.id.zoomName);
        name.setTypeface(Typeface.createFromAsset(getAssets(), "CzaristiteBold.ttf"));
        name.setText(item.getName());

        TextView description = findViewById(R.id.zoomDescription);
        description.setTypeface(Typeface.createFromAsset(getAssets(), "CzaristiteBold.ttf"));
        description.setText(item.getDescription());

        ImageView pic = findViewById(R.id.zoomImage);

        ScreenMeasurer sm = new ScreenMeasurer(this, 0);
        Picasso.with(this)
                .load(item.getPicURL())
                .resize(sm.getWidth(), sm.getHeight())
                .centerCrop()
                .into(pic);

        pic.setOnTouchListener(new OnSwipeTouchListener(this) {
            @Override
            public void onSwipeLeft() {

                callNextIfWithinBounds(itemPosition + 1);
            }

            @Override
            public void onSwipeRight() {

                callNextIfWithinBounds(itemPosition - 1);
            }
        });
    }
}
