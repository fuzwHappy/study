package com.fuzw.study.algorithm.sort;

public class BinarySearch {

	public int search(int data[], int value) {
		int left = 0, right = data.length - 1;
		return binarySearch(data, left, right, value);
	}

	private int binarySearch(int data[], int left, int right, int value) {
		if (left == right) {
			if (data[left] == value) {
				return left;
			} else {
				return -1;
			}
		}

		int mid = (left + right) / 2;
		if (data[mid] == value) {
			return mid;
		}
		if (value > data[mid]) {
			return binarySearch(data, mid + 1, right, value);
		} else {
			return binarySearch(data, left, mid - 1, value);
		}
	}

}
