import java.util.ArrayList;


class Main {
	
	static PropertyData properties = Data.properties;
	static PlayerData players = Data.players;
	
	public static void main(String[] args) {
		Property ori = properties.get("oriental avenue");
		Property ver = properties.get("vermont avenue");
		Property con = properties.get("conneticut avenue");

		Property r1 = properties.get("pennsylvania railroad");
		Property r2 = properties.get("b. & o. railroad");

		Player p1 = players.get("player1");
		
		p1.giveProperty(ori);
		p1.giveProperty(ver);
		p1.giveProperty(con);
		ori.houses = 4;
		p1.giveProperty(r1);
		p1.giveProperty(r2);

		
		System.out.println(p1.worth());
	}
}

