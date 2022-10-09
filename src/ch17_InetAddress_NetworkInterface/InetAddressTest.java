package ch17_InetAddress_NetworkInterface;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) {

		try {
			// there're no constructors, to create an instance of InetAddress, use one of its factory methods
			InetAddress addr = InetAddress.getLocalHost();
			System.out.println("local host IP address: " + addr.getHostAddress());
			System.out.println("local host name: " + addr.getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		try {
			InetAddress addr = InetAddress.getByName("docs.oracle.com");
			System.out.println("‘docs.oracle.com’ IP address: " + addr.getHostAddress());
			String hostAddr = addr.getHostAddress();
			// pass a literal IP address to the getByName method
			addr = InetAddress.getByName(hostAddr);
			System.out.println("hostname (servername) of IP address ‘" + addr.getHostAddress() + "’ is: "
									+ addr.getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		try {
			// returns an array of InetAddress objects
			InetAddress[] addresses = InetAddress.getAllByName("www.youtube.com");
			System.out.println("all addresses of ‘youtube.com’ are:");
			for (InetAddress i : addresses) {
				System.out.println(i);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}