package ch17_SimpleChatApp_Multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class SimpleChatClientB {

	private PrintWriter writer;

	void setUpNetworking() {
		try {
			InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 5000);
			SocketChannel sc = SocketChannel.open(serverAddress);
			writer = new PrintWriter(Channels.newWriter(sc, StandardCharsets.UTF_8));
			System.out.println("networking established!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void sendMessage() {
		// this byte stream is always open and ready to supply input data from the keyboard
		InputStream inputStreamClient = System.in;
		InputStreamReader isr = new InputStreamReader(inputStreamClient); // character stream
		BufferedReader keyboardReader = new BufferedReader(isr); // read character stream
		while (true) {
			try {
				String keyboardInput = keyboardReader.readLine();
				if (keyboardInput.equalsIgnoreCase("quit")) {
					break;
				}
				writer.println(keyboardInput);
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	void go() {
		setUpNetworking();
		sendMessage();
	}

	public static void main(String[] args) {
		new SimpleChatClientB().go();
	}

}
