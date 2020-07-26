package in.sisoft.easypainter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Eraser extends Activity implements OnSeekBarChangeListener
{ 	
	int ps=2;
	int cid;
	
	//int cid2=android.R.color.transparent;
	Button Done,cancle;
	/*public Eraser(Context context) 
		{
			super(context);
			// TODO Auto-generated constructor stub
			setContentView(layoutResID)		
			
		}*/
	TextView txt;
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eraser);
		
		Intent bint=this.getIntent();
		cid=bint.getExtras().getInt("bcid");
		
		txt=(TextView)findViewById(R.id.txt_seekbareraser);
		
		 Done=(Button)findViewById(R.id.btn_eraserok);
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
		    
		    cancle=(Button)findViewById(R.id.btn_erasercancle);
		    cancle.setOnClickListener(new View.OnClickListener()
		    {
				
				@Override
				public void onClick(View v) 
				{
					// TODO Auto-generated method stub
					 
					finish();					
				}
			});
		
	    SeekBar sb = (SeekBar)findViewById(R.id.seek_eraser);
	    sb.setMax(30);
	    sb.setProgress(ps);
	    sb.setOnSeekBarChangeListener(this); 
		
	}
	
	
	@Override
	public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) 
	{
		// TODO Auto-generated method stub
		//TextView txt=(TextView)findViewById(R.id.txtseekbar);
		ps=arg1;
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
		bundle.putInt("cid",cid);
		
		back.putExtras(bundle);
		setResult(RESULT_OK, back);
		finish();
		
	}
	

}
