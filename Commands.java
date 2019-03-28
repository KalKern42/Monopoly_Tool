/*
Author: Kal Kern
Date: 3/28/19

the structure needed for commands to operate the 
*/

import java.util.Scanner;

class Commands {
	public static void commandudes(String[] args) {
		Scanner input = new Scanner(System.in);
		int stayIn = 0;
		String usrImpt = "";
		String commTarget = "";
		
		System.out.println("Begining Monopoly Commands..... ");
		System.out.println("(type: 'let me out' to leave)");
				
		while (stayIn == 0) {
			System.out.print("Monopoly User: ");
			usrImpt = input.nextLine();
/* these are going to be the commands. 
Adding a new comand looks like:
elif (usrImpt.contains(command name){
	everything the command does
}   ~~Reffer to kill as a refference also~~*/
			if (usrImpt.contains("let me out")) {
				stayIn = 1;
			}else if (usrImpt.contains("kill")) {
				commTarget = commandMod(usrImpt, 4);
				System.out.println(commTarget);//this line is just a test
			}
		}
	}
	public static String commandMod(String command, int commLenth){
		//some commands have specific targets such as players or properties, this method is designed to "grab" such things
		String modd = command.substring(commLenth + 1);
		return(modd);		
	}
}