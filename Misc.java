import java.util.ArrayList;


public class Misc {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_BOLD = "\033[1;92m";

	
	public static String getRentInfo(Property property) {
		String rents =	"";
		int rentPrice = property.rentPrice();
		
		if (property.railroad) {
			for (int i = 1; i <= 4; i++) {
				int priceAtRailroadsOwned = 25 * (int)Math.pow(2, i-1);

				if (rentPrice == priceAtRailroadsOwned) {
					rents += ANSI_BOLD;
				}
				
				String trains = repeat("🚂", i);
				String conditionalTab = (i<4 ? "\t  : $" : " : $");
				rents += ("\t" + trains + conditionalTab + priceAtRailroadsOwned + ANSI_RESET + "\n\t"); 
			}
		}
		else if (property.utility) {
			
			int numOwnerUtilities = findAllOfColor("utility", property.owner.properties).size();
			if (numOwnerUtilities == 1) {
				rents += ANSI_BOLD;
			}
			rents += "\t🔧\t  : roll * $4" + ANSI_RESET + "\n\t";
			if (numOwnerUtilities == 2) {
				rents += ANSI_BOLD;
			}
			rents += "\t🔧🔧\t  : roll * $10" + ANSI_RESET + "\n\t";
		}
		
		else {
			if (rentPrice == property.houseRent[0]) {
				rents += ANSI_BOLD;
			}
			rents += "\tdefault\t  : $" + property.houseRent[0] + ANSI_RESET + "\n\t";
			
			if (rentPrice == property.houseRent[0] * 2) {
				rents += ANSI_BOLD;
			}			
			rents += "\tfull set  : $" + (property.houseRent[0] * 2) + ANSI_RESET + "\n\t";
			
			for (int i = 1; i <= 4; i++) {
				int priceAtHousesOwned = property.houseRent[i];

				if (property.houses == i) {
					rents += ANSI_BOLD;
				}
				
				String houses = repeat("🏠", i);
				String conditionalTab = (i<4 ? "\t  : $" : " : $");
				rents += ("\t" + houses + conditionalTab + priceAtHousesOwned + ANSI_RESET + "\n\t"); 
			}
			
			if (property.hotel) {
				rents += ANSI_BOLD;
			}
			
			rents += "\t🏨\t  : $" + property.hotelRent + ANSI_RESET + "\n\t";
		}
		
		
		
		
		if (property.mortgaged == true) {
			rents += "\t" + ANSI_RED + "MORTGAGED : $0 \n\t" + ANSI_RESET;
		}
		
		return rents;
	}
	
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
		String icon = "🏠";

		
		if (property.mortgaged) {
			icon = ANSI_RED + "MORTGAGED" + ANSI_RESET;
			return icon;
		}
		
		if  (!property.hotel) {
			icon = repeat(icon, property.houses);
		}
		else {
			icon = "🏨";
		}
		
		if (property.railroad == true) {
			icon = "🚂";
		}
		
		if (property.utility == true) {
			icon = "🔧";
		}
		return icon;
	}
}