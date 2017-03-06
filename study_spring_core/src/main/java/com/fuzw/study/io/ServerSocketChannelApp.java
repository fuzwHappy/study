package com.fuzw.study.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.List;

public class ServerSocketChannelApp {

	public static void main(String[] args) {
		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.socket().bind(new InetSocketAddress(9999));
			serverSocketChannel.configureBlocking(false);

			List<SocketChannel> socketChannels = new LinkedList<SocketChannel>();

			while (true) {
				SocketChannel socketChannel = serverSocketChannel.accept();
				if (socketChannel != null) {
					socketChannel.configureBlocking(false);
					socketChannels.add(socketChannel);
				}
				for (SocketChannel socketChannel2 : socketChannels) {
					if (!socketChannel2.isConnected()) {
						socketChannels.remove(socketChannel2);
						continue;
					}
					ByteBuffer buffer = ByteBuffer.allocate(6);
					int read = socketChannel2.read(buffer);
					while (read > 0) {
						buffer.flip();
						while (buffer.hasRemaining()) {
							byte c = buffer.get();
							System.out.println((char) c);
						}
						buffer.clear();
						read = socketChannel2.read(buffer);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
