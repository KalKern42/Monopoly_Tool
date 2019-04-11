import java.util.ArrayList;



public class CommandMethods {
	PropertyData properties = Data.properties;
	PlayerData players = Data.players;
	
	

	public void propertyStats(String propertyName) {
		Property property = properties.get(propertyName);
		String icon = Misc.getIconForProperty(property);		
		
		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_BOLD = "\033[1;99m";
		String title = ANSI_BOLD + property.toString().toUpperCase() + ANSI_RESET;
		
		String printOut = title	+ "\t\t\t\t" + icon 					+  "\n\t"
						+ "price\t\t : $"+ property.price				+ "\n\t"
						+ "owner\t\t : " + property.owner 				+ "\n\t"
						+ "color set\t : " + property.color				+ "\n\t"
						+ "rent prices\t" 								+ "\n\t"
						 +	Misc.getRentInfo(property)
						+ "mortgage value\t : $" + property.mortgage 	+ "\n\n";
						
		System.out.print(printOut);
	}
	
}