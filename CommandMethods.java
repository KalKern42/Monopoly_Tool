import java.util.ArrayList;



public class CommandMethods {
	PropertyData properties = Data.properties;
	PlayerData players = Data.players;
	
	public void rules() {
		
		final String RESET = "\033[0m";  

			// Regular Colors
			final String BLACK = "\033[0;30m";   
			final String RED = "\033[0;31m";     
			final String GREEN = "\033[0;32m";   
			final String YELLOW = "\033[0;33m";  
			final String BLUE = "\033[0;34m";    
			final String PURPLE = "\033[0;35m";  
			final String CYAN = "\033[0;36m";    
			final String WHITE = "\033[0;37m";   

			// Bold
			final String BLACK_BOLD = "\033[1;30m";  
			final String RED_BOLD = "\033[1;31m";    
			final String GREEN_BOLD = "\033[1;32m";  
			final String YELLOW_BOLD = "\033[1;33m"; 
			final String BLUE_BOLD = "\033[1;34m";   
			final String PURPLE_BOLD = "\033[1;35m"; 
			final String CYAN_BOLD = "\033[1;36m";   
			final String WHITE_BOLD = "\033[1;37m";  

			// Underline
			final String BLACK_UNDERLINED = "\033[4;30m";  
			final String RED_UNDERLINED = "\033[4;31m";    
			final String GREEN_UNDERLINED = "\033[4;32m";  
			final String YELLOW_UNDERLINED = "\033[4;33m"; 
			final String BLUE_UNDERLINED = "\033[4;34m";   
			final String PURPLE_UNDERLINED = "\033[4;35m"; 
			final String CYAN_UNDERLINED = "\033[4;36m";   
			final String WHITE_UNDERLINED = "\033[4;37m";  

			// Background
			final String BLACK_BACKGROUND = "\033[40m";  
			final String RED_BACKGROUND = "\033[41m";    
			final String GREEN_BACKGROUND = "\033[42m";  
			final String YELLOW_BACKGROUND = "\033[43m"; 
			final String BLUE_BACKGROUND = "\033[44m";   
			final String PURPLE_BACKGROUND = "\033[45m"; 
			final String CYAN_BACKGROUND = "\033[46m";   
			final String WHITE_BACKGROUND = "\033[47m";  

			// High Intensity
			final String BLACK_BRIGHT = "\033[0;90m";  
			final String RED_BRIGHT = "\033[0;91m";    
			final String GREEN_BRIGHT = "\033[0;92m";  
			final String YELLOW_BRIGHT = "\033[0;93m"; 
			final String BLUE_BRIGHT = "\033[0;94m";   
			final String PURPLE_BRIGHT = "\033[0;95m"; 
			final String CYAN_BRIGHT = "\033[0;96m";   
			final String WHITE_BRIGHT = "\033[0;97m";  

			// Bold High Intensity
			final String BLACK_BOLD_BRIGHT = "\033[1;90m"; 
			final String RED_BOLD_BRIGHT = "\033[1;91m";   
			final String GREEN_BOLD_BRIGHT = "\033[1;92m"; 
			final String YELLOW_BOLD_BRIGHT = "\033[1;93m";
			final String BLUE_BOLD_BRIGHT = "\033[1;94m";  
			final String PURPLE_BOLD_BRIGHT = "\033[1;95m";
			final String CYAN_BOLD_BRIGHT = "\033[1;96m";  
			final String WHITE_BOLD_BRIGHT = "\033[1;97m"; 

			// High Intensity backgrounds
			final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";
			final String RED_BACKGROUND_BRIGHT = "\033[0;101m";
			final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";
			final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";
			final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";
			final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; 
			final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  
			final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m"; 
		
		System.out.println(WHITE_BOLD_BRIGHT + RED_BACKGROUND + "\t\t\tMONOPOLY");
		System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Rules");
		System.out.println("\n How to win");
		System.out.println(BLACK + WHITE_BACKGROUND + "\tMove around the board buying as many properties as you can. The more you own, the more rent you'll ba able to collect from other players. \n\tIf you're the last player with money when all the other players have gone bankrupt, you win! ");
		System.out.println(BLACK_BOLD + "\n Who goes first?");
		System.out.println(BLACK + WHITE_BACKGROUND + "\tEach player rolls both dice. \n\tThe highest roller starts first, and play moves to the left. ");
		System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "\n On Your turn");
		System.out.println(BLACK + WHITE_BACKGROUND + "\t1.  Roll both dice.\n\t2.  Move your token clockwise that number of spaces.\n\t3.  Where did you land? Carry out the rules of that board space. See " + BLACK_BOLD + "spaces." + BLACK_BOLD + WHITE_BACKGROUND + "\n\t\tDid you roll a double?" + BLACK + WHITE_BACKGROUND + "\n\t\tRoll the dice again and take another turn.\n\n" + BLACK_BOLD + WHITE_BACKGROUND + "\t\tWatch out!" + BLACK + WHITE_BACKGROUND + " If you roll a double 3 times in a row, you must immediately Go To Jail! Do not complete your third turn. \n\t4.  Your turn ends. Pass the dice to your left.");
		System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "\n Start playing!");
		System.out.println(BLACK + WHITE_BACKGROUND + "\tThat's all you need to know, so get going. \nLook up the spaces as you land on them.");
		
	}	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void propertyStats(String propertyName) {
		Property property = properties.get(propertyName);
		String icon = Misc.getIconForProperty(property);		
				
		String printOut = property + " - $" + property.price + icon 		+ "\n\t"
						+ "owner : " + property.owner 						+ "\n\t"
						+ "color : " + property.color						+ "\n\n";
												
		System.out.print(printOut);
	}
	
}