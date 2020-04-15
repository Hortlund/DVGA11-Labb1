import java.util.Observable;

public class Model extends Observable {
	private int[][] board = new int[3][3] ;
	private int playerTurn;
	private int btn;
	private boolean btnTaken = false;
	private int player1Score = 0, player2Score = 0;
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
	
	public int checkWin() {
		int win = 0;
		
		for(int i = 0; i < 3; i++) {
			if(board[i][0] == 1 && board[i][1] == 1 && board[i][2] == 1) {
				win = 1;
				player1Score++;
			}else if(board[i][0] == 2 && board[i][1] == 2 && board[i][2] == 2) {
				win = 2;
				player2Score++;
			}
		}
		for(int i = 0; i < 3; i++) {
			if(board[0][i] == 1 && board[1][i] == 1 && board[2][i] == 1) {
				win = 1;
				player1Score++;
			}else if(board[0][i] == 2 && board[1][i] == 2 && board[2][i] == 2) {
				win = 2;
				player2Score++;
			}
		}
		if(board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1) {
			win = 1;
			player1Score++;
		}else if(board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2) {
			win = 2;
			player2Score++;
		}
		if(board[0][2] == 1 && board[1][1] == 1 && board[2][0] == 1) {
			win = 1;
			player1Score++;
		}else if(board[0][2] == 2 && board[1][1] == 2 && board[2][0] == 2) {
			win = 2;
			player2Score++;
		}
		return win;
	}
	
	public void test(int btn, int col, int row) {
		this.btn = btn;
		
		if(board[col][row] == 1 || board[col][row] == 2) {
			btnTaken = true;
			setChanged();
			notifyObservers();
		}else {
			board[col][row] = playerTurn;
			
			
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
	
	public void resetGame() {
		playerTurn = 1;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = 0;
				}
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
	
	public int getPlayer1Score() {
		
		return player1Score;
	}
	public int getPlayer2Score() {
		
		return player2Score;
	}

}
