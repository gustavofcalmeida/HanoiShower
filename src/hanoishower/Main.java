/**
 * 
 */
package hanoishower;

import javax.swing.JOptionPane;

import hanoishower.model.Hanoi;
import hanoishower.view.GraphicHanoiShower;
import hanoishower.view.TextHanoiShower;

/**
 * @author Gustavo
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ask for ui type
		int uiType = JOptionPane.showOptionDialog( null, "Choose user interface:", "Hanoi Shower", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Graphical", "Text", "Both"}, "Graphical");
		
		// ask for number of disks
		Integer discs = null;
		if ( uiType != JOptionPane.CLOSED_OPTION ) {
			discs = (Integer)JOptionPane.showInputDialog( null, "Choose number of discs:", "Hanoi Shower", JOptionPane.QUESTION_MESSAGE, null, new Integer[]{1, 2, 3, 4, 5, 6}, new Integer(6));
		}
		
		// if valid user input
		if ( uiType != JOptionPane.CLOSED_OPTION && discs != null ) {
			Hanoi h = new Hanoi();
			
			switch ( uiType ) {
				// graphical
				case 0:
					h.addDiscListener( new GraphicHanoiShower( discs ) );
					break;
				// text
				case 1:
					h.addDiscListener( new TextHanoiShower() );
					break;
				// both	
				case 2:
					h.addDiscListener( new GraphicHanoiShower( discs ) );
					h.addDiscListener( new TextHanoiShower() );
					break;
				// should never get here
				default:
					return;
			}
			
			h.play( discs, 1000 );	
		}
	}
}