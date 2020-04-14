import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Controller extends WindowAdapter implements ActionListener {
	private Model model;
	
	public Controller(Model model){
        this.model = model;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String switchButton = e.getActionCommand();
		switch(switchButton) {
		
			case "b0": 
				model.test();
				break;
				
			case "b1":
				break;
				
			case "b2":
				break;
				
			case "b3": 
				break;
				
			case "b4": 
				break;
				
			case "b5": 
				break;
				
			case "b6": 
				break;
				
			case "b7": 
				break;
				
			case "b8": 
				break;
					
		}
		
	}
	
	public void windowClosing(WindowEvent e){
		System.out.println("QUIT");
        System.exit(1);
    }

}
