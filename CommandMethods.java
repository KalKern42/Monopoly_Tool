import java.util.ArrayList;
import java.awt.Color;



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
		System.out.println(BLACK + WHITE_BACKGROUND + "\tThat's all you need to know, so get going. \nLook up the spaces as you land on them.\n" + RESET + "\n");
		
		
		
	}
	  void spaces() {
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
			
			
			//the rest of the colours
			/*final Color aliceblue = new Color( 240, 248, 255 );
			final Color antiquewhite = new Color( 250, 235, 215 );
			final Color aqua = new Color( 0, 255, 255 );
			final Color aquamarine = new Color( 127, 255, 212 );
			final Color azure = new Color( 240, 255, 255 );
			final Color beige = new Color( 245, 245, 220 );
			final Color bisque = new Color( 255, 228, 196 );
			final Color black = new Color( 0, 0, 0 );
			final Color blanchedalmond = new Color( 255, 255, 205 );
			final Color blue = new Color( 0, 0, 255 );
			final Color blueviolet = new Color( 138, 43, 226 );
			final Color brown = new Color( 165, 42, 42 );
			final Color burlywood = new Color( 222, 184, 135 );
			final Color cadetblue = new Color( 95, 158, 160 );
			final Color chartreuse = new Color( 127, 255, 0 );
			final Color chocolate = new Color( 210, 105, 30 );
			final Color coral = new Color( 255, 127, 80 );
			final Color cornflowerblue = new Color( 100, 149, 237 );
			final Color cornsilk = new Color( 255, 248, 220 );
			final Color crimson = new Color( 220, 20, 60 );
			final Color cyan = new Color( 0, 255, 255 );
			final Color darkblue = new Color( 0, 0, 139 );
			final Color darkcyan = new Color( 0, 139, 139 );
			final Color darkgoldenrod = new Color( 184, 134, 11 );
			final Color darkgray = new Color( 169, 169, 169 );
			final Color darkgreen = new Color( 0, 100, 0 );
			final Color darkkhaki = new Color( 189, 183, 107 );
			final Color darkmagenta = new Color( 139, 0, 139 );
			final Color darkolivegreen = new Color( 85, 107, 47 );
			final Color darkorange = new Color( 255, 140, 0 );
			final Color darkorchid = new Color( 153, 50, 204 );
			final Color darkred = new Color( 139, 0, 0 );
			final Color darksalmon = new Color( 233, 150, 122 );
			final Color darkseagreen = new Color( 143, 188, 143 );
			final Color darkslateblue = new Color( 72, 61, 139 );
			final Color darkslategray = new Color( 47, 79, 79 );
			final Color darkturquoise = new Color( 0, 206, 209 );
			final Color darkviolet = new Color( 148, 0, 211 );
			final Color deeppink = new Color( 255, 20, 147 );
			final Color deepskyblue = new Color( 0, 191, 255 );
			final Color dimgray = new Color( 105, 105, 105 );
			final Color dodgerblue = new Color( 30, 144, 255 );
			final Color firebrick = new Color( 178, 34, 34 );
			final Color floralwhite = new Color( 255, 250, 240 );
			final Color forestgreen = new Color( 34, 139, 34 );
			final Color fuchsia = new Color( 255, 0, 255 );
			final Color gainsboro = new Color( 220, 220, 220 );
			final Color ghostwhite = new Color( 248, 248, 255 );
			final Color gold = new Color( 255, 215, 0 );
			final Color goldenrod = new Color( 218, 165, 32 );
			final Color gray = new Color( 128, 128, 128 );
			final Color green = new Color( 0, 128, 0 );
			final Color greenyellow = new Color( 173, 255, 47 );
			final Color honeydew = new Color( 240, 255, 240 );
			final Color hotpink = new Color( 255, 105, 180 );
			final Color indianred = new Color( 205, 92, 92 );
			final Color indigo = new Color( 75, 0, 130 );
			final Color ivory = new Color( 255, 240, 240 );
			final Color khaki = new Color( 240, 230, 140 );
			final Color lavender = new Color( 230, 230, 250 );
			final Color lavenderblush = new Color( 255, 240, 245 );
			final Color lawngreen = new Color( 124, 252, 0 );
			final Color lemonchiffon = new Color( 255, 250, 205 );
			final Color lightblue = new Color( 173, 216, 230 );
			final Color lightcoral = new Color( 240, 128, 128 );
			final Color lightcyan = new Color( 224, 255, 255 );
			final Color lightgoldenrodyellow = new Color( 250, 250, 210 );
			final Color lightgreen = new Color( 144, 238, 144 );
			final Color lightgrey = new Color( 211, 211, 211 );
			final Color lightpink = new Color( 255, 182, 193 );
			final Color lightsalmon = new Color( 255, 160, 122 );
			final Color lightseagreen = new Color( 32, 178, 170 );
			final Color lightskyblue = new Color( 135, 206, 250 );
			final Color lightslategray = new Color( 119, 136, 153 );
			final Color lightsteelblue = new Color( 176, 196, 222 );
			final Color lightyellow = new Color( 255, 255, 224 );
			final Color lime = new Color( 0, 255, 0 );
			final Color limegreen = new Color( 50, 205, 50 );
			final Color linen = new Color( 250, 240, 230 );
			final Color magenta = new Color( 255, 0, 255 );
			final Color maroon = new Color( 128, 0, 0 );
			final Color mediumaquamarine = new Color( 102, 205, 170 );
			final Color mediumblue = new Color( 0, 0, 205 );
			final Color mediumorchid = new Color( 186, 85, 211 );
			final Color mediumpurple = new Color( 147, 112, 219 );
			final Color mediumseagreen = new Color( 60, 179, 113 );
			final Color mediumslateblue = new Color( 123, 104, 238 );
			final Color mediumspringgreen = new Color( 0, 250, 154 );
			final Color mediumturquoise = new Color( 72, 209, 204 );
			final Color mediumvioletred = new Color( 199, 21, 133 );
			final Color midnightblue = new Color( 25, 25, 112 );
			final Color mintcream = new Color( 245, 255, 250 );
			final Color mistyrose = new Color( 255, 228, 225 );
			final Color mocassin = new Color( 255, 228, 181 );
			final Color navajowhite = new Color( 255, 222, 173 );
			final Color navy = new Color( 0, 0, 128 );
			final Color oldlace = new Color( 253, 245, 230 );
			final Color olive = new Color( 128, 128, 0 );
			final Color olivedrab = new Color( 107, 142, 35 );
			final Color orange = new Color( 255, 165, 0 );
			final Color orangered = new Color( 255, 69, 0 );
			final Color orchid = new Color( 218, 112, 214 );
			final Color palegoldenrod = new Color( 238, 232, 170 );
			final Color palegreen = new Color( 152, 251, 152 );
			final Color paleturquoise = new Color( 175, 238, 238 );
			final Color palevioletred = new Color( 219, 112, 147 );
			final Color papayawhip = new Color( 255, 239, 213 );
			final Color peachpuff = new Color( 255, 218, 185 );
			final Color peru = new Color( 205, 133, 63 );
			final Color pink = new Color( 255, 192, 203 );
			final Color plum = new Color( 221, 160, 221 );
			final Color powderblue = new Color( 176, 224, 230 );
			final Color purple = new Color( 128, 0, 128 );
			final Color red = new Color( 255, 0, 0 );
			final Color rosybrown = new Color( 188, 143, 143 );
			final Color royalblue = new Color( 65, 105, 225 );
			final Color saddlebrown = new Color( 139, 69, 19 );
			final Color salmon = new Color( 250, 128, 114 );
			final Color sandybrown = new Color( 244, 164, 96 );
			final Color seagreen = new Color( 46, 139, 87 );
			final Color seashell = new Color( 255, 245, 238 );
			final Color sienna = new Color( 160, 82, 45 );
			final Color silver = new Color( 192, 192, 192 );
			final Color skyblue = new Color( 135, 206, 235 );
			final Color slateblue = new Color( 106, 90, 205 );
			final Color slategray = new Color( 112, 128, 144 );
			final Color snow = new Color( 255, 250, 250 );
			final Color springgreen = new Color( 0, 255, 127 );
			final Color steelblue = new Color( 70, 138, 180 );
			final Color tan = new Color( 210, 180, 140 );
			final Color teal = new Color( 0, 128, 128 );
			final Color thistle = new Color( 216, 191, 216 );
			final Color tomato = new Color( 253, 99, 71 );
			final Color turquoise = new Color( 64, 224, 208 );
			final Color violet = new Color( 238, 130, 238 );
			final Color wheat = new Color( 245, 222, 179 );
			final Color white = new Color( 255, 255, 255 );
			final Color whitesmoke = new Color( 245, 245, 245 );
			final Color yellow = new Color( 255, 255, 0 );
			final Color yellowgreen = new Color( 154, 205, 50 );*/
			
			final Color Brown = new Color.rgb(102, 51, 0);
			
			
			
			System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "THE BOARD SPACES");
			System.out.println(BLACK_BOLD + WHITE_BACKGROUND + " PROPERTIES");
			System.out.println(BLACK + WHITE_BACKGROUND + "\tWhen you land on an unowned Street, Railroad or Utility, you must buy it or auction it. ");
			System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Want to buy it?" + BLACK + WHITE_BACKGROUND + "\n\tPay the price on the board space " + PURPLE_BACKGROUND + "by typing the name of the player \n\tand the name of the property into this program and the property will be yours.");
			System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Don't want to buy it?" + BLACK + WHITE_BACKGROUND + "\n\tThe Banker must auction it. Bidding starts at $10, and anyone can increase the bid by as little as $1.\n\tYou don't need to gollow turn order, and the banker ends the austion when no player is willing to increase the bid. \n\tThe highest bidder pays the Bank. If no one wants to bid on the property, that's fine. No one pays anything, and the \n\tTittle Deed stays in the bank. ");
			System.out.println(BLACK_BOLD + WHITE_BACKGROUND + "Collect color sets");
			//String Brownn = new String();
			//Brownn.setColor(Color.Brown);
			
			System.out.println("\t" + BLUE_BACKGROUND_BRIGHT + "\t" + PURPLE_BACKGROUND + "\t" + RED_BACKGROUND_BRIGHT + "\t" + RED_BACKGROUND + "\t" + YELLOW_BACKGROUND + "\t" + GREEN_BACKGROUND + "\t" + BLUE_BACKGROUND + "\t" + WHITE_BACKGROUND);
			
			
			
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