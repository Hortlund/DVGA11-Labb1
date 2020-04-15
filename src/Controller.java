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
				model.test(0,0,0);
				break;
				
			case "b1":
				model.test(1,1,0);
				break;
				
			case "b2":
				model.test(2,2,0);
				break;
				
			case "b3": 
				model.test(3,0,1);
				break;
				
			case "b4": 
				model.test(4,1,1);
				break;
				
			case "b5": 
				model.test(5,2,1);
				break;
				
			case "b6": 
				model.test(6,0,2);
				break;
				
			case "b7": 
				model.test(7,1,2);
				break;
				
			case "b8": 
				model.test(8,2,2);
				break;
					
		}
		
	}
	
	public void windowClosing(WindowEvent e){
        System.exit(1);
    }

}
