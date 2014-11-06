package bits.dvm.oasis;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Define a Service that returns an IBinder for the
 * sync adapter class, allowing the sync adapter framework to call
 * onPerformSync().
 */

public class SyncService extends Service implements SHARED_CONSTANTS {
	
	NotificationManager manager;
	
	// Storage for an instance of the sync adapter
    private static SyncAdapter syncAdapter = null;
    
    // Object to use as a thread-safe lock
    //private static final Object syncAdapterLock = new Object();
    
    /*
     * Instantiate the sync adapter object.
     */
	@Override
	public void onCreate() {
		
		//Log.e("up","pad");
		
        
        //Log.e("up2","pad");
		
        manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		
        //Log.e("up3","pad");
        
		syncAdapter = new SyncAdapter(this, true, manager);
        
/*		//text to be displayed for success
		String text = "Service onCreate() called";
				
		//using toast to make and display text for successful call of the function
		Toast.makeText(this, text, Toast.LENGTH_LONG).show();
*/						
        /*
		
         * Create the sync adapter as a singleton.
         * Set the sync adapter as syncable
         * Disallow parallel syncs
         
        synchronized (syncAdapterLock) {
            if (syncAdapter == null) {
                syncAdapter = new SyncAdapter(getApplicationContext(), true, manager);
            }
        }*/
        
        Thread thread = new Thread(){
        	@Override
        	public void run() {
        		//use try catch block to avoid unhandled thread interrrupted exception and preventing app from crashing 
                try {
					while(true){
						syncAdapter.sync();
						Log.e("here","as well");
						sleep(SYNC_INTERVAL);
					}
				} catch (InterruptedException e) {
					//Log.e("Sync Service Thread wait error",e.getMessage());
				} catch (Exception e) {
					//Log.e("sync Other thread exception","Err: " + e.getMessage());
				}
             }
        };
        
        
        //syncAdapter.sync();
        Log.e("here","as well too");
		thread.start();
        
       /* while(true){
        	syncAdapter.sync();
        	thread.start();
        	while(true){
        		if(thread.isAlive()){
        			
        		}
        		else{
        			break;
        		}
        	}
        }*/
        
        
        
	}
    
    /**
     * Return an object that allows the system to invoke
     * the sync adapter.
     *
     */
    @Override
	public IBinder onBind(Intent intent) {
/*        
         * Get the object that allows external processes
         * to call onPerformSync(). The object is created
         * in the base class code when the SyncAdapter
         * constructors call super()
         
        return syncAdapter.getSyncAdapterBinder();
*/  	
    return null;
    }

    @Override
    /**
     * Logging-only destructor.
     */
    public void onDestroy() {
    }

}
