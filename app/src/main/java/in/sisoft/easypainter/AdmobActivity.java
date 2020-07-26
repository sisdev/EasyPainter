package in.sisoft.easypainter;

import android.app.Activity;
/*
import com.amazon.device.ads.AdLayout;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.AdTargetingOptions;
import com.amazon.device.ads.AdLayout.AdSize;
*/

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.AdView;

public class AdmobActivity extends Activity 
{
	AdView adView;
	 LinearLayout layout;
	 
	   // The ad view used to load and display the ad.
//	 private static final String APP_ID = "244dfb966cc14f42b1b3374e8b76e826";//"sample-app-v1_pub-2"; // Sample App Key. Replace this variable with your App Key

	private static final String APP_ID="ca-app-pub-6926507421176998~3733121131";
	    
//	 private static final String AmazonAPP_ID = "244dfb966cc14f42b1b3374e8b76e826";
	    
	  private static final String LOG_TAG = "SimpleAdSample"; // Tag used to prefix all log messages
	    

   public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		MobileAds.initialize(this, new OnInitializationCompleteListener() {
			@Override
			public void onInitializationComplete(InitializationStatus initializationStatus) {
			}
		});
     }
    
    
  /* 	 public void SetupAds()
    	    { 
    	     Log.i("AdMob", "Start Setup");
    	     layout = new LinearLayout(this);
    	     layout.setOrientation(LinearLayout.VERTICAL);
    	     layout.setGravity(android.view.Gravity.BOTTOM | android.view.Gravity.CENTER_HORIZONTAL);   //To put AdMob Adv to Bottom of Screen
    	     Log.i("AdMob", "End Layout Setup");

    	    addContentView(layout, new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));

    	    //adView = new AdView(this, AdSize.BANNER,"a14fbb3d2aa59ec");
    	    //adView.setAdListener(this);
    	    Log.i("AdMob", "Init complete Adview");

    	    layout.addView(adView, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    	    Log.i("AdMob", "Done AddView Layout");

    	    AdRequest request = new AdRequest();    
    	   // request.addTestDevice(AdRequest.TEST_EMULATOR);
    	    //request.addKeyword("LifeOK");

    	    //adView.loadAd(request);

    	    Log.i("AdMob", "End Setup");    
    	    }*/

   	 
   	 public void SetupAds()
	    { 
   		 try
   		 {
   			 
   			 
   //		  AdRegistration.setAppKey(getApplicationContext(),APP_ID);
   	     
         //Programmatically create the AdLayout 
         
   		 
   	//	 adView = new AdLayout(this,AdSize.AD_SIZE_320x50);

	     Log.i("AdMob", "Start Setup");
	     layout = new LinearLayout(this);
	     layout.setOrientation(LinearLayout.VERTICAL);
	     layout.setGravity(android.view.Gravity.BOTTOM | android.view.Gravity.CENTER_HORIZONTAL);   //To put AdMob Adv to Bottom of Screen
	     Log.i("AdMob", "End Layout Setup");

	      addContentView(layout, new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));

	     
	   // adView = new AdView(this, AdSize.BANNER,"a14fbb3d2aa59ec");
	    //adView.setAdListener(this);
	    Log.i("AdMob", "Init complete Adview");

	    layout.addView(adView, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
	    Log.i("AdMob", "Done AddView Layout");

	    //AdRequest request = new AdRequest();    
	   // request.addTestDevice(AdRequest.TEST_EMULATOR);
	    //request.addKeyword("LifeOK");

	   // adView.loadAd(request);
//	    AdRegistration.enableTesting(getApplicationContext(), true);
 //       AdTargetingOptions adOptions = new AdTargetingOptions();
 //       adView.loadAd(adOptions);

	    //Toast.makeText(getApplicationContext(),"Amazon Ads...",Toast.LENGTH_LONG).show();
	    Log.i("AdMob", "End Setup");    
	    
	    }catch (Exception e) 
	    {
			// TODO: handle exception
		}

	    }
   	 
   /* Amzzon ADS */
	/*
   	public void AmazonAdsTop()
    { 
		 try
		 {
			 
			 
		  AdRegistration.setAppKey(getApplicationContext(),AmazonAPP_ID);
	     
    //Programmatically create the AdLayout 
    
		 
		 adView = new AdLayout(this,AdSize.AD_SIZE_320x50);

     Log.i("AdMob", "Start Setup");
     layout = new LinearLayout(this);
     layout.setOrientation(LinearLayout.VERTICAL);
     layout.setGravity(android.view.Gravity.TOP | android.view.Gravity.CENTER_HORIZONTAL);   //To put AdMob Adv to Bottom of Screen
     Log.i("AdMob", "End Layout Setup");

      addContentView(layout, new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));

     
   // adView = new AdView(this, AdSize.BANNER,"a14fbb3d2aa59ec");
    //adView.setAdListener(this);
    Log.i("AdMob", "Init complete Adview");

    layout.addView(adView, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    Log.i("AdMob", "Done AddView Layout");

    //AdRequest request = new AdRequest();    
   // request.addTestDevice(AdRequest.TEST_EMULATOR);
    //request.addKeyword("LifeOK");

   // adView.loadAd(request);
    AdRegistration.enableTesting(getApplicationContext(), true);
   AdTargetingOptions adOptions = new AdTargetingOptions();
   adView.loadAd(adOptions);

    //Toast.makeText(getApplicationContext(),"Amazon Ads...",Toast.LENGTH_LONG).show();
    Log.i("AdMob", "End Setup");    
    
    }catch (Exception e) 
    {
		// TODO: handle exception
	}

    }
	 
	 
 public void AmazonAdsBottom()
    { 
	 try
	 {
		 
		 
	  AdRegistration.setAppKey(getApplicationContext(),AmazonAPP_ID);
     
 //Programmatically create the AdLayout 
 
	 
	 adView = new AdLayout(this,AdSize.AD_SIZE_320x50);

     Log.i("AdMob", "Start Setup");
     layout = new LinearLayout(this);
     layout.setOrientation(LinearLayout.VERTICAL);
     layout.setGravity(android.view.Gravity.BOTTOM | android.view.Gravity.CENTER_HORIZONTAL);   //To put AdMob Adv to Bottom of Screen
     Log.i("AdMob", "End Layout Setup");

      addContentView(layout, new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));

     
   // adView = new AdView(this, AdSize.BANNER,"a14fbb3d2aa59ec");
    //adView.setAdListener(this);
    Log.i("AdMob", "Init complete Adview");

    layout.addView(adView, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    Log.i("AdMob", "Done AddView Layout");

    //AdRequest request = new AdRequest();    
   // request.addTestDevice(AdRequest.TEST_EMULATOR);
    //request.addKeyword("LifeOK");

   // adView.loadAd(request);
    AdRegistration.enableTesting(getApplicationContext(), true);
AdTargetingOptions adOptions = new AdTargetingOptions();
adView.loadAd(adOptions);

    //Toast.makeText(getApplicationContext(),"Amazon Ads...",Toast.LENGTH_LONG).show();
    Log.i("AdMob", "End Setup");    
    
    }catch (Exception e) 
    {
		// TODO: handle exception
	}

    }

	 */
}