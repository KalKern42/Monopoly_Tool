import java.util.ArrayList;
import java.util.Scanner;


public class CommandMethods {
	PropertyData properties = Data.properties;
	PlayerData players = Data.players;
	final String ANSI_RESET = "\u001B[0m";
	final String ANSI_BOLD = "\033[1;99m";
	final String ANSI_UNDERLINE = "\033[4;39m";

	public void propertyStats(String propertyName) {
		Property property = properties.get(propertyName);
		
		if (property == null) {
			return;
		}
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
		if (player == null) {
			return;
		}
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
		if (player == null) {
			return;
		}
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
		if (player == null) {
			return;
		}
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
		if (from == null || to == null) {
			return;
		}
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
		
		if (player == null || property == null) {
			return;
		}
		
		payRent(player, property);
	}
	
	public void payRent(Player player, Property property) {
		int rentDue = property.rentPrice();
		String printOut = ANSI_BOLD + property.name.toUpperCase() + ":" + ANSI_RESET;
		
		if (property.utility == true) {
			Scanner input = new Scanner(System.in);
			System.out.print("> What did " + player + " roll? ");
			
			int ownerUtilities = Misc.findAllOfColor("utility", property.owner.properties).size();
			int roll = input.nextInt();
			
			if (ownerUtilities == 1) {
				rentDue = 4 * roll;
			}
			else if (ownerUtilities == 2) {
				rentDue = 10 * roll;
			}
		}
		
		if (rentDue == 0 || property.owner.name == player.name) {
			System.out.print(printOut + "\033[1;92m No rent due!");
			return;
		}
		
		printOut += "\033[0;91m $" +  rentDue + " RENT" + ANSI_RESET;
		System.out.print(printOut + "\n");
		transferMoney(player, property.owner, rentDue);
	}	
	
	public void purchaseProperty(String playerName, String propertyName) {
		Player player = players.get(playerName);
		Property property = properties.get(propertyName);
		
		if (player == null || property == null) {
			return;
		}
		
		purchaseProperty(player, property);
	}
	
	public void purchaseProperty(Player player, Property property) {
		if (property.owner != null) {
			System.out.print("\033[0;91m" + property.toString().toUpperCase() + " isn't for sale!");
			return;
		}
		
		int propertyPrice = property.price;
		
		if (player.cash < propertyPrice) {
			System.out.print("\033[0;91m" + player.name.toUpperCase() + " has only $" + player.cash + "\nThey need $" + (propertyPrice - player.cash) + " more to purchase " + property.toString().toUpperCase());
			return;
		}
		
		System.out.println(property.name.toUpperCase() + " :\033[0;91m $" + propertyPrice + ANSI_RESET);
		System.out.println(player.name.toUpperCase() + " :\033[1;92m $" + player.cash + ANSI_RESET);
		
		System.out.print("Purchase " + property.name.toUpperCase() + " for $" + propertyPrice + "? (y/n) ");
		Scanner input = new Scanner(System.in);
		
		String response = "";		
		while (true) {
			response = input.nextLine().toLowerCase();
			
			if (response.equals("y")) {
				System.out.print("\t");
				incrementMoney(player, -propertyPrice);
				System.out.print("\t\033[1;92m+" + property.name.toUpperCase() + "\n");
				player.giveProperty(property);
				break;
			}
			else if (response.equals("n")) {
				break;
			}
		}
	}
	
	public void mortgageProperty(String propertyName) {
		Property property = properties.get(propertyName);
		
		if (property == null) {
			return;
		}
		mortgageProperty(property);
	}
	
	public void mortgageProperty(Property property) {
		
		if (property.hotel || property.houses != 0) {
			System.out.print("\u001B[31m"+"Must sell all houses/hotels before mortgaging a property!");
			return;
		}
		
		if (property.owner == null) {
			System.out.print("\u001B[31m" + property.name.toUpperCase() + " doesn't even have an owner!");
			return;
		}
				
		System.out.print("Mortgage " + property.name.toUpperCase() + " in exchange for\033[1;92m $" + property.mortgage + "?" + ANSI_RESET + " (y/n) ");
		
		Scanner input = new Scanner(System.in);
		String response = "";
		
		while (true) {
			response = input.nextLine().toLowerCase();
			
			if (response.equals("y")) {
				System.out.print("\t");
				incrementMoney(property.owner, property.mortgage);
				System.out.print("\t" + property.name.toUpperCase() + ANSI_BOLD + "\t\u001B[31m MORTGAGED" + ANSI_RESET);
				property.mortgaged = true;
				break;
			}
			if (response.equals("n")) {
				break;
			}
		}
	}
	
	public void unmortgageProperty(String propertyName) {
		Property property = properties.get(propertyName);
		
		if (property == null) {
			return;
		}
		unmortgageProperty(property);
	}
	
	public void unmortgageProperty(Property property) {
		
		int unmortgagePrice = (int)Math.round(property.mortgage * 1.1);
		
		if (property.owner == null) {
			System.out.print("\u001B[31m" + property.name.toUpperCase() + " doesn't even have an owner!");
			return;
		}
		
		if (property.owner.cash < unmortgagePrice) {
			System.out.print("\033[0;91m" + property.owner.name.toUpperCase() + " has only $" + property.owner.cash + "\nThey need $" + (unmortgagePrice - property.owner.cash) + " more to unmortgage " + property.toString().toUpperCase());
			return;
		}
		
		if (!property.mortgaged) {
			System.out.print("\u001B[31m" + property.name.toUpperCase() + " isn't even mortgaged!");
			return;
		}
		
		
		System.out.print("Unmortgage " + property.name.toUpperCase() + " for\033[0;91m $" + unmortgagePrice + "?" + ANSI_RESET + " (y/n) ");
		
		Scanner input = new Scanner(System.in);
		String response = "";
		
		while (true) {
			response = input.nextLine().toLowerCase();
			
			if (response.equals("y")) {
				System.out.print("\t");
				incrementMoney(property.owner, -unmortgagePrice);
				System.out.print("\t" + property.name.toUpperCase() + ANSI_BOLD + "\t\033[1;92m UNMORTGAGED" + ANSI_RESET);
				property.mortgaged = false;
				break;
			}
			if (response.equals("n")) {
				break;
			}
		}
		
	}
	
}


// TODO: buy and sell houses/hotels
// TODO: sell properties