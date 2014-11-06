package bits.dvm.oasis;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class RowAdapterHomeScreen extends ArrayAdapter<HomeScreenListItem> implements SHARED_CONSTANTS{

	private final Context context;
	private final ArrayList<HomeScreenListItem> menuHomeScreenList;
	
	public RowAdapterHomeScreen(Context context, ArrayList<HomeScreenListItem> menuHomeScreenList) {
		
		//calling super constructor 
		super(context, R.layout.home_listview_row, menuHomeScreenList);
		
		//setting context to the passed value 
		this.context = context;
		
		//setting menuHomeScreenList to the passed value
		this.menuHomeScreenList = menuHomeScreenList;
		
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
			rowView = inflater.inflate(R.layout.home_listview_row, parent, false);
		}
		
		//3. get imageview from rowview
		ImageView img = (ImageView)rowView.findViewById(R.id.imageView1);
		
		//4. set imageview 
		img.setImageResource(menuHomeScreenList.get(position).getImage());
		
		//Log.e("position",String.valueOf(position));
		
		//5. return rowView
		return rowView;
				
	}
	
	
}