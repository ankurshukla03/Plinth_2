package lnmiit.madclub.plinth.Literary.TurnCoat;

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
 * Created by Ankur Shukla on 1/8/2016.
 */
public class Register_turncoat extends Fragment {


    Button button_reg,payment;
    ImageButton phone1,mail1,phone2,mail2;
    TextView name1,name2;
    public Register_turncoat() {
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


        name1.setText("Sonali Gupta");
        name2.setText("Sobhit Asai");

        phone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 09462900363"));
                startActivity(intent);
            }
        });

        phone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 09479361848"));
                startActivity(intent);
            }
        });

        mail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"sonaligpt0@gmail.com"});
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email Client"));
            }
        });

        mail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"asaiatin@gmail.com"});
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email Client"));
            }
        });

        button_reg.setVisibility(View.GONE);
        payment.setVisibility(View.GONE);

        return view;
    }
}