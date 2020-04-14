import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;

public class NewButton extends JButton{
		/**
		 * 
		 */
		private int playerTurn;
		private static final long serialVersionUID = 1L;
		public NewButton() {
		}
		
		public void getPrefferedSize() {
			super.getPreferredSize();
			//System.out.println(super.getPreferredSize());
		}
		
		
		public void setPlayerTurn(int p) {
			this.playerTurn = p;
		}
		
		public void paintComponent(Graphics arg0) {
			super.paintComponent(arg0);
			if(playerTurn == 2) {
				Graphics g = (Graphics2D)arg0;
				Font font = new Font("Sans", getWidth(), getHeight());
				g.setFont(font);
				g.setColor(Color.red);
				String text = "O";
				FontMetrics fm = g.getFontMetrics();
				Rectangle2D bounds = fm.getStringBounds(text, g);
				//g.drawString("b", getWidth() / 2, getHeight() /2);
				g.drawString(text, (this.getWidth() - (int)bounds.getWidth()) / 2,  this.getHeight() - (this.getHeight() - fm.getAscent()) / 2 - (fm.getAscent() / 8));
			}else if(playerTurn == 1){
				Graphics g = (Graphics2D)arg0;
				Font font = new Font("Sans", getWidth(), getHeight());
				g.setFont(font);
				g.setColor(Color.blue);
				String text = "X";
				FontMetrics fm = g.getFontMetrics();
				Rectangle2D bounds = fm.getStringBounds(text, g);
				//g.drawString("b", getWidth() / 2, getHeight() /2);
				g.drawString(text, (this.getWidth() - (int)bounds.getWidth()) / 2,  this.getHeight() - (this.getHeight() - fm.getAscent()) / 2 - (fm.getAscent() / 8));
			}
		}
			
			 
}
		
