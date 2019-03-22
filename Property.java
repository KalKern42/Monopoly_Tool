class Property {
	String color = "COLOR MISSSING";
	String name = "NAME MISSING";
	boolean railroad = false;
	boolean utility = false;
	int price = 0;
	int mortgage = 0;
	int housePrice = 0;
	
	int houses = 0;
	int hotels = 0;
	int[] houseRent = new int[]{0, 0, 0, 0};
	int hotelRent = 0;

	public Property(String c, String n) {
		color = c;
		name = n;
	}
	
	public String toString() {
		return name;
	}
}

