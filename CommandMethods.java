import java.util.ArrayList;
import java.awt.Color;



 public class CommandMethods {
	PropertyData properties = Data.properties;
	PlayerData players = Data.players;
	
	 public void rules() {
		
		final String RESET = "\033[0m";  
		final String BLACK = "\033[0;30m";   
		final String BLACK_BOLD = "\033[1;30m";  
		final String WHITE_BOLD = "\033[1;37m";  
		final String RED_BACKGROUND = "\033[41m";       
		final String WHITE_BACKGROUND = "\033[47m";  

		
		System.out.println(WHITE_BOLD + RED_BACKGROUND + "\t\t\tMONOPOLY");
		System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Rules");
		System.out.println("\n How to win");
		System.out.println(BLACK + WHITE_BACKGROUND + "\tMove around the board buying as many properties as you can. The more you own, the more rent you'll ba able to collect from other players. \n\tIf you're the last player with money when all the other players have gone bankrupt, you win! ");
		System.out.println(BLACK_BOLD + "\n Who goes first?");
		System.out.println(BLACK + WHITE_BACKGROUND + "\tEach player rolls both dice. \n\tThe highest roller starts first, and play moves to the left. ");
		System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "\n On Your turn");
		System.out.println(BLACK + WHITE_BACKGROUND + "\t1.  Roll both dice.\n\t2.  Move your token clockwise that number of spaces.\n\t3.  Where did you land? Carry out the rules of that board space. See " + BLACK_BOLD + "spaces." + BLACK_BOLD + WHITE_BACKGROUND + "\n\t\tDid you roll a double?" + BLACK + WHITE_BACKGROUND + "\n\t\tRoll the dice again and take another turn.\n\n" + BLACK_BOLD + WHITE_BACKGROUND + "\t\tWatch out!" + BLACK + WHITE_BACKGROUND + " If you roll a double 3 times in a row, you must immediately Go To Jail! Do not complete your third turn. \n\t4.  Your turn ends. Pass the dice to your left.");
		System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "\n Start playing!");
		System.out.println(BLACK + WHITE_BACKGROUND + "\tThat's all you need to know, so get going. \nLook up the spaces as you land on them.\n" + RESET + "\n");
		
				
	}
	 public void spaces() {
		final String RESET = "\033[0m";  
		final String BLACK = "\033[0;30m";  				
		final String BLACK_BOLD = "\033[1;30m";  
		final String PURPLE_BACKGROUND = "\033[45m"; 
		final String WHITE_BACKGROUND = "\033[47m";  
		
		System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "THE BOARD SPACES");
		System.out.println(BLACK_BOLD + WHITE_BACKGROUND + " PROPERTIES");
		System.out.println(BLACK + WHITE_BACKGROUND + "\tWhen you land on an unowned Street, Railroad or Utility, you must buy it or auction it. ");
		System.out.println(BLACK_BOLD + WHITE_BACKGROUND + " Want to buy it?" + BLACK + WHITE_BACKGROUND + "\n\tPay the price on the board space " + PURPLE_BACKGROUND + "by typing the name of the player \n\tand the name of the property into this program and the property will be yours.");
		System.out.println(BLACK_BOLD + WHITE_BACKGROUND + " Don't want to buy it?" + BLACK + WHITE_BACKGROUND + "\n\tThe Banker must auction it. Bidding starts at $10, and anyone can increase the bid by as little as $1.\n\tYou don't need to gollow turn order, and the banker ends the austion when no player is willing to increase the bid. \n\tThe highest bidder pays the Bank. If no one wants to bid on the property, that's fine. No one pays anything, and the \n\tTittle Deed stays in the bank. ");
		System.out.println(BLACK_BOLD + WHITE_BACKGROUND + " Collect color sets");
			//System.out.println("brown\t" + BLUE_BACKGROUND_BRIGHT + "\t" + PURPLE_BACKGROUND + "\t" + RED_BACKGROUND_BRIGHT + "\t" + RED_BACKGROUND + "\t" + YELLOW_BACKGROUND + "\t" + GREEN_BACKGROUND + "\t" + BLUE_BACKGROUND + "\t" + WHITE_BACKGROUND);
		System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "\tWhen you own each color set:" + BLACK + WHITE_BACKGROUND + "\n\t\tYou can double the rent for those Streets\n\t\tYou can build Houses and Hotels and charge even more rent!");
		System.out.println(BLACK_BOLD + WHITE_BACKGROUND + " Owned Properties");
		System.out.println(BLACK + WHITE_BACKGROUND + "\tWhen you land on a property that someone elser owns, the owner must ask for rent. If they do, you must pay. if they don't ask before the next player rolls the dice, you don't have to pay. ");
			
			
	}

	
	
	
	
	
	
	
	

	  void propertyStats(String propertyName) {
		Property property = properties.get(propertyName);
		String icon = Misc.getIconForProperty(property);		
				
		String printOut = property + " - $" + property.price + icon 		+ "\n\t"
						+ "owner : " + property.owner 						+ "\n\t"
						+ "color : " + property.color						+ "\n\n";
												
		System.out.print(printOut);
	}
	
}