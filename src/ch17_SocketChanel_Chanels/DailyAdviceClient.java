package ch17_SocketChanel_Chanels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class DailyAdviceClient {

	public static void main(String[] args) {

		try {
			// InetSocketAddress represents the full address of the machine we want to connect to
			// “127.0.0.1” is the IP address of the server (localhost), 5000 is TCP port number
			InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 5000);
			// create a new SocketChannel and connect it to the address you give it
			SocketChannel socketChannel = SocketChannel.open(serverAddress);
			System.out.println("connected to the server!");

			Reader channelReader = Channels.newReader(socketChannel, StandardCharsets.UTF_8);
			BufferedReader reader = new BufferedReader(channelReader);
			String advice = reader.readLine();
			System.out.println("Today you should: " + advice);
			reader.close(); // close the stream and release any system resources associated with it
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
