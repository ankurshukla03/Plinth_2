package lnmiit.madclub.plinth.Fragment;

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
 * Created by Ankur Shukla on 1/1/2016.
 */
public class Register extends Fragment {


    Button button_reg, payment;
    ImageButton phone1, mail1, phone2, mail2;
    TextView name1, name2;
    String n1,p1,m1,n2,p2,m2,reg1,reg2,pay,colour;

    public Register() {
    }
    public Register(String n1,String p1,String m1,String n2,String p2,String m2,String reg1,String reg2,String pay,String colour) {
        this.n1=n1;
        this.n2=n2;
        this.p1=p1;
        this.p2=p2;
        this.m1=m1;
        this.m2=m2;
        this.reg1=reg1;
        this.reg2=reg2;
        this.pay=pay;
        this.colour=colour;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        button_reg = (Button) view.findViewById(R.id.button);
        phone1 = (ImageButton) view.findViewById(R.id.reg_phone1);
        phone2 = (ImageButton) view.findViewById(R.id.reg_phone2);
        mail1 = (ImageButton) view.findViewById(R.id.reg_mail1);
        mail2 = (ImageButton) view.findViewById(R.id.reg_mail2);
        name1 = (TextView) view.findViewById(R.id.reg_name1);
        name2 = (TextView) view.findViewById(R.id.reg_name2);
        payment = (Button) view.findViewById(R.id.mkpay);


        name1.setText(n1);
        name2.setText(n2);

        phone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: "+p1));
                startActivity(intent);
            }
        });

        phone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: "+p2));
                startActivity(intent);
            }
        });

        mail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{m1});
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email Client"));
            }
        });

        mail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setData(Uri.parse("mailto:"));
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{m2});
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email Client"));
            }
        });

        button_reg.setVisibility(View.GONE);
        payment.setVisibility(View.GONE);


        return view;
    }
}