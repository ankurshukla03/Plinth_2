package lnmiit.madclub.plinth.Literary.Fk;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import lnmiit.madclub.plinth.R;

/**
 * Created by Ankur Shukla on 1/8/2016.
 */
public class Register_fk extends Fragment {


    Button button,payment;
    ImageButton phone1,mail1,phone2,mail2;
    TextView name1,name2;
    CardView crd;
    public Register_fk() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        button = (Button)view.findViewById(R.id.button);
        crd = (CardView)view.findViewById(R.id.reg_crd2);
        phone1 = (ImageButton)view.findViewById(R.id.reg_phone1);
        phone2 = (ImageButton)view.findViewById(R.id.reg_phone2);
        mail1  = (ImageButton)view.findViewById(R.id.reg_mail1);
        mail2 = (ImageButton)view.findViewById(R.id.reg_mail2);
        name1 = (TextView)view.findViewById(R.id.reg_name1);
        name2 = (TextView)view.findViewById(R.id.reg_name2);
        payment = (Button)view.findViewById(R.id.mkpay);

        crd.setVisibility(View.GONE);

        name1.setText("Ishant Rajpurohit");

        phone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 0887533243"));
                startActivity(intent);
            }
        });

        mail1.setVisibility(View.GONE);
        button.setVisibility(View.GONE);
        payment.setVisibility(View.GONE);
        return view;
    }
}