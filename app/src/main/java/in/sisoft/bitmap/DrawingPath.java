package in.sisoft.bitmap;

/**
 * Created by IntelliJ IDEA.
 * User: almondmendoza
 * Date: 10/11/2010
 * Time: 12:44 AM
 * Link: http://www.tutorialforandroid.com/
 */
public class DrawingPath //implements ICanvasCommand
{
    public float pathX;
    public float pathY;

    public DrawingPath()
    {
    	
    }
    
    public DrawingPath(float x,float y)
    {
    	this.pathX=x;
    	this.pathY=y;
    }
    
    public void setxy(float x,float y)
    {
    	this.pathX=x;
    	this.pathY=y;    	
    }

   
}
