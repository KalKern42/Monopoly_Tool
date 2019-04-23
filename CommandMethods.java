import java.util.ArrayList;



public class CommandMethods {
	PropertyData properties = Data.properties;
	PlayerData players = Data.players;
	final String ANSI_RESET = "\u001B[0m";
	final String ANSI_BOLD = "\033[1;99m";

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
						+ "rent prices\t" 								+ "\n\t"
						 +	Misc.getRentInfo(property)
						+ "mortgage value\t : $" + property.mortgage 	+ "\n\n";
						
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
			printOut += "\t" + player;
			printOut += "\n\t  balance\t: $" + player.cash;
			printOut += "\n\t  net worth\t: $" + player.worth();
			printOut += "\n\t  properties\t: " + player.properties.size();
			int railroads = 0;
			int utilities = 0;
			int houses = 0;
			int hotels = 0;
			for (Property property : player.properties) {
				houses += property.houses;
				if (property.hotel) {
					hotels++;
				}
				if (property.railroad) {
					railroads++;
				}
				if (property.utility) {
					utilities++;
				}
			}
			printOut += "\n\t    🚂\t: " + railroads;
			printOut += "\n\t    🔧\t: " + utilities;
			printOut += "\n\t    🏠\t: " + houses;
			printOut += "\n\t    🏨\t: " + hotels;
		}
		
		System.out.print(printOut);
	}
}