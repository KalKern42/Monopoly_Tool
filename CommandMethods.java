import java.util.ArrayList;



public class CommandMethods {
	PropertyData properties = Data.properties;
	PlayerData players = Data.players;
	final String ANSI_RESET = "\u001B[0m";
	final String ANSI_BOLD = "\033[1;99m";
	final String ANSI_UNDERLINE = "\033[4;39m";

	public void propertyStats(String propertyName) {
		Property property = properties.get(propertyName);
		propertyStats(property);
	}

	public void propertyStats(Property property) {
		String icon = Misc.getIconForProperty(property);		
		

		String title = ANSI_BOLD + property.toString().toUpperCase() + ANSI_RESET;
		
		String printOut = title	+ "\t\t\t\t" + icon 					+  "\n\t"
						+ "price\t\t : $"+ property.price				+ "\n\t"
						+ "owner\t\t : " + property.owner 				+ "\n\t"
						+ "color set\t : " + property.color				+ "\n\t"
						+ "mortgage value\t : $" + property.mortgage 	+ "\n\t"
						+ "rent prices\t" 								+ "\n\t"
						 +	Misc.getRentInfo(property) + "\n";
						
		System.out.print(printOut);
	}
	
	
	public void playerStats(String playerName) {
		Player player = players.get(playerName);
		playerStats(player);
	}
	
	public void playerStats(Player player) {
		String title = ANSI_BOLD + player.toString().toUpperCase() + ANSI_RESET;
		
		String printOut = title	 			  					+  "\n\t"
						+ "balance\t\t : $" + player.cash		+ "\n\t"
						+ "net worth\t : $" + player.worth()	+ "\n\t"
						+ "properties (" + player.properties.size() + ")\n"
						+ Misc.createPropertyList(player.properties, "\t  ") + "\n";
						
		System.out.print(printOut);
	}
	
	public void playerProperties(String playerName) {
		Player player = players.get(playerName);
		playerProperties(player);
	}
	
	public void playerProperties(Player player) {
		String title = ANSI_BOLD + player.toString().toUpperCase() + " PROPERTIES (" + player.properties.size() + ")" + ANSI_RESET;
		String printOut = title + "\n"
						+ Misc.createPropertyList(player.properties, "\t  ") + "\n";
		System.out.print(printOut);
	}
	
	public void allProperties() {
		String title = ANSI_BOLD + "PROPERTIES (" + Data.properties.propertyList.size() + ")" + ANSI_RESET;
		String printOut = title + "\n"
						+ Misc.createAllPropertyList("\t  ") + "\n";
		System.out.print(printOut);
	}
	
	public void playersOverview() {
		String title = ANSI_BOLD + "PLAYERS (" + Data.players.playerList.size() + ")" + ANSI_RESET;
		String printOut = title + "\n";
		
		for (Player player : Data.players.playerList) {
			printOut += "   " + ANSI_UNDERLINE + player + ANSI_RESET;
			printOut += "\n\tbalance\t\t: $" + player.cash;
			printOut += "\n\tnet worth\t: $" + player.worth();
			printOut += "\n\tproperties (" + player.properties.size() + ")\n";
			int railroads = 0;
			int utilities = 0;
			int normals = 0;
			for (Property property : player.properties) {
				if (property.railroad) {
					railroads++;
				}
				if (property.utility) {
					utilities++;
				}
				if (!(property.railroad || property.utility)) {
					normals++;
				}
			}
			
			printOut += Misc.createPropertyList(player.properties, "\t  ");
			printOut += "\n";

		}
		
		System.out.print(printOut);
	}
	
	public void propertiesByType(String color) {
		ArrayList<Property> properties = Misc.findAllOfColor(color, Data.properties.propertyList);
		
		String keyName = color.toUpperCase() + " PROPERTIES";
		if (color == "railroad") {
			keyName = "RAILROADS";
		}
		if (color == "utility") {
			keyName = "UTILITIES";
		}		
		
		String title = ANSI_BOLD + keyName + " (" + properties.size() + ")" + ANSI_RESET;
		
		String printOut = title + "\n";
		for (Property property : properties) {
			String owner = "";
			if (property.owner != null) {
				owner = property.owner.name;
			}
			
			String conditionalTab = "";
			if (property.name.length() < 16) {
				conditionalTab += "\t";
			}
			
			printOut += "\t" + property + "\t" + conditionalTab + owner + "\n";
		}
		
		System.out.print(printOut);
	}
	
}