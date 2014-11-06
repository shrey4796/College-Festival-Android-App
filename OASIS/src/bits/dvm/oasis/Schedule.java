package bits.dvm.oasis;

import java.util.ArrayList;
import java.util.Date;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Schedule extends ActionBarActivity implements
		ActionBar.TabListener {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a {@link FragmentPagerAdapter}
	 * derivative, which will keep every loaded fragment in memory. If this
	 * becomes too memory intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_schedule);
		
		Database database = new Database(this);

		// Set up the action bar.
		final ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the activity.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager(),database);

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.schedule, menu);
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

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		Date date;
		int year,day,month;
		Database database;
		@SuppressWarnings("deprecation")
		public SectionsPagerAdapter(FragmentManager fm, Database database) {
			super(fm);
			this.database = database;
			date = new Date();
			day = date.getDate();
			month = date.getMonth();
			year = date.getYear();
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a PlaceholderFragment (defined as a static inner class
			// below).
			return PlaceholderFragment.newInstance((position + 1),database);
		}
		
		public String[] getTitle(){
			String[] title = new String[5];

				if(month==10 && day ==31){
					title[0] = "Today";
					title[0] = "Friday, October 31";
					title[1] = "Tomorrow";
					title[1] = "Saturday, November 1";
					title[2] = "Sunday, November 2";
					title[3] = "Monday, November 3";
					title[4] = "Tuesday, November 4";
				}
				else if (month==11 && day==1){
					title[0] = "Yesterday";
					title[1] = "Today";
					title[2] = "Tomorrow";
					title[3] = "Monday, November 3";
					title[4] = "Tuesday, November 4";
				}
				else if (month==11 && day==2){
					title[0] = "Oct 31";
					title[1] = "Yesterday";
					title[2] = "Today";
					title[3] = "Tomorrow";
					title[4] = "Monday, November 3";
				}
				else if (month==11 && day==3){
					title[0] = "Oct 31";
					title[1] = "Nov 1";
					title[2] = "Yesterday";
					title[3] = "Today";
					title[4] = "Tomorrow";
				}
				else if (month==11 && day==4){
					title[0] = "Oct 31";
					title[1] = "Nov 1";
					title[2] = "Nov 2";
					title[3] = "Yesterday";
					title[4] = "Today";
				}
				else{
					title[0] = "Oct 31";
					title[1] = "Nov 1";
					title[2] = "Nov 2";
					title[3] = "Nov 3";
					title[4] = "Nov 4";
				}
			
			return title;
		}
		
		@Override
		public int getCount() {
			// Show 5 total pages.
			return 5;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			String[] title = getTitle();
			return title[position];
		}
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment implements SHARED_CONSTANTS {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber, Database database) {
			PlaceholderFragment fragment = new PlaceholderFragment(database);
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}
		
		Database database;

		public PlaceholderFragment() {
		}

		public PlaceholderFragment(Database database) {
			this.database = database;
		}

		
		

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_schedule,
					container, false);
			
			String sectionNumber;
			
			switch(getArguments().getInt(ARG_SECTION_NUMBER)){
			case 1:
				sectionNumber = "31";
				break;
			case 2:
				sectionNumber = "1";
				break;
			case 3:
				sectionNumber = "2";
				break;
			case 4:
				sectionNumber = "3";
				break;
			case 5:
				sectionNumber = "4";
				break;
			default:
				sectionNumber = "2";
				break;
					
			}
			
			final ListView list = (ListView)rootView.findViewById(R.id.listView1);
			RowAdapterEventList adapter = new RowAdapterEventList(getActivity().getAssets(), getActivity(), 
					database.getEvents(DATE, sectionNumber, ID, DESCENDING));
			list.setAdapter(adapter);
			
			final ArrayList<Event_EventNew_Item> listItems = database.getEvents(DATE, sectionNumber, ID, DESCENDING);
			
			list.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					Intent go = new Intent(getActivity(), GeneralEventDetails.class);
					go.putExtra("name",listItems.get(position).getName());
					go.putExtra("id", listItems.get(position).getId());
					startActivity(go);
				}
			}); 
			
			return rootView;
		}
	}

}
