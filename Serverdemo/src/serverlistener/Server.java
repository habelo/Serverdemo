package serverlistener;

import sessionobject.*;

class Server {
	
	Player p1;
	Player p2;
	SessionObject obj;
	Playerstate state;
	
	Server(Player p1, Player p2) {
		this.p1=p1;
		this.p2=p2;
		setupConnections();
		
	}

	private void setupConnections() {
		state=Playerstate.PLAYERONETURN;
		while((obj=p1.getIn()) != null) {
			if(state==Playerstate.PLAYERONETURN) {
				obj.setText(p1.getIn().getText());
				p2.writetOut(obj);
				state=Playerstate.PLAYERTWOTURN;
			}
			else if(state==Playerstate.PLAYERTWOTURN) {
				obj.setText(p2.getIn().getText());
				p1.writetOut(obj);
				state=Playerstate.PLAYERONETURN;
			}
			
		}
	}

}
