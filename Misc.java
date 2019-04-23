import java.util.ArrayList;

// NOTE

// This file has some hecking ugly code
// ugly code that works
// pls don't hurt yourself trying to make it pretty


public class Misc {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_BOLD = "\033[1;92m";
	public static final String HOUSE = "🏠";
	public static final String HOTEL = "🏨";
	public static final String RAILROAD = "🚂";
	public static final String UTILITY = "🔧";
	
	public static String repeat(String src, int rep) {
		return new String(new char[rep]).replace("\0", src);
	}
	
	public static ArrayList<Property> findAllOfColor(String color, ArrayList<Property> listOfProperties) {
			ArrayList<Property> returnList = new ArrayList<Property>();
			
			for (Property property : listOfProperties) {
				if (property.color == color) {
					returnList.add(property);
				}
			}
			return returnList;
		}
	
	public static String getIconForProperty(Property property) {
		String icon = HOUSE;

		if (property.mortgaged) {
			icon = ANSI_RED + "MORTGAGED" + ANSI_RESET;
			return icon;
		}
		
		if  (!property.hotel) {
			icon = repeat(icon, property.houses);
		}
		else {
			icon = HOTEL;
		}
		
		if (property.railroad == true) {
			icon = RAILROAD;
		}
		
		if (property.utility == true) {
			icon = UTILITY;
		}
		return icon;
	}
	
	public static String getRentInfo(Property property) {
		String rents = "";
		int rentPrice = property.rentPrice();
		
		if (property.railroad) {			// RAILROAD
			for (int i = 1; i <= 4; i++) {
				int priceAtRailroadsOwned = 25 * (int)Math.pow(2, i-1);

				if (rentPrice == priceAtRailroadsOwned) {
					rents += ANSI_BOLD;
				}
				
				String trains = repeat(RAILROAD, i);
				String conditionalTab = (i<4 ? "\t  : $" : " : $");
				rents += ("   " + trains + "\t" + conditionalTab + priceAtRailroadsOwned + ANSI_RESET + "\n\t"); 
			}
		}
			
		else if (property.utility) {		// UTILITY
			int numOwnerUtilities = findAllOfColor("utility", property.owner.properties).size();
			
			if (numOwnerUtilities == 1) {
				rents += ANSI_BOLD;
			}
			rents += "   " + UTILITY + "\t  : roll * $4" + ANSI_RESET + "\n\t";
			
			if (numOwnerUtilities == 2) {
				rents += ANSI_BOLD;
			}
			rents += "   " + UTILITY + UTILITY + "\t  : roll * $10" + ANSI_RESET + "\n\t";
		}
		
		else {								// STANDARD
			if (rentPrice == property.houseRent[0]) {
				rents += ANSI_BOLD;
			}
			rents += "   default\t: $" + property.houseRent[0] + ANSI_RESET + "\n\t";
			
			if (rentPrice == property.houseRent[0] * 2) {
				rents += ANSI_BOLD;
			}			
			rents += "   full set\t: $" + (property.houseRent[0] * 2) + ANSI_RESET + "\n\t";
				
			for (int i = 1; i <= 4; i++) { // per house
				int priceAtHousesOwned = property.houseRent[i];

				if (property.houses == i) {
					rents += ANSI_BOLD;
				}
				String houses = repeat(HOUSE, i);
				String conditionalTab = (i<3 ? "\t\t: $" : "\t: $");
				rents += ("   " + houses + conditionalTab + priceAtHousesOwned + ANSI_RESET + "\n\t"); 
			}
			
			if (property.hotel) { // hotel
				rents += ANSI_BOLD;
			}
			rents += "   " + HOTEL + "\t\t: $" + property.hotelRent + ANSI_RESET + "\n\t";
		}
		
		if (property.mortgaged == true) {	// MORTGAGED PROPERTIES
			rents += "   " + ANSI_RED + "MORTGAGED : $0 \n\t" + ANSI_RESET;
		}
		
		return rents;
	}
	
	
	public static String createPropertyList(ArrayList<Property> properties, String prefix) {
		String printOut = "";
		for (Property property : properties) {
			String icon = getIconForProperty(property);
			String conditionalTab = "";
			if (icon.length() < 6) {
				conditionalTab = "\t";
			}
			
			String conditionalTab2 = "";
			if (property.name.length() < 16) {
				conditionalTab2 += "\t";
			}
			
			printOut += prefix + icon + "\t" + conditionalTab + property.toString() + "\t" + conditionalTab2 + property.color.toUpperCase() + "\n";
		}
		return printOut;
	}
	
	public static String createAllPropertyList(String prefix) {
		ArrayList<Property> properties = Data.properties.propertyList;
		String printOut = "";
		for (Property property : properties) {
			String icon = getIconForProperty(property);
			String conditionalTab = "";
			if (icon.length() < 6) {
				conditionalTab = "\t";
			}
			
			String conditionalTab2 = "";
			if (property.name.length() < 16) {
				conditionalTab2 += "\t";
			}

			
			String conditionalTab3 = "";
			if (property.color.length() < 8) {
				conditionalTab3 += "\t";
			}
			
			String owner = "";
			if (property.owner != null) {
				owner = property.owner.toString();
			}
						printOut += prefix + icon + "\t" + conditionalTab + property.toString() + "\t" + conditionalTab2 + property.color.toUpperCase() + conditionalTab3 + "\t" + owner + "\n";
			
		}
		return printOut;
	}
	
}