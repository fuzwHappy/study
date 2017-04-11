package com.fuzw.study.algorithm.sort;

public class QKSort {

	public int[] sort(int[] data) {
		if (data.length > 1) {
			sort(data, 0, data.length - 1);
		}
		return data;
	}

	private void sort(int[] data, int start, int end) {
		if (end <= start) {
			return;
		}
		int midIndex = midIndex(data, start, end);
		sort(data, start, midIndex - 1);
		sort(data, midIndex + 1, end);
	}

	private int midIndex2(int[] data, int start, int end) {
		int left = start, half = start, right = end;
		while (left < right) {
			while (left < right) {
				if (data[right] > data[half]) {
					right--;
				} else {
					break;
				}
			}
			if (left == right) {
				return half;
			}
			swap(data, half, right);
			half = right;
			left++;
			while (left < right) {
				if (data[left] < data[half]) {
					left++;
				} else {
					break;
				}
			}
			if (left == right) {
				return half;
			}
			swap(data, left, half);
			half = left;
			right--;
		}
		return half;
	}
	
	
	private int midIndex(int[] data, int start, int end) {
		int left = start, right = start + 1;
		int mid = data[start];
		while(end >= right){
			if(data[right] > mid){
				right ++;
			}else{
				swap(data, left + 1, right);
				swap(data, left, left + 1);
				left++;
				right++;
			}
		}
		return left;
	}

	private void swap(int[] data, int l, int r) {
		int temp = data[l];
		data[l] = data[r];
		data[r] = temp;
	}

	public static void main(String args[]) {
		int data[] = { 9, 8, 5, 3, 2, 6, 4, 8, 7, 1, 6 , 4, 4, 1, 3, 1 };
		//int data[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
	    //int data[] = { 8, 7, 6, 5, 4, 3, 2, 1};
	    //int data[] = {};
	    //int data[] = {1};
	    //int data[] = {1, 2};
		data = new QKSort().sort(data);
		for (int item : data) {
			System.out.print(item + " ");
		}
	}

}
