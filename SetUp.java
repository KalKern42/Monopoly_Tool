import java.util.Scanner;

class SetUp {
	
	public SetUp(){
		Scanner input = new Scanner(System.in);
		
		System.out.print("How many players will be enjoying my company?");
		int p = input.nextInt();
		for (int i = 0; i <= p; i++) {
			System.out.print("What is the name of player" + i + "?");
			String name = input.nextLine();
		}
	}
}
	