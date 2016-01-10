package lnmiit.madclub.plinth.Adapter;


import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import lnmiit.madclub.plinth.Model.ModelGrid;
import lnmiit.madclub.plinth.R;

/**
 * Created by Ankur Shukla on 12/31/2015.
 */
public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    ArrayList<ModelGrid> modelArrayList = new ArrayList<>();
    Context context;
    TextView txt;

    public GridAdapter(ArrayList<ModelGrid> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @Override
    public GridAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_gridview, parent, false);
        txt = (TextView)v.findViewById(R.id.gridtext);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GridAdapter.ViewHolder holder, int position) {
            ModelGrid modelGrid = modelArrayList.get(position);
            holder.textView.setText(modelGrid.name);
           holder.view.setBackgroundColor(Color.parseColor(modelGrid.color));
            holder.textView.setTextColor(Color.parseColor("#ffffff"));
            holder.imageView.setImageResource(modelGrid.image);
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.gridimage);
            textView = (TextView) itemView.findViewById(R.id.gridtext);
            view = itemView.findViewById(R.id.bg);
        }

    }



}
