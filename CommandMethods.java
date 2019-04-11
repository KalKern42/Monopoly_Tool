import java.util.ArrayList;



public class CommandMethods {
	PropertyData properties = Data.properties;
	PlayerData players = Data.players;
	
	

	public void propertyStats(String propertyName) {
		Property property = properties.get(propertyName);
		String icon = Misc.getIconForProperty(property);		
		
		
		
		String printOut = property + "\t\t\t\t" + icon						+ "\n\t"
						+ "price\t\t : $"+ property.price					+ "\n\t"
						+ "current rent\t : $" + property.rentPrice()		+ "\n\t"
						+ "owner\t\t : " + property.owner 					+ "\n\t"
						+ "color\t\t : " + property.color					+ "\n\t"
						+ "possible rent prices\t" 							+ "\n\t"
						+	Misc.getRentInfo(property)

						+ "mortgage value\t : $" + property.mortgage 		+ "\n\n";
						
		System.out.print(printOut);
	}
	
}