import java.util.Scanner;
import java.util.ArrayList;

public class SetUp {
	
	public static ArrayList<String> illegalNames = new ArrayList<String>();
	
	public static String promptForName(int i) {
		Scanner input = new Scanner(System.in);

		System.out.print("What is the name of player " + i + "? " );
		String name = input.next().toLowerCase();
		for (String badName : illegalNames) {
			if (name.contains(badName)) {
				System.out.print("That name is forbidden. ");
				name = promptForName(i);
			}
		}
		return name;
	}
	
	public static void start(){
		Scanner input = new Scanner(System.in);
		
		illegalNames.add("kill");
		illegalNames.add("help");
		
		illegalNames.add("mediterranean");
		illegalNames.add("baltic");
		illegalNames.add("oriental");
		illegalNames.add("vermont");
		illegalNames.add("connecticut");
		illegalNames.add("st_");
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
		illegalNames.add("info");
		
		System.out.print("How many players will be enjoying my company?  I will not allow more than 6 or less than 2. ");
		int p = input.nextInt();
		
		while (p < 2 || p > 6) {
			if (p < 2) {
				System.out.print("No lonley bois, try again. ");
			} else {
				System.out.print("No crowds, too complicated, try again.  ");
			}
			p = input.nextInt();
			
		}
		
		for (int i = 1; i <= p; i++) {
			String name = promptForName(i);
			illegalNames.add(name);
			
			Player newPlayer = new Player(name);
			Main.players.playerList.add(newPlayer);

		}
	}
}
	