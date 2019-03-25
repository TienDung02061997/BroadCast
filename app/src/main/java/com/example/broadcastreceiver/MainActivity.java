package com.example.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    NetworkChangeReceiver receiver;
    Button sendBroadCasts;
    public static final String ACTION_DUNG="dung";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      sendBroadCasts= (Button) findViewById(R.id.btn_send);
      sendBroadCasts.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        receiver= new NetworkChangeReceiver();
        final IntentFilter intentFilter =new IntentFilter();
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("dung");
        registerReceiver(receiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onClick(View v) {
        Intent intent =new Intent();
        intent.putExtra(ACTION_DUNG,"Nguyen Tien Dung");
        intent.setAction(ACTION_DUNG);
        sendBroadcast(intent);
    }
}
