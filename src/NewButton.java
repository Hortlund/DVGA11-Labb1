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
		}
		
		
		public void setPlayerTurn(int p) {
			this.playerTurn = p;
		}
		
		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D)g;
			super.paintComponent(g);
			this.setForeground(Color.BLACK);
			if(playerTurn == 2) {
				Font font = new Font("Sans", getWidth(), getHeight());
				g2.setFont(font);
				g2.setColor(Color.red);
				g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
				String text = "O";
				FontMetrics fm = g2.getFontMetrics();
				Rectangle2D bounds = fm.getStringBounds(text, g2);
				g2.drawString(text, (getWidth() - (int)bounds.getWidth()) / 2,  getHeight() - (getHeight() - fm.getAscent()) / 2 - (int)bounds.getWidth() /6);
			}else if(playerTurn == 1){
				Font font = new Font("Sans", getWidth(), getHeight());
				g2.setFont(font);
				g2.setColor(Color.blue);
				g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
				String text = "X";
				FontMetrics fm = g2.getFontMetrics();
				Rectangle2D bounds = fm.getStringBounds(text, g2);
				g2.drawString(text, (getWidth() - (int)bounds.getWidth()) / 2,  getHeight() - (getHeight() - fm.getAscent()) / 2 - (int)bounds.getWidth() /6);
			}else if(playerTurn == 0) {
				super.paintComponent(g);
			}
		}
			
			 
}
		
