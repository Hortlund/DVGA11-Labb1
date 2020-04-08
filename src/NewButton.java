import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
		public void draw(Graphics g) {

			try {
				final BufferedImage image = ImageIO.read(new File("src/O.png"));
				g.drawImage(image, 20, 20, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			 
			 getPrefferedSize();
		}
		
		
	}