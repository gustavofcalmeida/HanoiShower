package hanoishower.util;

import java.util.LinkedList;

public class Stack<T> {
	
	// attributes
	private LinkedList<T> s;

	/**
	 * 
	 */
	public Stack() {
		this.s = new LinkedList<T>();
	}

	/**
	 * @param o
	 */
	public void push(T o) {
		this.s.addLast(o);
	}

	/**
	 * @return
	 */
	public T pop() {
		return this.s.removeLast();
	}

	/**
	 * @return
	 */
	public T getTop() {
		return this.s.getLast();
	}

	/**
	 * @return
	 */
	public int getSize() {
		return this.s.size();
	}
}