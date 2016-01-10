package lnmiit.madclub.plinth.NavigationDrawerFragment;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import lnmiit.madclub.plinth.Adapter.ContactAdapter;
import lnmiit.madclub.plinth.Model.ModelContacts;
import lnmiit.madclub.plinth.R;

/**
 * Created by Ankur Shukla on 1/9/2016.
 */
public class ContactUs extends Fragment {

    public ArrayList<ModelContacts> modelContactsArrayList = new ArrayList<>();
    ListView contact;
    ContactAdapter contactAdapter;
    String[] no = {"09530100403","07023479993",
            "09462317503",
            "09828853059"};
    public ContactUs() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);
        contact = (ListView) view.findViewById(R.id.contact);
        fillData();
        contactAdapter = new ContactAdapter(getActivity(), modelContactsArrayList);
        contact.setAdapter(contactAdapter);


        return view;
    }

    private void fillData() {
        String[] name = getResources().getStringArray(R.array.contact_name);
        String[] designation = getResources().getStringArray(R.array.contact_designation);
        TypedArray image = getResources().obtainTypedArray(R.array.contact_image);
        String[] phone = getResources().getStringArray(R.array.contact_phone);
        String[] email = getResources().getStringArray(R.array.contact_email);
        for (int i = 0; i < name.length; i++) {
            ModelContacts modelContacts = new ModelContacts();
            modelContacts.contact_name = name[i];
            modelContacts.designation = no[i];
            modelContacts.contact_image = String.valueOf(image.getResourceId(i, 0));
            modelContacts.phone  = no[i];
            modelContacts.contact_email = email[i];
            modelContactsArrayList.add(modelContacts);
        }

    }


}
