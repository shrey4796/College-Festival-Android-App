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

public class LisetCategoryEvents extends ActionBarActivity implements SHARED_CONSTANTS {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_liset_category_events);
		
		
		String category = getIntent().getExtras().getString("category");
		String title = category + " EVENTS";
		
		int category_id;
		
		if(category.equalsIgnoreCase("music")){
			category_id = 3;
		}
		else if(category.equalsIgnoreCase("art")){
			category_id = 4;
		}
		else if(category.equalsIgnoreCase("dance")){
			category_id = 5;
		}
		else if(category.equalsIgnoreCase("oratory")){
			category_id = 11;
		}
		else if(category.equalsIgnoreCase("drama")){
			category_id = 9;
		}
		else if(category.equalsIgnoreCase("miscellaneous")){
			category_id = 7;
		}
		else if(category.equalsIgnoreCase("quizzing")){
			category_id = 10;
		}
		else{ //online category
			category_id = 8;
		}
		
		TextView textView = (TextView)findViewById(R.id.textView1);
		
		//get typeface
		Typeface typeFace = Typeface.createFromAsset(getAssets(), FONT_PATH_MOJAVE);
		
		textView.setTypeface(typeFace);
		textView.setText(title);

		Database database = new Database(this);
		
		ListView listView = (ListView)findViewById(R.id.listView1);
		final ArrayList<Event_EventNew_Item> listItems = database.getEvents(CATEGORY_ID, 
				String.valueOf(category_id), ID, DESCENDING);
		RowAdapterEventList adapter = new RowAdapterEventList(getAssets(), this, listItems);
		listView.setAdapter(adapter);
		
		final Intent go = new Intent(this, GeneralEventDetails.class);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

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
		//getMenuInflater().inflate(R.menu.liset_category_events, menu);
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
