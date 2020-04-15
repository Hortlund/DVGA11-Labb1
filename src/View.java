import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.*;

public class View extends JFrame implements Observer {
	
	private static final long serialVersionUID = 1L;
	private JPanel gridPanel, statusPanel, imagePanel;
	private JLabel player1Score, player2Score,ticIcon, turnText;
	private GridLayout layout = new GridLayout(3,3);
	private NewButton[] btn = new NewButton[9];
	private BorderLayout bLayout = new BorderLayout();
	
	//https://stackoverflow.com/questions/16343098/resize-a-picture-to-fit-a-jlabel/32885963#32885963
	private ImageIcon tic = new ImageIcon(new ImageIcon("src/tttlogo.png").getImage().getScaledInstance(100, 64, Image.SCALE_DEFAULT));
	
	public View(Controller controller) {
		
		gridPanel = new JPanel();
		statusPanel = new JPanel();
		imagePanel = new JPanel();
		
		ticIcon = new JLabel(tic);
		imagePanel.add(ticIcon);
		
		player1Score = new JLabel("<html>Player <span style=\"font-family:Sans;font-size:13px;color:red;\">O</span> Score:</html>");
		turnText = new JLabel("<html>Player <span style=\"font-family:Sans;font-size:13px;color:red;\">O</span> turn</html>");
		player2Score = new JLabel("<html>Player <span style=\"font-family:Sans;font-size:13px;color:blue;\">X</span> Score:</html>");
		

		statusPanel.add(Box.createRigidArea(new Dimension(10,0)));
		statusPanel.add(player1Score);
		statusPanel.add(Box.createHorizontalGlue());
		statusPanel.add(turnText);
		statusPanel.add(Box.createHorizontalGlue());
		statusPanel.add(player2Score);
		
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
	
	@Override
	public void update(Observable o, Object arg) {
		Model model = (Model)o;
		btn[model.btnPressed()].setPlayerTurn(model.getPlayerTurn());
		if(model.getPlayerTurn() == 1){
			turnText.setText("<html>Player <span style=\"font-family:Sans;font-size:13px;color:red;\">O</span> turn</html>");
		}else {
			turnText.setText("<html>Player <span style=\"font-family:Sans;font-size:13px;color:blue;\">X</span> turn</html>");
		}
		
		if(model.fullBoard()) {
			JOptionPane.showMessageDialog(null, "ba", "InfoBox: " + "ba", JOptionPane.INFORMATION_MESSAGE);
		}
		if(model.isItemTaken()) {
			JOptionPane.showMessageDialog(null, "ba", "InfoBox: " + "ba", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
