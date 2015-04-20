package com.krishna.android.lockscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.WindowManager;

import android.util.Log;

/**
 * Created by Android on 20-04-2015.
 */
public class AutoStart extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        Log.e("inside service","inside");
        if(intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            Intent localIntent = new Intent(context, LockScreen.class);
            localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            localIntent.addFlags(WindowManager.LayoutParams.TYPE_SYSTEM_ERROR);
            context.startActivity(localIntent);
        }
    }
}
