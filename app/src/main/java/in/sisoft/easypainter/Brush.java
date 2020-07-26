package in.sisoft.easypainter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Brush extends Activity implements OnSeekBarChangeListener
{
	SeekBar sekbar;
	int ps,ps2;
	Float ps3;
	Button Done,btn_cancel;
	TextView txt;
		
		 public void onCreate(Bundle savedInstanceState)
		  {
		    super.onCreate(savedInstanceState);
		    setContentView(R.layout.brush);
		    
		    Intent brushint=this.getIntent();
		    Float ps3=brushint.getExtras().getFloat("brushps");
		    ps= ps3.intValue();
		    
		    txt=(TextView)findViewById(R.id.txt_seekbarbrush);
		    txt.setText(Float.toString(ps));
		    
		    //Toast.makeText(getApplicationContext(), "Size "+ps2, Toast.LENGTH_LONG).show();
		    
		    Done=(Button)findViewById(R.id.btn_done);
		    Done.setOnClickListener(new View.OnClickListener()
		    {				
				@Override
				public void onClick(View v) 
				{
					// TODO Auto-generated method stub
					 backint();
					//finish();					
				}
			});
		    
		    btn_cancel=(Button)findViewById(R.id.btn_brushcalcel);
		    btn_cancel.setOnClickListener(new View.OnClickListener()
		    {				
				@Override
				public void onClick(View v) 
				{
					// TODO Auto-generated method stub
					 backint();
					//finish();					
				}
			});
		    
		    SeekBar sb = (SeekBar)findViewById(R.id.seekBar_brush);
		    sb.setMax(30);
		    sb.setProgress(ps);
		    sb.setOnSeekBarChangeListener(this);  
		    
		  }


		@Override
		public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) 
		{
			// TODO Auto-generated method stub
			
			ps=arg1;							//Brush Size
			txt.setText(Float.toString(ps));
			
			
		}


		@Override
		public void onStartTrackingTouch(SeekBar arg0) 
		{
			// TODO Auto-generated method stub
			
		}


		@Override
		public void onStopTrackingTouch(SeekBar arg0) 
		{
			// TODO Auto-generated method stub
			
		}
		
		public void  backint()
		{
			Bundle bundle=new Bundle();
			Intent back=new Intent();
			bundle.putInt("PS",ps);
			back.putExtras(bundle);
			setResult(RESULT_OK, back);
			finish();
			
		}
}
