package com.pileproject.drivecommand.machine.device.port;

/**
 * Created by tatsuya on 15/09/04.
 */
public abstract class InputPort implements DevicePort {
	@Override
	public abstract int getRaw();
}