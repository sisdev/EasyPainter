package in.sisoft.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;

public class BitmapEffect 
{
	Bitmap bmpbright,bmpcontrast;
			
	public Bitmap toSephia(Bitmap bmpOriginal ,int dep)
	{        
	    int width, height, r,g, b, c, gry;
	    height = bmpOriginal.getHeight();
	    width = bmpOriginal.getWidth();
	    int depth = dep;

	    Bitmap bmpSephia = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
	    Canvas canvas = new Canvas(bmpSephia);
	    Paint paint = new Paint();
	    ColorMatrix cm = new ColorMatrix();
	    cm.setScale(.3f, .3f, .3f, 1.0f);   
	    ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
	    paint.setColorFilter(f);
	    canvas.drawBitmap(bmpOriginal, 0, 0, paint);
	    for(int x=0; x < width; x++) {
	        for(int y=0; y < height; y++) {
	            c = bmpOriginal.getPixel(x, y);

	            r = Color.red(c);
	            g = Color.green(c);
	            b = Color.blue(c);

	            gry = (r + g + b) / 3;
	            r = g = b = gry;

	            r = r + (depth * 2);
	            g = g + depth;

	            if(r > 255) {
	              r = 255;
	            }
	            if(g > 255) {
	              g = 255;
	            }
	            bmpSephia.setPixel(x, y, Color.rgb(r, g, b));
	        }
	    }      
	    return bmpSephia;
	}
	
	
	public Bitmap toBRB(Bitmap bmpOriginal ,int dep)
	{        
	    int width, height, r,g, b, c, gry;
	    height = bmpOriginal.getHeight();
	    width = bmpOriginal.getWidth();
	    int depth = dep;

	    Bitmap bmpSephia = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
	    Canvas canvas = new Canvas(bmpSephia);
	    Paint paint = new Paint();
	    ColorMatrix cm = new ColorMatrix();
	    cm.setScale(.3f, .3f, .3f, 1.0f);   
	    ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
	    paint.setColorFilter(f);
	    canvas.drawBitmap(bmpOriginal, 0, 0, paint);
	    for(int x=0; x < width; x++) {
	        for(int y=0; y < height; y++) {
	            c = bmpOriginal.getPixel(x, y);

	            r = Color.red(c);
	            g = Color.green(c);
	            b = Color.blue(c);

	            gry = (r + g + b) / 3;
	            r = g = b = gry;

	            r = r + (depth * 2);
	            g = g + depth;

	            if(r > 255) {
	              r = 255;
	            }
	            if(g > 255) {
	              g = 255;
	            }
	            bmpSephia.setPixel(x, y, Color.rgb(b, r, b));
	        }
	    }      
	    return bmpSephia;
	}
	
	public Bitmap toGRG(Bitmap bmpOriginal ,int dep)
	{        
	    int width, height, r,g, b, c, gry;
	    height = bmpOriginal.getHeight();
	    width = bmpOriginal.getWidth();
	    int depth = dep;

	    Bitmap bmpSephia = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
	    Canvas canvas = new Canvas(bmpSephia);
	    Paint paint = new Paint();
	    ColorMatrix cm = new ColorMatrix();
	    cm.setScale(.3f, .3f, .3f, 1.0f);   
	    ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
	    paint.setColorFilter(f);
	    canvas.drawBitmap(bmpOriginal, 0, 0, paint);
	    for(int x=0; x < width; x++) {
	        for(int y=0; y < height; y++) {
	            c = bmpOriginal.getPixel(x, y);

	            r = Color.red(c);
	            g = Color.green(c);
	            b = Color.blue(c);

	            gry = (r + g + b) / 3;
	            r = g = b = gry;

	            r = r + (depth * 2);
	            g = g + depth;

	            if(r > 255) {
	              r = 255;
	            }
	            if(g > 255) {
	              g = 255;
	            }
	            bmpSephia.setPixel(x, y, Color.rgb(g, r, g));
	        }
	    }      
	    return bmpSephia;
	}
	
	public Bitmap toRBR(Bitmap bmpOriginal ,int dep)
	{        
	    int width, height, r,g, b, c, gry;
	    height = bmpOriginal.getHeight();
	    width = bmpOriginal.getWidth();
	    int depth = dep;

	    Bitmap bmpSephia = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
	    Canvas canvas = new Canvas(bmpSephia);
	    Paint paint = new Paint();
	    ColorMatrix cm = new ColorMatrix();
	    cm.setScale(.3f, .3f, .3f, 1.0f);   
	    ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
	    paint.setColorFilter(f);
	    canvas.drawBitmap(bmpOriginal, 0, 0, paint);
	    for(int x=0; x < width; x++) {
	        for(int y=0; y < height; y++) {
	            c = bmpOriginal.getPixel(x, y);

	            r = Color.red(c);
	            g = Color.green(c);
	            b = Color.blue(c);

	            gry = (r + g + b) / 3;
	            r = g = b = gry;

	            r = r + (depth * 2);
	            g = g + depth;

	            if(r > 255) {
	              r = 255;
	            }
	            if(g > 255) {
	              g = 255;
	            }
	            bmpSephia.setPixel(x, y, Color.rgb(r, b, r));
	        }
	    }      
	    return bmpSephia;
	}
	
	
////////////////////////////////////////////////Brightness/////////////////////////////////////
	
	public  Bitmap doBrightness(Bitmap src, int value)
	{
		// image size
		int width = src.getWidth();
		int height = src.getHeight();
		// create output bitmap
		bmpbright = Bitmap.createBitmap(width, height, src.getConfig());
		// color information
		int A, R, G, B;
		int pixel;

		// scan through all pixels
		for(int x = 0; x < width; ++x) 
		{
			for(int y = 0; y < height; ++y)
			{
				// get pixel color
				pixel = src.getPixel(x, y);
				A = Color.alpha(pixel);
				R = Color.red(pixel);
				G = Color.green(pixel);
				B = Color.blue(pixel);

				// increase/decrease each channel
				R += value;
				if(R > 255) { R = 255; }
				else if(R < 0) { R = 0; }

				G += value;
				if(G > 255) { G = 255; }
				else if(G < 0) { G = 0; }

				B += value;
				if(B > 255) { B = 255; }
				else if(B < 0) { B = 0; }

				// apply new pixel color to output bitmap
				bmpbright.setPixel(x, y, Color.argb(A, R, G, B));
			}
		}
		return bmpbright;
		
	}
	
	
	////////////////////////////////////////////////////////Contrast///////////////////////////////

	public Bitmap doContrast(Bitmap src, int value)
	{
	    // image size
	    int width = src.getWidth();
	    int height = src.getHeight();
	    // create output bitmap

	    // create a mutable empty bitmap
	    bmpcontrast = Bitmap.createBitmap(width, height, src.getConfig());

	    // create a canvas so that we can draw the bmOut Bitmap from source bitmap
	    Canvas c = new Canvas();
	    c.setBitmap(bmpcontrast);

	    // draw bitmap to bmOut from src bitmap so we can modify it
	    c.drawBitmap(src, 0, 0, new Paint(Color.BLACK));


	    // color information
	    int A, R, G, B;
	    int pixel;
	    // get contrast value
	    double contrast = Math.pow((100 + value) / 100, 2);

	    // scan through all pixels
	    for(int x = 0; x < width; ++x) 
	    {
	        for(int y = 0; y < height; ++y)
	        {
	            // get pixel color
	            pixel = src.getPixel(x, y);
	            A = Color.alpha(pixel);
	            // apply filter contrast for every channel R, G, B
	            R = Color.red(pixel);
	            R = (int)(((((R / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
	            if(R < 0) { R = 0; }
	            else if(R > 255) { R = 255; }

	            G = Color.green(pixel);
	            G = (int)(((((G / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
	            if(G < 0) { G = 0; }
	            else if(G > 255) { G = 255; }

	            B = Color.blue(pixel);
	            B = (int)(((((B / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
	            if(B < 0) { B = 0; }
	            else if(B > 255) { B = 255; }

	            // set new pixel color to output bitmap
	            bmpcontrast.setPixel(x, y, Color.argb(A, R, G, B));
	        }
	    }
	    return bmpcontrast;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	public  Bitmap doContract1(Bitmap src, int value)
	{
		// image size
		int width = src.getWidth();
		int height = src.getHeight();
		// create output bitmap
		bmpbright = Bitmap.createBitmap(width, height, src.getConfig());
		// color information
		int A, R, G, B;
		int pixel;

		// scan through all pixels
		for(int x = 0; x < width; ++x) 
		{
			for(int y = 0; y < height; ++y)
			{
				// get pixel color
				pixel = src.getPixel(x, y);
				A = Color.alpha(pixel);
				R = Color.red(pixel);
				G = Color.green(pixel);
				B = Color.blue(pixel);

			//increase/decrease each channel
				/*
				A += value;
				if(A > 255) 
				{ A = 255; }
				else if(A < 0) 
				{ A = 0; }*/
				
				R = value;
				if(R > 255) 
				{ R = 255; }
				else if(R < 0) 
				{ R = 0; }

				G = value;
				if(G > 255)
				{ G = 255; }
				else if(G < 0)
				{ G = 0; }

				B = value;
				if(B > 255) { B = 255; }
				else if(B < 0) { B = 0; }

				// apply new pixel color to output bitmap
				bmpbright.setPixel(x, y, Color.argb(A, R, G, B));
			}
		}
		return bmpbright;
		
	}
	
	
//////////////////////////////////////////////////Resize/////////////////////////////////////////////////
	
	public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth)
	{
	    int width = bm.getWidth();
	    int height = bm.getHeight();
	    float scaleWidth = ((float) newWidth) / width;
	    float scaleHeight = ((float) newHeight) / height;
	    // CREATE A MATRIX FOR THE MANIPULATION
	    Matrix matrix = new Matrix();
	    // RESIZE THE BIT MAP
	    matrix.postScale(scaleWidth, scaleHeight);

	    // "RECREATE" THE NEW BITMAP
	    Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
	    return resizedBitmap;
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
/*	
	
	public static Bitmap drawShadow(Bitmap bitmap, int leftRightThk, int bottomThk, int padTop) {
	    int w = bitmap.getWidth();
	    int h = bitmap.getHeight();

	    int newW = w - (leftRightThk * 2);
	    int newH = h - (bottomThk + padTop);

	    Bitmap.Config conf = Bitmap.Config.ARGB_8888;
	    Bitmap bmp = Bitmap.createBitmap(w, h, conf);
	    Bitmap sbmp = Bitmap.createScaledBitmap(bitmap, newW, newH, false);

	    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
	    Canvas c = new Canvas(bmp);

	    // Left
	    int leftMargin = (leftRightThk + 7)/2;
	    Shader lshader = new LinearGradient(0, 0, leftMargin, 0, Color.TRANSPARENT, Color.BLACK, TileMode.CLAMP);
	    paint.setShader(lshader);
	    c.drawRect(0, padTop, leftMargin, newH, paint); 

	    // Right
	    Shader rshader = new LinearGradient(w - leftMargin, 0, w, 0, Color.BLACK, Color.TRANSPARENT, TileMode.CLAMP);
	    paint.setShader(rshader);
	    c.drawRect(newW, padTop, w, newH, paint);

	    // Bottom
	    Shader bshader = new LinearGradient(0, newH, 0, bitmap.getHeight(), Color.BLACK, Color.TRANSPARENT, TileMode.CLAMP);
	    paint.setShader(bshader);
	    c.drawRect(leftMargin -3, newH, newW + leftMargin + 3, bitmap.getHeight(), paint);
	    c.drawBitmap(sbmp, leftRightThk, 0, null);

	    return bmp;*/
	//}
	
	
	public Bitmap invert(Bitmap src,int a,int r,int g,int b)
	{
	    // image size
	    int width = src.getWidth();
	    int height = src.getHeight();
	    // create output bitmap
	    Bitmap bmOut = Bitmap.createBitmap(width, height, src.getConfig());
	    // color information
	    int A, R, G, B;
	    int pixel;

	    // scan through all pixels
	    for(int x = 0; x < width; ++x) {
	        for(int y = 0; y < height; ++y) {
	            // get pixel color
	            pixel = src.getPixel(x, y);
	            // get color on each channel
	            A = Color.alpha(pixel);
	            R = Color.red(pixel);
	            G = Color.green(pixel);
	            B = Color.blue(pixel);
	            // set new pixel color to output image
	            bmOut.setPixel(x, y, Color.argb(a-A, r-R, g-G, b-B));
	        }
	    }

	    // return final image
	    return bmOut;
	}
/*

   public static void rotateBitmap(Canvas canvas,Bitmap bitmap,float angle,int alpha,float scale) {
		    Matrix matrix = new Matrix();
		    matrix.setScale(4, 4);
		    Bitmap resizeBmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(),matrix, true);

		    matrix = new Matrix();
		    matrix.setTranslate(resizeBmp.getWidth()/2,resizeBmp.getHeight()/2);
		    matrix.preRotate(angle);

		    matrix.preTranslate(-resizeBmp.getWidth()/2,-resizeBmp.getHeight()/2);
		    matrix.postTranslate((canvas.getWidth()-resizeBmp.getWidth())/2,(canvas.getHeight()-resizeBmp.getHeight())/2);

		    Paint vPaint = new Paint();
		        vPaint.setStyle( Paint.Style.STROKE );   //???
		        vPaint.setAlpha(alpha);   // Bitmap?????0 ~ 100)
		    canvas.drawBitmap(resizeBmp,matrix,vPaint);
		    
		    Bitmap resizeBmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth()/2, bitmap.getHeight()/2);
		    canvas.drawBitmap(resizeBmp, 0,0,null);
		  }
*/		}

		  
	
	
	
