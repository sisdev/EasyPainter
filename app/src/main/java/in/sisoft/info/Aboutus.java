package in.sisoft.info;



import in.sisoft.easypainter.R;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class Aboutus  extends Activity
{
	Button infoback,btn_sistext,btn_sisbutton,btn_sisimg;
	Button btn_mbp,btn_kashi,btn_Kinder,btn_BITin,btn_BITusa,btn_BITuk,btn_BITaust,btn_mymedic,btn_firstaid;	
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_us);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		//Typeface tf= Typeface.createFromAsset(getAssets(),"algi.ttf");
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/* btn_sisimg=(Button)findViewById(R.id.btn_sisimage);
		 btn_sisimg.setOnClickListener( new View.OnClickListener()
			{
				
			 public void onClick(View v) 
				{
					// TODO Auto-generated method stub
					String url = "http://www.sisoft.in/appdev";
					Intent i = new Intent(Intent.ACTION_VIEW);
					i.setData(Uri.parse(url));
					startActivity(i);
				}
			});*/
		/* btn_sisbutton=(Button)findViewById(R.id.btn_Tital_sis);
		 btn_sisbutton.setOnClickListener( new View.OnClickListener()
			{
				
			 public void onClick(View v) 
				{
					// TODO Auto-generated method stub
					String url = "http://www.sisoft.in/appdev";
					Intent i = new Intent(Intent.ACTION_VIEW);
					i.setData(Uri.parse(url));
					startActivity(i);
				}
			});*/
		 
		 
		/* btn_sistext=(Button)findViewById(R.id.btn_aboutus_sis);
		 btn_sistext.setOnClickListener( new View.OnClickListener()
			{
				
			 public void onClick(View v) 
				{
					// TODO Auto-generated method stub
					String url = "http://www.sisoft.in/appdev";
					Intent i = new Intent(Intent.ACTION_VIEW);
					i.setData(Uri.parse(url));
					startActivity(i);
				}
			});*/
		 
		 
		infoback=(Button)findViewById(R.id.but_back_infous);
		infoback.setOnClickListener(new View.OnClickListener()
		{
		
		  public void onClick(View v)
		   {
				// TODO Auto-generated method stub
				backinfo();
			}
			
		});	
		
		Button btn_helthrecord=(Button)findViewById(R.id.btn_healthrecord);
		btn_helthrecord.setOnClickListener(new View.OnClickListener()
		{
			
		
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				String url = "http://www.amazon.com/sisoft-Technologies-Pvt-Lit-Health/dp/B00CX1X5HY";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		});
		
		btn_mbp=(Button)findViewById(R.id.btn_MBP_Android);
		btn_mbp.setOnClickListener(new View.OnClickListener()
		{
			
		
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				String url = "http://www.amazon.com/sisoft-Technologies-Pvt-Lit-MonthlyBudget/dp/B00CM68YEE";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		});
		
		
		btn_BITin=(Button)findViewById(R.id.btn_BIT_Android);
		btn_BITin.setOnClickListener(new View.OnClickListener()
		{
			
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				String url = "http://www.amazon.com/s/ref=nb_sb_noss?url=search-alias%3Dmobile-apps&field-keywords=sisoft";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		});
		
		btn_BITusa=(Button)findViewById(R.id.btn_BIT_Androidusa);
		btn_BITusa.setOnClickListener(new View.OnClickListener()
		{
			
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				String url = "http://www.amazon.com/sisoft-Technologies-Pvt-Lit-Immunization/dp/B00CM7TFB4";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		});
		
		btn_BITuk=(Button)findViewById(R.id.btn_BIT_Androiduk);
		btn_BITuk.setOnClickListener(new View.OnClickListener()
		{
			
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				String url = "http://www.amazon.com/sisoft-Technologies-Pvt-Lit-Immunization/dp/B00CM8S3ZM";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		});
		
		btn_BITaust=(Button)findViewById(R.id.btn_BIT_Androidaust);
		btn_BITaust.setOnClickListener(new View.OnClickListener()
		{
			
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				String url = "http://www.amazon.com/sisoft-Technologies-Pvt-Lit-Immunization/dp/B00CM8HT16";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		});
		
		btn_mymedic=(Button)findViewById(R.id.btn_MyMedicAlarm);
		btn_mymedic.setOnClickListener(new View.OnClickListener()
		{
			
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				String url = "http://www.amazon.com/s/ref=nb_sb_noss?url=search-alias%3Dmobile-apps&field-keywords=sisoft";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		});
		
		btn_firstaid=(Button)findViewById(R.id.btn_FirstAid);
		btn_firstaid.setOnClickListener(new View.OnClickListener()
		{
			
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				String url = "http://www.amazon.com/sisoft-Technologies-Pvt-Lit-First/dp/B00CM6ZHPI";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		});
		
		btn_kashi=(Button)findViewById(R.id.btn_Kashi_Android);
		btn_kashi.setOnClickListener(new View.OnClickListener()
		{
			
			
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				String url = "http://www.amazon.com/sisoft-Technologies-Pvt-Lit-Kashi/dp/B00COZM6WO";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		});
		
		btn_Kinder=(Button)findViewById(R.id.btn_kinder_game);
		btn_Kinder.setOnClickListener(new View.OnClickListener()
		{
			
	
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				//
				String url = "http://www.amazon.com/s/ref=nb_sb_noss?url=search-alias%3Dmobile-apps&field-keywords=sisoft";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		});
		
		
		
	}
		
	public void backinfo()
	{
		Intent data = new Intent();  
        //data.putExtra("result", "Hi from second activity");  
      setResult(RESULT_OK, data);  
      super.finish(); 
	
	}
	
}