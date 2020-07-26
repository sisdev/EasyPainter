//http://www.java2s.com/Code/Android/2D-Graphics/CropBitmap.htm

package in.sisoft.easypainter;
import java.io.OutputStream;

import in.sisoft.info.Aboutus;



import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class zDrowpic extends Activity implements OnClickListener,OnTouchListener
{
	  private Path path = new Path();
	  ImageView choosenImageView;
	  Button choosePicture,takepic,touchpaint;
	  Button savePicture,btn_info,btn_facebook;

	  Bitmap bmp;
	  Bitmap alteredBitmap;
	  Canvas canvas;
	  Paint paint;
	  Matrix matrix;
	  float downx = 0;
	  float downy = 0;
	  float upx = 0;
	  float upy = 0;

	  @Override
	  public void onCreate(Bundle savedInstanceState)
	  {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.easy_painter);

	    choosenImageView = (ImageView) this.findViewById(R.id.ChoosenImageView);
	    
	    takepic= (Button) this.findViewById(R.id.TakePictureButton);
	    choosePicture = (Button) this.findViewById(R.id.ChoosePictureButton);
	    touchpaint=(Button)this.findViewById(R.id.btn_touchPaint);
	    savePicture = (Button) this.findViewById(R.id.SavePictureButton);
	    btn_info= (Button) this.findViewById(R.id.btn_info);
	    btn_facebook=(Button)this.findViewById(R.id.btn_facebook);
	    
	    btn_facebook.setOnClickListener(this);	    
	    btn_info.setOnClickListener(this);
	    savePicture.setOnClickListener(this);	    
	    takepic.setOnClickListener(this);
	    choosePicture.setOnClickListener(this);
	    touchpaint.setOnClickListener(this);
	    choosenImageView.setOnTouchListener(this);
	    
	   /////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    
	    
	    
	    
	  
	  
	  
	  //////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  
	  }

	  
	  public void onClick(View v)
	  {

	    if (v == choosePicture) 
	    {
	    	
	    	//from Gallery
	    	
	      Intent choosePictureIntent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
	      startActivityForResult(choosePictureIntent, 0);
	    	
	    	
	    } 
	    
	    
	    else if (v == takepic) 
	    {	    	
	    	//Form Camara	    	
	    	 Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	         startActivityForResult(i, 11);
	    }
	    
	    
	    else if (v == touchpaint) 
	    {	    	
	    	//Form Camara
	    	
	    	 Intent i = new Intent(this,FirstPage.class);
	         startActivityForResult(i, 110);
	    	
	    	//choosenImageView.set    	
	    }
	    
	    
	    else if (v == savePicture) 
	    {

	      if (alteredBitmap != null)
	      {
	      try 
		   {
	          ContentValues contentValues = new ContentValues(3);
	          contentValues.put(Media.DISPLAY_NAME, "Draw On Me");

	          Uri imageFileUri = getContentResolver().insert(Media.EXTERNAL_CONTENT_URI, contentValues);
	        
	          OutputStream imageFileOS = getContentResolver().openOutputStream(imageFileUri);
	          alteredBitmap.compress(CompressFormat.JPEG, 90, imageFileOS);
	          
	          choosenImageView.refreshDrawableState();
	          
	          Toast t = Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT);
	          t.show();
	        } 	       
	      
	      catch (Exception e) 
	        {
	          Log.v("EXCEPTION", e.getMessage());
	          Toast.makeText(getApplicationContext(), "Error : "+e.toString(),Toast.LENGTH_LONG).show();
	        }
	      }
	    }
	    
	    else if(v==btn_info)
	    {
	    	//Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_LONG).show();
	    	Intent activityIntent = new Intent(this,Aboutus.class);
	    	startActivityForResult(activityIntent,201);

	    }
	    
	    else if(v==btn_facebook)
	    {
	    	//Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_LONG).show();
	    	Intent activityIntent = new Intent(this,Aboutus.class);
	    	startActivityForResult(activityIntent,201);
	    	////////////////////////////////////////////////////////////////////////////////////////////
	    	
	    	/*if (!btn_facebook.isSelected()) 
	    	{
	    		btn_facebook.setSelected(true);
            } 
	    	else 
	    	{
            	btn_facebook.setSelected(false);
            }
            //saveBtnFlag = 1;
            // if (connection.isInternetOn()) {

            if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED))
            {
                getCurrentImage();
                Intent i = new Intent(this, FaceBookAuthentication.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(i);
            }

            else 
            {
            	Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_LONG).show();
            	
               // ShowAlertMessage.showDialog(this,R.string.app_name, R.string.Sd_card,R.string.button_retry);
            }*/
	    	
	    	//////////////////////////////////////////////////////////////////////////////////////////////
	    } 

	  }
	  
	  protected void onActivityResult(int requestCode, int resultCode,Intent intent)
	  {
	    super.onActivityResult(requestCode, resultCode, intent);

	   if (resultCode == RESULT_OK) 
	    {
	      Uri imageFileUri = intent.getData();
	      try
	      {
	        BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();
	        bmpFactoryOptions.inJustDecodeBounds = true;
	        
	        bmp = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageFileUri), null, bmpFactoryOptions);

	        bmpFactoryOptions.inJustDecodeBounds = false;
	        bmp = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageFileUri), null, bmpFactoryOptions);

	        alteredBitmap = Bitmap.createBitmap(bmp.getWidth(), bmp.getHeight(), bmp.getConfig());
	        
	        canvas = new Canvas(alteredBitmap);
	        paint = new Paint();
	        paint.setColor(Color.GREEN);
	        paint.setStrokeWidth(5f);
	        matrix = new Matrix();
	        canvas.drawBitmap(bmp, matrix, paint);
	        
	        //canvas.drawPath(path, paint);

	        choosenImageView.setImageBitmap(alteredBitmap);	        
	        choosenImageView.setOnTouchListener(this);
	      } 
	      catch (Exception e) 
	      {
	        Log.v("ERROR", e.toString());
	      }
	    }
	    
	    
	    //For Camera
	   else if(requestCode==11 && resultCode==Activity.RESULT_OK)
	    {	         
			 alteredBitmap = (Bitmap)intent.getExtras().get("data");
			 choosenImageView.setImageBitmap(alteredBitmap);
			 choosenImageView.setOnTouchListener(this);
	    }    
	    
	  }	 
	  
	  public boolean onTouch(View v, MotionEvent event)
	  {
	    /*int action = event.getAction();
	    switch (action) {
	    case MotionEvent.ACTION_DOWN:
	      downx = event.getX();
	      downy = event.getY();
	      break;
	      
	    case MotionEvent.ACTION_MOVE:
	      upx = event.getX();
	      upy = event.getY();
	      canvas.drawLine(downx, downy, upx, upy, paint);
	      choosenImageView.invalidate();
	      downx = upx;
	      downy = upy;
	      break;
	      
	    case MotionEvent.ACTION_UP:
	      upx = event.getX();
	      upy = event.getY();
	      canvas.drawLine(downx, downy, upx, upy, paint);
	      choosenImageView.invalidate();
	      break;
	      
	    case MotionEvent.ACTION_CANCEL:
	      break;
	      
	    default:
	      break;
	    }
	    return true;*/
		  
		  
		  /////////////////////////////////////////////////////////////////////////////////////////
		  
		  
		  float eventX = event.getX();
		    float eventY = event.getY();

		    switch (event.getAction())
		    {
		    
		    case MotionEvent.ACTION_DOWN:
		    	
		      path.moveTo(eventX, eventY);
		      return true;
		      
		    case MotionEvent.ACTION_MOVE:
		    	
		      path.lineTo(eventX, eventY);
		      break;
		      
		    case MotionEvent.ACTION_UP:
		    	
		      // nothing to do
		      break;
		    default:
		      return false;
		    }

		    // Schedules a repaint.
		    choosenImageView.invalidate();
		    return true;
		  
		  /////////////////////////////////////////////////////
	  }
	  
	  
	 /* public void info(View clickedButton)
	    {
	    	//Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_LONG).show();
	        Intent activityIntent = new Intent(this,Info.class);
	        startActivity(activityIntent);
	    }*/
	  
	  
	  
}