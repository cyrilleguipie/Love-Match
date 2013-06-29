package com.gdg.miagegi.saintvalentinlovematch;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import android.os.Bundle;


import android.app.Activity;
import android.app.AlertDialog;

import android.content.Intent;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import android.widget.Toast;



public class MainActivity extends Activity {
    private EditText mnom=null; 
    private EditText snom=null;
    protected AdView adView;
    
    public int Score;
	public String nom1;
	public String nom2;
	public String affnom1;
	public String affnom2;
	private long Totnom1;
	private long Totnom2;
	private double Moynom1;
	private double Moynom2;
	private double var1;
	private double var2;
	private double cov;
	
	private String obsrevation="";
	private String res="";
	String score="";
	String obs="";
	
	

    
    
    
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adView = new AdView(this, AdSize.BANNER, "114b57f589414eac");

        LinearLayout layout = (LinearLayout)findViewById(R.id.adViewLayout);

       
        layout.addView(adView);

   
        adView.loadAd(new AdRequest());
        
        mnom=(EditText)findViewById(R.id.editText1);
        snom=(EditText)findViewById(R.id.editText2);
        
        Button b1=(Button)findViewById(R.id.button1);
		 b1.setOnClickListener(
		 new OnClickListener() {
		 
		 public void onClick(View v) {
			  nom1 = mnom.getText().toString().trim();
			 nom2 = snom.getText().toString().trim();
			 affnom2 = snom.getText().toString();
			 affnom1 = mnom.getText().toString();
			 
			 if ((nom1.length()>0)&&(nom2.length()>0))
			 {
			
			 
			 if(nom1.length()>nom2.length())
				{
					nom2 = nom2 + nom2.substring(0,Math.abs(nom1.length()-nom2.length()));
				} 
				else if (nom1.length()<nom2.length())
				{
					nom1 = nom1 + nom1.substring(0,Math.abs(nom2.length()-nom1.length()));
				}	
				byte bytenom1[] = nom1.getBytes();
				byte bytenom2[] = nom2.getBytes();
				Totnom1=0;
				Totnom2=0;
				for(int i=0;i<bytenom1.length;i++)
				{
		                	Totnom1 += bytenom1[i];
		                	Totnom2 += bytenom2[i];
		        	} 
				Moynom1 = (Totnom1 / bytenom1.length);
				Moynom2 = (Totnom2 / bytenom2.length);
				cov=0;
				var1=0;
				var2=0;
				for(int i=0;i<bytenom1.length;i++)
				{
		                	cov += (bytenom1[i]-Moynom1)*(bytenom2[i]-Moynom2)/bytenom1.length;
					var1 += (bytenom1[i]-Moynom1)*(bytenom1[i]-Moynom1)/bytenom1.length;
					var2 += (bytenom2[i]-Moynom2)*(bytenom2[i]-Moynom2)/bytenom2.length;
		        	} 
				Score=(int)(Math.max(cov/(Math.sqrt(var1)*Math.sqrt(var2))*100,-1*cov/(Math.sqrt(var1)*Math.sqrt(var2))*100));
				
				if (Score > 0) { obsrevation=getResources().getString(R.string.obs1);}
				if (Score > 4) { obsrevation=getResources().getString(R.string.obs2);}
				if (Score > 10) { obsrevation=getResources().getString(R.string.obs3);}
				if (Score > 20) { obsrevation=getResources().getString(R.string.obs4);}
				if (Score > 40) { obsrevation=getResources().getString(R.string.obs5);}
				if (Score == 51) { obsrevation=getResources().getString(R.string.obs6);}
				if (Score > 51) { obsrevation=getResources().getString(R.string.obs7);}
				if (Score == 69) { obsrevation=getResources().getString(R.string.obs8);}
				if (Score > 69) { obsrevation=getResources().getString(R.string.obs9);}
				if (Score > 80) { obsrevation=getResources().getString(R.string.obs10);}
				if (Score > 90) { obsrevation=getResources().getString(R.string.obs11);}
				
				res=affnom1+" + "+affnom2; 
				score=Score+"%";
				obs=obsrevation;
				 
				 Intent intent = new Intent(MainActivity.this, Result.class);
				 intent.putExtra("res",res);
				 intent.putExtra("score",score);
				 intent.putExtra("obs",""+obs);
					startActivity(intent);
			 }else
				 if ((nom1.length()==0)&&(nom2.length()==0))
				 {
					 makeToast(getResources().getString(R.string.empty));
				 }
				 
				
				
		 
			
			
		 
		 }});
		 
		
		  
        
    }
   
    				
    	

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
    public int nombrer(char n)
	{
		if (n=='a') return 1;
		if (n=='b') return 2;
		if (n=='c') return 3;
		if (n=='d') return 4;
		if (n=='e') return 5;
		if (n=='f') return 6;
		if (n=='g') return 7;
		if (n=='h') return 8;
		if (n=='i') return 9;
		if (n=='j') return 10;
		if (n=='k') return 11;
		if (n=='l') return 12;
		if (n=='m') return 13;
		if (n=='n') return 14;
		if (n=='o') return 15;
		if (n=='p') return 16;
		if (n=='q') return 17;
		if (n=='r') return 18;
		if (n=='s') return 19;
		if (n=='t') return 20;
		if (n=='u') return 21;
		if (n=='v') return 22;
		if (n=='w') return 23;
		if (n=='x') return 24;
		if (n=='y') return 25;
		if (n=='z') return 26;
		if (n==' ') return 0;
		else return 0;
	}
    
    
    
    
    public void makeToast(String message)
    {
    Toast.makeText(
    this,
    message,
    Toast.LENGTH_SHORT).show();
    }
    
    public void showOkAlertDialog(String message)
    {
    new AlertDialog.Builder(this)
    .setMessage(message)
    .setPositiveButton("OK", null)
    .show();
    }
   

}
