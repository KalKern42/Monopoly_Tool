import java.util.ArrayList;


class Main {
	static PropertyData properties = new PropertyData();
	static PlayerData players = new PlayerData();
		
	public static void main(String[] args) {
		
		Property med = properties.get("mediterranean avenue");
		Player p1 = players.get("player1");
		
		med.houses = 4;
		p1.giveProperty(med);
		
		System.out.print(p1.getProperty("mediterranean avenue").rentPrice());
		
	}
}

