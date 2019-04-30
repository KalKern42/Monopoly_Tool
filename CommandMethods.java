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
		
		System.out.print(printOut + "\n");
	}
	
	
	public void incrementMoney(String playerName, int delta) {
		Player player = players.get(playerName);
		incrementMoney(player, delta);
	}
	
	
	public void incrementMoney(Player player, int delta) {
		int initialBalance = player.cash;
		int postRentBalance = initialBalance + delta;
		String newBalance = "" + (postRentBalance);
		
		if (postRentBalance < 0) {
			newBalance = "-$" + Math.abs(initialBalance + delta);
		}
		else {
			newBalance = "$" + newBalance;
		}
		
		String color = "\033[0;93m";
		if (delta > 0) {
			color = "\033[1;92m";
		}
		else if( delta < 0) {
			color = "\033[0;91m";
		}
		String printOut = "";
		printOut += player.toString().toUpperCase();
		printOut += " : $" + initialBalance;
		printOut += " → " + color + newBalance + ANSI_RESET + "\n";
		
		player.cash = postRentBalance;
		
		System.out.print(printOut);
	}
	
	public void transferMoney(String fromName, String toName, int delta) {
		Player from = players.get(fromName);
		Player to = players.get(toName);
		transferMoney(from, to, delta);
	}
	
	public void transferMoney(Player from, Player to, int delta) {
		String first = from.toString().toUpperCase();
		String second = to.toString().toUpperCase();
		if (delta < 0) {
			first = to.toString().toUpperCase();
			second = from.toString().toUpperCase();
		}
		System.out.print(ANSI_BOLD + "Transferring $" + Math.abs(delta) + " from " + first + " to " + second + "\n" + ANSI_RESET);
		if (delta < 0) {
			incrementMoney(to, delta);
			incrementMoney(from, -delta);
		}
		else {
			incrementMoney(from, -delta);
			incrementMoney(to, delta);
		}
	}
	
	public void payRent(String playerName, String propertyName) {
		Player player = players.get(playerName);
		Property property = properties.get(propertyName);
		payRent(player, property);
	}
	
	public void payRent(Player player, Property property) {
		int rentDue = property.rentPrice();
		String printOut = ANSI_BOLD + property.name.toUpperCase() + ":" + ANSI_RESET;
		
		if (rentDue == 0 || property.owner.name == player.name) {
			System.out.print(printOut + "\033[1;92m No rent due!");
			return;
		}
		
		printOut += "\033[0;91m $" +  rentDue + " RENT" + ANSI_RESET;
		System.out.print(printOut + "\n");
		transferMoney(player, property.owner, rentDue);

	}	
}