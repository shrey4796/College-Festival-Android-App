package bits.dvm.oasis;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class FavouriteEventsList extends ActionBarActivity implements SHARED_CONSTANTS {

	Database database;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favourite_events_list);
		
		database = new Database(this);
		
		//loading font into typeFace
		Typeface typeFace = Typeface.createFromAsset(getAssets(), FONT_PATH_CORBERT);	
		
		TextView textView = (TextView)findViewById(R.id.textView1);
		textView.setTypeface(typeFace);

		final ListView list = (ListView)findViewById(R.id.listView1);
		RowAdapterEventList adapter = new RowAdapterEventList(getAssets(), this, 
				database.getEvents(FAVOURITE, String.valueOf(TRUE), ID, DESCENDING));
		list.setAdapter(adapter);
		
		final ArrayList<Event_EventNew_Item> listItems = 
				database.getEvents(FAVOURITE, String.valueOf(TRUE), ID, DESCENDING);
		
		final Intent go = new Intent(this, GeneralEventDetails.class);
		
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				go.putExtra("name",listItems.get(position).getName());
				go.putExtra("id", listItems.get(position).getId());
				startActivity(go);
			}
		}); 
		

	}
	
	@Override
	protected void onPause() {
		super.onPause();
		finish();
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
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.favourite_events_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		return super.onOptionsItemSelected(item);
	}
}
