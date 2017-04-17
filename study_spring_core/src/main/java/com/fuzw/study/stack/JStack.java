package com.fuzw.study.stack;

public class JStack {

	private Node header;

	public void add(int value) {
		Node newNode = new Node();
		newNode.value = value;

		if (header == null) {
			header = newNode;
		} else {
			newNode.next = header;
			header = newNode;
		}
	}

	public int pop() {
		if (header == null) {
			throw new RuntimeException("Error: Empty!");
		}

		Node temp = header;
		header = header.next;
		return temp.value;
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
		JStack stack = new JStack();
		for (int item : data) {
			stack.add(item);
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

}
