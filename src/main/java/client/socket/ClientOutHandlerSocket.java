package client.socket;

import java.io.IOException;
import java.io.ObjectOutputStream;

import client.ClientOutHandler;

public class ClientOutHandlerSocket extends ClientOutHandler {
	
	private ObjectOutputStream socketOut; 
	
	public ClientOutHandlerSocket(ObjectOutputStream socketOut) {
		if(socketOut==null) {
			throw new IllegalArgumentException("socketOut cannot be null"); 
		}
		this.socketOut = socketOut; 
	}

	@Override
	public void sendMsg(ClientMessage msg) {
		try {
			this.socketOut.writeObject(msg);
			this.socketOut.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}