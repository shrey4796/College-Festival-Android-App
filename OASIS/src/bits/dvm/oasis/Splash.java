package bits.dvm.oasis;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

public class Splash extends ActionBarActivity implements SHARED_CONSTANTS {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //Account mAccount;

        // A content resolver for accessing the provider
        //ContentResolver mResolver;

        
        //setting display to splash screen
        setContentView(R.layout.activity_splash);
        
        //creating intent for transition in activity from splash screen to home screen
        final Intent changeActivity = new Intent(this,Screen.class);
        
/*       NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
       SyncAdapter sync = new  SyncAdapter(this, false, manager);
       sync.sync();
*/       
        //creating thread for waiting WAIT_TIME seconds
        Thread wait = new Thread(){
        	@Override
        	public void run() {
        		//use try catch block to avoid unhandled thread interrrupted exception and preventing app from crashing 
                try {
					sleep(WAIT_TIME_SPLASH_SCREEN);
				} catch (InterruptedException e) {
					//Log.e("Splash Screen to Home Thread wait error",e.getMessage());
				} catch (Exception e) {
					//Log.e("Other thread exception",e.getMessage());
				} finally{
			        //starting the activity using the intent
					startActivity(changeActivity);
				}
        	
        	}
        };

        
        //creating intent for communicating with the SyncService class
        //SyncService is the Service class name here
        Intent serviceIntent = new Intent(this,SyncService.class);

        //starting the service by calling the desired intent
        Log.e("zxcvb","qwr");
        startService(serviceIntent);

        
        //starting the thread 
        wait.start();
        
            		
      		
		//Log.e("yes","yes");

		//startActivity(changeActivity);
        
        
    } 

    @Override
    protected void onPause() {
    	super.onPause();

    	//finishing splash activity after transition 
    	finish();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.splash, menu);
        return true;
    }

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if ( keyCode == KeyEvent.KEYCODE_MENU ) {
	        // do nothing
	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	} 
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }
}
