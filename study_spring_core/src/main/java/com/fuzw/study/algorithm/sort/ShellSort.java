package com.fuzw.study.algorithm.sort;

public class ShellSort {

	public int[] sort(int data[]) {
		int diff = data.length / 2;
		while (diff >= 1) {
			for (int j = 0; j < diff; j++) {
				shellSort(data, j, diff);
			}
			diff = diff / 2;
		}
		return data;
	}

	private void shellSort(int data[], int first, int diff) {
		int i = first + diff;
		while (i < data.length) {
			int right = i;
			while (right > first) {
				if (data[right] >= data[right - diff]) {
					break;
				}
				swap(data, right, right - diff);
				right = right - diff;
			}
			i = i + diff;
		}
	}

	private void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public static void main(String args[]) {
		int data[] = { 9, 8, 5, 3, 2, 6, 4, 8, 7, 1, 6, 4, 4, 1, 3, 1 };
		// int data[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		// int data[] = { 8, 7, 6, 5, 4, 3, 2, 1};
		// int data[] = {};
		// int data[] = {1};
		// int data[] = {1, 2};
		data = new ShellSort().sort(data);
		for (int item : data) {
			System.out.print(item + " ");
		}

		BinarySearch search = new BinarySearch();
		System.out.println();
		System.out.println("9 Index: "+search.search(data, 9));
		System.out.println("1 Index: "+search.search(data, 1));
		System.out.println("10 Index: "+search.search(data, 10));
		System.out.println("6 Index: "+search.search(data, 6));
		System.out.println("6 Index: "+search.search(data, 2));
	}

}
