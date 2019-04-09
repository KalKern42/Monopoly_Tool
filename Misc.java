public class Misc {
	
	public static String repeat(String src, int rep) {
		return new String(new char[rep]).replace("\0", src);
	}
	
	public static String getIconForProperty(Property property) {
		String icon = "🏠";
		
		if  (!property.hotel) {
			icon = "\t\t" + repeat(icon, property.houses);
		}
		else {
			icon = "\t\t🏨";
		}
		
		if (property.railroad == true) {
			icon = "\t\t🚂";
		}
		
		if (property.utility == true) {
			icon = "\t\t🔧";
		}
		return icon;
	}
}