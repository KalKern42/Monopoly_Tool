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
	
	public void giveProperty(Property newProperty) {
		newProperty.owner = this;
		properties.add(newProperty);
	}
	
	public void removeProperty(String propertyName) {
		int i = 0;
		for (Property property : properties) {
			if (property.name.equalsIgnoreCase(propertyName)) {
				properties.remove(i);
				break;
			}
			i++;
		}
	}
	
	public Property getProperty(String name) {
		for (Property property : properties) {
			if (property.name.equalsIgnoreCase(name)) {
				return property;
			}
		}
		return null;
	}
	
	public Player(String n) {
		name = n;
	}
	
	public String toString() {
		return name;
	}
	
}