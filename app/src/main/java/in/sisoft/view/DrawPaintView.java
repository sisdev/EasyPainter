//http://stackoverflow.com/questions/6409072/undo-and-redo-in-canvas-for-android
package in.sisoft.view;

import java.util.ArrayList;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class DrawPaintView extends View implements OnTouchListener
{
	//int cid=R.color.c10;
	//float  ps=5;
	
    private Canvas  mCanvas;
    private Path    mPath;
    private Paint   mPaint;   
    private ArrayList<Path> paths = new ArrayList<Path>();
    private ArrayList<Path> undonePaths = new ArrayList<Path>(); 
    
    private Bitmap im;
    String mode="draw";
    float ps=5;
    
    public DrawPaintView(Context context,float ps,int cid) 
    {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);      
        this.setOnTouchListener(this);
        this.mode=mode;
        this.ps=ps;
        
        
        	mPaint = new Paint();
            mPaint.setAntiAlias(true);
            mPaint.setDither(true);        
            mPaint.setColor(getResources().getColor(cid));
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeJoin(Paint.Join.ROUND);
            mPaint.setStrokeCap(Paint.Cap.ROUND);
            mPaint.setStrokeWidth(ps);
           
      
                
        mCanvas = new Canvas();
        mPath = new Path();
        paths.add(mPath);

        //im=BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_launcher);

        }  
    
       @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) 
        {
            super.onSizeChanged(w, h, oldw, oldh);
        }

        @Override
        protected void onDraw(Canvas canvas)
        {   
        	
        	   for (Path p : paths)
                 {
                  canvas.drawPath(p, mPaint);
                 }
        	
            
        }

        private float mX, mY;
        private static final float TOUCH_TOLERANCE = 4;

        private void touch_start(float x, float y)
        {
            mPath.reset();
            mPath.moveTo(x, y);
            mX = x;
            mY = y;
        }
        private void touch_move(float x, float y)
        {
            float dx = Math.abs(x - mX);
            float dy = Math.abs(y - mY);
            if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE)
            {
                mPath.quadTo(mX, mY, (x + mX)/2, (y + mY)/2);
                mX = x;
                mY = y;
            }
        }
        private void touch_up()
        {
            mPath.lineTo(mX, mY);
            // commit the path to our offscreen
            mCanvas.drawPath(mPath, mPaint);
            // kill this so we don't double draw            
            mPath = new Path();
            paths.add(mPath);
        }

        public void onClickUndo ()
        { 
            if (paths.size()>0) 
            { 
               undonePaths.add(paths.remove(paths.size()-1));
               invalidate();
             }
            else
            {

            }
             //toast the user 
        }

        public void onClickRedo ()
        {
           if (undonePaths.size()>0) 
           { 
               paths.add(undonePaths.remove(undonePaths.size()-1)); 
               invalidate();
           } 
           else 
           {

           }
             //toast the user 
        }

    @Override
    public boolean onTouch(View arg0, MotionEvent event)
    {
          float x = event.getX();
          float y = event.getY();

          switch (event.getAction()) {
              case MotionEvent.ACTION_DOWN:
                  touch_start(x, y);
                  invalidate();
                  break;
              case MotionEvent.ACTION_MOVE:
                  touch_move(x, y);
                  invalidate();
                  break;
              case MotionEvent.ACTION_UP:
                  touch_up();
                  invalidate();
                  break;
          }
          return true;
    }    
    
    public void erasePath()
    {
    	//mPaint.setColor(cid);
    	//eraseColor(android.R.color.transparent);
    	 
    	/* mPaint.setColor(Color.TRANSPARENT);
    	 mPath.reset();       
    	 mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
         invalidate();*/
    	
    	mPaint.setColor(-1);
    	mPaint.setAlpha(0);
    	mPaint.setAntiAlias(true);
    	mPaint.setStyle(Paint.Style.STROKE);
    	mPaint.setStrokeCap(Paint.Cap.ROUND);
   
        mPaint.setStrokeJoin(Paint.Join.ROUND);
     	
    	mPaint.setStrokeWidth(ps);
    	this.mode=mode;
    	
    	
    	//mCanvas.restore();
    }
}