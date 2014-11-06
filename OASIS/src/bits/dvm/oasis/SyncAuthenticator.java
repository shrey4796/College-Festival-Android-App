package bits.dvm.oasis;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.Bundle;

/*
 * this class is not used by the app as it does not have accounts secured 
 * with passwords for syncing data with the web server
 */

public class SyncAuthenticator extends AbstractAccountAuthenticator{

	//Simple Constructor
	public SyncAuthenticator(Context context) {
		super(context);
	}

	//Editting properties is not supported
	@Override
	public Bundle editProperties(AccountAuthenticatorResponse response,
			String accountType) {
		throw new UnsupportedOperationException("Editting properties is not supported");
	}

	//addding accounts is not supported
	@Override
	public Bundle addAccount(AccountAuthenticatorResponse response,
			String accountType, String authTokenType,
			String[] requiredFeatures, Bundle options)
			throws NetworkErrorException {
		return null;
	}

	//ignore attempts to confirm credentials
	@Override
	public Bundle confirmCredentials(AccountAuthenticatorResponse response,
			Account account, Bundle options) throws NetworkErrorException {
		return null;
	}
	
	//etting authentication token label is not supported
	@Override
	public Bundle getAuthToken(AccountAuthenticatorResponse response,
			Account account, String authTokenType, Bundle options)
			throws NetworkErrorException {
		throw new UnsupportedOperationException("etting authentication token is not supported");
	}

	//getting authentication token label is not supported
	@Override
	public String getAuthTokenLabel(String authTokenType) {
		throw new UnsupportedOperationException("etting authentication token label is not supported");
	}

	//updating credentials is not supported
	@Override
	public Bundle updateCredentials(AccountAuthenticatorResponse response,
			Account account, String authTokenType, Bundle options)
			throws NetworkErrorException {
		throw new UnsupportedOperationException("updating credentials is not supported");
	}

	//checking features for the account is not supported
	@Override
	public Bundle hasFeatures(AccountAuthenticatorResponse response,
			Account account, String[] features) throws NetworkErrorException {
		throw new UnsupportedOperationException("checking features for the account is not supported");
	}

}
