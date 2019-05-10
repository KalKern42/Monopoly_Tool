import java.util.ArrayList;
import java.util.Scanner;


public class CommandMethods {
	PropertyData properties = Data.properties;
	PlayerData players = Data.players;
	final String ANSI_RESET = "\u001B[0m";
	final String ANSI_BOLD = "\033[1;99m";
	final String ANSI_UNDERLINE = "\033[4;39m";
	final String ANSI_LIGHT_GREEN = "\033[1;92m";
	final String ANSI_LIGHT_RED = "\033[0;91m";
	public void propertyStats(String propertyName) {
		Property property = properties.get(propertyName);
		
		if (property == null) {
			return;
		}
		propertyStats(property);
	}
	
	public void stats(String thingName) {

		for (Player p : players.playerList) {
			if (p.name.equalsIgnoreCase(thingName)) {
				playerStats(thingName);
				return;
			}
		}
		
		for (Property pr : properties.propertyList) {
			if (pr.name.equalsIgnoreCase(thingName)) {
				propertyStats(thingName);
				return;
			}
		}

		System.out.println(ANSI_LIGHT_RED  + thingName.toUpperCase() + " not found!" + ANSI_RESET);
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
						+ Misc.createPropertyList(player.properties, "   ") + "\n";
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
		System.out.println("");
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
		System.out.println("");
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
			System.out.print(printOut + "\033[1;92m No rent due!\n\n" + ANSI_RESET);
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
			System.out.print("\033[0;91m" + property.toString().toUpperCase() + " isn't for sale!" + ANSI_RESET);
			return;
		}
		
		int propertyPrice = property.price;
		
		if (player.cash < propertyPrice) {
			System.out.print("\033[0;91m" + player.name.toUpperCase() + " has only $" + player.cash + "\nThey need $" + (propertyPrice - player.cash) + " more to purchase " + property.toString().toUpperCase()+ ANSI_RESET);
			return;
		}
		
		System.out.println(property.name.toUpperCase() + " :\033[0;91m $" + propertyPrice + ANSI_RESET);
		System.out.println(player.name.toUpperCase() + " :\033[1;92m $" + player.cash + ANSI_RESET);
		
		System.out.print(player.name.toUpperCase() + ", purchase " + property.name.toUpperCase() + " for $" + propertyPrice + "? (y/n) ");
		Scanner input = new Scanner(System.in);
		
		String response = "";		
		while (true) {
			response = input.nextLine().toLowerCase();
			
			if (response.equals("y")) {
				System.out.print("\t");
				incrementMoney(player, -propertyPrice);
				System.out.println("\t\033[1;92m+" + property.name.toUpperCase() + "\n" + ANSI_RESET);
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
		
		float housesPerProperty = 0;
		boolean anyHotels = false;
		
		
		if (property.owner == null) {
			System.out.println("\033[0;91m" + property.name.toUpperCase() + " doesn't even have an owner!\n"+ ANSI_RESET);
			return;
		}
		
		if (property.mortgaged == true) {
			System.out.println("\033[0;91m" + property.name.toUpperCase() + " is already mortgaged!\n"+ ANSI_RESET);
			return;
		}
		
		ArrayList<Property> propertiesOfColor = Misc.findAllOfColor(property.color, property.owner.properties);
		ArrayList<Property> allOfColor = Misc.findAllOfColor(property.color, Data.properties.propertyList);
		
		for (Property p : propertiesOfColor) {
			housesPerProperty += (p.houses / allOfColor.size());
			if (p.hotel == true) {
				anyHotels = true;
			}
		}
		
		if (housesPerProperty != 0 || anyHotels == true) {
			System.out.println("\033[0;91m"+"Must sell all houses/hotels before mortgaging a property!\n"+ ANSI_RESET);
			return;
		}
		
				
		System.out.print(property.owner.name.toUpperCase() + ", mortgage " + property.name.toUpperCase() + " in exchange for\033[1;92m $" + property.mortgage + "?" + ANSI_RESET + " (y/n) ");
		
		Scanner input = new Scanner(System.in);
		String response = "";
		
		while (true) {
			response = input.nextLine().toLowerCase();
			
			if (response.equals("y")) {
				System.out.print("\t");
				incrementMoney(property.owner, property.mortgage);
				System.out.println("\t" + property.name.toUpperCase() + ANSI_BOLD + "\t\u001B[31m MORTGAGED\n" + ANSI_RESET);
				property.mortgaged = true;
				break;
			}
			if (response.equals("n")) {
				System.out.println("");
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
			System.out.println("\033[0;91m" + property.name.toUpperCase() + " doesn't even have an owner!\n"+ ANSI_RESET);
			return;
		}
		
		if (property.owner.cash < unmortgagePrice) {
			System.out.println("\033[0;91m" + property.owner.name.toUpperCase() + " has only $" + property.owner.cash + "\nThey need $" + (unmortgagePrice - property.owner.cash) + " more to unmortgage " + property.toString().toUpperCase()+ "\n" + ANSI_RESET);
			return;
		}
		
		if (property.mortgaged != true) {
			System.out.println("\033[0;91m" + property.name.toUpperCase() + " isn't even mortgaged!\n"+ ANSI_RESET);
			return;
		}
		
		
		System.out.print(property.owner.name.toUpperCase() + ", unmortgage " + property.name.toUpperCase() + " for\033[0;91m $" + unmortgagePrice + "?" + ANSI_RESET + " (y/n) "+ ANSI_RESET);
		
		Scanner input = new Scanner(System.in);
		String response = "";
		
		while (true) {
			response = input.nextLine().toLowerCase();
			
			if (response.equals("y")) {
				System.out.print("\t");
				incrementMoney(property.owner, -unmortgagePrice);
				System.out.println("\t" + property.name.toUpperCase() + ANSI_BOLD + "\t\033[1;92m UNMORTGAGED\n" + ANSI_RESET);
				property.mortgaged = false;
				break;
			}
			if (response.equals("n")) {
				System.out.println("");
				break;
			}
		}
	}
	
	public void purchaseHouses(String propertyName, int houses) {
		Property property = properties.get(propertyName);	
		if (property == null) {
			return;
		}
		purchaseHouses(property, houses);
	}
	
	public void purchaseHouses(Property property, int houses) {
		
		if (property.owner == null) {
			System.out.println("\033[0;91m" + "This property has no owner!\n" + ANSI_RESET);
			return;
		}
		if (property.mortgaged == true) {
			System.out.println("\033[0;91m" + "You can't purchase houses for mortgaged properties!\n" + ANSI_RESET);
			return;
		}
		
		if (houses < 0) {
			System.out.println("\033[0;91m" + "Can't purchase negative houses!\n"+ ANSI_RESET);
			return;
		}
		if (property.houses + houses > 4) {
			System.out.println("\033[0;91m" + "A property can only have up to 4 houses!" + ANSI_RESET);
			return;
		}
		if (property.utility || property.railroad) {
			System.out.println("\033[0;91m" + "Railroads and utilities can't have houses!\n" + ANSI_RESET);
			return;
		}
		
		float owned = 0;
		
		ArrayList<Property> propertiesOfColor = Misc.findAllOfColor(property.color, property.owner.properties);
		ArrayList<Property> allOfColor = Misc.findAllOfColor(property.color, Data.properties.propertyList);
		
		for (Property p : propertiesOfColor) {
			owned++;
		}
		
		if (owned != allOfColor.size()) {
			System.out.print("\033[0;91m" + "Must own all properties from " + property.color.toUpperCase() + " color set before purchasing houses!\n" + ANSI_RESET);
		return;
		}

		
		int price = property.housePrice * houses;
		
		if (property.owner.cash < price) {
			System.out.println("\033[0;91m" + "You need $" + (price - property.owner.cash) + " more to make this transaction.\n" + ANSI_RESET);
			return;
		}
		
		
		System.out.print(property.owner.name.toUpperCase() + ", purchase " + houses + " houses on " + property.name.toUpperCase() + " for\033[0;91m $" + price + "?" + ANSI_RESET + " (y/n) ");
		
		Scanner input = new Scanner(System.in);
		String response = "";		
		
		while (true) {
			response = input.nextLine().toLowerCase();
			if (response.equals("y")) {
				System.out.print("\t");
				incrementMoney(property.owner, -price);
				property.houses += houses;
				System.out.println("\t" + property.name.toUpperCase() + ANSI_BOLD + "\t " + Misc.getIconForProperty(property) + "\n");
				break;
			}
			if (response.equals("n")) {
				break;
			}
		}
	}
	
	public void sellHouses(String propertyName, int houses) {
		Property property = properties.get(propertyName);	
		if (property == null) {
			return;
		}
		sellHouses(property, houses);
	}
	
	public void sellHouses(Property property, int houses) {
		
		if (property.owner == null) {
			System.out.print("\033[0;91m" + "This property has no owner!\n" + ANSI_RESET);
			return;
		}
		
		if (houses < 0) {
			System.out.print("\033[0;91m" + "Can't sell negative houses!\n"+ ANSI_RESET);
			return;
		}
		if (property.mortgaged == true) {
			System.out.print("\033[0;91m" + "Mortgaged properties don't have houses!\n" + ANSI_RESET);
			return;
		}
		if (property.hotel == true) {
			System.out.print("\033[0;91m" + "Hotel must be sold first!\n" + ANSI_RESET);
			return;
		}
		if (property.houses - houses < 0) {
			System.out.print("\033[0;91m" + "Attempt to sell more houses than owned!\n" + ANSI_RESET);
			return;
		}
		if (property.utility || property.railroad) {
			System.out.print("\033[0;91m" + "Railroads and utilities don't have houses!\n" + ANSI_RESET);
			return;
		}
			
			
		int gain = (int)Math.round(property.housePrice * houses * 0.5);
		
		System.out.print(property.owner.name.toUpperCase() + ", sell " + houses + " houses on " + property.name.toUpperCase() + " for\033[1;92m $" + gain + "?" + ANSI_RESET + " (y/n) ");
		
		Scanner input = new Scanner(System.in);
		String response = "";		
			
		while (true) {
			response = input.nextLine().toLowerCase();
			if (response.equals("y")) {
				System.out.print("\t");
				incrementMoney(property.owner, gain);
				property.houses -= houses;
				System.out.println("\t" + property.name.toUpperCase() + ANSI_BOLD + "\t " + Misc.getIconForProperty(property) + "\n" + ANSI_RESET);
				break;
			}
			if (response.equals("n")) {
				System.out.println("");
				break;
			}
		}
	}
	
	
	public void purchaseHotel(String propertyName) {
		Property property = properties.get(propertyName);	
		if (property == null) {
			return;
		}
		purchaseHotel(property);
	}
	
	public void purchaseHotel(Property property) {
		
		if (property.owner == null) {
			System.out.print("\033[0;91m" + "This property has no owner!\n" + ANSI_RESET);
			return;
		}
		
		float housesPerProperty = 0;
		boolean anyMortgagedProperties = false;
		int owned = 0;
		
		ArrayList<Property> propertiesOfColor = Misc.findAllOfColor(property.color, property.owner.properties);
		ArrayList<Property> allOfColor = Misc.findAllOfColor(property.color, Data.properties.propertyList);
		
		for (Property p : propertiesOfColor) {
			housesPerProperty += (p.houses / allOfColor.size());
			if (p.mortgaged == true) {
				anyMortgagedProperties = true;
			}
		}

		if (housesPerProperty != 4) {
			System.out.print("\033[0;91m" + "Must have 4 houses per property on " + property.color.toUpperCase() + " color group before upgrading to a hotel!\n"+ ANSI_RESET);
			return;
		}
		
		if (anyMortgagedProperties == true) {
			System.out.print("\033[0;91m" + "Can't purchase hotels for properties from color sets with mortgaged properties!\n" + ANSI_RESET);
			return;
		}
		
		
		if (property.utility || property.railroad) {
			System.out.print("\033[0;91m" + "Railroads and utilities can't have hotels!\n" + ANSI_RESET);
			return;
		}
		
		int price = property.houseRent[4];
		
		if (property.owner.cash < price) {
			System.out.print("\033[0;91m" + "You need $" + (price - property.owner.cash) + " more to make this transaction.\n" + ANSI_RESET);
			return;
		}
		
		
		System.out.print(property.owner.name.toUpperCase() + ", purchase a hotel on " + property.name.toUpperCase() + " for\033[0;91m $" + price + "?" + ANSI_RESET + " (y/n) ");
		
		Scanner input = new Scanner(System.in);
		String response = "";		
		
		while (true) {
			response = input.nextLine().toLowerCase();
			if (response.equals("y")) {
				System.out.print("\t");
				incrementMoney(property.owner, -price);
				property.hotel = true;
				System.out.print("\t" + property.name.toUpperCase() + ANSI_BOLD + "\t " + Misc.getIconForProperty(property) + "\n");
				break;
			}
			if (response.equals("n")) {
				System.out.println("");
				break;
			}
		}
	}

	public void sellHotel(String propertyName) {
			Property property = properties.get(propertyName);	
			if (property == null) {
				return;
			}
			sellHotel(property);
		}
		
	public void sellHotel(Property property) {
		
		if (property.owner == null) {
			System.out.print("\033[0;91m" + "This property has no owner!\n" + ANSI_RESET);
			return;
		}
		if (property.mortgaged == true) {
			System.out.print("\033[0;91m" + "Mortgaged properties don't have hotels!\n" + ANSI_RESET);
			return;
		}
		if (property.utility || property.railroad) {
			System.out.print("\033[0;91m" + "Railroads and utilities don't have hotels!\n" + ANSI_RESET);
			return;
		}
		
		int gain = (int)Math.round(property.houseRent[4] * 0.5);		
		
		System.out.print(property.owner.name.toUpperCase() + ", sell a hotel on " + property.name.toUpperCase() + " for\033[1;92m $" + gain + "?" + ANSI_RESET + " (y/n) ");
		
		Scanner input = new Scanner(System.in);
		String response = "";		
		
		while (true) {
			response = input.nextLine().toLowerCase();
			if (response.equals("y")) {
				System.out.print("\t");
				incrementMoney(property.owner, gain);
				property.hotel = false;
				System.out.print("\t" + property.name.toUpperCase() + ANSI_BOLD + "\t " + Misc.getIconForProperty(property) + "\n");
				break;
			}
			if (response.equals("n")) {
				System.out.println("");
				break;
			}
		}
	}

	public void givePropertyToPlayer(String propertyName, String playerName) {
		Property property = properties.get(propertyName);
		Player player = players.get(playerName);

		if (player == null || property == null) {
			return;
		}
		
		givePropertyToPlayer(property, player);
	}
	
	public void givePropertyToPlayer(Property property, Player player) {
		String upperName = property.name.toUpperCase();
		if (property.owner != null) {
			System.out.print(upperName + " already belongs to " + property.owner.name.toUpperCase() + ". Give to " + player.name.toUpperCase() + ", free of charge? (y/n) ");
		}
		else {
			System.out.print("Give " + upperName + " to " + player.name.toUpperCase() + ", free of charge? (y/n) ");
		}
		
		Scanner input = new Scanner(System.in);
		String response = "";
		
		while (true) {
			response = input.nextLine().toLowerCase();
			
			if (response.equals("y")) {
				System.out.print("\t");
				if (property.owner != null) {
					property.owner.removeProperty(upperName);
					System.out.println(property.owner.name.toUpperCase() + ANSI_LIGHT_RED + " -" + upperName + "\n" + ANSI_RESET);
				}
				player.giveProperty(property);
				System.out.println("\t" + player.name.toUpperCase() + ANSI_LIGHT_GREEN + " +" + upperName + "\n" + ANSI_RESET);
				break;
			}
			if (response.equals("n")) {
				System.out.println("");
				break;
			}
		}
	}
	
	public void rules() {
		
		final String RESET = "\033[0m";  
		final String BLACK = "\033[0;30m";   
		final String BLACK_BOLD = "\033[1;30m";  
		final String WHITE_BOLD = "\033[1;37m";  
		final String RED_BACKGROUND = "\033[41m";       
		final String WHITE_BACKGROUND = "\033[47m";  

		
		System.out.println(WHITE_BOLD + RED_BACKGROUND + "\t\t\tMONOPOLY");
		System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Rules");
		System.out.println("\n How to win");
		System.out.println(BLACK + WHITE_BACKGROUND + "\tMove around the board buying as many properties as you can. The more you own, the more rent you'll ba able to collect from other players. \n\tIf you're the last player with money when all the other players have gone bankrupt, you win! ");
		System.out.println(BLACK_BOLD + "\n Who goes first?");
		System.out.println(BLACK + WHITE_BACKGROUND + "\tEach player rolls both dice. \n\tThe highest roller starts first, and play moves to the left. ");
		System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "\n On Your turn");
		System.out.println(BLACK + WHITE_BACKGROUND + "\t1.  Roll both dice.\n\t2.  Move your token clockwise that number of spaces.\n\t3.  Where did you land? Carry out the rules of that board space. See " + BLACK_BOLD + "spaces." + BLACK_BOLD + WHITE_BACKGROUND + "\n\t\tDid you roll a double?" + BLACK + WHITE_BACKGROUND + "\n\t\tRoll the dice again and take another turn.\n\n" + BLACK_BOLD + WHITE_BACKGROUND + "\t\tWatch out!" + BLACK + WHITE_BACKGROUND + " If you roll a double 3 times in a row, you must immediately Go To Jail! Do not complete your third turn. \n\t4.  Your turn ends. Pass the dice to your left.");
		System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "\n Start playing!");
		System.out.println(BLACK + WHITE_BACKGROUND + "\tThat's all you need to know, so get going. \nLook up the spaces as you land on them.\n" + RESET + "\n");
		
		spaces();
	}
	 public void spaces() {
		final String RESET = "\033[0m";  
		final String BLACK = "\033[0;30m";  				
		final String BLACK_BOLD = "\033[1;30m";  
		final String PURPLE_BACKGROUND = "\033[45m"; 
		final String WHITE_BACKGROUND = "\033[47m";  
		
		System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "THE BOARD SPACES");
		System.out.println(BLACK_BOLD + WHITE_BACKGROUND + " PROPERTIES");
		System.out.println(BLACK + WHITE_BACKGROUND + "\tWhen you land on an unowned Street, Railroad or Utility, you must buy it or auction it. ");
		System.out.println(BLACK_BOLD + WHITE_BACKGROUND + " Want to buy it?" + BLACK + WHITE_BACKGROUND + "\n\tPay the price on the board space by typing the name of the player \n\tthe word \"buy\" and the name of the property into this program and the property will be yours.");
		System.out.println(BLACK_BOLD + WHITE_BACKGROUND + " Don't want to buy it?" + BLACK + WHITE_BACKGROUND + "\n\tThe Banker must auction it. Bidding starts at $10, and anyone can increase the bid by as little as $1.\n\tYou don't need to gollow turn order, and the banker ends the austion when no player is willing to increase the bid. \n\tThe highest bidder pays the Bank. If no one wants to bid on the property, that's fine. No one pays anything, and the \n\tTittle Deed stays in the bank. ");
		System.out.println(BLACK_BOLD + WHITE_BACKGROUND + " Collect color sets");
					System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "\tWhen you own each color set:" + BLACK + WHITE_BACKGROUND + "\n\t\tYou can double the rent for those Streets\n\t\tYou can build Houses and Hotels and charge even more rent!");
		System.out.println(BLACK_BOLD + WHITE_BACKGROUND + " Owned Properties");
		System.out.println(BLACK + WHITE_BACKGROUND + "\tWhen you land on a property that someone elser owns, the owner must ask for rent. If they do, you must pay. if they don't ask before the next player rolls the dice, you don't have to pay. ");
			
			
	}

}

// TODO: kill command