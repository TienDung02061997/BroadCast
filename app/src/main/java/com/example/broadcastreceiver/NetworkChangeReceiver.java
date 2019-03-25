package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NetworkChangeReceiver  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
   //     Toast.makeText(context, "Netword not connection", Toast.LENGTH_SHORT).show();
        if (intent.getAction().equals(MainActivity.ACTION_DUNG)){
            String title=intent.getStringExtra("dung");
            Toast.makeText(context, title, Toast.LENGTH_SHORT).show();

        }
    }
}
