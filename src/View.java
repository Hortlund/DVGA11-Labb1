import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class View extends JFrame implements Observer {
	
	private static final long serialVersionUID = 1L;
	private JPanel gridPanel, statusPanel, imagePanel;
	private JLabel player1, player2,ticIcon, turnText;
	private GridLayout layout = new GridLayout(3,3);
	private NewButton[] btn = new NewButton[9];
	private BorderLayout bLayout = new BorderLayout();
	private int player1Score = 0, player2Score = 0;
	
	//https://stackoverflow.com/questions/16343098/resize-a-picture-to-fit-a-jlabel/32885963#32885963
	private ImageIcon tic = new ImageIcon(new ImageIcon("src/tttlogo.png").getImage().getScaledInstance(100, 64, Image.SCALE_DEFAULT));
	
	public View(Controller controller) {
		
		gridPanel = new JPanel();
		statusPanel = new JPanel();
		imagePanel = new JPanel();
		
		ticIcon = new JLabel(tic);
		imagePanel.add(ticIcon);
		
		player1 = new JLabel("<html>Player <span style=\"font-family:Sans;font-size:13px;color:red;\">O</span> Score: " + player1Score + "</html>");
		turnText = new JLabel("<html>Player <span style=\"font-family:Sans;font-size:13px;color:red;\">O</span> turn</html>");
		player2 = new JLabel("<html>Player <span style=\"font-family:Sans;font-size:13px;color:blue;\">X</span> Score: " + player2Score + "</html>");
		

		statusPanel.add(Box.createRigidArea(new Dimension(10,0)));
		statusPanel.add(player1);
		statusPanel.add(Box.createHorizontalGlue());
		statusPanel.add(turnText);
		statusPanel.add(Box.createHorizontalGlue());
		statusPanel.add(player2);
		
		gridPanel.setLayout(layout);
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
		
		for(int i = 0; i < btn.length; i++) {
			btn[i] = new NewButton();
			btn[i].addActionListener(controller);
			btn[i].setActionCommand("b"+i);
			gridPanel.add(btn[i]);
		}
		
        this.addWindowListener(controller);
        
        this.setLayout(bLayout);
        
        
        this.add(gridPanel, bLayout.CENTER);
        this.add(statusPanel, bLayout.NORTH);
        this.add(imagePanel, bLayout.SOUTH);
        
        
		this.setVisible(true);
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);
		this.setTitle("Tic Tac Toe | Labb1 | Andreas Hortlund");
		
	}
	
	public void rePaint() {
		for(int i = 0; i < btn.length; i++) {
			btn[i].setPlayerTurn(0);
		}
		turnText.setText("<html>Player <span style=\"font-family:Sans;font-size:13px;color:red;\">O</span> turn</html>");
	}
	
	
	
	@Override
	public void update(Observable o, Object arg) {
		Model model = (Model)o;
		if(model.isItemTaken()) {
			JOptionPane.showMessageDialog(null, "Square already taken! Pick another", "InfoBox: " + "ba", JOptionPane.INFORMATION_MESSAGE);
		}else {
			btn[model.btnPressed()].setPlayerTurn(model.getPlayerTurn());
		}
		if(model.getPlayerTurn() == 1){
			turnText.setText("<html>Player <span style=\"font-family:Sans;font-size:13px;color:red;\">O</span> turn</html>");
		}else {
			turnText.setText("<html>Player <span style=\"font-family:Sans;font-size:13px;color:blue;\">X</span> turn</html>");
		}
		int win = model.checkWin();
		if(win == 1) {
			JOptionPane.showMessageDialog(null, "Player 1 won!", "InfoBox: " + "ba", JOptionPane.INFORMATION_MESSAGE);
			model.resetGame();
			rePaint();
		} else if(win == 2) {
			JOptionPane.showMessageDialog(null, "Player 2 won!", "InfoBox: " + "ba", JOptionPane.INFORMATION_MESSAGE);
			model.resetGame();
			rePaint();
		}
		if(model.fullBoard()) {
			JOptionPane.showMessageDialog(null, "Game Draw!", "InfoBox: " + "ba", JOptionPane.INFORMATION_MESSAGE);
			model.resetGame();
			rePaint();
		}
		
		
		player1.setText("<html>Player <span style=\"font-family:Sans;font-size:13px;color:red;\">O</span> Score: " + model.getPlayer1Score() + "</html>");
		player2.setText("<html>Player <span style=\"font-family:Sans;font-size:13px;color:blue;\">X</span> Score: " + model.getPlayer2Score() + "</html>");
	}

}
