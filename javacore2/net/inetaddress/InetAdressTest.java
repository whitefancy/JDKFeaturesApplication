package javacore2.net.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * telnet time-a.nist.gov 13
 */
public class InetAdressTest {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("time-a.nist.gov");
            System.out.println(address.getHostAddress());
            InetAddress[] addresses = InetAddress.getAllByName("www.baidu.com");
            Arrays.stream(addresses).map(InetAddress::getHostAddress).forEach(System.out::println);
            address = InetAddress.getLocalHost();
            System.out.println(address.getHostAddress());//172.20.10.8
            address = InetAddress.getByName("localhost");
            System.out.println(address.getHostAddress());//127.0.0.1

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
