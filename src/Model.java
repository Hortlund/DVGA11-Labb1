import java.util.Observable;

public class Model extends Observable {
	private int[][] board = new int[3][3] ;
	private int playerTurn;
	private int btn;
	public Model() {
		
		playerTurn = 1;
		
	}
	
	public void test(int btn) {
		this.btn = btn;
		System.out.println("ba");
		if(playerTurn == 1) {
			playerTurn = 2;
		}else {
			playerTurn = 1;
		}
		setChanged();
		notifyObservers();
	}
	
	public int btnPressed() {
		return btn;
	}
	public int getPlayerTurn() {
		return playerTurn;
		
	}

}
