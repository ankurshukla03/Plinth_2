package lnmiit.madclub.plinth.Literary.FC;

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
public class Register_fc extends Fragment {


    Button button_reg,payment;
    ImageButton phone1,mail1,phone2,mail2;
    TextView name1,name2;
    public Register_fc() {
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


        name1.setText("Bhavik Thakkar");
        name2.setText("Mihika Naik");

        phone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 08003253190"));
                startActivity(intent);
            }
        });

        phone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 09602974538"));
                startActivity(intent);
            }
        });

        button_reg.setVisibility(View.GONE);
        payment.setVisibility(View.GONE);
        mail1.setVisibility(View.GONE);
        mail2.setVisibility(View.GONE);

        return view;
    }
}