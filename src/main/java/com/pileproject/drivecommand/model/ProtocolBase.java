package com.pileproject.drivecommand.model;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.machine.MachineBase;
import com.pileproject.drivecommand.model.com.ICommunicator;

import java.io.IOException;
import java.util.HashMap;

public abstract class ProtocolBase {
	protected final ICommunicator mCommunicator;
	
	public ProtocolBase(ICommunicator comm) {
		mCommunicator = comm;
	}
	
	/**
	 * Open the connection between devices.
	 *
	 * @throws IOException
	 */
	public abstract void open() throws IOException;
	
	/**
	 * Close the connection between devices.
	 */
	public abstract void close();
	
	/**
	 * Execute the command.
	 *
	 * @param port
	 * @param cmd
	 * @return
	 */
	public abstract HashMap<String, Object> exec(int port, CommandBase cmd);

	/**
	 * Apply commands
	 * <p>
	 * This will be used with devices supporting transactions.
	 *
	 * @return success (true) or not (false)
	 */
	public abstract boolean apply();

	/**
	 * Creates an appropriate machine instance.
	 *
	 * @return an instance of MachineBase subclasses
	 */
	public abstract MachineBase createMachine();
}