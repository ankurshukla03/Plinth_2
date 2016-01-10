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
public class Register_sif extends Fragment {

//it has three button to naam chng hai thda take care of it while editing
    Button button_reg,payment,startup_reg;
    ImageButton phone1,mail1,phone2,mail2;
    TextView name1, name2,no1,no2,email1,email2;
    String color;

    public Register_sif() {
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
         startup_reg = (Button)view.findViewById(R.id.button3);
        payment = (Button)view.findViewById(R.id.mkpay);
        no1 = (TextView)view.findViewById(R.id.reg_no1);
        no2 = (TextView)view.findViewById(R.id.reg_no2);
        email1 = (TextView)view.findViewById(R.id.reg_e1);
        email2 = (TextView)view.findViewById(R.id.reg_e2);

        startup_reg.setVisibility(View.VISIBLE);
        color = "#d69940";

        button_reg.setText("STUDENT REGISTER HERE");
        startup_reg.setText("MAKE PAYMENT");
        payment.setText("STARTUPS REGISTER HERE");
        button_reg.setBackgroundColor(Color.parseColor(color));
        startup_reg.setBackgroundColor(Color.parseColor(color));
        payment.setBackgroundColor(Color.parseColor(color));

        name1.setText("Sumit Sapra");
        name2.setText("Parul Chhabra");
        no1.setText("09782799066");
        email1.setText("startupinternfair.plinth@gmail.com");
        no2.setText("08875063000");
        email2.setText("startupinternfair.plinth@gmail.com");

        phone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 09782799066"));
                startActivity(intent);
            }
        });

        phone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 08875063000"));
                startActivity(intent);
            }
        });

        mail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"startupinternfair.plinth@gmail.com"});
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email Client"));
            }
        });

        mail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"startupinternfair.plinth@gmail.com"});
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email Client"));
            }
        });

        button_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://plinth.typeform.com/to/a1smCM"));
                startActivity(i);
            }
        });


        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://plinth.typeform.com/to/AapZRM"));
                startActivity(i);
            }
        });

        startup_reg.setOnClickListener(new View.OnClickListener() {
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