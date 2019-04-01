import java.util.ArrayList;
import javax.swing.text.*;

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

	private ArrayList<Property> findAllOfColor(String color, ArrayList<Property> properties) {
		ArrayList<Property> returnList = new ArrayList<Property>();
		
		for (Property property : properties) {
			if (property.color == this.color) {
				returnList.add(property);
			}
		}
		return returnList;
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
		
		ArrayList<Property> playerColorMatches = findAllOfColor(this.color, owner.properties);
		ArrayList<Property> overallColorMatches = findAllOfColor(this.color, Main.properties.propertyList);
		
		if (mortgaged || (owner == null)) {
			return 0;
		}
	
		if (!mortgaged) {
			if (playerColorMatches.size() == overallColorMatches.size()) {
				if (!(railroad)) {
					if (houses != 0) {
						return houseRent[0] * 2;
					}
				}
			}
		}
		
		if (railroad) {
			return 25 * (int)Math.pow(2, playerColorMatches.size() - 1);
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

