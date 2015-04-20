package com.krishna.android.lockscreen;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {


    BroadcastReceiver mybroadcast = new BroadcastReceiver() {


        @Override
        public void onReceive(Context context, Intent intent) {

            Log.e("inside service", "inside");
            if(intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                Intent localIntent = new Intent(context, LockScreen.class);
                localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                localIntent.addFlags(WindowManager.LayoutParams.TYPE_SYSTEM_ERROR);
                context.startActivity(localIntent);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLock = (Button)findViewById(R.id.btnLock);

        btnLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((KeyguardManager)getSystemService(MainActivity.this.KEYGUARD_SERVICE)).newKeyguardLock("IN").disableKeyguard();



            }
        });

        registerReceiver(mybroadcast, new IntentFilter(Intent.ACTION_SCREEN_ON));
        registerReceiver(mybroadcast, new IntentFilter(Intent.ACTION_SCREEN_OFF));
    }



}
