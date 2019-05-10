/*
Author: Kal Kern
Date: 3/28/19
edited: 5/6/19
the structure needed for commands to operate the 
*/

// !!! use the .contains() to compare strings !!!

import java.util.*;
import javax.xml.bind.attachment.*;

class Commands {
	
	public static final String ANSI_RESET = "\u001B[0m"; // hope you don't mind a little bit of text formatting
	public static final String ANSI_BOLD = "\033[1;99m";
	
	public static void start() {
		Scanner input = new Scanner(System.in);
		int stayIn        = 0; //how to exit the loop
		String usrImpt    = ""; //for basic commands and leaving the loop
		String commTarget = ""; //this is what the commands will be targeting
		String actCommand = ""; //this is for taking the commands into other methods
		String[] comHands = new String[5]; //for the more complex commands requiring more than one target (also sorry for the pun)
		String[] comlist  = {
			"help  \t\t\t\tdisplays a list of commands" , 
			"kill [player]  \t\t\tremoves player" ,
			"trade [player1] [player2] \tchoose a property to go from player1 to player2" };
		
		
		System.out.println("Begining Monopoly Commands..... ");
		System.out.println("(type: 'lmo' to leave)\n");
				
		while (stayIn == 0) {
			System.out.print(ANSI_BOLD + "> " + ANSI_RESET);
			usrImpt = input.nextLine();
			usrImpt = usrImpt.toLowerCase();
			comHands = usrImpt.split(" ");
			
			System.out.println("");
			
/* these are going to be the commands. 
Adding a new comand looks like:
elif (usrImpt.contains(command name){
	everything the command does
}   ~~Reffer to kill as a refference also~~*/
			if (usrImpt.contains("lmo")) {
				stayIn = 1;
			}else if (usrImpt.contains("kill")) { //single command
				commTarget = commandMod(usrImpt, 4);
				
			}else if (usrImpt.contains("clear")) {
				for (int i = 0; i < 30; i++) {
					System.out.println("");
				}	
			}else if (usrImpt.contains("trade")) {
				actCommand = "trade";
				comHands = commandPlex(comHands, "trade");
				
			}else if (usrImpt.contains("cmds") || usrImpt.contains("commands")) {
				//printing a list of commands
				for (int r = 0; r < comlist.length; r++) {
					//output formating too look nice
					System.out.println("\t" + comlist[r]);
				}
				System.out.println("");
			}else if (usrImpt.contains(" stats")) {
				actCommand = "stats";
				comHands = commandPlex(comHands, "stats");
				Data.commands.stats(comHands[0]);	
			}
						
			else if (usrImpt.equals("all properties")) { // list all properties
				actCommand = "properties all";
				Data.commands.allProperties();
			}
			
			else if (usrImpt.contains(" properties")) { // if previous didn't happen, assume they want a specific color
				actCommand = "properties";
				comHands = commandPlex(comHands, "properties");
				Data.commands.propertiesByType(comHands[0]);
			}
			
			else if (usrImpt.equals("players")) { // if previous didn't happen, assume they want a specific color
				actCommand = "players";
				Data.commands.playersOverview();
			}
			
			else if (usrImpt.contains(" +$ ") || usrImpt.contains(" $+ ")) {
				actCommand = "money";
				comHands = commandPlex(comHands, "+$");
				int amount = 0;
				try {
					amount = Integer.parseInt(comHands[2]);
				} catch (Exception e) {
					amount = 0;
				}
				Data.commands.incrementMoney(comHands[0], amount);
			}
			
			else if (usrImpt.contains(" -$ ") || usrImpt.contains(" $- ")) {
				actCommand = "money";
				comHands = commandPlex(comHands, "-$");
				int amount = 0;
				try {
					amount = -Integer.parseInt(comHands[2]);
				} catch (Exception e) {
					amount = 0;
				}
				Data.commands.incrementMoney(comHands[0], amount);
			}
			
			else if (usrImpt.contains(" send ")) {
				actCommand = "send";
				comHands = commandPlex(comHands, "send");
				int amount = 0;
				try {
					amount = Integer.parseInt(comHands[3]);
				} catch (Exception e) {
					amount = 0;
				}
				Data.commands.transferMoney(comHands[0], comHands[2], amount);
			}
			
			else if (usrImpt.contains(" rent ")) { // TODO: revist and make sure whitespace works for all output variants
				actCommand = "rent";
				comHands = commandPlex(comHands, "rent");
				Data.commands.payRent(comHands[0], comHands[2]);
			}
			
			else if (usrImpt.contains(" buy ")) {
				actCommand = "buy";
				comHands = commandPlex(comHands, "buy");
				Data.commands.purchaseProperty(comHands[0], comHands[2]);
			}
			
			else if (usrImpt.contains("unmortgage ")) {
				actCommand = "unmortgage";
				comHands = commandPlex(comHands, "unmortgage");
				Data.commands.unmortgageProperty(comHands[1]);
			}
			
			else if (usrImpt.contains("mortgage ")) {
				actCommand = "mortgage";
				comHands = commandPlex(comHands, "mortgage");
				Data.commands.mortgageProperty(comHands[1]);
			}
			
			else if (usrImpt.contains(" +houses ") || usrImpt.contains(" houses+ ")) {
				actCommand = "houses";
				comHands = commandPlex(comHands, "+houses");
				int amount = 0;
				try {
					amount = Integer.parseInt(comHands[2]);
				} catch (Exception e) {
					amount = 0;
				}
				Data.commands.purchaseHouses(comHands[0], amount);
			}
			
			else if (usrImpt.contains(" +house") || usrImpt.contains(" house+")) { // only 1 house
				actCommand = "houses";
				comHands = commandPlex(comHands, "+houses");
				Data.commands.purchaseHouses(comHands[0], 1);
			}
			
			else if (usrImpt.contains(" -houses ") || usrImpt.contains(" houses- ")) {
				actCommand = "houses";
				comHands = commandPlex(comHands, "+houses");
				int amount = 0;
				try {
					amount = Integer.parseInt(comHands[2]);
				} catch (Exception e) {
					amount = 0;
				}
				Data.commands.sellHouses(comHands[0], amount);
			}
			
			else if (usrImpt.contains(" -house") || usrImpt.contains(" house-")) { // only 1 house
				actCommand = "houses";
				comHands = commandPlex(comHands, "+houses");
				Data.commands.sellHouses(comHands[0], 1);
			}

			else if (usrImpt.contains(" +hotel") || usrImpt.contains(" hotel+")) {
				actCommand = "hotel";
				comHands = commandPlex(comHands, "+hotel");
				Data.commands.purchaseHotel(comHands[0]);
			}
			
			else if (usrImpt.contains(" -hotel") || usrImpt.contains(" hotel-")) {
				actCommand = "hotel";
				comHands = commandPlex(comHands, "+hotel");
				Data.commands.sellHotel(comHands[0]);
			}
			
			else if (usrImpt.contains("assignto")) {
				actCommand = "assignto";
				comHands = commandPlex(comHands, "assignto");
				Data.commands.givePropertyToPlayer(comHands[0], comHands[2]);
			}
			
			else {
				System.out.println("I'm sorry that is not a command, if you would like to a list of commands type: cmds");
			}
		}
	}
	public static String commandMod(String command, int commLenth){
		//some commands have specific targets such as players or properties, this method is designed to "grab" such things
		String modd = command.substring(commLenth + 1);
		return(modd);		
	}
	public static String[] commandPlex(String[] commBit, String atCommand){
		String[] commTarg = new String[5];
		String storage = "";
		
		
		for (int c = 0; c < commBit.length; c++){
			storage = commBit[c]; //for easy comparing
			
			if (commBit[c].contains(atCommand)) {
				commTarg[c] = "";
			}else {
				commTarg[c] = commBit[c];
			}
			//the command targets are stored and returns but the command is not
		}
		
		for (String targ : commTarg) {
			//System.out.print(targ);
		}
		
		return(commTarg);
	}
}