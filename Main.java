import java.util.ArrayList;


class Main {
	static PropertyData properties = Data.properties;
	static PlayerData players = Data.players;
	static CommandMethods commands = Data.commands;

	
	public static void main(String[] args) {
	
		Player p1 = players.get("Player1");
		Property prop = properties.get("boardwalk");	
		p1.giveProperty(prop);

		commands.propertyStats("boardwalk");
	}
}

