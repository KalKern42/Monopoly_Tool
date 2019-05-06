import java.util.ArrayList;



class Main {
	static PropertyData properties = Data.properties;
	static PlayerData players = Data.players;
	static CommandMethods commands = Data.commands;

	
	public static void main(String[] args) {
	
		Player p1 = players.get("Player1");
		Player p2 = players.get("Player2");
		Property prop = properties.get("boardwalk");
		Property prop2 = properties.get("mediterranean avenue");
		Property prop3 = properties.get("water works");
		Property prop4 = properties.get("electric company");

		
		p1.giveProperty(prop2);
		//p1.giveProperty(prop3);
		prop.mortgaged = true;
		prop2.houses = 2;
		//prop3.houses = 3;
		//prop3.hotel = true;
		//p1.giveProperty(prop4);
		p1.giveProperty(prop);
		p1.giveProperty(prop3);
		//commands.propertyStats(prop);
		//commands.playerStats(p1);
		//commands.playerProperties(p1);
		//commands.allProperties();
		//commands.playersOverview();
		//commands.propertiesByType("dark blue");
		//commands.transferMoney("Player1", "Player2", -50);
		//commands.payRent(p2, prop3);
		p1.cash = 150;
		//commands.purchaseProperty(p1, prop3);
		commands.unmortgageProperty("boardwalk");
	}
}

