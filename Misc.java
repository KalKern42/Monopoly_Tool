public class Misc {
	
	
	public static String getRentInfo(Property property) {
		String rents =	"\tdefault\t : $" + property.houseRent[0]		+ "\n\t";
		
		rents += "\tfull set : $" + (property.houseRent[0] * 2)+ "\n\t";
		
		return rents;
	}
	
	public static String repeat(String src, int rep) {
		return new String(new char[rep]).replace("\0", src);
	}
	
	public static String getIconForProperty(Property property) {
		String icon = "🏠";
		String ANSI_RESET = "\u001B[0m";
		String ANSI_RED = "\u001B[31m";
		
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