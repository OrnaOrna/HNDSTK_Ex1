public class Contact {
	private String _name; // Contact name
	private String _phoneNum; // Contact phone number
	
	// Default Constructor
	public Contact() {
		this._name = "default name";
		this._phoneNum = "0";
	}
	
	// Constructor
	public Contact(String name, String phoneNum) {
		this._name = name;
		this._phoneNum = phoneNum;
	}
	// Copy Constructor
	public Contact(Contact c) {
		this._name = c.getName();
		this._phoneNum = c.getPhoneNum();
	}

	public String getName() {
		return _name;
	}


	public void setName(String name) {
		this._name = name;
	}


	public String getPhoneNum() {
		return _phoneNum;
	}


	public void setPhoneNum(String phoneNum) {
		this._phoneNum = phoneNum;
	}
	
	@Override
	public String toString() {
		return "(" + this.getPhoneNum() + ", " + this.getName() + ")";
	}

	/**
	 * Converts a string in the format (phoneNum, name) to a contact having _number
	 * phoneNum and _name name. This function is closely tied to the toString method -
	 * when changing one, the other must be changed too.
	 */
	public static Contact parse(String s) {
		// Edit the string to remove parentheses
		String edited = s.split("\\(")[1];
		edited = edited.split("\\)")[0];

		// Split the string into name and phone number
		String[] details = edited.split(", ");
		return new Contact(details[0], details[1]);
	}
}
