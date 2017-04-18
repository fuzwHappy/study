package com.fuzw.study.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ServerSocketChannelSelectorApp {

	public static void main(String[] args) {
		try {
			Selector selector = Selector.open();
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.socket().bind(new InetSocketAddress(9998));
			serverSocketChannel.configureBlocking(false);
			int interest = SelectionKey.OP_ACCEPT;
			serverSocketChannel.register(selector, interest);

			while (true) {
				int ready = selector.selectNow();
				if (ready == 0)
					continue;
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> it = keys.iterator();
				while (it.hasNext()) {
					SelectionKey key = (SelectionKey) it.next();
					if (key.isAcceptable()) {
						ServerSocketChannel serverchannel = (ServerSocketChannel) key.channel();
						SocketChannel socketChannel = serverchannel.accept();
						socketChannel.configureBlocking(false);
						socketChannel.register(selector, SelectionKey.OP_READ);
					} else if (key.isConnectable()) {
						SelectableChannel channel = key.channel();
						channel.configureBlocking(false);
						channel.register(selector, SelectionKey.OP_READ);
					} else if (key.isReadable()) {
						SocketChannel socketChannel = (SocketChannel) key.channel();
						ByteBuffer buffer = ByteBuffer.allocate(6);
						int read = socketChannel.read(buffer);
						while (read != 0) {
							buffer.flip();
							while (buffer.hasRemaining()) {
								byte c = buffer.get();
								System.out.println((char) c);
							}
							buffer.clear();
							read = socketChannel.read(buffer);
						}
					}
					it.remove();
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
