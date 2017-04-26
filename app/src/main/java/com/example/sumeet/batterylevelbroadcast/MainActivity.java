package com.example.sumeet.batterylevelbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView Blevel;
    BroadcastReceiver batteryLevel=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int level=intent.getIntExtra("level",0);
            Blevel=(TextView)findViewById(R.id.batteryLevelID);
            Blevel.setText("Battery Percentage : "+Integer.toString(level)+"%");

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Blevel=(TextView)findViewById(R.id.batteryLevelID);
        registerReceiver(batteryLevel,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

    }

}