package ch17_InetAddress_NetworkInterface;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class NetworkInterfaceTest {

	static void displayNetworkInterfaceInfo(NetworkInterface ni) {
		System.out.printf("display name: %s\n", ni.getDisplayName());
		System.out.printf("name: %s\n", ni.getName());
		// return an Enumeration of all or a subset of the InetAddresses bound to this network interface
		Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
		List<InetAddress> inetAddressList = Collections.list(inetAddresses);
		System.out.println("InetAddresses of " + ni.getDisplayName() + ": " + inetAddressList.size());
		for (InetAddress i : inetAddressList) {
			System.out.printf("%s\n", i);
		}
	}

	public static void main(String args[]) {
		try {
			// you can get an instance or an Enumeration of NetworkInterface using one of its factory methods
			Enumeration<NetworkInterface> niEnum = NetworkInterface.getNetworkInterfaces();
			// list all the network interfaces and their addresses on a machine
			for (NetworkInterface i : Collections.list(niEnum)) {
				System.out.println("\n---NetworkInterface informations: ");
				displayNetworkInterfaceInfo(i);
				// InterfaceAddress represents a Network Interface address
				List<InterfaceAddress> interfaceAddresses = i.getInterfaceAddresses();
				for (InterfaceAddress j : interfaceAddresses) {
					System.out.println("\t---InterfaceAddress informations:");
					System.out.println("\tInetAddress: " + j.getAddress());
					System.out.println("\tInetAddress for the broadcast address: " + j.getBroadcast());
					System.out.println("\tnetwork prefix length: " + j.getNetworkPrefixLength());
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
}