package hanoishower.event;

import hanoishower.model.Disc;
import java.util.EventObject;

public class DiscEvent extends EventObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4937606825567727056L;

	// attributes
	private int newPosition;
	private int newTower;
	private Disc d;
	
	/**
	 * @param disc
	 * @param newPosition
	 * @param newTower
	 */
	public DiscEvent(Disc disc, int newPosition, int newTower) {
		super(disc);

		this.d = disc;
		this.newPosition = newPosition;
		this.newTower = newTower;
	}

	/**
	 * @return
	 */
	public int getNewTower() {
		return this.newTower;
	}

	/**
	 * @return
	 */
	public int getNewPosition() {
		return this.newPosition;
	}

	/**
	 * @return
	 */
	public int getDiscNumber() {
		return this.d.getNumber();
	}
}