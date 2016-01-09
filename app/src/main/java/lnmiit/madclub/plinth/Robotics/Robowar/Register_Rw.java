package lnmiit.madclub.plinth.Robotics.Robowar;

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
public class Register_Rw extends Fragment {

    public Register_Rw() {
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

        name1.setText("Samyak Dutt Gupta");
        name2.setText("Abhishek Sukhwal");

        phone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 09462066697"));
                startActivity(intent);
            }
        });

        phone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 07597722415"));
                startActivity(intent);
            }
        });

        mail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"sdgupta.gupta9@gmail.com"});
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email Client"));
            }
        });

        mail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"abhisheksukhwal9@gmail.com"});
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email Client"));
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://docs.google.com/forms/d/1C7E-RXx8ck_U7bg8wno6MyM158zK2K8NyOP6Fw6vZ8U/viewform?embedded=true"));
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
