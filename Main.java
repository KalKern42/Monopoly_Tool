import java.util.ArrayList;


class Main {
	static PropertyData propertyData = new PropertyData();
	static ArrayList<Property> properties = propertyData.properties;
	
	public static void main(String[] args) {
		System.out.print(properties.get(1));
	}
}