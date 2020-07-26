package in.sisoft.easypainter;

//import com.facebook.android.Facebook;


public class zFacebookConnector
{
	
	
	/* private Facebook facebook;
	 Activity activity;
	 Context context;
	 String[] permissions;
	 Handler mHandler;

	public zFacebookConnector(String appId,Activity activity,Context context,String[] permissions)
	  {
			this.facebook = new Facebook(appId);
		 
			//SessionStore.restore(facebook, context);
		   // SessionEvents.addAuthListener(mSessionListener);
		    //SessionEvents.addLogoutListener(mSessionListener);
		 
			this.context=context;
			this.permissions=permissions;
			this.mHandler = new Handler();
			this.activity=activity;
		}
	public void postMessageOnWall(String msg)
	{
		if (facebook.isSessionValid()) 
		{
		    Bundle parameters = new Bundle();
		    parameters.putString("message", msg);
		    try 
		    {
				String response = facebook.request("128431033989929", parameters,"POST");
				System.out.println(response);
			} 
		    catch (IOException e)
			{
				e.printStackTrace();
			}
		} 
		else 
		{
			login();
		}		
		
	}
	
	
	public void login()
	{
	       if (!facebook.isSessionValid()) 
	       {
	           //facebook.authorize(this.activity, this.permissions,Facebook.FORCE_DIALOG_AUTH,new LoginDialogListener());
	       }
	 }
	
	
	private void postMessageInThread() 
	{
		Thread t = new Thread()		
		{
			public void run()
			{
	 
		    	try
		    	{
		    		//facebookConnector.postMessageOnWall(getFacebookMsg());
					//mFacebookHandler.post(mUpdateFacebookNotification);
				} 
		    	catch (Exception ex)
				{
					//Log.e(TAG, "Error sending msg",ex);
				}
		    }
		};
		t.start();
	}
	
	
	
	public void postMessage()
	{
		if (facebookConnector.getFacebook().isSessionValid())
		{
			postMessageInThread();
		}
		 else 
		{
			SessionEvents.AuthListener listener = new SessionEvents.AuthListener()
			{
	 
				@Override
				public void onAuthSucceed() 
				{
				  postMessageInThread();
				}
	 
				@Override
				public void onAuthFail(String error)
				{
	 
				}
			};
			SessionEvents.addAuthListener(listener);
			facebookConnector.login();
		}
	}
*/


}


