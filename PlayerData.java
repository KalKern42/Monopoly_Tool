import java.util.ArrayList;



public class PlayerData {
	public ArrayList<Player> playerList = new ArrayList<Player>();
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	
	public Player get(String name) {
		for (Player player : playerList) {
			if (player.name.equalsIgnoreCase(name)) {
				return player;
			}
		}
		System.out.println(ANSI_RED + "Player " + name.toUpperCase() + " not found!" + ANSI_RESET);
		return null;
	}
	
	public PlayerData() {
		Player p1 = new Player("Player1");
		playerList.add(p1);
		Player p2 = new Player("Player2");
		playerList.add(p2);
	}

}

