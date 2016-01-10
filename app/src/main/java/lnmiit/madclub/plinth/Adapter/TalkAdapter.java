package lnmiit.madclub.plinth.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import lnmiit.madclub.plinth.R;

/**
 * Created by Ankur Shukla on 1/10/2016.
 */
public class TalkAdapter extends RecyclerView.Adapter<TalkAdapter.ViewHolder> {


    @Override
    public TalkAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(TalkAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name,designation;
        public ImageView fb,twitter,wiki,linkedin;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.name);
            designation = (TextView)itemView.findViewById(R.id.designation);
            fb = (ImageView)itemView.findViewById(R.id.fb);
            twitter = (ImageView)itemView.findViewById(R.id.twitter);
            wiki = (ImageView)itemView.findViewById(R.id.wiki);
            linkedin = (ImageView)itemView.findViewById(R.id.linkedin);
        }
    }


}
