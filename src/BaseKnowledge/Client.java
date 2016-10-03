package BaseKnowledge;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * java socket通信 客户端源代码
 */
public class Client {
	public static final String IP_ADDR = "localhost";// 服务器地址
	public static final int PORT = 12345;// 服务器端口号

	public static void main(String[] args) {
		System.out.println("客户端启动...");
		System.out.println("当接到服务器端字符为\"OK\"的时候，客服端将终止\n");

		while (true) {
			Socket socket = null;
			try {
				// 创建一个流套接字并将其连接到指定主机上的指定端口号
				socket = new Socket(IP_ADDR, PORT);
				// 读取服务器端数据
				DataInputStream input = new DataInputStream(socket.getInputStream());
				// 像服务器端发送数据
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				System.out.print("请输入：\t");
				String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
				out.writeUTF(str);

				String ret = input.readUTF();
				System.out.println("服务器端返回的是" + ret);
				// 如果接到“ok”则断开
				if ("OK".equals(ret)) {
					System.out.println("客户端将关闭连接");
					Thread.sleep(500);
					break;
				}
				out.close();
				input.close();
			} catch (Exception e) {
				System.out.println("客户端异常" + e.getMessage());
			} finally {
				if (socket != null) {
					try {
						socket.close();
					} catch (IOException e) {
						socket = null;
						System.out.println("客户端 finally 异常" + e.getMessage());
					}
				}
			}
		}
	}
}
