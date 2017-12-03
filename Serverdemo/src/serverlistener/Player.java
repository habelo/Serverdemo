package serverlistener;

import java.io.*;
import java.net.*;

import sessionobject.SessionObject;

class Player{
	
	private Socket connection;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private SessionObject obj = new SessionObject();

	Player(Socket sock) {
		connection=sock;
		try {
		out = new ObjectOutputStream(connection.getOutputStream());out.flush();
		in = new ObjectInputStream(connection.getInputStream());
		} catch (IOException e) {e.printStackTrace();}
		
		
	}
	
	
	
	protected void writetOut(SessionObject obj) {
		try {
			out.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected SessionObject getIn() {
		try {
			return (SessionObject) in.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

//	public Playerstate getState() {
//		return state;
//	}
//
//	public void setState(Playerstate state) {
//		this.state = state;
//	}
//	

}
