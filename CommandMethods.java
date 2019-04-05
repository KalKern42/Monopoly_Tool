import java.util.ArrayList;



public class CommandMethods {
	PropertyData properties = Data.properties;
	PlayerData players = Data.players;
	
	

	
	public void propertyStats(String propertyName) {
		Property property = properties.get(propertyName);
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
		
				
		String printOut = property + " - $" + property.price + icon 		+ "\n\t"
						+ "owner : " + property.owner 						+ "\n\t"
						+ "color : " + property.color						+ "\n\n"
						
;						
		System.out.print(printOut);
	}
	
		private String repeat(String src, int rep) {
			return new String(new char[rep]).replace("\0", src);
		}
	
}