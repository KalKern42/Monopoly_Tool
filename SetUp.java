import java.util.Scanner;

public class SetUp {
	
	public static void setUp(){
		Scanner input = new Scanner(System.in);
		
		System.out.print("How many players will be enjoying my company? \n");
		int p = input.nextInt();
		
		for (int i = 1; i <= p; i++) {
			
			System.out.print("What is the name of player " + i + "? \n");
			String name = input.next();
		}
	}
}
	