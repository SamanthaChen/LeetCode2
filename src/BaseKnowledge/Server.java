package BaseKnowledge;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * java socketͨ�� ��������Դ����
 */
public class Server {
	public static final int PORT = 12345;// �����Ķ˿ں�

	public static void main(String[] args) {
		System.out.println("��������...\n");
		Server server = new Server();
		server.init();
	}

	public void init() {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			// ��ѭ������ĳ�˿��Ƿ�����������
			while (true) {
				// һ�����������������������ͻ��˻��������
				Socket client = serverSocket.accept();
				// ����һ���̴߳����������
				new HandlerThread(client);
			}

		} catch (Exception e) {
			System.out.println("�������쳣��" + e.getMessage());
		}

	}

	private class HandlerThread implements Runnable {
		private Socket socket;

		public HandlerThread(Socket client) {
			socket = client;
			new Thread(this).start();// �����߳�
		}

		@Override
		public void run() {
			try {
				// ��ȡ�ͻ�������
				DataInputStream input = new DataInputStream(socket.getInputStream());
				// ����Ҫע��Ϳͻ����������д������Ӧ�������׳�EOFException
				String clientInputStr = input.readUTF();
				// ����ͻ�������
				System.out.println("�ͻ��˷�����������" + clientInputStr);

				// ��ͻ��˻ظ���Ϣ
				DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				System.out.println("�����룺\t");
				// ���ͼ��������һ��
				String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
				out.writeUTF(s);

				out.close();
				input.close();
			} catch (Exception e) {
				System.out.println("������ run �쳣" + e.getMessage());
			} finally {
				// ���ر�socket
				if (socket != null) {
					try {
						socket.close();
					} catch (Exception e) {
						socket = null;
						System.out.println("������ finally �쳣" + e.getMessage());
					}
				}
			}

		}

	}
}
