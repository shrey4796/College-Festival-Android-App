package bits.dvm.oasis;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class Updates extends ActionBarActivity implements SHARED_CONSTANTS {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_updates);
		
		//loading font into typeFace
		Typeface typeFace = Typeface.createFromAsset(getAssets(), FONT_PATH_CORBERT);	
		
		TextView textView = (TextView)findViewById(R.id.textView1);
		textView.setTypeface(typeFace);
		
		Database database = new Database(this);
		
		ListView listView = (ListView)findViewById(R.id.listView1);
		RowAdapterUpdates adapter = new RowAdapterUpdates(getAssets(), this, database.getUpdates());
		
		listView.setAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.updates, menu);
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
