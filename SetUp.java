import java.util.Scanner;
import java.util.ArrayList;

public class SetUp {
	
	public static void start(){
		Scanner input = new Scanner(System.in);
		
		ArrayList<String> illegalNames = new ArrayList<String>();
		illegalNames.add("kill");
		illegalNames.add("help");
		
		illegalNames.add("mediterranean");
		illegalNames.add("baltic");
		illegalNames.add("oriental");
		illegalNames.add("vermont");
		illegalNames.add("conneticut");
		illegalNames.add("st");
		illegalNames.add("states");
		illegalNames.add("virginia");
		illegalNames.add("tennessee");
		illegalNames.add("new");
		illegalNames.add("kentucky");
		illegalNames.add("indiana");
		illegalNames.add("illinois");
		illegalNames.add("atlantic");
		illegalNames.add("ventor");
		illegalNames.add("marvin");
		illegalNames.add("pacific");
		illegalNames.add("north");
		illegalNames.add("pensylvania");
		illegalNames.add("park");
		illegalNames.add("boardwalk");
		illegalNames.add("reading");
		illegalNames.add("short");
		illegalNames.add("electric");
		illegalNames.add("water");
		illegalNames.add("propstats");
		illegalNames.add("playerstats");
		illegalNames.add("all");
		illegalNames.add("properties");
		illegalNames.add("players");
		illegalNames.add("+$");
		illegalNames.add("$+");
		illegalNames.add("$-");
		illegalNames.add("-$");
		illegalNames.add("send");
		illegalNames.add("rent");
		illegalNames.add("buy");
		illegalNames.add("mortgage");
		illegalNames.add("unmortgage");
		illegalNames.add("+house");
		illegalNames.add("house+");
		illegalNames.add("-house");
		illegalNames.add("house-");
		illegalNames.add("+hotel");
		illegalNames.add("hotel+");
		illegalNames.add("-hotel");
		illegalNames.add("hotel-");
		illegalNames.add("assignto");
		
		
		System.out.print("How many players will be enjoying my company?  I will not allow more than 6 or less than 2.  \n");
		int p = input.nextInt();
		
		while (p < 2 || p > 6) {
			if (p < 2) {
				System.out.println("No lonley bois, try again. ");
			} else {
				System.out.println("No crowds, too complicated, try again.  ");
			}
			p = input.nextInt();
			
		}
		
		for (int i = 1; i <= p; i++) {
			String name = "";
			do {
				if (illegalNames.contains(name)) {
					System.out.print("That is not allowed.  ");
				}
				System.out.print("What is the name of player " + i + "? \n");
				name = input.next().toLowerCase();
				
				
			} while (illegalNames.contains(name));
			illegalNames.add(name);
			
			Player newPlayer = new Player(name);
			Main.players.playerList.add(newPlayer);

		}
	}
}
	