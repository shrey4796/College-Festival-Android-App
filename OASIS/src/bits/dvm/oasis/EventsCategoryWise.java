package bits.dvm.oasis;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class EventsCategoryWise extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_events_category_wise);
		
		
	}
	
	public void musicButtonClick(View view){
		Intent changeActivity = new Intent(this, LisetCategoryEvents.class);
		changeActivity.putExtra("category", "MUSIC");
		startActivity(changeActivity);
	}

	public void artButtonClick(View view){
		Intent changeActivity = new Intent(this, LisetCategoryEvents.class);
		changeActivity.putExtra("category", "ART");
		startActivity(changeActivity);
	}

	public void danceButtonClick(View view){
		Intent changeActivity = new Intent(this, LisetCategoryEvents.class);
		changeActivity.putExtra("category", "DANCE");
		startActivity(changeActivity);
	}

	public void oratoryButtonClick(View view){
		Intent changeActivity = new Intent(this, LisetCategoryEvents.class);
		changeActivity.putExtra("category", "ORATORY");
		startActivity(changeActivity);
	}

	public void dramaButtonClick(View view){
		Intent changeActivity = new Intent(this, LisetCategoryEvents.class);
		changeActivity.putExtra("category", "DRAMA");
		startActivity(changeActivity);
	}

	public void miscButtonClick(View view){
		Intent changeActivity = new Intent(this, LisetCategoryEvents.class);
		changeActivity.putExtra("category", "MISCELLANEOUS");
		startActivity(changeActivity);
	}

	public void quizzingButtonClick(View view){
		Intent changeActivity = new Intent(this, LisetCategoryEvents.class);
		changeActivity.putExtra("category", "QUIZZING");
		startActivity(changeActivity);
	}

	public void onlineButtonClick(View view){
		Intent changeActivity = new Intent(this, LisetCategoryEvents.class);
		changeActivity.putExtra("category", "ONLINE");
		startActivity(changeActivity);
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
		//getMenuInflater().inflate(R.menu.events_category_wise, menu);
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
