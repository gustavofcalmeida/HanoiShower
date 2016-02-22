package hanoishower.view;

import java.awt.Color;

public class DiscImage {

	// attributes
	private int number;
	private int position;
	private int tower;
	public final Color color;

	/**
	 * @param number
	 * @param position
	 * @param tower
	 * @param color
	 */
	public DiscImage(int number, int position, int tower, Color color) {
		if (number < 1 || number > 6) {
			throw new IllegalArgumentException("Disc number must be from 1 to 6.");
		}

		if (position < 1 || position > 6) {
			throw new IllegalArgumentException("Disc position must be from 1 to 6.");
		}

		if (tower < 1 || tower > 3) {
			throw new IllegalArgumentException("Tower number must be from 1 to 3.");
		}
		
		this.number = number;
		this.position = position;
		this.tower = tower;
		this.color = color;
	}

	/**
	 * @return
	 */
	public int getWidth() {
		return 65 + ((this.number - 1) * 26);
	}
	
	/**
	 * @return
	 */
	public int getX() {
		return 28 + ((6 - this.number) * 13) + (223 * (this.tower - 1));
	}

	/**
	 * @return
	 */
	public int getY() {
		return 102 + (6 - this.position) * 25;
	}

	/**
	 * @param position
	 */
	public void setPosition(int position) {
		if (position < 1 || position > 6) {
			throw new IllegalArgumentException("Disc position must be from 1 to 6.");
		}

		this.position = position;
	}

	/**
	 * @param tower
	 */
	public void setTower(int tower) {
		if (tower < 1 || tower > 3) {
			throw new IllegalArgumentException("Tower number must be from 1 to 3.");
		}
		
		this.tower = tower;
	}
	
	public int getNumber() {
		return number;
	}
}