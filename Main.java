import java.util.ArrayList;


class Main {
	
	static PropertyData properties = Data.properties;
	static PlayerData players = Data.players;
	
	public static void main(String[] args) {
		Property med = properties.get("mediterranean avenue");
		Player p1 = players.get("player1");
		
		med.houses = 4;
		p1.giveProperty(med);
		
		System.out.print(properties.getByColor("railroad"));
		System.out.print(p1.worth());
	}
}

