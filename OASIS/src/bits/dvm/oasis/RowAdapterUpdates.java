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

public class RowAdapterUpdates extends ArrayAdapter<Event_Update_Item> implements SHARED_CONSTANTS{

	private final Context context;
	private final ArrayList<Event_Update_Item> UpdateList;
	AssetManager manager;
	
	public RowAdapterUpdates(AssetManager manager, Context context, ArrayList<Event_Update_Item> UpdateList) {
		
		//calling super constructor 
		super(context, R.layout.updates_row, UpdateList);
		
		//setting context to the passed value 
		this.context = context;
		
		//setting menuHomeScreenList to the passed value
		this.UpdateList = UpdateList;
		
		this.manager = manager;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		//creating view to be returned
		View rowView = null;
		
		//1.Create inflater
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		//2. get row view from inflater
		if(rowView == null | rowView != null){
			rowView = inflater.inflate(R.layout.updates_row, parent, false);
		}
		
		//3. get fontpath
		String fontPath = "fonts/corbert.otf";
		
		//4. get textviews from rowview
		TextView update = (TextView)rowView.findViewById(R.id.update);

		//5. loading font into typeFace
		Typeface typeFace = Typeface.createFromAsset(manager, fontPath);		
		
		//6. set textviews
		update.setTypeface(typeFace);
		update.setText(UpdateList.get(position).getupdate());
		
		//7s. return rowView
		return rowView;
				
	}
	
	
}