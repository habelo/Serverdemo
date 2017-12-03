package serverlistener;

import java.net.*;
import java.io.*;
import java.util.*;

public class ServerListener {
	
	int port = 5555;
	Socket player1;
	Socket player2;
	ServerSocket connectionlistener;
	Server server;
	
	ServerListener() {

		
		try {
			while(true) {
			connectionlistener = new ServerSocket(port);
			player1 = connectionlistener.accept();
			Player p1 = new Player(player1);
			player2 = connectionlistener.accept();
			Player p2 = new Player(player2);
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					Server server = new Server(p1, p2);
					
				}
			}).start();
			}
			
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public static void main(String[] args) {
		new ServerListener();
	}

}
