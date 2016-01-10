package lnmiit.madclub.plinth.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import lnmiit.madclub.plinth.Model.ModelContacts;
import lnmiit.madclub.plinth.R;
import lnmiit.madclub.plinth.Widget.Miscellaneous;

/**
 * Created by Ankur Shukla on 1/9/2016.
 */
public class ContactAdapter extends BaseAdapter {

    public ArrayList<ModelContacts> modelContactsArrayList = new ArrayList<>();
    public Context context;
    private LayoutInflater mInflater;

    public ContactAdapter(Context context,ArrayList<ModelContacts> modelContactsArrayList)
    {
        this.mInflater = LayoutInflater.from(context);
        this.context=context;
        this.modelContactsArrayList=modelContactsArrayList;
    }

    @Override
    public int getCount() {
        return modelContactsArrayList.size();

    }

    @Override
    public Object getItem(int position) {
        return modelContactsArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;
        if (convertView == null) {
            view = mInflater.inflate(R.layout.item_contact_list, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView) view.findViewById(R.id.contact_name);
            holder.designation = (TextView) view.findViewById(R.id.contact_designation);
            holder.mail = (ImageButton) view.findViewById(R.id.mail);
            holder.phone = (ImageButton) view.findViewById(R.id.phone);
            holder.avatar = (ImageView)view.findViewById(R.id.avatar);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        final ModelContacts modelContacts = modelContactsArrayList.get(position);
        holder.name.setText(modelContacts.contact_name);
        holder.designation.setText(modelContacts.designation);
        Picasso.with(holder.avatar.getContext())
                .load(Integer.parseInt(modelContacts.contact_image))
                .centerCrop()
                .resize(new Miscellaneous().dp2px(context, 48),
                        new Miscellaneous().dp2px(context, 48))
                .into(holder.avatar);
        holder.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: "+modelContacts.phone));
                context.startActivity(intent);
            }
        });
        holder.mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{modelContacts.contact_email});
                email.setType("message/rfc822");
                context.startActivity(Intent.createChooser(email, "Choose an Email Client"));
            }
        });
        return view;
    }
    public class ViewHolder
    {
        private TextView name,designation;
        private ImageButton mail,phone;
        private ImageView avatar;
    }
}

