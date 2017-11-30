package async.example.com.mylistapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Administrator on 25/11/2017.
 */

public class JSONToDataParser {

    public static ArrayList<DataItem> parseJSON(String json){

        ArrayList<DataItem> moviesList = new ArrayList<>();

        try {

            JSONArray arr = new JSONArray(json);

            for(int i = 0; i < arr.length(); ++i){

                JSONObject obj = arr.getJSONObject(i);
                DataItem data = new DataItem(obj.getString("name"), obj.getString("picURL"), "bla bla");

                moviesList.add(data);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return moviesList;
    }
}
