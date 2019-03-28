import java.util.ArrayList;



class PlayerData {
	public ArrayList<Player> playerList = new ArrayList<Player>();
	
	public Player get(String name) {
		String caseInsensitive = name.toLowerCase();
		for (Player player : playerList) {
			if (player.name.equalsIgnoreCase(caseInsensitive)) {
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