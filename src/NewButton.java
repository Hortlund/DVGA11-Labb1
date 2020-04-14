import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;

public class NewButton extends JButton{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		
		public void getPrefferedSize() {
			super.getPreferredSize();
			//System.out.println(super.getPreferredSize());
		}
		
		
		
		

		public void paintComponent(Graphics arg0) {
			super.paintComponent(arg0);
			Graphics2D g = (Graphics2D)arg0;
			String text = "X";
			Font font = new Font("Sans", getWidth(), getHeight());
			g.setFont(font);
			FontMetrics fm = g.getFontMetrics();
			Rectangle2D bounds = fm.getStringBounds(text, g);
			
			g.drawString(text, (this.getWidth() - (int)bounds.getWidth()) / 2,  this.getHeight() - (this.getHeight() - fm.getAscent()) / 2 - (fm.getAscent() / 8));
			 
		}
		
	}