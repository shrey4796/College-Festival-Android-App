package bits.dvm.oasis;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/*
 * Defining an implementation of ContentProvider that stubs out all methods
 */

public class SyncStubProvider extends ContentProvider {

	//Always return true indicating that the stub provider loaded correctly 
	@Override
	public boolean onCreate() {
		return true;
	}

	//query() always returns no results
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		return null;
	}

	//return an empty String for MIME type
	@Override
	public String getType(Uri uri) {
		return new String();
	}

	//insert() always returns null (no URI) 
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		return null;
	}

	//delete() always returns "no rows affected" (0)
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		return 0;
	}

	//update() always returns "no rows affected" (0)
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		return 0;
	}

}
