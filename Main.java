import java.util.ArrayList;



class Main {
	static PropertyData properties = Data.properties;
	static PlayerData players = Data.players;
	static CommandMethods commands = Data.commands;

	
	public static void main(String[] args) {
		SetUp.start();
		Commands.start();
	}
}

