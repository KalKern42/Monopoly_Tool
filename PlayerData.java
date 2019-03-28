import java.util.ArrayList;



class PlayerData {
	public ArrayList<Player> players = new ArrayList<Player>();
	
	public Player get(String name) {
		String caseInsensitive = name.toLowerCase();
		for (Player player : players) {
			if (player.name.toLowerCase().equals(caseInsensitive)) {
				return player;
			}
		}
		return null;
	}
	
	public PlayerData() {
		Player p1 = new Player("Player1");
		players.add(p1);
	}

}