package bits.dvm.oasis;

public class Event_EventNew_Item {
	
	int id, category_id, icon, favourite;
	String name, content, description, date, time, venue, endtime;
	
	//constructor
	public Event_EventNew_Item(int id, int category_id,
			String name, String content, String description, String date,
			String time, String venue, String endtime, int favourite) {

		this.id = id;
		this.category_id = category_id;
		this.icon = get_icon(category_id);
		this.name = name;
		this.content = content;
		this.description = description;
		this.date = date;
		this.time = time;
		this.venue = venue;
		this.endtime = endtime;
		this.favourite = favourite;
	}
	
	//simple constructor
	public Event_EventNew_Item() {
	}
	
	//function to get icon from category_id
	private int get_icon(int category_id){
		switch (category_id) {
		case 0:
			return 0;  //change to R.drawable category wise icons

		default:
			return 1;  //change to R.drawable.misc category icon
		}
	}

	//getters and setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
		this.icon = get_icon(category_id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public int getIcon() {
		return icon;
	}

	public int getFavourite() {
		return favourite;
	}

	public void setFavourite(int favourite) {
		this.favourite = favourite;
	}
	
}
