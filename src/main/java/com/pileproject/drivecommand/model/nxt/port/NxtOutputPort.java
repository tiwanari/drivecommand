package com.pileproject.drivecommand.model.nxt.port;

import com.pileproject.drivecommand.machine.device.port.OutputPort;

/**
 * Created by tatsuya on 15/09/03.
 */
public class NxtOutputPort extends OutputPort {
	private final int mPort;

	public static final NxtOutputPort PORT_A = new NxtOutputPort(0);
	public static final NxtOutputPort PORT_B = new NxtOutputPort(1);
	public static final NxtOutputPort PORT_C = new NxtOutputPort(2);

	private NxtOutputPort(int port) {
		mPort = port;
	}

	@Override
	public int getRaw() {
		return mPort;
	}

	@Override
	public String toString() {
		final int A = 65;

		return "[NXT] OUTPUT-PORT-" +  (char)(A + mPort);
	}
}
