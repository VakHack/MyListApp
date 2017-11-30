package async.example.com.mylistapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 27/11/2017.
 */

public class DataItemAdapter extends RecyclerView.Adapter<DataItemAdapter.ViewHolder>{

    private Context context;
    private List<DataItem> items;

    public DataItemAdapter(List<DataItem> items, Context context) {
        this.context = context;
        this.items = items;
    }

    @Override
    public DataItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataItemAdapter.ViewHolder holder, final int position) {

        final DataItem item = items.get(position);

        holder.name.setText(item.getName());
        holder.name.setTypeface(Typeface.createFromAsset(context.getAssets(), "CzaristiteBold.ttf"));

        ScreenMeasurer sm = new ScreenMeasurer(context, 0);
        Picasso.with(context)
                .load(item.getPicURL())
                .resize(sm.getWidth(), 300)
                .centerCrop()
                .into(holder.pic);

        holder.pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent zoomScreen = new Intent(context, DataZoom.class);
                zoomScreen.putExtra("itemNum", position);

                context.startActivity(zoomScreen);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public ImageView pic;

        public ViewHolder(View itemView) {
            super(itemView);

            pic = itemView.findViewById(R.id.listPic);
            name = itemView.findViewById(R.id.listName);
        }
    }
}
