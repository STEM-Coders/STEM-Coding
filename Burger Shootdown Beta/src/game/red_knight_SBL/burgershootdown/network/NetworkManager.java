package game.red_knight_SBL.burgershootdown.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;

public class NetworkManager implements Runnable {

	private String host;
	private int port;

	Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private boolean running = false;

	public NetworkManager(String host, int port) {
		this.host = host;
		this.port = port;
	}

	private void connect() {
		try {
			socket = new Socket(host, port);
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
			new Thread(this).start();
		} catch (ConnectException e) {
			System.out.println(
					"Unable to connect to server. Please sheck internet connection or the server may be offline.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void close() {
		try {
			running = false;
			// Tell server we disconnected
			in.close();
			out.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendObject(Object packet) {
		try {
			out.writeObject(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			running = true;

			while (running) {
				try {
					Object data = in.readObject();
					// Handle data
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SocketException e) {
					close();
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
