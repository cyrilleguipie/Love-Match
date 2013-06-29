package com.gdg.miagegi.saintvalentinlovematch;

import android.os.Bundle;

import android.app.Activity;


import android.widget.TextView;


public class Result extends Activity {
  TextView res;
  TextView score;
  TextView obs;
  

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setContentView(R.layout.activity_result);
        res=(TextView)findViewById(R.id.res);
        score=(TextView)findViewById(R.id.score);
        obs=(TextView)findViewById(R.id.obs);
       

        if(getIntent().getExtras() != null){
        	if(getIntent().getExtras().containsKey("res"))
        		res.setText(getIntent().getExtras().getString("res"));
        	if(getIntent().getExtras().containsKey("score"))
        		score.setText(getIntent().getExtras().getString("score"));
        	if(getIntent().getExtras().containsKey("obs"))
        		obs.setText(getIntent().getExtras().getString("obs"));
    }
}}

