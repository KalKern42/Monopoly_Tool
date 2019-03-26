import java.util.ArrayList;

public class Player {
	String name = "NAME MISSING";
	int cash = 1500;
	
	ArrayList<Property> properties = new ArrayList<Property>();
	
	public int worth() {
		int net = cash;
		for (Property property : properties) {
			net += property.worth();
		}
		return net;
	}
	
	public void addProperty(Property newProperty) {
		newProperty.owner = name;
		properties.add(newProperty);
	}
	
	public Player(String n) {
		name = n;
	}
	
	public String toString() {
		return name;
	}
	
}