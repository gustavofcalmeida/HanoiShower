package hanoishower.event;

import java.util.EventListener;

public interface DiscListener extends EventListener {

	/**
	 * @param de
	 */
	public void discPositionChanged(DiscEvent de);
}