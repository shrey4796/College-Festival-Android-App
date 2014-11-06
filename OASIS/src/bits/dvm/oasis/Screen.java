package bits.dvm.oasis;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Screen extends ActionBarActivity implements SHARED_CONSTANTS{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_screen);
		
		
		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.screen, menu);
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
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment implements SHARED_CONSTANTS{

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_home, container,
					false);
			
			ArrayList<HomeScreenListItem> mainScreenItemsArrayList = new ArrayList<HomeScreenListItem>();
			
			for (int i = 0; i < mainScreenItemsList.length; i++) {
				mainScreenItemsArrayList.add(new HomeScreenListItem(mainScreenItemsList[i]));
			}
			
			RowAdapterHomeScreen adapter = new RowAdapterHomeScreen(getActivity(), mainScreenItemsArrayList);
			ListView listview = (ListView)rootView.findViewById(R.id.listView1);
			listview.setAdapter(adapter);

			listview.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					Intent intent;
					switch(position){
					case 0:
						intent = new Intent(getActivity(), About.class);
						startActivity(intent);
						break;
					case 1:
						intent = new Intent(getActivity(), Schedule.class);
						startActivity(intent);
						break;
					case 2:
						intent = new Intent(getActivity(), Updates.class);
						startActivity(intent);
						break;
					case 3:
						intent = new Intent(getActivity(), FavouriteEventsList.class);
						startActivity(intent);
						break;
					case 4:
						intent = new Intent(getActivity(), Sponsors.class);
						startActivity(intent);
						break;
					case 5:
						intent = new Intent(getActivity(), EventsCategoryWise.class);
						startActivity(intent);
						break;
					case 6:
						intent = new Intent(getActivity(), Social.class);
						startActivity(intent);
						break;
					case 7:
						intent = new Intent(getActivity(), Contacts.class);
						intent.putExtra("page", "reach");
						startActivity(intent);
						break;
					case 8:
						intent = new Intent(getActivity(), Contacts.class);
						intent.putExtra("page", "contacts");
						startActivity(intent);
						break;
					case 9:
						intent = new Intent(getActivity(), Contacts.class);
						intent.putExtra("page", "developer");
						startActivity(intent);
						break;
					}
					
					
				}
			}); 
			
			return rootView;
		}
	}
}
