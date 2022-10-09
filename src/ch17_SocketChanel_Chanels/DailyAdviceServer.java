package ch17_SocketChanel_Chanels;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Random;

public class DailyAdviceServer {

	static String[] adviceList = { "Take smaller bites.",
									"Go for the tight jeans. No they do NOT make you look fat.",
									"One word: inappropriate",
									"Just for today, be honest. Tell your boss what you *really* think.",
									"You might want to rethink that haircut." };
	static Random random = new Random();

	public static void main(String[] args) {
		try {
			// make a ServerSocketChannel to “listen” for client requests on the port it’s bound to
			ServerSocketChannel serverChannel = ServerSocketChannel.open();
			serverChannel.bind(new InetSocketAddress(5000));

			// the server goes into a permanent loop, waiting for (and servicing) client requests
			while (serverChannel.isOpen()) {
				System.out.println("waiting for requests from clients...");
				// the accept method blocks (just sits there) until a request comes in
				SocketChannel clientChannel = serverChannel.accept();
				System.out.println("got a connection!");

				PrintWriter writer = new PrintWriter(Channels.newOutputStream(clientChannel));
				writer.println(getAdvice()); // send the client a String advice message
				writer.close(); // close the stream and release any system resources associated with it
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static private String getAdvice() {
		int nextAdvice = random.nextInt(adviceList.length);
		return adviceList[nextAdvice];
	}

}
