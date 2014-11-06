package bits.dvm.oasis;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * A bound Service that instantiates the authenticator
 * when started.
 */

public class SyncAuthenticatorService extends Service {

	// Instance field that stores the authenticator object
    SyncAuthenticator authenticator;
	
    @Override
    public void onCreate() {
    	//create new SyncAuthenticator object
    	authenticator = new SyncAuthenticator(this);	
    }
    
    /*
     * When the system binds to this Service to make the RPC call
     * return the authenticator's IBinder.
     */
    
    
	@Override
	public IBinder onBind(Intent intent) {
		return authenticator.getIBinder();
	}

}
