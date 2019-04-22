/*
Author: Kal Kern
Date: 3/28/19

the structure needed for commands to operate the 
*/

import java.util.*;
import javax.xml.bind.attachment.*;

class Commands {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int stayIn = 0;
		String usrImpt = ""; //for basic commands and leaving the loop
		String commTarget = "";
		String actCommand = "";
		String[] comHands = new String[5]; //for the more complex commands requiring more than one target (also sorry for the pun)
		
		
		System.out.println("Begining Monopoly Commands..... ");
		System.out.println("(type: 'let me out' to leave)");
				
		while (stayIn == 0) {
			System.out.print("Monopoly User: ");
			usrImpt = input.nextLine();
			usrImpt = usrImpt.toLowerCase();
			comHands = usrImpt.split(" ");
			for (int i = 0; i < comHands.length; i++){ // dont forget to delete this
				System.out.println(comHands[i]);
			}
/* these are going to be the commands. 
Adding a new comand looks like:
elif (usrImpt.contains(command name){
	everything the command does
}   ~~Reffer to kill as a refference also~~*/
			if (usrImpt.contains("let me out")) {
				stayIn = 1;
			}else if (usrImpt.contains("kill")) {
				commTarget = commandMod(usrImpt, 4);
				System.out.println(commTarget + "2");//this line is just a test
			}else if (usrImpt.contains("trade")) {
				actCommand = "trade";
				comHands = commandPlex(comHands, actCommand);
				System.out.println(comHands[0]);
				System.out.println(comHands[1]);
				System.out.println(comHands[2]);
			}
		}
	}
	public static String commandMod(String command, int commLenth){
		//some commands have specific targets such as players or properties, this method is designed to "grab" such things
		String modd = command.substring(commLenth + 1);
		return(modd);		
	}
	public static String[] commandPlex(String[] commBit, String actCommand){
		
		// HEP MEH I NEED SOME FIXING DONT FORGET ME
		String[] commTarg = new String[5];
		int i = 0;
		while (i < commBit.length){
			if (commBit[i] != actCommand) {
				commTarg[i] = commBit[i];
				i++;
			}
		}
		return(commTarg);
	}
}