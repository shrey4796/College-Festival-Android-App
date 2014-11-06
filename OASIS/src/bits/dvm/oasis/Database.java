package bits.dvm.oasis;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper implements SHARED_CONSTANTS {

	//Constructor
	public Database(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		if(context == null){
			//Log.e("wer","null");
		}
		
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		//Log.e("as", "asd");
		
		//query to create event category table
		db.execSQL(CREATE_TABLE_EVENTS_CATEGORY);
		
		//query to create events table
		db.execSQL(CREATE_TABLE_EVENTS_EVENTNEW);
		
		//query to create updates table
		db.execSQL(CREATE_TABLE_UPDATES);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		//drop table event category
		db.execSQL(DROP_TABLE_EVENTS_CATEGORY);
		//drop table events
		db.execSQL(DROP_TABLE_EVENTS_EVENTSNEW);
		//call onCreate to regenerate database
		onCreate(db);
				
	}
	
	//get writable database
	public SQLiteDatabase get_database() {
		return this.getWritableDatabase();
	}
	
	//add event_eventnew item
	public void addEventNewItem(int id, int category_id, String name, String content,
			String description, String date, String time, String venue, 
			String endtime, int favourite){
		ContentValues values = new ContentValues();
		values.put(ID, id);
		values.put(CATEGORY_ID, category_id);
		values.put(NAME, name);
		values.put(CONTENT, content);
		values.put(DESCRIPTION, description);
		values.put(DATE, date);
		values.put(TIME, time);
		values.put(VENUE, venue);
		values.put(ENDTIME, endtime);
		values.put(FAVOURITE, favourite);
		SQLiteDatabase db = getWritableDatabase();
		db.insert(EVENTS_EVENTNEW, null, values);
		//db.close();
	}
	
	//update event_eventnew item
	public void updateEventNewItem(int id, int category_id, String name, String content,
			String description, String date, String time, String venue, 
			String endtime, int favourite){
		ContentValues values = new ContentValues();
		values.put(ID, id);
		values.put(CATEGORY_ID, category_id);
		values.put(NAME, name);
		values.put(CONTENT, content);
		values.put(DESCRIPTION, description);
		values.put(DATE, date);
		values.put(TIME, time);
		values.put(VENUE, venue);
		values.put(ENDTIME, endtime);
		values.put(FAVOURITE, favourite);
		SQLiteDatabase db = getWritableDatabase();
/*		String query = "UPDATE " + EVENTS_EVENTNEW + " SET " + FAVOURITE + " = " + favourite + " WHERE " 
					   + ID + " = " + id;
*/
		db.update(EVENTS_EVENTNEW, values, ID + "=?", new String[]{String.valueOf(id)});
		//Log.e("n",String.valueOf(n));
		
		//Log.e("Debug",String.valueOf(getEventById(id).getFavourite()));
		
		//db.close();
	}
	
	
	
	public void addEventNewItem(Event_EventNew_Item item){
		if(checkIfExists(EVENTS_EVENTNEW, item.getId())){
			updateEventNewItem(item.getId(), item.getCategory_id(), item.getName(), item.getContent(),
					item.getDescription(),item.getDate(),item.getTime(),item.getVenue(),item.getEndtime(),
					item.getFavourite());
		}
		else{	
			addEventNewItem(item.getId(), item.getCategory_id(), item.getName(), item.getContent(),
				item.getDescription(),item.getDate(),item.getTime(),item.getVenue(),item.getEndtime(),
				item.getFavourite());
		}
	}
	
	public void markAsFavourite(Event_EventNew_Item item){
		
		if(item.getFavourite() == TRUE){
			//Log.e("msg1", "fav true");
			item.setFavourite(FALSE);
		}
		else{
			//Log.e("msg2", "fav false");
			item.setFavourite(TRUE);
		}
		
		updateEventNewItem(item.getId(), item.getCategory_id(), item.getName(), item.getContent(),
				item.getDescription(),item.getDate(),item.getTime(),item.getVenue(),item.getEndtime(),
				item.getFavourite());
		
		
	}
	
	//add event_category item
	public void addEventCategoryItem(int id, String name){
		ContentValues values = new ContentValues();
		values.put(ID, id);
		values.put(NAME, name);
		SQLiteDatabase db = getWritableDatabase();
		db.insert(EVENT_CATEGORY, null, values);
		//db.close();
	}
	
	//update event_category item
	public void updateEventCategoryItem(int id, String name){
		ContentValues values = new ContentValues();
		values.put(ID, id);
		values.put(NAME, name);
		SQLiteDatabase db = getWritableDatabase();
		db.update(EVENT_CATEGORY, values, ID + " =?", new String[]{String.valueOf(id)});
		//db.close();
	}
	
	//checking if exists
	public boolean checkIfExists(String table_name, int id){
		boolean result = false;
		SQLiteDatabase db = getWritableDatabase();
		Cursor cursor = 
				db.query(table_name, new String[]{ID}, ID + " =?", new String[] {String.valueOf(id)}, null, null, null);
		if(cursor.getCount()!=0)
			result = true;
		cursor.close();
		return result;
	}
	
	public void addEventCategoryItem(Event_Category_Item item){
		if(checkIfExists(EVENT_CATEGORY, item.getId())){
			updateEventCategoryItem(item.getId(), item.getName());
		}
		else{
			addEventCategoryItem(item.getId(), item.getName());
		}
	}
	
	//add event_update data
	public void addUpdateItem(int updateID, String updateContent, int notify){
		SQLiteDatabase db = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(ID, updateID);
		values.put(UPDATE, updateContent);
		values.put(SHOW_NOTIFICATION, notify);
		db.insert(EVENT_UPDATE, null, values);
		//Log.e("qw",String.valueOf(getUpdatesCount()));
		//db.close();
	}
	
	//update event_update data
	public void updateUpdateItem(int updateID, String updateContent, int notify){
		SQLiteDatabase db = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(ID, updateID);
		values.put(UPDATE, updateContent);
		values.put(SHOW_NOTIFICATION, notify);
		db.update(EVENT_UPDATE, values, ID + " =?", new String[]{String.valueOf(updateID)});
		//db.close();
	}
	
	public void addUpdateItem(Event_Update_Item item){
		if(checkIfExists(EVENT_UPDATE, item.getid())){
			updateUpdateItem(item.getid(), item.getupdate(), item.isshow_notification());
		}
		else{
			addUpdateItem(item.getid(), item.getupdate(), item.isshow_notification());
		}
	}
	
	//get all updates
	public ArrayList<Event_Update_Item> getUpdates(){
		
		SQLiteDatabase db = getWritableDatabase();
		ArrayList<Event_Update_Item> list = new ArrayList<Event_Update_Item>();
		
		//select all query
		String query = "SELECT * FROM " + EVENT_UPDATE + " ORDER BY " + ID + " DESC";
		
		Cursor cursor = db.rawQuery(query, null);
		
		if(cursor.moveToFirst()){
			do{
				Event_Update_Item item = new Event_Update_Item();
				
				item.setid(cursor.getInt(cursor.getColumnIndex(ID)));
				item.setupdate(cursor.getString(cursor.getColumnIndex(UPDATE)));
				item.setshow_notification(cursor.getInt(cursor.getColumnIndex(SHOW_NOTIFICATION)));
				
				//adding item to list
				try {
					list.add(item);
				} catch (Exception e) {
					//Log.e("Error from unable extract update", e.getMessage());
				}
				
				
			}while(cursor.moveToNext());
		}
		
		cursor.close();
		//return list
		return list; 
	}
	
	//get updates count
	public int getUpdatesCount(){
		List<Event_Update_Item> list = getUpdates();
		//Log.e("asazd",String.valueOf(list.size()));
		return list.size();
	}
	
	//get all events
	public ArrayList<Event_EventNew_Item> getEvents(String field, String match, 
			String orderBy, int sortOrder){
		
		String sortOrderString = "DESC";
		
		
		SQLiteDatabase db = getWritableDatabase();
		
		
		ArrayList<Event_EventNew_Item> list = new ArrayList<Event_EventNew_Item>();
		
		if(sortOrder == 0) {
			sortOrderString = "ASC";
		}
		
		if(sortOrder == 1) {
			sortOrderString = "DESC";
		}
		
		//select all query
		String query = "SELECT * FROM " + EVENTS_EVENTNEW + " WHERE " + 
						field + " = " + match + " ORDER BY " + orderBy + " " + sortOrderString;
		
		Cursor cursor = db.rawQuery(query, null);
		
		if(cursor.moveToFirst()){
			do{
				Event_EventNew_Item item = new Event_EventNew_Item();
				
				item.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ID))));
				item.setName(cursor.getString(cursor.getColumnIndex(NAME)));
				item.setCategory_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(CATEGORY_ID))));
				item.setContent(cursor.getString(cursor.getColumnIndex(CONTENT)));
				item.setDescription(cursor.getString(cursor.getColumnIndex(DESCRIPTION)));
				item.setDate(cursor.getString(cursor.getColumnIndex(DATE)));
				item.setTime(cursor.getString(cursor.getColumnIndex(TIME)));
				item.setVenue(cursor.getString(cursor.getColumnIndex(VENUE)));
				item.setEndtime(cursor.getString(cursor.getColumnIndex(ENDTIME)));
				item.setFavourite(Integer.parseInt(cursor.getString(cursor.getColumnIndex(FAVOURITE))));
				
				//adding item to list
				try {
					list.add(item);
				} catch (Exception e) {
					//Log.e("Error from unable extract event", e.getMessage());
				}
				
				
			}while(cursor.moveToNext());
		}
		
		cursor.close();
		//return list
		return list;
	}
	
	//get event by id
	public Event_EventNew_Item getEventById(int id) {
		//Log.e("length",String.valueOf(getEvents(ID, String.valueOf(id), ID, ASCENDING).size()));
	if(getEvents(ID, String.valueOf(id), ID, ASCENDING).size() > 0)
		return getEvents(ID, String.valueOf(id), ID, ASCENDING).get(0);
	else
		return new Event_EventNew_Item(0, 0, null, "SPONSORS<br/>Connect to the internet to fetch data.", 
				null, null, null, null, null, 0);
	}
	
	
	
	

}
