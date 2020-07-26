package in.sisoft.easypainter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import in.sisoft.bitmap.BitmapEffect;
import in.sisoft.view.MeshView;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.FileProvider;

public class EffectSetting extends Activity implements OnSeekBarChangeListener
{
	Bitmap effectbmp,backbmp,bmp,bmp1,bmp2,bmp3,bmp4,bmp5,bmp6,bmp7,bmp8;
	Button btn_refresh,btn_close,btn_save,btn_share;
	FrameLayout meshfl;
	ImageView imgview;
	SeekBar seek_setting;
	String eid;
	int value;
	BitmapEffect beffect;
	MeshView meshview;
	TextView tital;
	String temp="myDraw";
	ImageView eimg1,eimg2,eimg3,eimg4,eimg5,eimg6,eimg7,eimg8;
	HorizontalScrollView hsv;
	LinearLayout seeklayout;
	
	List<Bitmap> listBMP;
	
	ProgressDialog pDialog ;
    boolean isAlphaOriginalValue = true;
    boolean isRotationOriginalValue = true;
    boolean isScaleOriginalValue = true;
    Matrix mMatrix = new Matrix();

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.effectsetting);		

		// Get the bitmap image and effect Id
		Intent getbmp=this.getIntent();
		byte[] byteArray = getIntent().getByteArrayExtra("BitmapImage");
		bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
		//bmp=getbmp.getParcelableExtra("BitmapImage");
		eid=getbmp.getExtras().getString("effectId");
		
		hsv=(HorizontalScrollView)findViewById(R.id.hsv_eeffect_layout);
		hsv.setVisibility(View.GONE);
		meshfl=(FrameLayout)findViewById(R.id.fl_effectVew);
		seeklayout=(LinearLayout)findViewById(R.id.seek_layout);
		
		seek_setting=(SeekBar)findViewById(R.id.seek_adjectment);
		seek_setting.setOnSeekBarChangeListener(this);
		seek_setting.setMax(100);
		
		//seek_setting.setProgress(5);
		
		tital=(TextView)findViewById(R.id.txt_effecttitle);
		imgview=(ImageView)findViewById(R.id.imgview_settingeffect);
		imgview.setImageBitmap(bmp);
		
		eimg1=(ImageView)findViewById(R.id.bmp_effect1);			
		eimg2=(ImageView)findViewById(R.id.bmp_effect2);
		eimg3=(ImageView)findViewById(R.id.bmp_effect3);			
		eimg4=(ImageView)findViewById(R.id.bmp_effect4);
		eimg5=(ImageView)findViewById(R.id.bmp_effect5);			
		eimg6=(ImageView)findViewById(R.id.bmp_effect6);
		eimg7=(ImageView)findViewById(R.id.bmp_effect7);			
		eimg8=(ImageView)findViewById(R.id.bmp_effect8);
					
		eimg1.setOnClickListener(new View.OnClickListener() 
		{				
				@Override
				public void onClick(View v) 
				{
					// TODO Auto-generated method stub	
					//Toast.makeText(getApplicationContext(), "pic select please wait...", Toast.LENGTH_LONG).show();
					imgview.setImageBitmap(bmp);
				 }
			});
			
						
	        eimg2.setOnClickListener(new View.OnClickListener() 
	        {
				@Override
				public void onClick(View v) 
				{
					// TODO Auto-generated method stub
					    //Toast.makeText(getApplicationContext(), "pic select please wait...", Toast.LENGTH_LONG).show();	
						//bmp2=beffect.invert(bmp, 1, 225, 255, 255);
						imgview.setImageBitmap(listBMP.get(1));
				}
			});			
		
			 eimg3.setOnClickListener(new View.OnClickListener() 
		        {
					@Override
					public void onClick(View v) 
					{
						// TODO Auto-generated method stub
						//Toast.makeText(getApplicationContext(), "pic select please wait...", Toast.LENGTH_LONG).show();					
						//bmp3=beffect.toSephia(bmp, 40);
						imgview.setImageBitmap(listBMP.get(2));
					 	
					}
				});
			
			
			 eimg4.setOnClickListener(new View.OnClickListener() 
		        {
					@Override
					public void onClick(View v) 
					{
						// TODO Auto-generated method stub
					
						//Toast.makeText(getApplicationContext(), "pic select please wait...", Toast.LENGTH_LONG).show();
						//bmp4=beffect.toSephia(bmp, 100);						
						imgview.setImageBitmap(listBMP.get(3));
						
					}
				});
			
			
			 eimg5.setOnClickListener(new View.OnClickListener() 
				{				
						@Override
						public void onClick(View v) 
						{
							// TODO Auto-generated method stub	
							//Toast.makeText(getApplicationContext(), "pic select please wait...", Toast.LENGTH_LONG).show();
							imgview.setImageBitmap(listBMP.get(4));
						 }
					});
					
								
			        eimg6.setOnClickListener(new View.OnClickListener() 
			        {
						@Override
						public void onClick(View v) 
						{
							// TODO Auto-generated method stub
							   // Toast.makeText(getApplicationContext(), "pic select please wait...", Toast.LENGTH_LONG).show();	
								//bmp2=beffect.invert(bmp, 1, 225, 255, 255);
								imgview.setImageBitmap(listBMP.get(5));
						}
					});			
				
					 eimg7.setOnClickListener(new View.OnClickListener() 
				        {
							@Override
							public void onClick(View v) 
							{
								// TODO Auto-generated method stub
								//Toast.makeText(getApplicationContext(), "pic select please wait...", Toast.LENGTH_LONG).show();					
								//bmp3=beffect.toSephia(bmp, 40);
								imgview.setImageBitmap(listBMP.get(6));
							 	
							}
						});					
					
				
		
		btn_refresh=(Button)findViewById(R.id.btn_refresh);
		btn_refresh.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
				imgview.setImageBitmap(bmp);				
				seek_setting.setProgress(5);
				
			}
		});
		
		//btn_done.setVisibility(View.GONE);
		btn_save=(Button)findViewById(R.id.btn_effectsave);
		btn_save.setOnClickListener(new View.OnClickListener() 
		{
		    @Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
		    	
		    	AlertDialog alertDialog = new AlertDialog.Builder(EffectSetting.this).create(); 
			    alertDialog.setTitle("Do you want to save image..");
			    alertDialog.setButton( alertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener()
			     {
			       public void onClick(DialogInterface dialog, int which) 
			         {
			    	       saveImage();
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
		});
		
		
		btn_share=(Button)findViewById(R.id.btn_effectshare);
		btn_share.setOnClickListener(new View.OnClickListener() 
		{
		    @Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
				shareImage();
				//backImage();
			}
		});
		
		btn_close=(Button)findViewById(R.id.btn_effectback);
		btn_close.setOnClickListener(new View.OnClickListener() 
		{
		    @Override
			public void onClick(View arg0) 
			{
				// TODO Auto-generated method stub
		    		    			    	
		    	AlertDialog alertDialog = new AlertDialog.Builder(EffectSetting.this).create(); 
			    alertDialog.setTitle("Do you want to back with image..");
			    alertDialog.setButton( alertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener()
			     {
			       public void onClick(DialogInterface dialog, int which) 
			         {
			    	     imgview.setDrawingCacheEnabled(true);
			             imgview.buildDrawingCache();
			             backbmp=imgview.getDrawingCache();
			    	     backImage(backbmp);
			         }
			       });

			      alertDialog.setButton(alertDialog.BUTTON_NEUTRAL, "No", new DialogInterface.OnClickListener()   
			      {
			      public void onClick(DialogInterface dialog, int which) 
			      {
			    	   backImage(backbmp);

			      }});
			      alertDialog.setButton(alertDialog.BUTTON_NEGATIVE, "Cancle", new DialogInterface.OnClickListener()   
			      {
			      public void onClick(DialogInterface dialog, int which) 
			      {
			    	  dialog.cancel();

			      }});

			    alertDialog.show();	 
			}
		});	
		
	}
	
	
	public void onStart()
	{ 
		super.onStart();
		beffect=new BitmapEffect();
		meshview=new MeshView(this,bmp);
		if(eid.equals("mesh"))
		{
			seeklayout.setVisibility(View.GONE);
			meshfl.addView(meshview);
			imgview.setVisibility(View.GONE);
		}
		
		if(eid.equals("bright") || eid.equals("contrast") )
		{
			seeklayout.setVisibility(View.VISIBLE);
			imgview.setVisibility(View.VISIBLE);
		}
		
		if(eid.equals("eeffect") )
		{
			seeklayout.setVisibility(View.GONE);
			imgview.setVisibility(View.VISIBLE);
			hsv.setVisibility(View.VISIBLE);
			effectBimap();
			//new LoadImage().execute();
		}
		
	}
	
	
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser)
	{
		// TODO Auto-generated method stub
		value=progress;
		
		if(eid.equals("bright"))
		{
			try
			{
				tital.setText("Britness"+" "+value);
				Bitmap imgbmp=beffect.doBrightness(bmp,value);
				
				if(imgbmp!=null)
				{
				   imgview.setImageBitmap(imgbmp);
				}
				else
					Toast.makeText(getApplicationContext(), "Blank Bitmap",Toast.LENGTH_LONG).show();
					
			}
			catch (Exception e) 
			{
				// TODO: handle exception
				AlertDialog.Builder al=new AlertDialog.Builder(this);
				al.setMessage("Error "+e.toString());
				al.show();
			}
			
			
		}
		else if (eid.equals("contrast"))
		{
			try
			{
				tital.setText("Contrast"+" "+value);
				
				alphaXform(value);
			//Bitmap imgbmp=beffect.doContract1(bmp, value);
			//if(imgbmp!=null)
				
				///imgview.setImageBitmap(imgbmp);
				
				//else
					//Toast.makeText(getApplicationContext(), "Blank Bitmap",Toast.LENGTH_LONG).show();
					
			}
			catch (Exception e)
			{
				// TODO: handle exception
				
				AlertDialog.Builder al=new AlertDialog.Builder(this);
				al.setMessage("Error "+e.toString());
				al.show();
			}			
		}		
		
	}
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) 
	{
		// TODO Auto-generated method stub
		//btn_done.setVisibility(View.VISIBLE);
		//btn_close.setVisibility(View.GONE);
	}
	@Override
	public void onStopTrackingTouch(SeekBar seekBar) 
	{
		// TODO Auto-generated method stub
		
	}	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public void shareImage()
	{			
	  try 
		{			  
		      imgview.setDrawingCacheEnabled(true);
		      imgview.buildDrawingCache();
			  effectbmp=imgview.getDrawingCache();				  
			  
			File  mFile = savebitmap(effectbmp);
			if(effectbmp!=null)
			  {
				    Uri u = null;
//					u = Uri.fromFile(mFile);
				  u = FileProvider.getUriForFile(getApplicationContext(),"in.sisoft.fileprovider",mFile);


				  final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
					//
					String address = " ";
					String subject = "EasyPainter image";
				    String 	emailtext = "Please check the attached image";
					//
					emailIntent.setType("image/*");
					 
					emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { address });
					 
					emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
					 
					emailIntent.putExtra(Intent.EXTRA_STREAM,Uri.parse("file://" + mFile));
					 
					emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, emailtext);
					 
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
					}
			   }//sendEmail
		
	
		private File savebitmap(Bitmap bmp) 
		{
			//  String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
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
		
  public void saveImage()
	{
	   OutputStream ops;
 	   Uri fileuri;
 	   
 	    		 
		//File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "EasyPainter");
 	   
// 	    File root=new File(Environment.getExternalStorageDirectory()+File.separator+"EasyPainter"+File.separator);
		File root=new File(this.getExternalFilesDir(null)+File.separator);

		if (!root.exists())
 	    root.mkdir();
	    	//SingleTouchEventView stev=new SingleTouchEventView(this,null);
	  
	    	imgview.setDrawingCacheEnabled(true);
	    	imgview.buildDrawingCache();
	    	effectbmp= imgview.getDrawingCache();
	  
	   
     	    // if (alteredBitmap != null)
	      if(effectbmp !=null)
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
	        	 effectbmp.compress(Bitmap.CompressFormat.JPEG, 100, ops);
	        	 ops.flush();
	        	 ops.close();        	 
	        	
	          Toast t = Toast.makeText(this, date.toString() +" "+"Saved!",Toast.LENGTH_SHORT);
	          t.show();
	    	  
	    	
		   } 
	    	  	    	  
	          catch (Exception e) 
		        {
		          Log.v("EXCEPTION", e.getMessage());
		          Toast.makeText(getApplicationContext(), "Error : "+e.toString(),Toast.LENGTH_LONG).show();
		        }
		   }		
		} 
  

  public String fromInt(int val)
  {
    return String.valueOf(val);
  }
	
	
	
  private void alphaXform(int value) 
  {
      imgview.setImageAlpha(225-value);
      isAlphaOriginalValue = !isAlphaOriginalValue;
      imgview.setImageMatrix(mMatrix);
      imgview.invalidate();
  }  
  
  public void effectBimap()
  { 	
	 listBMP =new ArrayList<Bitmap>();
	  
  	 eimg1.setImageBitmap(bmp);				 
 	
 	 bmp2=beffect.toSephia(bmp,10);
 	 eimg2.setImageBitmap(bmp2);
 	
 	 bmp3=beffect.toSephia(bmp,50);
 	 eimg3.setImageBitmap(bmp3);
 	
 	 bmp4=beffect.toSephia(bmp, 100);
 	 eimg4.setImageBitmap(bmp4);
 	 
 	 bmp5=beffect.toGRG(bmp,10);
	 eimg5.setImageBitmap(bmp5);
	 
	 bmp6=beffect.toGRG(bmp,80);
 	 eimg6.setImageBitmap(bmp6); 	 
 	 
 	 bmp7=beffect.toBRB(bmp, 20);
	 eimg7.setImageBitmap(bmp7);	 
	 
	
 	 
 	 listBMP.add(bmp);
 	 listBMP.add(bmp2);
 	 listBMP.add(bmp3);
 	 listBMP.add(bmp4);
 	 listBMP.add(bmp5);
	 listBMP.add(bmp6);
	 listBMP.add(bmp7);

 	 
 	 //pDialog.dismiss();

   }
  
  
  
  class LoadImage extends AsyncTask<String, String, String>
 	{
 		/**
 		 * Before starting background thread Show Progress Dialog
 		 * */
 		@Override
 		protected void onPreExecute()
 		{
 			super.onPreExecute();
 			pDialog = new ProgressDialog(EffectSetting.this);
 			pDialog.setMessage(Html.fromHtml("Loading Image..."));
 			pDialog.setIndeterminate(false);
 			pDialog.setCancelable(false);
 			pDialog.show();
 		}

 		/**
 		 * getting Places JSON
 		 * */
 		protected String doInBackground(String... args)
 		{ 			
 			try 
 			{
 				
 			
 			 	 bmp2=beffect.toSephia(bmp,10);	 
 			 	
 			 	 bmp3=beffect.toSephia(bmp,80);			 
 			 	
 			 	 bmp4=beffect.toSephia(bmp, 150);
 			
 				
 			} 
 			catch (Exception e)
 			{
 				e.printStackTrace();
 			}
 			return null;
 		}
 		
 		protected void onPostExecute(String file_url)
 		{
 			// dismiss the dialog after getting all products
 			 
 			pDialog.dismiss();
 			
 			// updating UI from Background Thread
 			runOnUiThread(new Runnable()
 			{
 				public void run() 
 				{
/*
 					 imgview.setDrawingCacheEnabled(true);
 					 imgview.buildDrawingCache();
 				 	 Bitmap bitmp2= imgview.getDrawingCache();				
 				 	*/
 				 	 eimg1.setImageBitmap(bmp);					
 					 eimg2.setImageBitmap(bmp2);			
 					 eimg3.setImageBitmap(bmp3);					 
 					 eimg4.setImageBitmap(bmp4);
 					
 				}				
 			});
 		}
 	}

  public void  backImage(Bitmap bmp)
  {
	  //Bitmap realImage = BitmapFactory.decodeStream(stream);
	 
	   Intent backint=new Intent();
	   backint.putExtra("Eimage",bmp);
	   setResult(RESULT_OK,backint);
	   finish();
  }

	
}

