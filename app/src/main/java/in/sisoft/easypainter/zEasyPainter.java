package in.sisoft.easypainter;



import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;

public class zEasyPainter extends Activity
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {        
    	
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.newdraw);   
        
        
    }   
   public void onStart()
   {
	   super.onStart();
//	   AmazonAdsTop();
	
} 
    
    public class MyView extends View
    {

		public MyView(Context context)
		{
			super(context);
			// TODO Auto-generated constructor stub
		}
		
		
		
		
    	
    }

    
    /*   *//** Switches to the DrawShapes1 activity when the associated button is clicked. 
     *  You must also register the new Activity in AndroidManifest.xml. 
     *//*
    public void clickEasyPainter(View clickedButton) 
    {
    	//Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_LONG).show();
        Intent activityIntent =new Intent(this,zDrowpic.class);
        startActivity(activityIntent);
    }
    
    *//** Switches to the RotateActivity when the associated button is clicked. *//*
    public void Colorpickar(View clickedButton)
    {
        // Intent activityIntent =new Intent(this,Colorpickar.class);
        // startActivity(activityIntent);
    }
    
    *//** Switches to the SkewActivity when the associated button is clicked. *//*
    
    public void launchSkew(View clickedButton)
    {
        //Intent activityIntent = new Intent(this, SkewActivity.class);
        //startActivity(activityIntent);
    }
    
    *//** Switches to the DrawShapes2 activity when the associated button is clicked. *//*
    
    public void launchDrawShapes2(View clickedButton)
    {
        //Intent activityIntent = new Intent(this, DrawShapes2.class);
        //startActivity(activityIntent);
    }
    
    
    public void touchPaintclick(View clickedButton)
    {
    	//Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_LONG).show();
        //Intent activityIntent = new Intent(this,tuchdrow.class);
        //startActivity(activityIntent);
    }
    
    public void touchPaintclick2(View clickedButton)
    {
    	//Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_LONG).show();
        //Intent activityIntent = new Intent(this,TouchPaint2.class);
        //startActivity(activityIntent);
    }
    
    public void touchPaintclick3(View clickedButton)
    {
    	//Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_LONG).show();
       // Intent activityIntent = new Intent(this,TouchPaint3.class);
        //startActivity(activityIntent);
    }
    
    public void touchPaintclick4(View clickedButton)
    {
    	//Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_LONG).show();
        //Intent activityIntent = new Intent(this,SplitTouchView.class);
        //startActivity(activityIntent);
    }
    
    
    public void touchPaintclick5(View clickedButton)
    {
    	//Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_LONG).show();
        //Intent activityIntent = new Intent(this,MultyTouch.class);
        //startActivity(activityIntent);
    }
    
    public void touchPaintclick6(View clickedButton)
    {
    	//Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_LONG).show();
        //Intent activityIntent = new Intent(this,DrowPic.class);
        //startActivity(activityIntent);
    }
    
    
    public void touchPaintclick7(View clickedButton)
    {
    	//Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_LONG).show();
        //Intent activityIntent = new Intent(this,ImageMirror.class);
        //startActivity(activityIntent);
    }
    
    
    public void info(View clickedButton)
    {
    	//Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_LONG).show();
        Intent activityIntent = new Intent(this,Info.class);
        startActivity(activityIntent);
    }*/
    
}
