package in.sisoft.easypainter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ColorPicker extends Activity implements OnClickListener
{
	Button c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29,c30;
	
	Button btn_ok,btn_cancle,btncolor;
	
	int colorid,rid;

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.colorpicker);
		
		 //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FE);
		 //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FL);
		 
		 //Activity dialog = new Activity();
		 //dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
        Intent colorID=this.getIntent();
        colorid=colorID.getExtras().getInt("CID");
        rid=colorID.getExtras().getInt("RID");
        

		c1=(Button)findViewById(R.id.btn_c1);
		c2=(Button)findViewById(R.id.btn_c2);
		c3=(Button)findViewById(R.id.btn_c3);
		c4=(Button)findViewById(R.id.btn_c4);
		c5=(Button)findViewById(R.id.btn_c5);
		c6=(Button)findViewById(R.id.btn_c6);
		c7=(Button)findViewById(R.id.btn_c7);
		c8=(Button)findViewById(R.id.btn_c8);
		c9=(Button)findViewById(R.id.btn_c9);
		c10=(Button)findViewById(R.id.btn_c10);
		
		c11=(Button)findViewById(R.id.btn_c11);
		c12=(Button)findViewById(R.id.btn_c12);
		c13=(Button)findViewById(R.id.btn_c13);
		c14=(Button)findViewById(R.id.btn_c14);
		c15=(Button)findViewById(R.id.btn_c15);
		c16=(Button)findViewById(R.id.btn_c16);
		c17=(Button)findViewById(R.id.btn_c17);
		c18=(Button)findViewById(R.id.btn_c18);
		c19=(Button)findViewById(R.id.btn_c19);
		c20=(Button)findViewById(R.id.btn_c20);
		
		c21=(Button)findViewById(R.id.btn_c21);
		c22=(Button)findViewById(R.id.btn_c22);
		c23=(Button)findViewById(R.id.btn_c23);
		c24=(Button)findViewById(R.id.btn_c24);
		
		c25=(Button)findViewById(R.id.btn_c25);
		c26=(Button)findViewById(R.id.btn_c26);
		c27=(Button)findViewById(R.id.btn_c27);
		c28=(Button)findViewById(R.id.btn_c28);
		
		c29=(Button)findViewById(R.id.btn_c29);
		
		
		btn_ok=(Button)findViewById(R.id.btn_colorok);
		btn_cancle=(Button)findViewById(R.id.btn_colocancle);
		btncolor=(Button)findViewById(R.id.btn_colorset);
	   		
		c1.setOnClickListener(this);
		c2.setOnClickListener(this);
		c3.setOnClickListener(this);
		c4.setOnClickListener(this);
		c5.setOnClickListener(this);
		c6.setOnClickListener(this);
		c7.setOnClickListener(this);
		c8.setOnClickListener(this);
		c9.setOnClickListener(this);
		c10.setOnClickListener(this);	
		
		c11.setOnClickListener(this);
		c12.setOnClickListener(this);
		c13.setOnClickListener(this);
		c14.setOnClickListener(this);
		c15.setOnClickListener(this);
		c16.setOnClickListener(this);
		c17.setOnClickListener(this);
		c18.setOnClickListener(this);
		c19.setOnClickListener(this);
		
		c20.setOnClickListener(this);		
		c21.setOnClickListener(this);
		c22.setOnClickListener(this);
		c23.setOnClickListener(this);
		c24.setOnClickListener(this);
		
		c25.setOnClickListener(this);		
		c26.setOnClickListener(this);
		c27.setOnClickListener(this);
		c28.setOnClickListener(this);
		c29.setOnClickListener(this);
		
		btn_ok.setOnClickListener(this);
		btn_cancle.setOnClickListener(this);
		//btncolor.setOnClickListener(this);
	
		btncolor.setBackgroundResource(colorid);
		
	}

	@Override
	 
	 public void onClick(View v)
	  {

	    if (v ==c1) 
	    {
	    	
	       //from Gallery
    	  // Intent choosePictureIntent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
	     //startActivityForResult(choosePictureIntent, 0);
	    	
	    	btncolor.setBackgroundResource(R.color.c1);
	    	colorid=R.color.c1;  	
	    	
	    } 
	    
	    
	    else if (v ==c2) 
	    {	    	
	    	
	    	btncolor.setBackgroundResource(R.color.c2);
	    	colorid=R.color.c2;
	    }
	    
	    
	    else if (v == c3) 
	    {	
	    	    	
	    	btncolor.setBackgroundResource(R.color.c3);
	    	colorid=R.color.c3;
	    	
	    	//choosenImageView.set    	
	    }
	    
	    else if (v == c4) 
	    {	    	
	    	btncolor.setBackgroundResource(R.color.c4);
	    	colorid=R.color.c4;
	    }
	    
	    
	    else if (v == c5) 
	    {	    	
	    	btncolor.setBackgroundResource(R.color.c5); 
	    	colorid=R.color.c5;
	    }
	    
	   
	    
	    else if(v==c6)
	    {
	    	btncolor.setBackgroundResource(R.color.c6);
	    	colorid=R.color.c6;

	    }
	    
	    else if(v==c7)
	    {
	    	btncolor.setBackgroundResource(R.color.c7);
	    	colorid=R.color.c7;
	    	
	    }    
	    
	    
	    else if (v ==c8) 
	    {
	    	
	    	btncolor.setBackgroundResource(R.color.c8);
	    	colorid=R.color.c8;
	    	
	    } 
	    
	    
	    else if (v ==c9) 
	    {	    	
	    	btncolor.setBackgroundResource(R.color.c9);
	    	colorid=R.color.c9;
	    }
	    
	    
	    else if (v == c10) 
	    {    	
	    	
	    	btncolor.setBackgroundResource(R.color.c10);
	    	colorid=R.color.c10;
	    	    	  	
	    }
	    
	    else if (v == c11) 
	    {	    	
	    	btncolor.setBackgroundResource(R.color.c11);
	    	
	    	colorid=R.color.c11;
	    }
	    
	    
	    else if (v == c12) 
	    {	    	
	    	btncolor.setBackgroundResource(R.color.c12);
	    	colorid=R.color.c12;
	    }
	    
	   
	    
	    else if(v==c13)
	    {
	    	btncolor.setBackgroundResource(R.color.c13);
	    	colorid=R.color.c13;

	    }
	    
	    else if(v==c14)
	    {
	    	btncolor.setBackgroundResource(R.color.c14);
	    	colorid=R.color.c14;
	    
	    } 

	    
	    
	    if (v ==c15) 
	    {
	    	
	    	btncolor.setBackgroundResource(R.color.c15);
	    	colorid=R.color.c15;  	
	    	
	    } 
	    
	    
	    else if (v ==c16) 
	    {	    	
	    	btncolor.setBackgroundResource(R.color.c16);
	    	colorid=R.color.c16;
	    }
	    
	    
	    else if (v == c17) 
	    {	    	
	    	btncolor.setBackgroundResource(R.color.c17);  
	    	colorid=R.color.c17;
	    }
	    
	    else if (v == c18) 
	    {	btncolor.setBackgroundResource(R.color.c18);  
	    colorid=R.color.c18;
	    }
	    
	    
	    else if (v == c19) 
	    {	    	
	    	btncolor.setBackgroundResource(R.color.c19);
	    	colorid=R.color.c19;
	    }
	    
	   
	    
	    else if(v==c20)
	    {
	    	btncolor.setBackgroundResource(R.color.c20);
	    	colorid=R.color.c20;

	    }
	    
	    else if(v==c21)
	    {
	    	btncolor.setBackgroundResource(R.color.c21);
	    	colorid=R.color.c21;
	    
	    } 

	    
	    
	    if (v ==c22) 
	    {
	    	
	    	btncolor.setBackgroundResource(R.color.c22);
	    	colorid=R.color.c22;
	    	
	    } 
	    
	    
	    else if (v ==c23) 
	    {	    	
	    	btncolor.setBackgroundResource(R.color.c23);
	    	colorid=R.color.c23;
	    }
	    
	    
	    else if (v == c24) 
	    {	    	
	    	btncolor.setBackgroundResource(R.color.c24);
	    	colorid=R.color.c24;
	    }
	    
	    
	    else if(v==c25)
	    {
	    	btncolor.setBackgroundResource(R.color.c25);
	    	colorid=R.color.c25;

	    }
	    
	    else if(v==c26)
	    {
	    	btncolor.setBackgroundResource(R.color.c26);
	    	colorid=R.color.c26;
	    
	    } 

	    
	    
	    if (v ==c27) 
	    {
	    	
	    	btncolor.setBackgroundResource(R.color.c27);
	    	colorid=R.color.c27;
	    	
	    } 
	    
	    
	    else if (v ==c28) 
	    {	    	
	    	btncolor.setBackgroundResource(R.color.c28);
	    	colorid=R.color.c28;
	    }
	    
	    
	    else if (v == c29) 
	    {	    	
	    	btncolor.setBackgroundResource(R.color.c29);
	    	colorid=R.color.c29;
	    }
	    
	    
	    else if (v ==btn_ok) 
	    {
	    	Bundle color=new Bundle();
	    	Intent colorint=new Intent();
	    	colorint.putExtra("colorID",colorid);
	    	setResult(RESULT_OK, colorint);
	    	super.finish();	    	
	    	
	    	   	
	    }
	    
	    
	    else if (v == btn_cancle) 
	    {	    	
	    	finish(); 	
	    } 
	    
	  

	  }
	 
 
   

}
