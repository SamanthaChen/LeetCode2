package BaseKnowledge;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * java socket通信 服务器端源代码
 */
public class Server {
	public static final int PORT = 12345;// 监听的端口号

	public static void main(String[] args) {
		System.out.println("服务启动...\n");
		Server server = new Server();
		server.init();
	}

	public void init() {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			// 死循环监听某端口是否有连接请求
			while (true) {
				// 一旦有阻塞，则表明服务器与客户端获得了链接
				Socket client = serverSocket.accept();
				// 创建一个线程处理这次连接
				new HandlerThread(client);
			}

		} catch (Exception e) {
			System.out.println("服务器异常：" + e.getMessage());
		}

	}

	private class HandlerThread implements Runnable {
		private Socket socket;

		public HandlerThread(Socket client) {
			socket = client;
			new Thread(this).start();// 启动线程
		}

		@Override
		public void run() {
			try {
				// 读取客户端数据
				DataInputStream input = new DataInputStream(socket.getInputStream());
				// 这里要注意和客户端输出流的写方法对应，否则抛出EOFException
				String clientInputStr = input.readUTF();
				// 处理客户端数据
				System.out.println("客户端发过来的内容" + clientInputStr);

				// 向客户端回复信息
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				System.out.println("请输入：\t");
				// 发送键盘输入的一行
				String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
				out.writeUTF(s);

				out.close();
				input.close();
			} catch (Exception e) {
				System.out.println("服务器 run 异常" + e.getMessage());
			} finally {
				// 最后关闭socket
				if (socket != null) {
					try {
						socket.close();
					} catch (Exception e) {
						socket = null;
						System.out.println("服务器 finally 异常" + e.getMessage());
					}
				}
			}

		}

	}
}
