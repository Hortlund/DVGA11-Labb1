import java.util.Observable;

public class Model extends Observable {
	private int[] board;
	private int playerTurn;
	public Model() {
		
		playerTurn = 1;
		
	}
	
	public void test() {
		System.out.println("ba");
		if(playerTurn == 1) {
			playerTurn = 2;
		}else {
			playerTurn = 1;
		}
		setChanged();
		notifyObservers();
	}
	
	public int getPlayerTurn() {
		return playerTurn;
	}

}
