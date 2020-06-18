package javacore2.net.inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 如果不在命令行中设置参数，将打印本机因特网地址。反之打印主机的所有因特网地址
 */
public class PrintAdress {
    public static void main(String[] args) throws UnknownHostException {
        if (args.length > 0) {
            String host = args[0];
            InetAddress[] addresses = InetAddress.getAllByName(host);
            for (int i = 0; i < addresses.length; i++) {
                System.out.println(addresses[i]);
            }
        } else {
            InetAddress localHostAddress = InetAddress.getLocalHost();
            System.out.println(localHostAddress);
        }
    }
}
