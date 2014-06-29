package test.drivecommand.machine.input;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.*;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

import com.pile_drive.drivecommand.command.CommandBase;
import com.pile_drive.drivecommand.machine.DeviceType;
import com.pile_drive.drivecommand.machine.input.RemoteControlReciever;
import com.pile_drive.drivecommand.model.ProtocolBase;

@SuppressWarnings("serial")
public class RemoteControlRecieverTest {
	@Mocked private ProtocolBase protocol;
	private final int PORT = 0;
	private final int VALUE_BUTTON = 3;
	private final int VALUE_DISTANCE = 3;
	private final String KEY_VALUE = "value";
	
	@Test
	public void getRemoteControllerButton() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any);
			result = new HashMap<String, Object>() {{put(KEY_VALUE, VALUE_BUTTON);}};
		}};
		RemoteControlReciever rr = new RemoteControlReciever(PORT, protocol);
		assertEquals(rr.getRemoteButton(), VALUE_BUTTON);
	}
	
	@Test
	public void getRemoteControllerDistance() {
		new Expectations() {{
			protocol.exec(PORT, (CommandBase)any);
			result = new HashMap<String, Object>() {{put(KEY_VALUE, VALUE_DISTANCE);}};
		}};
		RemoteControlReciever rr = new RemoteControlReciever(PORT, protocol);
		AssertJUnit.assertEquals(rr.getRate(), VALUE_DISTANCE);
	}
	
	@Test
	public void deviceTypeIsRemoteControlReciever() {
		RemoteControlReciever rr = new RemoteControlReciever(PORT, protocol);
		assertEquals(rr.getDeviceType(), DeviceType.REMOTECONTROL_RECIEVER);
	}
}
