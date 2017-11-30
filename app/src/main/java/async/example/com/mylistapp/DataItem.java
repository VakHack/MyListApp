package async.example.com.mylistapp;

/**
 * Created by Administrator on 27/11/2017.
 */

public class DataItem {

    private String name;
    private String picURL;
    private String description;

    public DataItem(String name, String picURL, String description) {
        this.name = Translator.translate(name);
        this.picURL = picURL;
        this.description = Translator.translate(description);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
