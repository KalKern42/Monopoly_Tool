import java.util.ArrayList;



class Main {
	static PropertyData properties = Data.properties;
	static PlayerData players = Data.players;
	static CommandMethods commands = Data.commands;

	
	public static void main(String[] args) {
		Property ori = properties.get("oriental avenue");
		ori.houses = 4;
		//ori.hotel = true;
		commands.propertyStats("short line");
		commands.propertyStats("oriental avenue");
		commands.rules(); 

	}
}

