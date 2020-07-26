package in.sisoft.easypainter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import in.sisoft.info.Aboutus;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

/**
 *
 *
 *
 */


public class AppDashboardActivity extends Activity
{
	Set<String> contentset=new HashSet<String>();
	List<Set> contentlist=new ArrayList<Set>();
		
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_layout);
           
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        Button btn_newdraw = (Button) findViewById(R.id.btn_newdraw);       
        Button btn_choocepic = (Button) findViewById(R.id.btn_choocepic);        
        //Button btn_takepic = (Button) findViewById(R.id.btn_takepic);
       
        //Button btn_ecall = (Button) findViewById(R.id.btn_emarcall);
        Button btn_info = (Button) findViewById(R.id.btn_infoo);
        Button btn_feedback = (Button) findViewById(R.id.btn_feedback);
        Button btn_rateus = (Button) findViewById(R.id.btn_rateus);
                
       
        btn_newdraw.setOnClickListener(new View.OnClickListener() 
        {			
		  @Override
		  public void onClick(View view) 
			{			
				Intent i = new Intent(getApplicationContext(), FirstPage.class);
				i.putExtra("RecId","1");
				startActivity(i);
			}
		});
        
    
        btn_choocepic.setOnClickListener(new View.OnClickListener()
        {			
			@Override
			public void onClick(View view) 
			{				
				Intent i = new Intent(getApplicationContext(), FirstPage.class);
				i.putExtra("RecId","2");
				startActivity(i);
			}
		});        
      
       /* btn_takepic.setOnClickListener(new View.OnClickListener()
        {
			
			@Override
			public void onClick(View view) 
			{
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(),FirstPage.class);
				i.putExtra("RecId","3");
				startActivity(i);
			}
		});*/
        
             
        btn_info.setOnClickListener(new View.OnClickListener()
        {
			
			@Override
			public void onClick(View view)
			{
				Intent i = new Intent(getApplicationContext(),Aboutus.class);
				startActivity(i);					
			}
		});
        
        btn_feedback.setOnClickListener(new View.OnClickListener()
        {			
			@Override
			public void onClick(View view)
			{
				onfeedbck();				  			
			}
		});
        
        
       /* btn_rateus.setOnClickListener(new View.OnClickListener()
        {			
			@Override
			public void onClick(View view)
			{
				//onfeedbck();
				
				 //Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.sisoft.easypainter#?t=W251bGwsMSwxLDIxMiwiY29tLnNpc29mdC5lYXN5cGFpbnRlciJd");
				 //https://play.google.com/store/apps/details?id=com.sisoft.easypainter#?t=W251bGwsMSwxLDIxMiwiY29tLnNpc29mdC5lYXN5cGFpbnRlciJd
				   Uri uri = Uri.parse("market://details?id=" + getPackageName()+"&write_review=true");
				   Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
				    try 
				    {
				        startActivity(myAppLinkToMarket);
				    } 
				    catch (ActivityNotFoundException e)
				    {
				        Toast.makeText(getApplicationContext(), " unable to find market app", Toast.LENGTH_LONG).show();
				    }				
			}
		});*/
        
      }  
        
    public void onStart()
	{
		super.onStart();
	//	AmazonAdsBottom();
	}
    
    protected void onfeedbck()
	{
		Uri uri=Uri.parse("mailto:info@sisoft.in");
		Intent email=new Intent(Intent.ACTION_SENDTO,uri);
		email.putExtra(Intent.EXTRA_SUBJECT,"EasyPainter (Android App)");
		email.putExtra(Intent.EXTRA_TEXT,"  ");
		startActivity(email);
	}
    
       
   
    public void showSelectedNumber(int type, String number) 
    {
        Toast.makeText(this, type + ": " + number, Toast.LENGTH_LONG).show();      
    }
    
    
    public void saveEcall()
    {
    	String mode="private";
    	//SharedPreferences ecall=new SharedPreferences("Ecall",mode);
		
	}
    
    
}