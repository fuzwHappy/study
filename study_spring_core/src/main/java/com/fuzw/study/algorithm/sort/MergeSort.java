package com.fuzw.study.algorithm.sort;

public class MergeSort {

	public int[] sort(int data[]) {
		mergeSort(data, 0, data.length - 1);
		return data;
	}

	public void mergeSort(int data[], int start, int end) {
		if (start >= end) {
			return;
		}
		int mid = (end + start) / 2;
		mergeSort(data, start, mid);
		mergeSort(data, mid + 1, end);
		merge2(data, start, mid, end);
	}

	public void merge(int[] data, int start, int mid, int end) {
		int left = start, right = mid + 1;
		int[] temp = new int[end - start + 1];
		int i = 0;
		while (left <= mid && right <= end) {
			if (data[left] < data[right]) {
				temp[i++] = data[left];
				left++;
			} else {
				temp[i++] = data[right];
				right++;
			}
		}

		while (left <= mid) {
			temp[i++] = data[left];
			left++;
		}

		while (right <= end) {
			temp[i++] = data[right];
			right++;
		}

		int s = start;
		for (int item : temp) {
			data[s++] = item;
		}
	}

	public void merge2(int[] data, int start, int mid, int end) {
		int left = start, right = mid + 1;
		int[] temp = new int[mid - start + 1];
		int s = start, i = 0;
		while (s <= mid) {
			temp[i++] = data[s++];
		}
		i = 0;
		while (i < temp.length && right <= end) {
			if (temp[i] < data[right]) {
				data[left++] = temp[i++];
			} else {
				data[left++] = data[right++];
			}
		}

		while (i < temp.length) {
			data[left++] = temp[i++];
		}

	}

	public static void main(String args[]) {
		int data[] = { 9, 8, 5, 3, 2, 6, 4, 8, 7, 1, 6, 4, 4, 1, 3, 1 };
		// int data[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		// int data[] = { 8, 7, 6, 5, 4, 3, 2, 1};
		// int data[] = {};
		// int data[] = {1};
		// int data[] = {1, 2};
		data = new MergeSort().sort(data);
		for (int item : data) {
			System.out.print(item + " ");
		}
	}

}
