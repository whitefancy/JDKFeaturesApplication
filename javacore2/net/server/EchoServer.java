package javacore2.net.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 服务端程序，比如HTTP web服务器，
 * 会执行以下循环
 * 通过输入数据流从客户端接收一个命令
 * 解码客户端请求的信息
 * 通过输出数据流发送信息给客户端
 */
public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket s = new ServerSocket(8189)) {
            //监听本机的端口8189
            try (Socket incoming = s.accept()) {
                //一旦等到了有效的链接，进入try块
                InputStream inputStream = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();

                try (Scanner in = new Scanner(inputStream, "UTF-8")) {
                    PrintWriter out = new PrintWriter(
                            new OutputStreamWriter(outputStream, "UTF-8"),
                            true
                    );
                    out.println("Hello! Enter BYE to exit.");
                    //echo client input
                    boolean done = false;
                    while (!done && in.hasNextLine()) {
                        String line = in.nextLine();
                        out.println("Echo:" + line);
                        if (line.trim().equals("BYE")) {
                            done = true;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
Hello! Enter BYE to exit.
he
Echo:he
dfdsaf
Echo:dfdsaf
BYE
Echo:BYE


遗失对主机的连接。

C:\Users\white>telnet 127.0.0.1 8189
正在连接127.0.0.1...无法打开到主机的连接。 在端口 8189: 连接失败
 */