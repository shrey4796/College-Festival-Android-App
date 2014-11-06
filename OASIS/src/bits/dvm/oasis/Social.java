package bits.dvm.oasis;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Social extends ActionBarActivity implements SHARED_CONSTANTS {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_social);
		
		ArrayList<HomeScreenListItem> socialItemsArrayList = new ArrayList<HomeScreenListItem>();
		
		for (int i = 0; i < socialItemsList.length; i++) {
			socialItemsArrayList.add(new HomeScreenListItem(socialItemsList[i]));
		}
		
		RowAdapterHomeScreen adapter = new RowAdapterHomeScreen(this, socialItemsArrayList);
		ListView listview = (ListView)findViewById(R.id.listView1);
		listview.setAdapter(adapter);
		
		final Intent intent = new Intent(this, Contacts.class);;
		
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch(position){
				case 0:
					intent.putExtra("page", "facebook");
					startActivity(intent);
					break;
				case 1:
					intent.putExtra("page", "youtube");
					startActivity(intent);
					break;
				case 2:
					intent.putExtra("page", "twitter");
					startActivity(intent);
					break;
				case 3:
					intent.putExtra("page", "blog");
					startActivity(intent);
					break;
				}
			}
		});
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.social, menu);
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
