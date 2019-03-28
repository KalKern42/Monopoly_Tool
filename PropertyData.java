import java.util.ArrayList;



class PropertyData {
	public ArrayList<Property> propertyList = new ArrayList<Property>();
	
	public Property get(String name) {
		String caseInsensitive = name.toLowerCase();
		
		for (Property property : propertyList) {
			if (property.name.equalsIgnoreCase(name)) {
				return property;
			}
		}
		return null;
	}
	
	public ArrayList<Property> getByColor(String color) {
		ArrayList<Property> colored = new ArrayList<Property>();
		String caseInsensitive = color.toLowerCase();
		
		for (Property property : propertyList) {
			if (property.color.equalsIgnoreCase(color)) {
				colored.add(property);
			}
		}
		return colored;
	}
	
	public PropertyData() {
		Property a = new Property("purple", "mediterranean avenue");
		a.price = 60;
		a.mortgage = 30;
		a.housePrice = 50;
		a.houseRent = new int[]{2, 10, 30, 90, 160};
		a.hotelRent = 250;
		propertyList.add(a);
		
		
	}
	
}