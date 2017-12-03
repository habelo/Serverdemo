package klient;

import sessionobject.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class Klient {
	
	String ip = "127.0.0.1";
	int port = 5555;
	Socket connection;
	ObjectOutputStream out;
	ObjectInputStream in;
	SessionObject obj;
	Scanner sc = new Scanner(System.in);
	String write;
	
	public Klient() {
		
		setupConnection();
		setupGame();
		try {
			out = new ObjectOutputStream(connection.getOutputStream());out.flush();;
			in = new ObjectInputStream(connection.getInputStream());
		} catch (IOException e) {e.printStackTrace();}
	}
	
	private void setupGame() {
		
			try {
				while((obj = (SessionObject) in.readObject())!= null) {
				
				System.out.println(obj.getText());
				write= sc.nextLine();
				obj.setText(write);
				out.writeObject(obj);out.flush();
			} 
		}
			catch (ClassNotFoundException | IOException e) {e.printStackTrace();}
	}

	private void setupConnection() {
		try {
			connection= new Socket(ip, port);
		} catch (IOException e) {e.printStackTrace();}
	}

	public static void main(String[] args) {
		new Klient();
	}
}
