package hanoishower.model;

import hanoishower.util.Stack;

public class Tower {
	
	// attributes
	private Stack<Disc> t;
	private int number;
	
	/**
	 * @param number
	 */
	public Tower(int number) {
		this.t = new Stack<Disc>();
		this.number = number;
	}

	/**
	 * @param discNumber
	 * @param number
	 */
	public Tower(int number, int discNumber) {
		if (discNumber < 1) {
			throw new IllegalArgumentException("The number of discs must be greater than zero.");
		}

		this.t = new Stack<Disc>();
		this.number = number;
		
		for (; discNumber > 0; discNumber--) {
			this.pushDisc(new Disc(discNumber));
		}
	}

	/**
	 * @param d
	 */
	private void pushDisc(Disc d) {
		this.t.push(d);
	}

	/**
	 * @return
	 */
	private Disc popDisc() {
		return (Disc)this.t.pop();
	}
	
	/**
	 * @return
	 */
	public Disc getTopDisc() {
		return (Disc)this.t.getTop();
	}

	/**
	 * @param destination
	 */
	public void moveDisc(Tower destination) {
		if ((destination.getSize() != 0) &&
			(this.getTopDisc().getNumber() >= destination.getTopDisc().getNumber())) {
			throw new IllegalArgumentException("The origin top disc must be smaller than destination top disc.");
		}

		destination.pushDisc(this.popDisc());
	}

	/**
	 * @return
	 */
	public int getNumber() {
		return this.number;
	}

	/**
	 * @return
	 */
	public int getSize() {
		return this.t.getSize();
	}
}