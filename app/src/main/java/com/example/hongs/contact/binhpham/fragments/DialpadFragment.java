package com.example.hongs.contact.binhpham.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hongs.contact.R;
import com.example.hongs.contact.binhpham.my_abstract.RightDrawableOnTouchListener;

public class DialpadFragment extends Fragment implements View.OnClickListener {

    private TextView textView;
    private Button[] buttons = new Button[12];
    private int ids[] = {
            R.id.btn_0, R.id.btn_1, R.id.btn_2,
            R.id.btn_3, R.id.btn_4, R.id.btn_5,
            R.id.btn_6, R.id.btn_7, R.id.btn_8,
            R.id.btn_9, R.id.btn_sao, R.id.btn_thang
    };


    public DialpadFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialpad, container, false);

        //init view
        textView = view.findViewById(R.id.edit_number_phone);
        textView.setOnTouchListener(new RightDrawableOnTouchListener(textView) {
            @Override
            public boolean onDrawableTouch(final MotionEvent event) {

                String s = textView.getText().toString();
                if (!s.isEmpty()) textView.setText(PhoneNumberUtils.formatNumber(s.substring(0, s.length() - 1)));

                return false;
            }
        });

        for (int i = 0; i < ids.length; i++) {
            buttons[i] = view.findViewById(ids[i]);
            buttons[i].setOnClickListener(this);
        }
        FloatingActionButton floatingActionButton = view.findViewById(R.id.floating_call);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                String strNumberPhone = "tel:" + textView.getText().toString();
                intent.setData(Uri.parse(strNumberPhone));
                startActivity(intent);
            }
        });

        return view;
    }


    @Override
    public void onClick(View v) {
        String s = textView.getText().toString() + ((Button) v).getText().toString();
        textView.setText(PhoneNumberUtils.formatNumber(s));
    }
}
