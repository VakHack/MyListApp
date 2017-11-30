package async.example.com.mylistapp;

import android.os.AsyncTask;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by Administrator on 26/11/2017.
 */

public class JSONURLReader extends AsyncTask<String, Void, String> {

    private String url;

    public JSONURLReader(String url) {
        this.url = url;
    }

    @Override
    protected String doInBackground(String... voids) {

        String json = null;

        try {

            json = IOUtils.toString(new URL(url), Charset.forName("UTF-8"));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }
}
