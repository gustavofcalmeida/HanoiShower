package hanoishower.view;

import hanoishower.event.DiscEvent;
import hanoishower.event.DiscListener;

public class TextHanoiShower implements DiscListener {
	
	// attributes
	private long steps;
	
	/**
	 * 
	 */
	public TextHanoiShower() {
		this.steps = 0;
	}

	/**
	 * @see DiscListener#discPositionChanged(DiscEvent)
	 */
	public void discPositionChanged(DiscEvent de) {
		System.out.println(++this.steps + ". Disc " + de.getDiscNumber() + " -> Tower " + de.getNewTower());
	}
}