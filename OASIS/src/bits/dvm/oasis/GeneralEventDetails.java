package bits.dvm.oasis;

import java.util.Calendar;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class GeneralEventDetails extends ActionBarActivity implements SHARED_CONSTANTS {

	Intent reminderIntent;
	Event_EventNew_Item event;
	Database database;
	Button cal,fav;
	
	public static final String AUTHORITY = "com.android.calendar";
	public static final Uri CONTENT_URI2 =
             Uri.parse("content://" + AUTHORITY + "/events");

	Intent intent;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_general_event_details);
		
		database = new Database(this);
		event = database.getEventById(getIntent().getExtras().getInt("id"));
		
		WebView webView = (WebView)findViewById(R.id.webView1);
		webView.loadDataWithBaseURL("file:///android_asset/", HTML_STARTER + event.getContent(), "text/html", "utf-8", null);
		
		int month;
		if(event.getDate().equals("31")){
			month = 9;
		}
		else{
			month = 10;
		}

		cal = (Button)findViewById(R.id.button1);
		fav = (Button)findViewById(R.id.button2);
		
		
		//loading font into typeFace
		Typeface typeFace = Typeface.createFromAsset(getAssets(), FONT_PATH_CORBERT);		
		
		cal.setTypeface(typeFace);
		fav.setTypeface(typeFace);
		
		if(event.getFavourite() == TRUE){
			fav.setText("Un-Favourite");
		}
		if(event.getFavourite() == FALSE){
			fav.setText("Favourite");
		}
		
		try{
			Calendar calendar = Calendar.getInstance();
			int hrs = (int)Double.parseDouble(event.getTime());
			int minutes = (int)(100*(Double.parseDouble(event.getTime())-hrs)); 
			int date = Integer.parseInt(event.getDate());
			calendar.set(2014, month, date, hrs, minutes);

			
			Calendar calendar2 = Calendar.getInstance();
			int hrs2 = (int)Double.parseDouble(event.getEndtime());
			int minutes2 = (int)(100*(Double.parseDouble(event.getEndtime())-hrs2));
			int date2 = Integer.parseInt(event.getDate());
			if(Double.parseDouble(event.getEndtime())<Double.parseDouble(event.getTime())){
				date2 = date2 + 1;
			}
			
			calendar2.set(2014, month, date2, hrs2, minutes2);
		
		
		
		intent = new Intent(Intent.ACTION_INSERT)
        .setData(CONTENT_URI2)
        .putExtra("beginTime", calendar.getTimeInMillis())
        .putExtra("endTime", calendar2.getTimeInMillis())
        .putExtra("title", event.getName())
        .putExtra("eventLocation", event.getVenue());
		
		
		}
		catch(Exception e){
			e.printStackTrace();
			cal.setVisibility(android.view.View.GONE);
		}
		
	}

	public void addToReminder(View view) { 
		//startActivity(reminderIntent);
		startActivity(intent);
	}
	
	public void markFavourite(View view){

		if(fav.getText().toString().equalsIgnoreCase("Un-Favourite")){
			fav.setText("Favourite");
		}
		if(event.getFavourite() == FALSE){
			fav.setText("Un-Favourite");
		}
		database.markAsFavourite(event);
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
		//getMenuInflater().inflate(R.menu.general_event_details, menu);
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
