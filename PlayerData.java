import java.util.ArrayList;


public class PlayerData {
	public ArrayList<Player> playerList = new ArrayList<Player>();
	
	public Player get(String name) {
		for (Player player : playerList) {
			if (player.name.equalsIgnoreCase(name)) {
				return player;
			}
		}
		return null;
	}
	
	
	public PlayerData() {
		Player p1 = new Player("Player1");
		playerList.add(p1);
	}

}

