import java.util.ArrayList;



public class CommandMethods {
	PropertyData properties = Data.properties;
	PlayerData players = Data.players;
	
	

	
	public void propertyStats(String propertyName) {
		Property property = properties.get(propertyName);
		String icon = Misc.getIconForProperty(property);		
				
		String printOut = property + " - $" + property.price + icon 		+ "\n\t"
						+ "owner : " + property.owner 						+ "\n\t"
						+ "color : " + property.color						+ "\n\n"
						
;						
		System.out.print(printOut);
	}
	
}