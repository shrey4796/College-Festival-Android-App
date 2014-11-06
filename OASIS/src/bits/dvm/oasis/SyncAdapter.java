package bits.dvm.oasis;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.accounts.Account;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Handle the transfer of data between oasis server and app, using the Android sync adapter framework.
 */

public class SyncAdapter extends AbstractThreadedSyncAdapter implements SHARED_CONSTANTS {

	Database database;
	
	Context context;
	
	NotificationManager manager;

	ServiceHandler handlerForEventCategoryTable;
	ServiceHandler handlerForEventNewTable;
	ServiceHandler handlerForEventUpdateTable;
	
	//String jsonCountForEventCategoryTable;
	//String jsonCountForEventNewTable;
	//String jsonCountForEventUpdateTable;
	String jsonEventCategoryTable;
	String jsonEventNewTable;
	String jsonEventUpdateTable;
	
	int countForEventCategoryTable;
	int countForEventNewTable;
	int countForEventUpdateTable;
	
	Thread threadForEventCategoryTable;
	Thread threadForEventNewTable;
	Thread threadForEventUpdateTable;
	
	List<Event_Category_Item> listEventCategory;
	List<Event_EventNew_Item> listEventNew;
	List<Event_Update_Item> listUpdate;
	
	
	/*
	 * to be removed before launching start
	 */
	
	//urls to be called
	String urlForEventCategoryTable = "";
	String urlForEventNewTable = "";
	String urlForEventUpdateTable = "";
	String countUrlForEventCategoryTable = "";
	String countUrlForEventNewTable = "";
	String countUrlForEventUpdateTable = "";


	/*
	 * to be removed before launching end
	 */

	public void doWork() {
		
		
		handlerForEventCategoryTable = new ServiceHandler();
		handlerForEventNewTable = new ServiceHandler();
		handlerForEventUpdateTable = new ServiceHandler();
		
		/*
		 * to be removed before launching start
		 */

		/*if(DEVELOPER == TRUE){
			urlForEventCategoryTable = developerUrlForEventCategoryTable;
			urlForEventNewTable = developerUrlForEventNewTable;
			urlForEventUpdateTable = developerUrlForEventUpdateTable;
		}
		else{
		*/	
			urlForEventCategoryTable = liveUrlForEventCategoryTable;
			urlForEventNewTable = liveUrlForEventNewTable;
			urlForEventUpdateTable = liveUrlForEventUpdateTable;
		//}

		/*
		 * to be removed before launching end
		 */
		 
		
		threadForEventCategoryTable = new Thread(){
			
			@Override
			public void run() {
				//Log.e("url",urlForEventCategoryTable);
				listEventCategory = new ArrayList<Event_Category_Item>();
				//database.upgradeTableEventsCategory(database.get_database());
				jsonEventCategoryTable = handlerForEventCategoryTable.makeServiceCall
						(urlForEventCategoryTable, ServiceHandler.GET);
				if(jsonEventCategoryTable!=null){
					try {
						JSONArray arrayEventCategoryTable = 
								new JSONArray(jsonEventCategoryTable);
						for (int i = 0; i < arrayEventCategoryTable.length(); i++) {
							JSONObject objectEventCategoryTable = arrayEventCategoryTable.getJSONObject(i);
							int id = objectEventCategoryTable.getInt(ID);
							String name = objectEventCategoryTable.getString(NAME);
							Event_Category_Item itemCategory = new Event_Category_Item(id, name);
							listEventCategory.add(itemCategory);
							//database.addEventCategoryItem(id, name);
						}
					} catch (JSONException e) {
						//Log.e("Event category table json exception",e.getMessage());
					}
				}
			
				for (int i = 0; i < listEventCategory.size(); i++) {
					//Log.e("s1",String.valueOf(listEventCategory.size()));
					database.addEventCategoryItem(listEventCategory.get(i));
				}
				
			
			}
		};
		
		threadForEventNewTable = new Thread(){
			
			@Override
			public void run() {
				listEventNew = new ArrayList<Event_EventNew_Item>();
				//database.upgradeTableEventsNew(database.get_database());
				
				jsonEventNewTable = handlerForEventNewTable.makeServiceCall
						(urlForEventNewTable, ServiceHandler.GET);
				
				int start_index = "{\"Events\": ".length();
				String temp = handlerForEventNewTable.makeServiceCall
						(urlForEventNewTable, ServiceHandler.GET);
				if(temp!=null){
					int end_index = temp.length() - 1;
					jsonEventNewTable = temp.substring(start_index,end_index);
				}
				else{
					jsonEventNewTable = temp;
				}
				//Log.e("cont",jsonEventNewTable);
				if(jsonEventNewTable!=null){
					try {
						JSONArray arrayForEventNewTable = 
								new JSONArray(jsonEventNewTable);
						for (int i = 0; i < arrayForEventNewTable.length(); i++) {
							JSONObject objectForEventNewTable = arrayForEventNewTable.getJSONObject(i);
							int id = objectForEventNewTable.getInt(ID);
							String name = objectForEventNewTable.getString(NAME);
							int category_id = objectForEventNewTable.getInt(CATEGORY_ID);
							String content = objectForEventNewTable.getString(CONTENT);
							String description = objectForEventNewTable.getString(DESCRIPTION);
							String date = objectForEventNewTable.getString(DATE);
							String time = objectForEventNewTable.getString(TIME);
							String venue = objectForEventNewTable.getString(VENUE);
							String endtime = objectForEventNewTable.getString(ENDTIME);
							int favourite = FALSE;
							Event_EventNew_Item itemEventNew = new Event_EventNew_Item(id, 
									category_id, name, content, description, date, time, 
									venue, endtime, favourite);
							listEventNew.add(itemEventNew);
							//database.addEventNewItem(id, category_id, name, content, 
								//	description, date, time, venue, endtime, openreg, favourite);
						}
					} catch (JSONException e) {
						//Log.e("Event new table json exception",e.getMessage());
					}
				}
				
				for (int i2 = 0; i2 < listEventNew.size(); i2++) {
					//Log.e("s2",String.valueOf(listEventNew.size()));
					database.addEventNewItem(listEventNew.get(i2));
				}

			}
		};
		
		threadForEventUpdateTable = new Thread(){
			
			@Override
			public void run() {
				listUpdate = new ArrayList<Event_Update_Item>();
				//database.upgradeTableEventsUpdate(database.get_database());
				jsonEventUpdateTable = handlerForEventUpdateTable.makeServiceCall
						((urlForEventUpdateTable+"?uid="+database.getUpdatesCount()), ServiceHandler.GET);
				Log.e("zx", urlForEventUpdateTable+"?uid="+database.getUpdatesCount());
				int start_index = "{\"updates\":".length();
				String temp = handlerForEventUpdateTable.makeServiceCall
						((urlForEventUpdateTable+"?uid="+database.getUpdatesCount()), ServiceHandler.GET);
				if(temp!=null){
					int end_index = temp.length() - 1;
					jsonEventUpdateTable = temp.substring(start_index,end_index);
				}
				else{
					jsonEventUpdateTable = temp;
				}
				if(jsonEventUpdateTable!=null){
					Log.e("asdfg",jsonEventUpdateTable);
						try {
						Log.e("json",jsonEventUpdateTable);
						JSONArray arrayEventUpdateTable = 
								new JSONArray(jsonEventUpdateTable);
						for (int i = 0; i < arrayEventUpdateTable.length(); i++) {
							JSONObject objectEventUpdateTable = arrayEventUpdateTable.getJSONObject(i);
							int id = objectEventUpdateTable.getInt(ID);
							String update = objectEventUpdateTable.getString(UPDATE);
							int show_notification = objectEventUpdateTable.getInt(SHOW_NOTIFICATION);
							Event_Update_Item itemUpdate = new Event_Update_Item(id, update, show_notification);
							Log.e("asxc","sf");
							listUpdate.add(itemUpdate);
							//database.addUpdateItem(id, update, show_notification);
							if(show_notification == TRUE){ 
								generateNotification(update);
							}
						}
					} catch (JSONException e) {
						Log.e("Update table json exception",e.getMessage());
					}
				}
				for (int i3 = 0; i3 < listUpdate.size(); i3++) {
					//Log.e("s3",String.valueOf(listUpdate.size()));
					database.addUpdateItem(listUpdate.get(i3));
				}

			
			}
		};
		

	}
	
	int notificationID = 1;
	
	public void generateNotification(String update){
		NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
											.setSmallIcon(notificationIcon)
											.setContentTitle(notificationTitle)
											.setContentText(update)
											.setSound(RingtoneManager.getDefaultUri
													(RingtoneManager.TYPE_NOTIFICATION));
		try{
		
		notificationBuilder.setAutoCancel(true);	//send context from syncservice
		
		Intent notificationClick = new Intent(context, Screen.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, 
				notificationClick, PendingIntent.FLAG_UPDATE_CURRENT);
		
		notificationBuilder.setContentIntent(pendingIntent);
		
		//Log.e("update content",update);
		
		manager.notify(notificationID, notificationBuilder.build());
		notificationID++;
		
		}
		
		catch(Exception e){
			//Log.e("notification error" ,"Err:" + e.getMessage());
		}
		
	}
	
	public SyncAdapter(Context context, boolean autoInitialize) {
		super(context, autoInitialize);
		//Log.e("sync","called");
		database = new Database(context);
		doWork();
	}

	public SyncAdapter(Context context, boolean autoInitialize,
			boolean allowParallelSyncs) {
		super(context, autoInitialize, allowParallelSyncs);
		database = new Database(context);
		doWork();
	}
	
	public SyncAdapter(Context context, boolean autoInitialize, NotificationManager manager) {
		super(context, autoInitialize);
		database = new Database(context);
		this.manager = manager;
		this.context = context;
		//Log.e("cool","cool");
		doWork();
	}
	
	@Override
	public void onPerformSync(Account account, Bundle extras, String authority,
			ContentProviderClient provider, SyncResult syncResult) {

		threadForEventCategoryTable.start();
		threadForEventNewTable.start();
		threadForEventUpdateTable.start();
	}
	
	public void sync(){
		
		//database.onUpgrade(database.get_database(),1, 1);
		Log.e("asdsa","eagwashb");
		
		//threadForEventCategoryTable.start();
		threadForEventNewTable.start();
		threadForEventUpdateTable.start();
		
	}

}
