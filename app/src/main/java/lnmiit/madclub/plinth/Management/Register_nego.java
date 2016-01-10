package lnmiit.madclub.plinth.Management;

import android.content.Intent;
import android.graphics.Color;
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
 * Created by Ankur Shukla on 1/8/2016.
 */
public class Register_nego extends Fragment {


    //it has only two button isme payment ka option nh hai
    Button button_reg,payment;
    ImageButton phone1,mail1,phone2,mail2;
    TextView name1, name2,no1,no2,email1,email2;
    String color;
    public Register_nego() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        button_reg = (Button)view.findViewById(R.id.button);
        phone1 = (ImageButton)view.findViewById(R.id.reg_phone1);
        phone2 = (ImageButton)view.findViewById(R.id.reg_phone2);
        mail1  = (ImageButton)view.findViewById(R.id.reg_mail1);
        mail2 = (ImageButton)view.findViewById(R.id.reg_mail2);
        name1 = (TextView)view.findViewById(R.id.reg_name1);
        name2 = (TextView)view.findViewById(R.id.reg_name2);
        payment = (Button)view.findViewById(R.id.mkpay);
        no1 = (TextView)view.findViewById(R.id.reg_no1);
        no2 = (TextView)view.findViewById(R.id.reg_no2);
        email1 = (TextView)view.findViewById(R.id.reg_e1);
        email2 = (TextView)view.findViewById(R.id.reg_e2);

        color = "#d69940";

        button_reg.setText("STARTUPS REGISTER HERE");
        payment.setText("VIEWERS REGISTER HERE");

        name1.setText("Akhilesh Maheshwari");
        name2.setText("Guarav Maheshwari");
        no1.setText("09772565365");
        email1.setText("ak2maheshwari@gmail.com");
        no2.setText("07597023883");
        email2.setText("gmaheshwari26@gmail.com");
        button_reg.setBackgroundColor(Color.parseColor(color));
        payment.setBackgroundColor(Color.parseColor(color));


        phone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 09772565365"));
                startActivity(intent);
            }
        });

        phone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 07597023883"));
                startActivity(intent);
            }
        });

        mail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"ak2maheshwari@gmail.com"});
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email Client"));
            }
        });

        mail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"gmaheshwari26@gmail.com"});
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email Client"));
            }
        });

        button_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://docs.google.com/forms/d/1KLFMy-7x4YFVP-mjiwynOlwo64GvE5YsXffE7r3dOE8/viewform?embedded=true"));
                startActivity(i);
            }
        });


        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://docs.google.com/forms/d/1FQdBNAqWgnWWjFyVkTt-HPDsOT0FPrnFkBHdW69hiOY/viewform"));
                startActivity(i);
            }
        });


        return view;
    }
}