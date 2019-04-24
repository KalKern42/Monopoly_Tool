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
		Property prop3 = properties.get("new york avenue");
		
		p1.giveProperty(prop2);
		p1.giveProperty(prop3);
		prop.houses = 4;
		prop2.houses = 2;
		prop3.houses = 3;
		prop3.hotel = true;
		p1.giveProperty(prop);

		//commands.propertyStats(prop);
		//commands.playerStats(p1);
		//commands.playerProperties(p1);
		//commands.allProperties();
		//commands.playersOverview();
		
	}
}

