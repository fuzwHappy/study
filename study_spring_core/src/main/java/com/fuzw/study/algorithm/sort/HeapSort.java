package com.fuzw.study.algorithm.sort;

public class HeapSort {

	public int[] sort(int data[]) {
		buildHeap(data, 0);
		heapSort(data);
		return data;
	}

	private void heapSort(int data[]) {
		int limit = data.length;
		while (limit > 1) {
			swap(data, 0, --limit);
			maxSelf(data, 0, limit);
		}
	}

	private void buildHeap(int data[], int i) {
		if (2 * i + 1 < data.length) {
			buildHeap(data, 2 * i + 1);
		}
		if (2 * i + 2 < data.length) {
			buildHeap(data, 2 * i + 2);
		}
		maxSelf(data, i, data.length);
	}

	private void maxSelf(int data[], int i, int limit) {
		if (2 * i + 1 >= limit) {
			return;
		}

		if (2 * i + 2 >= limit) {
			if (data[i] >= data[2 * i + 1]) {
				return;
			}
			swap(data, i, i * 2 + 1);
			maxSelf(data, 2 * i + 1, limit);
			return;
		}
		int max;
		if (data[2 * i + 1] > data[2 * i + 2]) {
			max = 2 * i + 1;
		} else {
			max = 2 * i + 2;
		}
		if (data[i] >= data[max]) {
			return;
		}
		swap(data, i, max);
		maxSelf(data, max, limit);
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
		data = new HeapSort().sort(data);
		for (int item : data) {
			System.out.print(item + " ");
		}
	}

}
