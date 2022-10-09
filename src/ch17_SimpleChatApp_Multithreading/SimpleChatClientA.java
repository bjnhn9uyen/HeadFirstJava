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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleChatClientA {

	private BufferedReader reader;
	private PrintWriter writer;

	void setUpNetworking() {
		try {
			InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 5000);
			SocketChannel sc = SocketChannel.open(serverAddress);
			reader = new BufferedReader(Channels.newReader(sc, StandardCharsets.UTF_8));
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

	class IncomingReader implements Runnable {
		@Override
		public void run() {
			try {
				String message;
				while ((message = reader.readLine()) != null) {
					System.out.println("server's message: " + message);
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	void go() {
		setUpNetworking();

		// using the Thread class to run separate jobs is no longer
		// the preferred way to create multithreaded applications in Java
		// instead, use an Executor or an ExecutorService
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(new IncomingReader());

		sendMessage();
	}

	public static void main(String[] args) {
		new SimpleChatClientA().go();
	}

}
