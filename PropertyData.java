import java.util.ArrayList;



class PropertyData {
	public ArrayList<Property> properties = new ArrayList<Property>();
	
	// making changes to property data given property name
	
	public PropertyData() {
		Property a = new Property("purple", "mediterranean avenue");
		a.price = 60;
		a.mortgage = 30;
		a.housePrice = 50;
		a.houseRent = new int[]{2, 10, 30, 90, 160};
		a.hotelRent = 250;
		properties.add(a);
		
		
	}
	
}