package com.gdg.miagegi.saintvalentinlovematch;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;


public class Splash extends Activity {
	private static final int STOPSPLASH = 0;
	private static final long SPLASHTIME = 1000;
	private final transient Handler splashHandler = new Handler()
	{   
		public void handleMessage(Message msg)
		{
			if (msg.what == STOPSPLASH)
			{  
				final Intent intent = new Intent(Splash.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
			super.handleMessage(msg);
		}
		
	};
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
        final Message msg = new Message();
        msg.what = STOPSPLASH;
        splashHandler.sendMessageDelayed(msg, SPLASHTIME);
    }

   
}
