package client;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class JavaClient {
	public static void main(String[] args) {
		MyClient mc = new MyClient();
		mc.mystart();
//		while(true) {
//			mc.mystart();
//		}
	}
}

class MyClient{
	InputStream is;
	OutputStream os;
	Socket socket;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	Scanner sc;
	String rMsg;
	
	public void mystart() {
		try {
			socket = new Socket("127.0.0.1", 5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		while(true) {
			sendMessage(socket);
			receiveMessage(socket);
		}
	}
	
	public void sendMessage(Socket socket) {
		try {
			os = socket.getOutputStream();
			oos = new ObjectOutputStream(os);
			sc = new Scanner(System.in);
			System.out.print("보낼 메시지>>");
			String sMsg = sc.nextLine();
			oos.writeObject(sMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void receiveMessage(Socket socket) {
		try {
			is = socket.getInputStream();
			ois = new ObjectInputStream(is);
			rMsg = (String)ois.readObject();
			System.out.println(rMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





