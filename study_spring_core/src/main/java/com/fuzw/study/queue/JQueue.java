package com.fuzw.study.queue;

public class JQueue {

	private Node header;

	private Node tail;

	private int size = 0;

	public void add(int value) {
		Node newNode = new Node();
		newNode.value = value;

		if (header == null) {
			header = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = tail.next;
		}
		size++;
	}

	public int pop() {
		if (header == null) {
			throw new RuntimeException("Error: Empty!");
		}

		Node temp = header;
		header = header.next;
		size--;
		if (header == null) {
			tail = null;
		}
		return temp.value;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return header == null;
	}

	static class Node {
		int value;
		Node next;
	}

	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		JQueue queue = new JQueue();
		for (int item : data) {
			queue.add(item);
		}
		while (!queue.isEmpty()) {
			System.out.print(queue.pop() + " ");
		}
	}

}
