public class Property {
	String color = "COLOR MISSSING";
	String name = "NAME MISSING";
	Player owner = null;
	boolean railroad = false;
	boolean utility = false;
	int price = 0;
	int mortgage = 0;
	int housePrice = 0;
	boolean mortgaged = false;
	
	int houses = 0;
	boolean hotel = false;
		
	
	int[] houseRent = new int[]{0, 0, 0, 0, 0};
	int hotelRent = 0;

	public Property(String c, String n) {
		color = c;
		name = n;
	}


	public int worth() {
		int base = mortgage;
		
		if (mortgaged) {
			return base;
		}

		if (railroad || utility) {
			base *= 2;
		}
		else {
			base += (houses * housePrice);
		}
		
		if (hotel) {
			base += housePrice;
		}
		
		
		
		return base;
	}
	
	public int rentPrice() {
		if (mortgaged || (owner == null)) {
			return 0;
		}
		
		if (railroad || utility) {
			// TODO: find rent based on number of properties owned
			return 0;
		}
		
		if (hotel) {
			return hotelRent;
		}
		else {
			return houseRent[houses];
		}
	} 
	
	public String toString() {
		return name.toLowerCase();
	}
}

