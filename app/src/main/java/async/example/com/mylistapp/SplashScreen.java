package async.example.com.mylistapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    final int SPLASH_DISPLAY_LENGTH = 3000;
    final int PROGRESS_BAR_FRAGMENT = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final ProgressBar progressBar = findViewById(R.id.progressBar);
        final Handler handler = new Handler();

        TextView tv = findViewById(R.id.flashTitle);
        tv.setTypeface(Typeface.createFromAsset(getAssets(), "Anabelle Script.ttf"));

        new Thread(new Runnable() {

            int progressCounter = 0;

            @Override
            public void run() {

                while (progressCounter++ < 100){
                    SystemClock.sleep(PROGRESS_BAR_FRAGMENT);

                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            progressBar.setProgress(progressCounter);
                        }
                    });
                }
            }
        }).start();

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                Intent mainIntent = new Intent(SplashScreen.this, ListScreen.class);
                startActivity(mainIntent);
                finish();
            }

        }, SPLASH_DISPLAY_LENGTH);
    }
}
