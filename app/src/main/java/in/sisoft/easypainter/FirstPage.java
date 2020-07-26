package in.sisoft.easypainter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/*
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
*/

import in.sisoft.bitmap.BitmapEffect;
import in.sisoft.bitmap.DrawingPath;
import in.sisoft.view.DrawPaintView;
import in.sisoft.view.ImageViewWithZoom;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
//import android.drm.DrmStore.Action;
//import android.graphics.AvoidXfermode.Mode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
//import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.core.content.FileProvider;

//import com.facebook.android.*;
//import com.facebook.android.Facebook.DialogListener;

// @SuppressLint("NewApi")

public class FirstPage  extends Activity implements OnClickListener
{
	// private static File APP_FILE_PATH = new File("/sdcard/EasyPainterDrawings");
	 ImageViewWithZoom imvz	;
	 DrawPaintView drawingview;
	 
	 boolean eflag=true;
	 int flflag=1;
     
	 Paint paint;
     Path path;
     
     ImageView drawView;
     
     Button choosePicture,newpage,btn_brush,btn_colorpick,takepic,btn_eraser,btn_undo,btn_redo,btn_bgcolor,btn_home;
	 Button btn_britness,btn_contrast,btn_distort,btn_eefect,effectclose,savePicture,imgeffect,btn_email;
     
	 View stv;     
     
	 float ps=3;                         //Brush Size
     String mode="draw";
	 int cid=R.color.c3;                // Color ID
     int bgcolor=R.color.c1;
     
     List<DrawingPath> currentpath;     
     
     Canvas canvas1;
	 Matrix matrix;
	  
	 String temp="myDraw";
	 
	 Point p;     
	 
     Bitmap bmp,bitmp2;
	 Bitmap alteredBitmap,comeffectbmp;
	 Bitmap bitmap;
     FrameLayout fl1,fl2;
     LinearLayout effectscrollview,footer_drawlayout;
     HorizontalScrollView toolsscrollview;
     TableLayout getpic_layout;
     Boolean hsvisiable=false;
     
     ImageView eimg1,eimg2,eimg3,eimg4,eimg5,eimg6,eimg7,eimg8;
     Bitmap   bmp1,bmp2,bmp3,bmp4,bmp5,bmp6,bmp7,bmp8;
     Bitmap mainbmp;
   
//     private static final String FACEBOOK_APPID = "PUT YOUR FACEBOOK APPID HERE";
// 	 private static final String FACEBOOK_PERMISSION = "publish_stream";
    //////////////////////////////////////////////////////////////////////////////////////// 
     boolean ereasf=true;
     String recid;
     BitmapEffect bea;
     
     HashMap<String, Bitmap> hashbmp;
     ProgressDialog pDialog ;
     
	 public void onCreate(Bundle savedInstanceState)
	  {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.newdraw);
	    	  
	    //drawingview=new DrawPaintView(this);

/*
	    if (android.os.Build.VERSION.SDK_INT > 9)
	    {

            StrictMode.ThreadPolicy policy =new StrictMode.ThreadPolicy.Builder().permitAll().build();

            StrictMode.setThreadPolicy(policy);

        }

 */

	    Intent intid=this.getIntent();
	    recid=intid.getExtras().getString("RecId");
	
	      fl1=(FrameLayout)findViewById(R.id.paintView);
	      fl2=(FrameLayout)findViewById(R.id.ImageView);
	     
	      effectscrollview=(LinearLayout)findViewById(R.id.footer_effect_layout);
	      footer_drawlayout=(LinearLayout)findViewById(R.id.footer_draw_layout);
	      toolsscrollview=(HorizontalScrollView)findViewById(R.id.hsv_drawtools);
	      getpic_layout=(TableLayout)findViewById(R.id.getPicture_layout);
	      
	      drawView=(ImageView)findViewById(R.id.ImageView2);
	      
	      
	      fl1.setVisibility(View.GONE);
	      fl2.setVisibility(View.GONE);
	      effectscrollview.setVisibility(View.GONE);
	      toolsscrollview.setVisibility(View.GONE);
	    
	      takepic= (Button) this.findViewById(R.id.btn_takepic);
	      choosePicture = (Button) this.findViewById(R.id.btn_choocepic);

	    
	     
	      savePicture = (Button) this.findViewById(R.id.SavePictureButton);
          btn_eraser = (Button) this.findViewById(R.id.btn_eraser);
          btn_undo= (Button) this.findViewById(R.id.btn_undo);
          btn_redo= (Button) this.findViewById(R.id.btn_redo);
          btn_bgcolor=(Button) this.findViewById(R.id.btn_bgcolor);
	      btn_home= (Button) this.findViewById(R.id.btn_home);
	      btn_email=(Button)this.findViewById(R.id.btn_email);
	      imgeffect=(Button)this.findViewById(R.id.btn_imgeffect);
	      
	      /////////////////////////////////////Effect Image/////////////////////////////////////////
	      btn_distort=(Button)findViewById(R.id.btn_distort);
	      btn_distort.setOnClickListener(this);
	     
	      
	      btn_britness=(Button)findViewById(R.id.btn_brightness);
	      btn_britness.setOnClickListener(this);
	      
	      btn_contrast=(Button)findViewById(R.id.btn_contrast);
	      btn_contrast.setOnClickListener(this);
	      btn_eefect=(Button)findViewById(R.id.btn_eeffect);
	      btn_eefect.setOnClickListener(this);
	      effectclose=(Button)findViewById(R.id.btn_effect_close);
	      effectclose.setOnClickListener(this);
	     
	     bea=new BitmapEffect();					 
			
			
		      
	      btn_home.setOnClickListener(this);
	      btn_eraser.setOnClickListener(this);	        
	      savePicture.setOnClickListener(this);	    
	      takepic.setOnClickListener(this);
	      choosePicture.setOnClickListener(this);
	    
	      imgeffect.setOnClickListener(this);
	      btn_bgcolor.setOnClickListener(this);	     
	      btn_undo.setOnClickListener(this);
	      btn_redo.setOnClickListener(this);	     
	      btn_email.setOnClickListener(this);
	        
	    
	     btn_brush=(Button)findViewById(R.id.btn_brush);	
	     btn_brush.setOnClickListener(this); 
	   
	     btn_colorpick=(Button)findViewById(R.id.btn_colorpick);	
	     btn_colorpick.setOnClickListener(this); 	      
	   }	
	 
	 
	
	 public void onClick(View v)
	  {		 
		
		 if(v==btn_home)
		 {
			  AlertDialog alertDialog = new AlertDialog.Builder(FirstPage.this).create(); 
			  alertDialog.setTitle("Save and Exit ");
			  alertDialog.setMessage("Do you want to save  then Exit ?");
			  alertDialog.setButton( alertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() 
			   {
			     public void onClick(DialogInterface dialog, int which) 
			     {
			     	   dialog.cancel();
			    	   saveImage();
			    	   finish();
			      }});

			      alertDialog.setButton( alertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener()
			      {
			      public void onClick(DialogInterface dialog, int which) 
			      {
			    	    
			    	  dialog.cancel();
			      }});
			      
			      alertDialog.setButton( alertDialog.BUTTON_NEUTRAL, "No", new DialogInterface.OnClickListener()
			      {
			      public void onClick(DialogInterface dialog, int which) 
			      {
			    	  //  Intent backint=new Intent();
					  // 	setResult(RESULT_OK, backint);
					  dialog.cancel();
					  finish();
			      }});
			      
			    alertDialog.show();
			 
		 }
		  if (v == btn_bgcolor) 
		    {	    	
		    	//Form Camara
		    	  eflag=true;
		    	 Intent colorpick=new Intent(this,ColorPicker.class);
		    	 colorpick.putExtra("CID",cid);
		    	 colorpick.putExtra("rid",1);
				 startActivityForResult(colorpick,205);
		    	 mode="erese";
		    	//choosenImageView.set    	
		    }

	   if (v == choosePicture) 
	    {
	    	 //selectImageMenu(v);
		     toolsscrollview.setEnabled(false);
	    	 clickalbum();    	
	    	 mode="draw";
	    }    
	    
	    else if (v == takepic) 
	    {	  
	    	 bgcolor=R.color.c1;
	    	//Form Camara	    	
	    	 Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	         startActivityForResult(i, 201);
	         fl1.setVisibility(View.GONE);
	         fl2.setVisibility(View.VISIBLE);
	         toolsscrollview.setEnabled(false);
	         flflag=0;
	    } 
	    
	    
	    else if (v == btn_brush) 
	    {	    	
	    	//Form Camara	    	
	    	 Intent brush=new Intent(this,Brush.class);	    	 
	    	 brush.putExtra("brushps", ps); 					//Brush Size
			 startActivityForResult(brush,202);
			 mode="draw";
	    	//choosenImageView.set    	
	    }
	    	    
	    else if (v == btn_colorpick) 
	    {	    	
	    	//Form Camara
	    	  eflag=true;
	    	 Intent colorpick=new Intent(this,ColorPicker.class);
	    	 colorpick.putExtra("CID",cid);
	    	 colorpick.putExtra("RID",2);
			 startActivityForResult(colorpick,203);
			 mode="draw";
	    	//choosenImageView.set    	
	    }
	    
	    else if (v == imgeffect) 
	    {	
	    	//if(hsvisiable.equals(false))
	    	//{
	    	  effectscrollview.setVisibility(View.VISIBLE);
	    	  btn_distort.setVisibility(View.GONE);
	    	  footer_drawlayout.setVisibility(View.GONE);
	    	  //Toast.makeText(getApplicationContext(), "Show", Toast.LENGTH_LONG).show();
	    	/*  hsvisiable=true;
	    
	    	  
	    	}
	    	else if(hsvisiable.equals(true))
	    	{
	    		 effectscrollview.setVisibility(View.GONE);
	    		 Toast.makeText(getApplicationContext(), "hide", Toast.LENGTH_LONG).show();
	    	     hsvisiable=false;
	    	}*/
	    	 	
	    }	     
	 	   
	    else if (v == effectclose) 
	    {	
	    	 effectscrollview.setVisibility(View.GONE);
	    	 footer_drawlayout.setVisibility(View.VISIBLE);
	      	    		
	    	 	
	    }
	   else if (v == btn_distort) 
	    {	
/*
	    	drawView.setDrawingCacheEnabled(true);
	    	drawView.buildDrawingCache();
	    	Bitmap ebp=drawView.getDrawingCache();
*/
			Bitmap ebp = Bitmap.createBitmap(drawView.getMeasuredWidth(),drawView.getMeasuredHeight(),Bitmap.Config.ARGB_8888);


			if(ebp!=null)
	    	{
	    		Intent effectint=new Intent(FirstPage.this,BitmapMesh.class);	    	
		    	effectint.putExtra("BitmapImage", ebp);
		    	effectint.putExtra("effectId","mesh");
		    	startActivityForResult(effectint, 300);
	    	}
	    	else 
	    		Toast.makeText(getApplicationContext(), "Blank Bitmap..",Toast.LENGTH_LONG).show();
	    	
	    	    		
	    	 	
	    }
	   
	    else if (v == btn_britness) 
	    {	

	    	drawView.setDrawingCacheEnabled(true);
	    	drawView.buildDrawingCache();
	    	Bitmap ebp=drawView.getDrawingCache();

//			Bitmap ebp = Bitmap.createBitmap(drawView.getMeasuredWidth(),drawView.getMeasuredHeight(),Bitmap.Config.ARGB_8888);

			if(ebp!=null)
	    	{
	    		Intent effectint=new Intent(FirstPage.this,EffectSetting.class);

				ByteArrayOutputStream bStream = new ByteArrayOutputStream();
				ebp.compress(Bitmap.CompressFormat.PNG, 100, bStream);
				byte[] byteArray = bStream.toByteArray();
				effectint.putExtra("BitmapImage", byteArray);

				// effectint.putExtra("BitmapImage", ebp);
		    	effectint.putExtra("effectId","bright");
		    	startActivityForResult(effectint, 301);
	    	}
	    	else 
	    		Toast.makeText(getApplicationContext(), "Blank Bitmap..",Toast.LENGTH_LONG).show();
	    	
	    	    		
	    	 	
	    }
	   

	    else if (v == btn_contrast) 
	    {	
	    	
/*
	    	drawView.setDrawingCacheEnabled(true);
	    	drawView.buildDrawingCache();
	    	Bitmap ebp=drawView.getDrawingCache();

 */
			Bitmap ebp = Bitmap.createBitmap(drawView.getMeasuredWidth(),drawView.getMeasuredHeight(),Bitmap.Config.ARGB_8888);

			if(ebp!=null)
	    	{
	    		Intent effectint=new Intent(FirstPage.this,EffectSetting.class);

				ByteArrayOutputStream bStream = new ByteArrayOutputStream();
				ebp.compress(Bitmap.CompressFormat.PNG, 100, bStream);
				byte[] byteArray = bStream.toByteArray();
				effectint.putExtra("BitmapImage", byteArray);

			//	effectint.putExtra("BitmapImage", ebp);
		    	effectint.putExtra("effectId","contrast");
		    	startActivityForResult(effectint, 302);
	    	}
	    	else 
	    		Toast.makeText(getApplicationContext(), "Blank Bitmap..",Toast.LENGTH_LONG).show();
	    	
	       }
	   
	    else if (v == btn_eefect) 
	    {	
	    	Toast.makeText(getApplicationContext(), "Image Loading Please Wait...", Toast.LENGTH_LONG).show();
//	    	drawView.setDrawingCacheEnabled(true);
//	    	drawView.buildDrawingCache();,
//	    	Bitmap ebp=drawView.getDrawingCache();
	    	Bitmap ebp = Bitmap.createBitmap(drawView.getMeasuredWidth(),drawView.getMeasuredHeight(),Bitmap.Config.ARGB_8888);

	    	if(ebp!=null)
	    	{
	    		Intent effectint=new Intent(FirstPage.this,EffectSetting.class);

				// Used byteArray to xfer file in intent. Otherwise getting Binder Failed Error

				ByteArrayOutputStream bStream = new ByteArrayOutputStream();
				ebp.compress(Bitmap.CompressFormat.PNG, 100, bStream);
				byte[] byteArray = bStream.toByteArray();
		    	effectint.putExtra("BitmapImage", byteArray);
		    	effectint.putExtra("effectId","eeffect");
		    	startActivityForResult(effectint, 303);
	    	}
	    	else 
	    		Toast.makeText(getApplicationContext(), "Blank Bitmap..",Toast.LENGTH_LONG).show();
	    	
	       }
	   
	    else if (v == btn_eraser) 
	    {    	    	
	    	
	    	   Intent brush=new Intent(this,Eraser.class);
	    	   brush.putExtra("bcid",bgcolor);
			   startActivityForResult(brush,204);
	    	
	    	 //drawingview.erasePath("erese");
	    	 Toast.makeText(getApplicationContext(), "Erese Mode", Toast.LENGTH_LONG).show();
	    	 //mode="erese";
	    	/////////////////////////////////////////////////////////////////////////////////////////////
	    	  	
	    	
	    	/*try
	    	{
	    		//drawingview.erasePath();
	    		
	    		Toast.makeText(getApplicationContext(), "Erese Mode", Toast.LENGTH_LONG).show();	
	    	}
	    	catch (Exception e)
	    	{	// TODO: handle exception
			
	    		AlertDialog.Builder al=new AlertDialog.Builder(this);
	    		al.setMessage(e.toString());
	    		al.show();
	    		
	    	}	*/    	
	    	 
	    	///////////////////////////////////////////////////////////////////////////////////////////////////   	
	    }
	    
	    
	    else if (v == btn_undo) 
	    {	    	
	    	
			try
			{
				
				drawingview.onClickUndo();			
				
			}
			catch (Exception e) 
			{
				//TODO: handle exception
				AlertDialog.Builder ab=new AlertDialog.Builder(this);
				ab.setMessage(e.toString());
				ab.show();
			}  	 
	    	
	    	//choosenImageView.set     	
	    	
	    }  
	    
	    
	    else if (v == btn_redo) 
	    {	    	
			try
			{
				
				drawingview.onClickRedo();			
				
			}
			catch (Exception e) 
			{
				//TODO: handle exception
				AlertDialog.Builder ab=new AlertDialog.Builder(this);
				ab.setMessage(e.toString());
				ab.show();
			}    	
	    
	    }
	    
	    else if (v == savePicture) 
	    {
	    	//saveImage(); 	
	    	
	    	AlertDialog alertDialog = new AlertDialog.Builder(FirstPage.this).create(); 
		    alertDialog.setTitle("Do you want to save image..");
		   alertDialog.setButton( alertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() 
		     {
		       public void onClick(DialogInterface dialog, int which) 
		         {
		    	       saveImage();
		    	     //savePhoto();
		         }
		       });

		      alertDialog.setButton(alertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener()   
		      {
		      public void onClick(DialogInterface dialog, int which) 
		      {
		    	  dialog.cancel();

		      }});

		    alertDialog.show();	    	    	
	    }   
	   
	    else if(v==btn_email)
	     {
	    	shareImage();	        
	       //Toast.makeText(getApplicationContext(), "Coming soon in next version...", Toast.LENGTH_LONG).show();
	     }	
	  } 	 
	 public void  onStart() 
	 {
		 super.onStart();	
		 
	//	 AmazonAdsTop();
		 drawingview=new DrawPaintView(this,ps,cid);
		 fl1.setBackgroundResource(bgcolor);
		 
		 if(recid.equals("1"))
		    {
			    toolsscrollview.setVisibility(View.VISIBLE);
			    fl1.setVisibility(View.VISIBLE);
		    	takepic.setVisibility(View.GONE);
		    	choosePicture.setVisibility(View.GONE);
		    	imgeffect.setVisibility(View.GONE);
		    	flflag=1; 	
		    }
		    else if(recid.equals("2") ||recid.equals("3"))
		    {
		    	//clickalbum();
		    	btn_bgcolor.setVisibility(View.GONE);
		    	takepic.setVisibility(View.VISIBLE);
		    	btn_eraser.setVisibility(View.GONE);	
		    	flflag=0; 
		    }		    
		   
		 
		 if(flflag==1)
		   {
			 fl1.addView(drawingview);
		   }
		 
		 if(flflag==0)
		   {
			 fl2.addView(drawingview);
		   }	
		
			
	 }
	 
	 public void onResume() 
	 {
		 super.onResume();
		 drawingview=new DrawPaintView(this,ps,cid);
		 fl1.setBackgroundResource(bgcolor);
		 
		 if(recid.equals("1"))
		    {
			    toolsscrollview.setVisibility(View.VISIBLE);
			    fl1.setVisibility(View.VISIBLE);
		    	takepic.setVisibility(View.GONE);
		    	choosePicture.setVisibility(View.GONE);
		    	 flflag=1; 		
		    }
		 else if(recid.equals("2") ||recid.equals("3"))
		    {
		    	//clickalbum();
		    	btn_bgcolor.setVisibility(View.GONE);
		    	takepic.setVisibility(View.VISIBLE);
		    	btn_eraser.setVisibility(View.GONE);	
		    	flflag=0; 
		    }		    
		   
		 
		 if(flflag==1)
		   {
			 fl1.addView(drawingview);
		   }
		 
		 if(flflag==0)
		   {
			 fl2.addView(drawingview);
		   }
		
		
		 //drawView.addView(new SingleTouchEventView(this,null));
		 //Toast.makeText(getApplicationContext(),"Back23 "+ps, Toast.LENGTH_LONG).show();
	}	  
	
	 protected void onActivityResult(int requestCode, int resultCode,Intent intent)
	  {
	     super.onActivityResult(requestCode, resultCode, intent);
	     try
	        {
	    	 
	    	 if ((requestCode == 200) && resultCode == RESULT_OK) 
	 	      {
	 	        Uri imageFileUri = intent.getData();
	 	     
	 	         BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();
	 	         bmpFactoryOptions.inJustDecodeBounds = true;
	 	        
	 	         bmp = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageFileUri), null, bmpFactoryOptions);

	 	         bmpFactoryOptions.inJustDecodeBounds = false;
	 	         bmp = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageFileUri), null, bmpFactoryOptions);

	 	         alteredBitmap = Bitmap.createBitmap(bmp.getWidth(), bmp.getHeight(), bmp.getConfig());
	 	        
	 	         canvas1 = new Canvas(alteredBitmap);
	 	         paint = new Paint();
	 	         paint.setColor(Color.GREEN);
	 	         paint.setStrokeWidth(5f);
	 	         matrix = new Matrix();
	 	         canvas1.drawBitmap(bmp, matrix, paint);
	 	        
	 	       //canvas.drawPath(path, paint);

	 	       drawView.setImageBitmap(alteredBitmap);
	 	      // mainbmp=alteredBitmap;
	 	      getpic_layout.setVisibility(View.GONE);
	 	     toolsscrollview.setVisibility(View.VISIBLE);
	 	       //effectBimap();
	 	     
	 		 drawView.setDrawingCacheEnabled(true);
			 drawView.buildDrawingCache();
		 	 bitmp2= drawView.getDrawingCache();
	 	     
		 	//effectBimap();// new LoadImage().execute();
	 	        
	 	      } 
	    	 
	    	 //for camera
	    	 if ((requestCode == 201) && resultCode == RESULT_OK) 
		 	    {	    		 
	    		     Bitmap takeBmp = (Bitmap) intent.getExtras().get("data");
	    		     takeBmp = Bitmap.createScaledBitmap(takeBmp, 980, 980, false);	
	    		     mainbmp=alteredBitmap;
	    		     drawView.setImageBitmap(takeBmp);
	    		     getpic_layout.setVisibility(View.GONE);
	    		     toolsscrollview.setVisibility(View.VISIBLE);
	    		     
	    		     //effectBimap();
	    			 drawView.setDrawingCacheEnabled(true);
	    			 drawView.buildDrawingCache();
	    		 	 bitmp2= drawView.getDrawingCache();
	    		 	  //effectBimap();
	    		 	  //new LoadImage().execute();
	    	   } 
	    	 	    	 
			if((requestCode == 202) && (resultCode == Activity.RESULT_OK))
				{				    
					Bundle myResults = intent.getExtras();
					ps =myResults.getInt("PS");
				}			
	     
	      else if ((requestCode == 203) && (resultCode == Activity.RESULT_OK))
			 {			    
			    Bundle myResults = intent.getExtras();
				cid=myResults.getInt("colorID");								   			  			    
			 }
			
		 else if ((requestCode == 204) && (resultCode == Activity.RESULT_OK))
			{			    
			    Bundle myResults = intent.getExtras();
				//Object PorterDuff;
				cid=myResults.getInt("cid");//android
			    ps =myResults.getInt("PS");
			    //drawingview.erasePath();
			  				   			  			    
			 }	
			
			
		  else if ((requestCode == 205) && (resultCode == Activity.RESULT_OK))
			 {			    
			    Bundle myResults = intent.getExtras();
				bgcolor=myResults.getInt("colorID");								   			  			    
			 }
			
			
		  else if ((requestCode == 210) && (resultCode == Activity.RESULT_OK))
			 {			    
			    //Bundle myResults = intent.getExtras();
				Bitmap effectedimg=intent.getParcelableExtra("Eimg");
				drawView.setImageBitmap(effectedimg);
			 }
			
			
			
		  else if ((requestCode == 300) && (resultCode == Activity.RESULT_OK))
			 {			    
			    comeffectbmp=intent.getParcelableExtra("Eimage");
				if(comeffectbmp!=null)
				drawView.setImageBitmap(comeffectbmp);
				else
					Toast.makeText(getApplicationContext(), "Bitmap blanck",Toast.LENGTH_LONG).show();
			 
			 
				  effectscrollview.setVisibility(View.GONE);
		    	 footer_drawlayout.setVisibility(View.VISIBLE);
			 }
			
			
		  else if ((requestCode == 301) && (resultCode == Activity.RESULT_OK))
			 {			    
			     comeffectbmp=intent.getParcelableExtra("Eimage");
				if(comeffectbmp!=null)
				drawView.setImageBitmap(comeffectbmp);
				else
					Toast.makeText(getApplicationContext(), "Bitmap blanck",Toast.LENGTH_LONG).show();
		
			 
				effectscrollview.setVisibility(View.GONE);
		    	 footer_drawlayout.setVisibility(View.VISIBLE);
			 }
			
		  else if ((requestCode == 302) && (resultCode == Activity.RESULT_OK))
			 {			    
			    comeffectbmp=intent.getParcelableExtra("Eimage");
				if(comeffectbmp!=null)
				drawView.setImageBitmap(comeffectbmp);
				else
					Toast.makeText(getApplicationContext(), "Bitmap blanck",Toast.LENGTH_LONG).show();
			 
			 
				  effectscrollview.setVisibility(View.GONE);
		    	 footer_drawlayout.setVisibility(View.VISIBLE);
			 }
			
		  else if ((requestCode == 303) && (resultCode == Activity.RESULT_OK))
			 {			    
			   // Bundle myResults = intent.getExtras();
			  comeffectbmp=intent.getParcelableExtra("Eimage");
				if(comeffectbmp!=null)
				drawView.setImageBitmap(comeffectbmp);
				else
					Toast.makeText(getApplicationContext(), "Bitmap blanck",Toast.LENGTH_LONG).show();
			 
				 effectscrollview.setVisibility(View.GONE);
		    	 footer_drawlayout.setVisibility(View.VISIBLE);
			 }
			
		}
			catch (Exception e) 
			{
			  //lblResult.setText("Problems â€� + requestCode + + resultCode);
			}   
	  }
	
  public void shareImage()
	{			
	  try 
		{			  
		   if(flflag==1 || recid.equals("1"))
			  {
			       fl1.setDrawingCacheEnabled(true);
				   fl1.buildDrawingCache();
				   bitmap=fl1.getDrawingCache();
			 }
			  
			  else if(flflag==0)// || recid.equals("2")|| recid.equals("3"))
			  {
				 fl2.setDrawingCacheEnabled(true);
				 fl2.buildDrawingCache();
				 bitmap=fl2.getDrawingCache();				  
			  }	   
		 
			File  mFile = savebitmap2(bitmap);
			if(bitmap!=null)
			  {
				    Uri u = null;
					//u = Uri.fromFile(mFile);

				  // Used FileProvider to share the image for email program

					u = FileProvider.getUriForFile(getApplicationContext(),"in.sisoft.fileprovider",mFile);
					Log.d("shared URI", u.toString());
					final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
					//
					String address = " ";
					String subject = "EasyPainter image";
				    String 	emailtext = "Please check the attached image";
					//

					 
					emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { address });
					emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
				  	emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, emailtext);

					emailIntent.putExtra(Intent.EXTRA_STREAM,u);

				 	emailIntent.setType("image/*");
				  	//emailIntent.setDataAndType(u,"image/*");
					emailIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

					this.startActivity(Intent.createChooser(emailIntent, "Send mail..."));
				}
					   
				else
					{
						   Toast.makeText(getApplicationContext(), "Bitmap blanck",Toast.LENGTH_LONG).show();
					   }
					} 
				catch (Throwable t)
				    {
					  Toast.makeText(this, "Request failed: " + t.toString(),Toast.LENGTH_LONG).show();
					  Log.d("FirstPage:",t.toString());
					}
			   }//sendEmail
		
	
		private File savebitmap(Bitmap bmp) 
		{
	//		  String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
			  String extStorageDirectory = this.getExternalFilesDir(null).toString();

			OutputStream outStream = null;
			  File file = new File(extStorageDirectory, temp + ".png");
			  if (file.exists()) 
			  {
			   file.delete();
			   file = new File(extStorageDirectory, temp + ".png");
			  }

			  try 
			  {
			    outStream = new FileOutputStream(file);
			    bmp.compress(Bitmap.CompressFormat.PNG, 100, outStream);
			    outStream.flush();
			    outStream.close();
			  }
			  catch (Exception e) 
			  {
			   e.printStackTrace();
			   return null;
			  }
			  return file;
			 }

	private File savebitmap2(Bitmap bmp)
	{

		//		  String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
	//	String extStorageDirectory = this.getExternalFilesDir(null).toString();
		String extStorageDirectory = this.getExternalFilesDir(null) + "/" + "images/";
		File filePath = new File(extStorageDirectory);
		if (!filePath.exists())
		{
			filePath.mkdirs();
		}
		Log.d("savebitmap2",extStorageDirectory);
		OutputStream outStream = null;
		File file = new File(filePath, temp + ".png");
		if (file.exists())
		{
			file.delete();
			file = new File(filePath, temp + ".png");
		}

		try
		{
			outStream = new FileOutputStream(file);
			bmp.compress(Bitmap.CompressFormat.PNG, 100, outStream);
			outStream.flush();
			outStream.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			Log.d("savebitmap2",e.getMessage());
			return null;
		}
		return file;
	}


	public void saveImage()
	{
	   OutputStream ops;
 	   Uri fileuri;
 	   
 	    		 
		//File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "EasyPainter");
 	   
// 	    File root=new File(Environment.getExternalStorageDirectory()+File.separator+"EasyPainter"+File.separator);
		File root=new File(this.getExternalFilesDir(null)+File.separator+"EasyPainter"+File.separator);

		if (!root.exists())
 	    root.mkdir();
	    	//SingleTouchEventView stev=new SingleTouchEventView(this,null);
	   if(flflag==1)
	   {
	    	fl1.setDrawingCacheEnabled(true);
	    	fl1.buildDrawingCache();
	    	bitmap= fl1.getDrawingCache();
	   }
	   
	   if(flflag==0)
	   {
	    	fl2.setDrawingCacheEnabled(true);
	    	fl2.buildDrawingCache();
	    	bitmap= fl2.getDrawingCache();
	   }
	   
	       	    // if (alteredBitmap != null)
	      if(bitmap !=null)
	        {
	         try 
		      {    	       
	    	  //////////////////////////////////////////////////////////////////////////////////////////////
	        		        	 
	          Calendar c = Calendar.getInstance();
	   		  String date = fromInt(c.get(Calendar.MONTH))
	   		              + fromInt(c.get(Calendar.DAY_OF_MONTH))
	   		              + fromInt(c.get(Calendar.YEAR))
	   		              + fromInt(c.get(Calendar.HOUR_OF_DAY))
	   		              + fromInt(c.get(Calendar.MINUTE))
	   		              + fromInt(c.get(Calendar.SECOND));
	   		  
	          //File imageFileName = new File(imageFileFolder, date.toString() + ".jpg");
	        	 
	        	 
	         /////////////////////////////////////////////////////////////////////////////////////////////   
	             File dsdirectory=new File(root,date.toString() + ".JPEG");
	        	 fileuri=Uri.fromFile(dsdirectory);
	        	 ops=new FileOutputStream(dsdirectory);
	        	 bitmap.compress(Bitmap.CompressFormat.JPEG, 100, ops);
	        	 ops.flush();
	        	 ops.close();
	        	 
	        	 //////////////////////////////////////////////////////////////////////////////////////////////
	        	 
	              //Toast.makeText(this, "start Saved!", Toast.LENGTH_SHORT).show();
	              //ContentValues contentValues = new ContentValues(30);
	            //contentValues.put(Media.DISPLAY_NAME, "Draw On Me");
	            //Uri imageFileUri = getContentResolver().insert(Media.EXTERNAL_CONTENT_URI,contentValues);	        
	          //OutputStream imageFileOS = getContentResolver().openOutputStream(imageFileUri);	          
	         /*FileOutputStream imagesaveuri=new FileOutputStream("/Easypainter/image");
	          bitmap.compress(CompressFormat.JPEG,90,imagesaveuri);       
	         
	          drawingview.refreshDrawableState();*/	          
	          
	          Toast t = Toast.makeText(this, date.toString() +" "+"Saved!",Toast.LENGTH_SHORT);
	          
	          t.show();
	    	  
	    	   /*Uri imageFileUri = intent.getData();
	    	    BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();
	    	    bmpFactoryOptions.inJustDecodeBounds = true;
	 	        
	 	        bmp = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageFileUri), null, bmpFactoryOptions);

	 	        bmpFactoryOptions.inJustDecodeBounds = false;
	 	        bmp = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageFileUri), null, bmpFactoryOptions);

	 	        alteredBitmap = Bitmap.createBitmap(bmp.getWidth(), bmp.getHeight(), bmp.getConfig());*/
		   } 
	    	  	    	  
	          catch (Exception e) 
		        {
		          Log.v("EXCEPTION", e.getMessage());
		          Toast.makeText(getApplicationContext(), "Error : "+e.toString(),Toast.LENGTH_LONG).show();
		        }
		   }		
		} 
  
  public void savePhoto()
  {
  
	//  File imageFileFolder = new File(Environment.getExternalStorageDirectory(),"Rotate");
	   File imageFileFolder = new File(this.getExternalFilesDir(null),"Rotate");

  if(!imageFileFolder.exists())
    imageFileFolder.mkdir();
    FileOutputStream out = null;
    Calendar c = Calendar.getInstance();
    String date = fromInt(c.get(Calendar.MONTH))
              + fromInt(c.get(Calendar.DAY_OF_MONTH))
              + fromInt(c.get(Calendar.YEAR))
              + fromInt(c.get(Calendar.HOUR_OF_DAY))
              + fromInt(c.get(Calendar.MINUTE))
              + fromInt(c.get(Calendar.SECOND));
 File imageFileName = new File(imageFileFolder, date.toString() + ".jpg");
  try
   {
	   out = new FileOutputStream(imageFileName);
	   bmp.compress(Bitmap.CompressFormat.JPEG, 100, out);
	   
	   Toast.makeText(getApplicationContext(), "Seve",Toast.LENGTH_LONG).show();
	  
	   //scanPhoto(imageFileName.toString());
	   MediaStore.Images.Media.insertImage(getContentResolver(),imageFileName.getAbsolutePath(),imageFileName.getName(),imageFileName.getName());
	   //MediaStore.Images.Media.i//getContentUri(imageFileFolder.getAbsolutePath());
	   out.flush();
	   out.close();
	   out = null;
   } 
  catch (Exception e)
  {
   e.printStackTrace();
  }
  }


  public String fromInt(int val)
  {
    return String.valueOf(val);
  }


 public void showToast(String sms)
  {
	 Toast.makeText(getApplicationContext(),sms,Toast.LENGTH_LONG).show();	 
  }
  
 public void clickalbum()
 {
	 bgcolor=R.color.c1;
 	 //from Gallery
	 flflag=0;
     
	 Intent choosePictureIntent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
     startActivityForResult(choosePictureIntent, 200);
 	
      choosePicture.setVisibility(View.GONE);
      fl1.setVisibility(View.GONE);
      fl2.setVisibility(View.VISIBLE);
      //kkk
 }
 
 public void clickcamera()
 {
	 bgcolor=R.color.c1;
 	//Form Camara
	 flflag=0;
	 
 	 Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
     startActivityForResult(i, 201);
     takepic.setVisibility(View.GONE);
     fl1.setVisibility(View.GONE);
     fl2.setVisibility(View.VISIBLE);      
 } 

}
