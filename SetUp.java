import java.util.Scanner;
import javax.lang.model.element.*;

public class SetUp {
	
	public static void setUp(){
		Scanner input = new Scanner(System.in);
		
		System.out.print("How many players will be enjoying my company?  I will not allow more than 6 or less than 2.  \n");
		int p = input.nextInt();
		
		while (p < 2 || p > 6) {
			System.out.println("Try again.");
			p = input.nextInt();
			
		}
		
		for (int i = 1; i <= p; i++) {
			
			System.out.print("What is the name of player " + i + "? \n");
			String name = input.next();
		}
	}
}
	