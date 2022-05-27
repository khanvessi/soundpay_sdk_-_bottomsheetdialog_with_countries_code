package com.example.soundpaysdkapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.countrycode.CountryCodeDialog;
import com.example.countrycode.CountryCodePicker;
import com.example.soundpaysdk.sound.sound.SoundActivity;

import java.util.ArrayList;

public class MainActivity extends SoundActivity {

    //Implemented in SoundActivity (the interface)
    @Override
    public void actionDone(int srFlag, String message) {
        super.actionDone(srFlag, message);
        if(srFlag==0){
            ((Button) findViewById(R.id.button_chatbox_sending)).setText("Send");
            ((EditText) findViewById(R.id.edt_result)).setText("");
        }
        if(srFlag==1){
            ((Button) findViewById(R.id.button_chatbox_listen)).setText("Listen");
//            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            if(message!=null){
                ((TextView) findViewById(R.id.txt_result)).setText(message);
            }else {
                ((TextView) findViewById(R.id.txt_result)).setText("nothing received");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void listenMessage(View view) {
        ((Button) findViewById(R.id.button_chatbox_listen)).setText("Listening");
        ((TextView) findViewById(R.id.txt_result)).setText("message will be shown here");
        listenMessage();
//
//        ArrayList<String> countries = new ArrayList<String>();
//        countries.add("Pakistan");
//        countries.add("India");
//        countries.add("Afghanistan");

        CountryCodeDialog countryCodeDialog = new CountryCodeDialog(new CountryCodePicker(this));
        countryCodeDialog.show();
    }

    public void sendMessage(View view) {
        String someText = ((EditText) findViewById(R.id.edt_result)).getText().toString();
        ((Button) findViewById(R.id.button_chatbox_sending)).setText("Sending");
        sendMessage(someText);
    }
}