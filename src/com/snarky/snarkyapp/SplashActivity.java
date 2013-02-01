package com.snarky.snarkyapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class SplashActivity extends Activity {

	//stopping splash screen starting home activity.
	private static final int STOPSPLASH = 0;
	//time duration in millisecond for which your splash screen should visible to
      //user. here i have taken half second
    private static final long SPLASHTIME = 2000;

    //handler for splash screen
    private Handler splashHandler = new Handler() {
         @Override
         public void handleMessage(Message msg) {
              switch (msg.what) {
              	case STOPSPLASH:
              		//Generating and Starting new intent on splash time out	
              		Intent intent = new Intent(getApplicationContext(), 
                                             MainActivity.class);
              		startActivity(intent);
              		SplashActivity.this.finish();
              		break;
              }
              super.handleMessage(msg);
         }
    };
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		 //Generating message and sending it to splash handle 
        Message msg = new Message();
        msg.what = STOPSPLASH;
        splashHandler.sendMessageDelayed(msg, SPLASHTIME);
	}

}
