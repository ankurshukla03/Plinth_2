package lnmiit.madclub.plinth.Robotics.LF;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import lnmiit.madclub.plinth.R;

/**
 * Created by Ankur Shukla on 1/7/2016.
 */
public class Register_lf extends Fragment {

    public Register_lf() {
    }

    ImageButton phone1,mail1,phone2,mail2;
    TextView name1,name2;
    Button reg,payment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.trans_register,container,false);
        phone1 = (ImageButton)view.findViewById(R.id.reg_trans_phone1);
        phone2 = (ImageButton)view.findViewById(R.id.reg_trans_phone2);
        mail1  = (ImageButton)view.findViewById(R.id.reg_trans_mail1);
        mail2 = (ImageButton)view.findViewById(R.id.reg_trans_mail2);
        name1 = (TextView)view.findViewById(R.id.reg_trans_name1);
        name2 = (TextView)view.findViewById(R.id.reg_trans_name2);
        reg = (Button)view.findViewById(R.id.register_btn_trans);
        payment = (Button)view.findViewById(R.id.mkpay_trans);


        name1.setText("Ankit Puri");
        name2.setText("Aayush Agarwal");

        phone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 08003194158"));
                startActivity(intent);
            }
        });

        phone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 09462035225"));
                startActivity(intent);
            }
        });

        mail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"ankitpuri1995@gmail.com"});
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email Client"));
            }
        });

        mail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"aayushag007@gmail.com"});
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email Client"));
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://docs.google.com/forms/d/1ibO17nEovdrhhxM7HzQjCcivrsWtUtZ9kzb8t699u2I/viewform?embedded=true"));
                startActivity(i);
            }
        });


        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://thecollegefever.com/plinth"));
                startActivity(i);
            }
        });

        return view;
    }
}
