package lnmiit.madclub.plinth.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import lnmiit.madclub.plinth.Model.ModelGrid;
import lnmiit.madclub.plinth.Model.ModelTalks;
import lnmiit.madclub.plinth.R;

/**
 * Created by Ankur Shukla on 1/10/2016.
 */
public class TalkAdapter extends RecyclerView.Adapter<TalkAdapter.ViewHolder> {

    ArrayList<ModelTalks> modelTalksArrayList = new ArrayList<>();
    Context context;

    public TalkAdapter(ArrayList<ModelTalks> modelTalksArrayList, Context context) {
        this.modelTalksArrayList = modelTalksArrayList;
        this.context = context;
    }

    @Override
    public TalkAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_item2, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TalkAdapter.ViewHolder holder, int position) {
            final ModelTalks modelTalks = modelTalksArrayList.get(position);
            holder.name.setText(modelTalks.name);
            holder.designation.setText(modelTalks.designation);
            holder.avatar.setImageResource(modelTalks.image);
            if(modelTalks.twitter_link.equals("")){
                holder.twitter.setVisibility(View.GONE);
            }
            if(modelTalks.linked_link.equals("")){
                holder.linkedin.setVisibility(View.GONE);
            }
            holder.fb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(modelTalks.fb_link));
                    context.startActivity(i);
                }
            });
        holder.linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(modelTalks.linked_link));
                context.startActivity(i);
            }
        });
        holder.twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(modelTalks.twitter_link));
                context.startActivity(i);
            }
        });
        holder.wiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(modelTalks.wiki_link));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelTalksArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name,designation;
        public ImageView fb,twitter,wiki,linkedin,avatar;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.name);
            avatar = (ImageView)itemView.findViewById(R.id.avatar);
            designation = (TextView)itemView.findViewById(R.id.designation);
            fb = (ImageView)itemView.findViewById(R.id.fb);
            twitter = (ImageView)itemView.findViewById(R.id.twitter);
            wiki = (ImageView)itemView.findViewById(R.id.wiki);
            linkedin = (ImageView)itemView.findViewById(R.id.linkedin);
        }
    }


}
