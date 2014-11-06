package bits.dvm.oasis;

public class Event_Update_Item {
	
	private int id,show_notification;
	private String update;
	
	//simple constructor
	public Event_Update_Item(){
		
	}

	//parameterised constructor
	public Event_Update_Item(int id, String update, int show_notification) {
		this.id = id;
		this.update = update;
		this.show_notification = show_notification;
	}

	//getters and setters
	
	public String getupdate() {
		return update;
	}

	public void setupdate(String update) {
		this.update = update;
	}

	public int isshow_notification() {
		return show_notification;
	}

	public void setshow_notification(int show_notification) {
		this.show_notification = show_notification;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}
	
	
}
