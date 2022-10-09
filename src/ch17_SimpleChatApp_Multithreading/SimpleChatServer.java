package ch17_SimpleChatApp_Multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleChatServer {

	private List<PrintWriter> clientWriters = new ArrayList<>();

	void tellEveryone(String message) {
		for (PrintWriter writer : clientWriters) {
			writer.println(message);
			writer.flush();
		}
	}

	class ClientHandler implements Runnable {

		private BufferedReader reader;

		public ClientHandler(SocketChannel sc) {
			reader = new BufferedReader(Channels.newReader(sc, StandardCharsets.UTF_8));
		}

		@Override
		public void run() {
			String message;
			try {
				while ((message = reader.readLine()) != null) {
					System.out.println("client's message: " + message);
					tellEveryone(message);
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	public void go() {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		try {
			ServerSocketChannel serverChannel = ServerSocketChannel.open();
			serverChannel.bind(new InetSocketAddress(5000));

			while (serverChannel.isOpen()) {
				System.out.println("waiting for requests from clients...");
				SocketChannel clientChannel = serverChannel.accept();
				PrintWriter writer = new PrintWriter(
										Channels.newWriter(clientChannel, StandardCharsets.UTF_8));
				clientWriters.add(writer);
				threadPool.submit(new ClientHandler(clientChannel));
				System.out.println("got a connection!");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String args[]) {
		new SimpleChatServer().go();
	}
}
