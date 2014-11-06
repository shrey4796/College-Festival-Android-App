package bits.dvm.oasis;

public class Event_Category_Item {

	int id;
	String name;

	//constructor
	public Event_Category_Item(int id, String name) {
		this.id = id;
		this.name = name;
	}

	//simple constructor
	public Event_Category_Item() {
	}
	
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
