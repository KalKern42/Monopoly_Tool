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
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int stayIn = 0; //how to exit the loop
		String usrImpt = ""; //for basic commands and leaving the loop
		String commTarget = ""; //this is what the commands will be targeting
		String actCommand = ""; //this is for taking the commands into other methods
		String[] comHands = new String[5]; //for the more complex commands requiring more than one target (also sorry for the pun)
		String[] comlist = { "help" , "kill" , "trade" };
		
		
		System.out.println("Begining Monopoly Commands..... ");
		System.out.println("(type: 'lmo' to leave)");
				
		while (stayIn == 0) {
			System.out.print("Monopoly User: ");
			usrImpt = input.nextLine();
			usrImpt = usrImpt.toLowerCase();
			comHands = usrImpt.split(" ");
			
/* these are going to be the commands. 
Adding a new comand looks like:
elif (usrImpt.contains(command name){
	everything the command does
}   ~~Reffer to kill as a refference also~~*/
			if (usrImpt.contains("lmo")) {
				stayIn = 1;
			}else if (usrImpt.contains("kill")) { //single command
				commTarget = commandMod(usrImpt, 4);
			}else if (usrImpt.contains("trade")) {
				actCommand = "trade";
				comHands = commandPlex(comHands, "trade");
			}else if (usrImpt.contains("help")) {
				//printing a list of commands
				for (int r = 0; r < comlist.length; r++) {
					//output formating too look nice
					if (r == comlist.length - 1) {
						System.out.println(comlist[r]);
					}else {
						System.out.print(comlist[r] + ", ");
					}
				}
			}
			else{
				System.out.println("I sorry that is not a command, if you would like to a list of commands type: help");
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
			
			if (storage.contains(atCommand)) {
				commTarg[c] = "";
			}else {
				commTarg[c] = commBit[c];
			}
			//the command targets are stored and returns but the command is not
		}
		
		return(commTarg);
	}
}