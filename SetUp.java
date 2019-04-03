import java.util.Scanner;
import javax.lang.model.element.*;
import java.util.ArrayList;

public class SetUp {
	
	public static void setUp(){
		Scanner input = new Scanner(System.in);
		
		ArrayList<String> illegalNames = new ArrayList<String>();
		illegalNames.add("kill");
		illegalNames.add("help");
			
		
		
		System.out.print("How many players will be enjoying my company?  I will not allow more than 6 or less than 2.  \n");
		int p = input.nextInt();
		
		while (p < 2 || p > 6) {
			System.out.println("Try again.");
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

		}
	}
}
	