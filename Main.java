import java.util.ArrayList;


class Main {
	
	static PropertyData properties = Data.properties;
	static PlayerData players = Data.players;
	
	public static void main(String[] args) {
		Property med = properties.get("mediterranean avenue");
		Property r1 = properties.get("pennsylvania railroad");
		Property r2 = properties.get("b. & o. railroad");

		Player p1 = players.get("player1");
		
		med.houses = 4;
		p1.giveProperty(med);
		p1.giveProperty(r1);
		p1.giveProperty(r2);
		
		System.out.print(p1.getProperty(r1.name).rentPrice());
		
		//System.out.println(properties.getByColor("railroad"));
		//System.out.println(p1.worth());
	}
}

