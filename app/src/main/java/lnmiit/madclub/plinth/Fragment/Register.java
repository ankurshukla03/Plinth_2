package lnmiit.madclub.plinth.Fragment;

import android.content.Intent;
import android.graphics.Color;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import lnmiit.madclub.plinth.R;

/**
 * Created by Ankur Shukla on 1/1/2016.
 */
public class Register extends Fragment {


    Button button_reg, payment,button3;
    ImageButton phone1, mail1, phone2, mail2;
    TextView name1, name2,no1,no2,email1,email2;
    String n1,p1,m1,n2,p2,m2,reg1,reg2,pay,colour;
    CardView cardView;
    LinearLayout linearLayout,linearLayout2;

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
        button3 = (Button)view.findViewById(R.id.button3);
        no1 = (TextView)view.findViewById(R.id.reg_no1);
        no2 = (TextView)view.findViewById(R.id.reg_no2);
        email1 = (TextView)view.findViewById(R.id.reg_e1);
        email2 = (TextView)view.findViewById(R.id.reg_e2);
        cardView = (CardView)view.findViewById(R.id.griditem2);
        linearLayout = (LinearLayout)view.findViewById(R.id.llcrd1);
        linearLayout2 = (LinearLayout)view.findViewById(R.id.llcrd2);

        if(n2.equals("")){
            cardView.setVisibility(View.GONE);
        }
        if(pay.equals("")){
            payment.setVisibility(View.GONE);
        }
        if(reg1.equals("")){
            button_reg.setVisibility(View.GONE);
        }
        if(reg2.equals("")){
            button3.setVisibility(View.GONE);
        }
        if(m1.equals("")){
            email1.setVisibility(View.GONE);
            mail1.setVisibility(View.GONE);
            linearLayout.setVisibility(View.GONE);
        }
        if(m2.equals("")){
            email2.setVisibility(View.GONE);
            mail2.setVisibility(View.GONE);
            linearLayout2.setVisibility(View.GONE);
        }
        name1.setText(n1);
        name2.setText(n2);
        no1.setText(p1);
        email1.setText(m1);
        no2.setText(p2);
        email2.setText(m2);
        button_reg.setBackgroundColor(Color.parseColor(colour));
        payment.setBackgroundColor(Color.parseColor(colour));
        button3.setBackgroundColor(Color.parseColor(colour));


        phone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: " + p1));
                startActivity(intent);
            }
        });

        phone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: " + p2));
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

        button_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(reg1));
                startActivity(i);
            }
        });

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(pay));
                startActivity(i);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(reg2));
                startActivity(i);
            }
        });


        return view;
    }
}