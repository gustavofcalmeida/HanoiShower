package hanoishower.model;

import hanoishower.event.DiscEvent;
import hanoishower.event.DiscListener;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Hanoi extends Thread {

	// attributes
	private List<DiscListener> listeners;
	private Tower a, b, c;
	private long delay;
	private int discNumber;

	/**
	 * 
	 */
	public Hanoi() {
		this.listeners = new LinkedList<DiscListener>();
	}

	/**
	 * @param discNumber
	 * @param delay
	 */
	public void play(int discNumber, long delay) {
		if (delay < 0) {
			throw new IllegalArgumentException("Delay value must be positive.");
		}

		this.discNumber = discNumber;
		this.delay = delay;

		this.a = new Tower(1, discNumber);
		this.b = new Tower(2);
		this.c = new Tower(3);

		this.start();
	}

	/**
	 * @see java.lang.Thread#start()
	 */
	public void start() {
		this.hanoi(this.a, this.c, this.b, this.discNumber);
	}

	/**
	 * @param listener
	 */
	public void addDiscListener(DiscListener listener) {
		if (listener == null) {
			throw new NullPointerException("Argument can't be null.");
		}

		this.listeners.add(listener);
	}

	/**
	 * @param origin
	 * @param destination
	 * @param aux
	 * @param discNumber
	 */
	private void hanoi(Tower origin, Tower destination, Tower aux, int discNumber) {
		if (discNumber > 1) {
			this.hanoi(origin, aux, destination, (discNumber - 1));
		}
		
		stepWait();
		
		origin.moveDisc(destination);
		
		this.fireDiscEvent(destination.getTopDisc(),
						   destination.getSize(),
						   destination.getNumber());
		
		if (discNumber > 1) {
			this.hanoi(aux, destination, origin, (discNumber - 1));
		}
	}

	/**
	 * 
	 */
	private void stepWait() {
		try {
			Thread.sleep(this.delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param d
	 * @param newPosition
	 * @param newTower
	 */
	private void fireDiscEvent(Disc d, int newPosition, int newTower) {
		DiscEvent de = new DiscEvent(d, newPosition, newTower);
		
		for (Iterator<DiscListener> i = this.listeners.iterator(); i.hasNext();) {
			i.next().discPositionChanged(de);
		}
	}
}