package hanoishower.view;

import hanoishower.event.DiscEvent;
import hanoishower.event.DiscListener;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GraphicHanoiShower extends JFrame implements DiscListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8530620849912434339L;
	
	// attributes
	private DiscImage[] discImage;
	private int steps;
	
	/**
	 * @param discNumber
	 */
	public GraphicHanoiShower(int discNumber) {
		super("Hanoi Shower");
		
		if (discNumber < 1 || discNumber > 6) {
			throw new IllegalArgumentException("The number of discs must be from 1 to 6.");
		}
		
		this.steps = 0;
		this.initializeDiscImages(discNumber);

		DrawingPanel centerPanel = new DrawingPanel();
		getContentPane().add(centerPanel);

		ImageIcon i = new ImageIcon( this.getClass().getResource("/hanoishower/view/icon.png") );
		setIconImage(i.getImage());
		setResizable(false);
		pack();
		setSize(697 + getInsets().left + getInsets().right, 290 + getInsets().top + getInsets().bottom);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * @param discNumber
	 */
	private void initializeDiscImages(int discNumber) {
		this.discImage = new DiscImage[discNumber];
		
		Color[] colorArray = {Color.GRAY,
						  	  Color.BLUE,
						  	  Color.GREEN,
						  	  Color.MAGENTA,
						  	  Color.RED,
						  	  Color.YELLOW};

		List<Color> colorList = Arrays.asList(colorArray);
		Collections.shuffle(colorList);
		colorList.toArray(colorArray);
		
		for (int aux = discNumber + 1; discNumber > 0; discNumber--) {
			this.discImage[discNumber - 1] = new DiscImage(discNumber,
														   (aux - discNumber),
														   1,
														   colorArray[discNumber - 1]);
		}
	}

	/**
	 * @see DiscListener#discPositionChanged(DiscEvent)
	 */
	public void discPositionChanged(DiscEvent de) {
		this.discImage[de.getDiscNumber() - 1].setPosition(de.getNewPosition());
		this.discImage[de.getDiscNumber() - 1].setTower(de.getNewTower());
		repaint();
		this.steps++;
		this.setTitle("Hanoi Shower - Steps: " + this.steps);
	}

	private class DrawingPanel extends JPanel {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -7905684675737269958L;
		
		// attributes
		private ImageIcon boardImage;
		
		/**
		 * 
		 */
		public DrawingPanel() {
			super();
			this.boardImage = new ImageIcon( this.getClass().getResource("/hanoishower/view/board.png") );
		}

		/**
		 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
		 */
		public void paintComponent (Graphics g) {
			super.paintComponent(g);
			
			this.boardImage.paintIcon(this, g, 0, 0);
			
			for (int i = 0; i < GraphicHanoiShower.this.discImage.length; i++) {
				
				DiscImage di = GraphicHanoiShower.this.discImage[i];
				
				g.setColor(di.color);
				g.fillRoundRect(di.getX(), di.getY(), di.getWidth(), 25, 10, 10);
				
				g.setColor( Color.BLACK );
				g.drawString( "" + di.getNumber(), di.getX() + (di.getWidth() / 2), di.getY() + 25 - 1 );
			}
		}
	}
}