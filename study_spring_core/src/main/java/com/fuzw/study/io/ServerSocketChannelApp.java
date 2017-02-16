package com.fuzw.study.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelApp {

	public static void main(String[] args) {
		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.socket().bind(new InetSocketAddress(9999));
			while (true) {
				SocketChannel socketChannel = serverSocketChannel.accept();
				ByteBuffer buffer = ByteBuffer.allocate(6);
				int read = socketChannel.read(buffer);
				while (read != -1) {
					buffer.flip();
					while (buffer.hasRemaining()) {
						byte c = buffer.get();
						System.out.println((char)c);
					}
					buffer.clear();
					read = socketChannel.read(buffer);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
