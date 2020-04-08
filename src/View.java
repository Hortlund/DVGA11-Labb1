import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class View extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	//dwf
	private Controller controller;
	private NewButton b1, b2, b3, b4, b5, b6, b7, b8, b9;
	private JPanel gridPanel, statusPanel, imagePanel;
	private JLabel player1Score, player2Score, turnIcon, ticIcon, turnText;
	private GridLayout layout = new GridLayout(3,3);
	private BorderLayout bLayout = new BorderLayout();
	private FlowLayout fLayout = new FlowLayout(1, 30 ,10 );
	
	//https://stackoverflow.com/questions/16343098/resize-a-picture-to-fit-a-jlabel/32885963#32885963
	private ImageIcon O = new ImageIcon(new ImageIcon("src/O.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
	private ImageIcon X = new ImageIcon(new ImageIcon("src/X.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
	
	public View() {
		
		controller = new Controller(this);
		
		
		
		gridPanel = new JPanel();
		statusPanel = new JPanel();
		imagePanel = new JPanel();
		
		ticIcon = new JLabel(new ImageIcon("src/tic.jpg"));
		imagePanel.add(ticIcon);
		
		player1Score = new JLabel("Player 1" +  " Score: ");
		turnText = new JLabel("Det är: ");
		turnIcon = new JLabel();
		turnIcon.setIcon(O);
		player2Score = new JLabel("  Player 2" + " Score: 2");
		
		statusPanel.add(player1Score);
		statusPanel.add(turnText);
		statusPanel.add(turnIcon);
		statusPanel.add(player2Score);
		
		b1 = new NewButton();
		b1.addActionListener(controller);
		b1.setActionCommand("b1");
		
        b2 = new NewButton();
        b2.addActionListener(controller);
        b2.setActionCommand("b2");
        
        b3 = new NewButton();
        b3.addActionListener(controller);
        b3.setActionCommand("b3");
        
        b4 = new NewButton();
        b4.addActionListener(controller);
        b4.setActionCommand("b4");
        
        b5 = new NewButton();
        b5.addActionListener(controller);
        b5.setActionCommand("b5");
        
        b6 = new NewButton();
        b6.addActionListener(controller);
        b6.setActionCommand("b6");
        
        b7 = new NewButton();
        b7.addActionListener(controller);
        b7.setActionCommand("b7");
        
        b8 = new NewButton();
        b8.addActionListener(controller);
        b8.setActionCommand("b8");
        
        b9 = new NewButton();
        b9.addActionListener(controller);
        b9.setActionCommand("b9");
        
        
        gridPanel.setLayout(layout);
        statusPanel.setLayout(fLayout);
        
        gridPanel.add(b1);
        gridPanel.add(b2);
        gridPanel.add(b3);
        gridPanel.add(b4);
        gridPanel.add(b5);
        gridPanel.add(b6);
        gridPanel.add(b7);
        gridPanel.add(b8);
        gridPanel.add(b9);
        
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
	
	public void drawO() {
		
	}
	
	public void drawX() {
		
	}
	
	public void turn(int turn) {
		if(turn == 1) {
			turnIcon.setIcon(X);
		}else if(turn == 2) {
			
			turnIcon.setIcon(O);
		}
	}
	
	public boolean setIcon(JButton ev, int turn) {
		if(ev.getIcon() == null) {
			if(turn == 1) {
				ev.setIcon(new ImageIcon("src/O.png"));
			}else if(turn == 2) {
				ev.setIcon(new ImageIcon("src/X.png"));
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Knappen är tagen");
			return false;
		}
		return true;
	}
	
	public void btnAlreadySet() {
		JOptionPane.showMessageDialog(null, "Spel oavgjort");
	}
	
	public static void main(String args[]){
        new View();
    }

}
