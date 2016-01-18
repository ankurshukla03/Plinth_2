package lnmiit.madclub.plinth.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import lnmiit.madclub.plinth.R;

/**
 * Created by Ankur Shukla on 1/19/2016.
 */
public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    ArrayList<String> day = new ArrayList<>();
    Context context;

    public ScheduleAdapter(ArrayList<String> day , Context context) {
        this.day = day;
        this.context = context;
    }

    @Override
    public ScheduleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_event_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ScheduleAdapter.ViewHolder holder, int position) {
        String temp = day.get(position);
        holder.name.setText(temp);

    }

    @Override
    public int getItemCount() {
        return day.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.textView1);
            image = (ImageView) itemView.findViewById(R.id.imageView1);
            image.setVisibility(View.GONE);
        }
    }

}
