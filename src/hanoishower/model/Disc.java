package hanoishower.model;

public class Disc {
	
	// attributes
	private int number;
		
	/**
	 * @param number
	 */
	public Disc(int number) {
		if (number < 1) {
			throw new IllegalArgumentException("Disc number must be greater than zero.");
		}

		this.number = number;
	}

	/**
	 * @return
	 */
	public int getNumber() {
		return this.number;
	}
}