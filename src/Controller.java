import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Controller extends WindowAdapter implements ActionListener {
	
	private View gui;
	private Model model;
	private int turn, turns;
	
	public Controller(View guiIn){
        gui = guiIn;
        model = new Model();
    }
	
	//https://codereview.stackexchange.com/questions/71756/tic-tac-toe-in-mvc

	@Override
	public void actionPerformed(ActionEvent e) {
		
		turn = model.playerTurn();
		turns = model.getTurns();
		
		if(turn == 1) {
			gui.turn(1);
		}else if(turn == 2) {
			gui.turn(2);
		}
		
		if(turns == 9) {
			gui.btnAlreadySet();
			gui.dispose();
			gui = new View();
		}
		
		JButton ev =(JButton)e.getSource();
		String switchButton = e.getActionCommand();
		switch(switchButton) {
		
			case "b1": 
				gui.setIcon(ev, turn);
				break;
				
			case "b2":
				gui.setIcon(ev, turn);
				break;
				
			case "b3":
				gui.setIcon(ev, turn);
				break;
				
			case "b4": 
				gui.setIcon(ev, turn);
				break;
				
			case "b5": 
				gui.setIcon(ev, turn);
				break;
				
			case "b6": 
				gui.setIcon(ev, turn);
				break;
				
			case "b7": 
				gui.setIcon(ev, turn);
				break;
				
			case "b8": 
				gui.setIcon(ev, turn);
				break;
				
			case "b9": 
				gui.setIcon(ev, turn);
				break;
					
		}
		
	}
	
	public void windowClosing(WindowEvent e){
        System.exit(1);
    }

}
