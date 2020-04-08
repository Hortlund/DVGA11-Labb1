

public class Model {
	
	private int playerTurn = 2;
	private int turns;
	
	
	public void drawO() {
		
		
		
	}
	public void drawX() {
		
	}
	
	public int playerTurn() {
		
		if(playerTurn == 1) {
			playerTurn = 2;
		} else if(playerTurn == 2) {
			playerTurn = 1;
		}
		
		System.out.println(playerTurn);
		turns++;
		return playerTurn;
		
	}
	public int getTurns() {
		return turns;
		
	}

}
