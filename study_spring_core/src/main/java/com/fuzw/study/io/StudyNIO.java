package com.fuzw.study.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.LinkedList;
import java.util.List;

public class StudyNIO {

	public static void main(String[] args) {
		readFile();
	}

	static void readFile() {
		try {
			RandomAccessFile txtFile;
			txtFile = new RandomAccessFile("/Users/fuzuwen/develop/nio-data.txt", "rw");
			FileChannel fileChannel = txtFile.getChannel();
			int size = 2;
			ByteBuffer buffer = ByteBuffer.allocate(size);
			List<Byte> line = new LinkedList<Byte>();
			int read = fileChannel.read(buffer);
			while (read != -1) {
				buffer.flip();
				while (buffer.hasRemaining()) {
					byte b = buffer.get();
					line.add(b);
					if (b == (byte) '\n') {
						byte[] bytes = new byte[line.size()];
						int i = 0;
						for (Byte B : line) {
							bytes[i] = B.byteValue();
							i++;
						}
						String strline = new String(bytes);
						System.out.print(strline);
						line.clear();
						break;
					}
				}

				buffer.compact();
				read = fileChannel.read(buffer);
			}
			
			byte[] bytes = new byte[line.size()];
			int i = 0;
			for (Byte B : line) {
				bytes[i] = B.byteValue();
				i++;
			}
			String strline = new String(bytes);
			System.out.print(strline);

			
			txtFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void writeFile() {
		try {
			String content = "hello! wrold! 123456789abcdefghijklmnopqrstuvwxyz";
			RandomAccessFile txtFile = new RandomAccessFile("/Users/fuzuwen/develop/nio-data.txt", "rw");
			FileChannel fileChannel = txtFile.getChannel();
			byte[] bytes = content.getBytes();
			int size = 2;
			ByteBuffer buffer = ByteBuffer.allocate(size);
			for (int i = 0; i < bytes.length;) {
				int length = i + size < bytes.length ? size : bytes.length - i;
				buffer.put(bytes, i, length);
				buffer.flip();
				while (buffer.hasRemaining()) {
					fileChannel.write(buffer);
				}
				buffer.clear();
				i = i + length;
			}
			txtFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
