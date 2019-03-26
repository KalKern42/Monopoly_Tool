import java.util.ArrayList;


class Main {
	static PropertyData propertyData = new PropertyData();
	static PlayerData playerData = new PlayerData();
	
	static ArrayList<Property> properties = propertyData.properties;
	static ArrayList<Player> players = playerData.players;
	
	public static void main(String[] args) {
		
		Property med = properties.get(0);
		med.houses = 4;
		System.out.println(med.rentPrice());
	}
}