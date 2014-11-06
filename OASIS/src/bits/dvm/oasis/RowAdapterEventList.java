package bits.dvm.oasis;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class RowAdapterEventList extends ArrayAdapter<Event_EventNew_Item> implements SHARED_CONSTANTS{

	private final Context context;
	private final ArrayList<Event_EventNew_Item> menuEventScreenList;
	AssetManager manager;
	
	public RowAdapterEventList(AssetManager manager, Context context, ArrayList<Event_EventNew_Item> menuEventScreenList) {
		
		//calling super constructor 
		super(context, R.layout.event_row, menuEventScreenList);
		
		//setting context to the passed value 
		this.context = context;
		
		//setting menuHomeScreenList to the passed value
		this.menuEventScreenList = menuEventScreenList;
		
		this.manager = manager;
		//Log.e("size",String.valueOf(this.menuHomeScreenList.size()));
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		//creating view to be returned
		View rowView = null;
		
		//1.Create inflater
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		//2. get row view from inflater
		if(rowView == null | rowView != null){
			rowView = inflater.inflate(R.layout.event_row, parent, false);
		}
		
		//3. get fontpath
		String fontPath = "fonts/corbert.otf";
		
		//4. get textviews from rowview
		TextView name = (TextView)rowView.findViewById(R.id.name);
		TextView time = (TextView)rowView.findViewById(R.id.time);
		TextView venue = (TextView)rowView.findViewById(R.id.venue);
		
		//5. loading font into typeFace
		Typeface typeFace = Typeface.createFromAsset(manager, fontPath);
		
		//6. set textviews
		String date = menuEventScreenList.get(position).getDate();
		String date_content = date;
		if(date.equals("31")){
			date_content = date_content + " October, ";
		}
		else if (date.equals("1")){
			date_content = date_content + " November, ";
		}
		else if (date.equals("2")){
			date_content = date_content + " November, ";
		}
		else if (date.equals("3")){
			date_content = date_content + " November, ";
		}
		else if (date.equals("4")){
			date_content = date_content + " November, ";
		}
		String timeString = menuEventScreenList.get(position).getTime();
		try{
		if(Double.parseDouble(menuEventScreenList.get(position).getEndtime()) < 
				Double.parseDouble(menuEventScreenList.get(position).getTime())){
			timeString = date_content + menuEventScreenList.get(position).getTime() + " - " + 
				menuEventScreenList.get(position).getEndtime() + " next day";
		}
		else if(Double.parseDouble(menuEventScreenList.get(position).getEndtime()) > 
				Double.parseDouble(menuEventScreenList.get(position).getTime())){
			timeString = date_content + menuEventScreenList.get(position).getTime() + " - " + 
				menuEventScreenList.get(position).getEndtime();
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		name.setTypeface(typeFace);
		time.setTypeface(typeFace);
		venue.setTypeface(typeFace);
		name.setText(menuEventScreenList.get(position).getName());
		time.setText(timeString);
		venue.setText(menuEventScreenList.get(position).getVenue());
		
		//Log.e("position",String.valueOf(position));
		
		//7s. return rowView
		return rowView;
				
	}
	
	
}