package com.fuzw.study.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketClinetApp {

	public static void main(String[] args) {
		try {
			SocketChannel client = SocketChannel.open();
			client.connect(new InetSocketAddress("127.0.0.1", 9999));
			ByteBuffer buffer = ByteBuffer.allocate(2);
			while (true) {
				char c = 'B';
				buffer.put((byte) c);
				buffer.flip();
				while(buffer.hasRemaining()){
					client.write(buffer);		
				}
				buffer.clear();
				Thread.sleep(10);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
