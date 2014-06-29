package com.pile_drive.drivecommand.machine.output;

import java.util.HashMap;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.command.CommandFactory;
import com.pile_drive.drivecommand.machine.DeviceBase;
import com.pile_drive.drivecommand.machine.DeviceType;
import com.pile_drive.drivecommand.model.CommandType;
import com.pile_drive.drivecommand.model.ProtocolBase;

public class Servomotor extends DeviceBase {
	
	public Servomotor(int port, ProtocolBase protocol) {
		super(port, protocol);
	}
	
	/**
	 * Set the angle to this servomotor
	 * 
	 * @return valid
	 */
	public boolean setAngle(int angle) {
		HashMap<String, Object> args = new HashMap<String, Object>();
		args.put("speed", angle);
		CommandBase cmd = CommandFactory.createCommand(CommandType.SET_MOTOR_SPEED, args);
		HashMap<String, Object> res = exec(cmd);
		return (Boolean) res.get("valid");
	}
	
	/**
	 * Get the angle of the servomotor
	 * 
	 * @return valid
	 */
	public int getAngle() {
		CommandBase cmd = CommandFactory.createCommand(CommandType.GET_SERVO_ANGLE, null);
		HashMap<String, Object> res = exec(cmd);
		return (Integer) res.get("value");
	}

	@Override
	public DeviceType getDeviceType() {
		return DeviceType.SERVOMOTOR;
	}
	
}