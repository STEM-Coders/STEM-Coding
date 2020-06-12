package game.red_knight_SBL.burgershootdown.network;

public class NetworkEventListener {
	
	public void received (Object p) {
		if (p instanceof AddPlayerPacket) {
			AddPlayerPacket packet = (AddPlayerPacket)p;
		} 
		
	}

}
