import java.util.Arrays;
import java.util.Observable;

public class Model extends Observable {
	private int[][] board = new int[3][3] ;
	private int playerTurn;
	private int btn;
	private boolean btnTaken = false;
	public Model() {
		
		playerTurn = 1;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = 0;
				}
			}
		
	}
	
	public  boolean fullBoard() {
		boolean isFull = true;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(board[i][j] == 0) {
					isFull = false;
				}
			}
		}
		
		return isFull;
	}
	
	public void test(int btn, int col, int row) {
		this.btn = btn;
		
		if(board[col][row] == 1) {
			btnTaken = true;
			setChanged();
			notifyObservers();
		}else {
			board[col][row] = 1;
			System.out.println(Arrays.deepToString(board));
			
			
			if(playerTurn == 1) {
				playerTurn = 2;
			}else {
				playerTurn = 1;
			}
			btnTaken = false;
			setChanged();
			notifyObservers();
			
		}
		
	}
	
	public int btnPressed() {
		return btn;
	}
	public boolean isItemTaken() {
		return btnTaken;
	}
	public int getPlayerTurn() {
		return playerTurn;
		
	}

}
