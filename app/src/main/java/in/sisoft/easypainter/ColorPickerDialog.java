package in.sisoft.easypainter;

import android.app.Dialog;
import android.content.Context;
import android.widget.Button;

public class ColorPickerDialog extends Dialog
{
	Button c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21;
	
	Button btn_ok,btn_cancle;

	public ColorPickerDialog(Context context)
	{
		super(context);
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
		c19=(Button)findViewById(R.id.btn_c1);
		c20=(Button)findViewById(R.id.btn_c2);
		c3=(Button)findViewById(R.id.btn_c3);
		c4=(Button)findViewById(R.id.btn_c4);
		c5=(Button)findViewById(R.id.btn_c5);
		c6=(Button)findViewById(R.id.btn_c6);
		c7=(Button)findViewById(R.id.btn_c7);
		
		
		
		//TODO Auto-generated constructor stub
	}
 
   

	/*public interface OnColorChangedListener 
	{
        void colorChanged(int color);
    }
 
    private OnColorChangedListener mListener;
    private int mInitialColor;
 
    private static class ColorPickerView extends View 
    {
        private Paint mPaint;
        private Paint mCenterPaint;
        private final int[] mColors;
        private OnColorChangedListener mListener;
 
        ColorPickerView(Context c, OnColorChangedListener l, int color)
         {
            super(c);
            mListener = l;
            mColors = new int[] 
            {
                0xFFFF0000, 0xFFFF00FF, 0xFF0000FF, 0xFF00FFFF, 0xFF00FF00,
                0xFFFFFF00, 0xFFFF0000
            };
            Shader s = new SweepGradient(0, 0, mColors, null);
 
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaint.setShader(s);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeWidth(32);
 
            mCenterPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mCenterPaint.setColor(color);
            mCenterPaint.setStrokeWidth(5);
        }
 
        private boolean mTrackingCenter;
        private boolean mHighlightCenter;
 
        @Override 
        protected void onDraw(Canvas canvas) 
        {
            float r = CENTER_X - mPaint.getStrokeWidth()*0.5f;
 
            canvas.translate(CENTER_X, CENTER_X);
 
            canvas.drawOval(new RectF(-r, -r, r, r), mPaint);            
            canvas.drawCircle(0, 0, CENTER_RADIUS, mCenterPaint);
 
            if (mTrackingCenter)
             {
                int c = mCenterPaint.getColor();
                mCenterPaint.setStyle(Paint.Style.STROKE);
 
                if (mHighlightCenter) {
                    mCenterPaint.setAlpha(0xFF);
                } else {
                    mCenterPaint.setAlpha(0x80);
                }
                canvas.drawCircle(0, 0,
                                  CENTER_RADIUS + mCenterPaint.getStrokeWidth(),
                                  mCenterPaint);
 
                mCenterPaint.setStyle(Paint.Style.FILL);
                mCenterPaint.setColor(c);
            }
        }
 
        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
        {
            setMeasuredDimension(CENTER_X*2, CENTER_Y*2);
        }
 
        private static final int CENTER_X = 100;
        private static final int CENTER_Y = 100;
        private static final int CENTER_RADIUS = 32;
 
        private int floatToByte(float x) {
            int n = java.lang.Math.round(x);
            return n;
        }
        private int pinToByte(int n) 
        {
            if (n < 0) 
            {
                n = 0;
            } else if (n > 255) 
            {
                n = 255;
            }
            return n;
        }
 
        private int ave(int s, int d, float p)
         {
            return s + java.lang.Math.round(p * (d - s));
        }
 
        private int interpColor(int colors[], float unit)
         {
            if (unit <= 0) 
            {
                return colors[0];
            }
            if (unit >= 1)
            {
                return colors[colors.length - 1];
            }
 
            float p = unit * (colors.length - 1);
            int i = (int)p;
            p -= i;
 
            // now p is just the fractional part [0...1) and i is the index
            int c0 = colors[i];
            int c1 = colors[i+1];
            int a = ave(Color.alpha(c0), Color.alpha(c1), p);
            int r = ave(Color.red(c0), Color.red(c1), p);
            int g = ave(Color.green(c0), Color.green(c1), p);
            int b = ave(Color.blue(c0), Color.blue(c1), p);
 
            return Color.argb(a, r, g, b);
        }
 
        private int rotateColor(int color, float rad)
         {
            float deg = rad * 180 / 3.1415927f;
            int r = Color.red(color);
            int g = Color.green(color);
            int b = Color.blue(color);
 
            ColorMatrix cm = new ColorMatrix();
            ColorMatrix tmp = new ColorMatrix();
 
            cm.setRGB2YUV();
            tmp.setRotate(0, deg);
            cm.postConcat(tmp);
            tmp.setYUV2RGB();
            cm.postConcat(tmp);
 
            final float[] a = cm.getArray();
 
            int ir = floatToByte(a[0] * r +  a[1] * g +  a[2] * b);
            int ig = floatToByte(a[5] * r +  a[6] * g +  a[7] * b);
            int ib = floatToByte(a[10] * r + a[11] * g + a[12] * b);
 
            return Color.argb(Color.alpha(color), pinToByte(ir),
                              pinToByte(ig), pinToByte(ib));
        }
 
        private static final float PI = 3.1415926f;
 
        @Override
        public boolean onTouchEvent(MotionEvent event) 
        {
            float x = event.getX() - CENTER_X;
            float y = event.getY() - CENTER_Y;
            boolean inCenter = java.lang.Math.sqrt(x*x + y*y) <= CENTER_RADIUS;
 
            switch (event.getAction()) 
            {
                case MotionEvent.ACTION_DOWN:
                    mTrackingCenter = inCenter;
                    if (inCenter) {
                        mHighlightCenter = true;
                        invalidate();
                        break;
                    }
                case MotionEvent.ACTION_MOVE:
                    if (mTrackingCenter)
                     {
                        if (mHighlightCenter != inCenter)
                         {
                            mHighlightCenter = inCenter;
                            invalidate();
                        }
                    }
                     else 
                    {
                        float angle = (float)java.lang.Math.atan2(y, x);
                        // need to turn angle [-PI ... PI] into unit [0....1]
                        float unit = angle/(2*PI);
                        if (unit < 0) {
                            unit += 1;
                        }
                        mCenterPaint.setColor(interpColor(mColors, unit));
                        invalidate();
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    if (mTrackingCenter) 
                    {
                        if (inCenter)
                         {
                            mListener.colorChanged(mCenterPaint.getColor());
                        }
                        mTrackingCenter = false;    // so we draw w/o halo
                        invalidate();
                    }
                    break;
            }
            return true;
        }
    }
 
    public ColorPickerDialog(Context context, OnColorChangedListener listener,int initialColor) 
    {
        super(context); 
        mListener = listener;
        mInitialColor = initialColor;
    }
 
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        OnColorChangedListener l = new OnColorChangedListener() 
        {
            public void colorChanged(int color)
             {
                mListener.colorChanged(color);
                dismiss();
             }
        };
 
        setContentView(new ColorPickerView(getContext(), l, mInitialColor));
        setTitle("Pick a Color");*/
    //}
}
