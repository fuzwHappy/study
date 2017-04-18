package com.fuzw.study.algorithm.lintcode;

import java.util.LinkedList;
import java.util.List;

public class MaxNumber {

	
	static class Status{
		List<Left> list = new LinkedList<Left>();
		int s;
		int maxValue;
	}
	
	static class Left{
		int firstLeft;
		int secondLeft;
	}
	
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int[] result = max2(nums1, nums2, 0, 0, k);
		return result;
	}
	
//	private Status max(int[] nums1, int[] nums2, int firstLeft, int secondLeft, int s){
//		Status result = new Status();
//		result.firstLeft = firstLeft;
//		result.secondLeft = secondLeft;
//		result.s = s;
//		int firstMax = maxIndex(nums1, firstLeft, s + secondLeft - nums2.length);
//		int secondMax = maxIndex(nums2, secondLeft, s + firstLeft - nums1.length);
//		if(firstMax == nums1.length || nums1[firstMax] < nums2[secondMax]){
//			result.maxValue = nums2[secondMax];
//			result.secondLeft = secondMax + 1;
//			return result;
//		}else if(secondMax == nums2.length || nums1[firstMax] > nums2[secondMax]){
//			result.maxValue = nums1[firstMax];
//			result.firstLeft = firstMax + 1;
//			return result;
//		}if(nums1[firstMax] == nums2[secondMax]){
//			Status status1 = max(nums1, nums2, );
//		}
//	}
	
	private int maxIndex(int data[], int start, int limitSize) {
		int maxIndex = start, temp = start + 1;
		while(temp < data.length && data.length - temp >= limitSize){
			if(data[temp] > data[maxIndex]){
				maxIndex = temp;
			}
			temp ++;
		}
		return maxIndex;
	}
	
	
	public int[] max2(int[] nums1, int[] nums2, int firstLeft, int secondLeft, int k) {
		if(k == 0){
			return new int[0];
		}
		int[] result = new int[k];
		int s = k;
		int firstMax = maxIndex(nums1, firstLeft, s + secondLeft - nums2.length);
		int secondMax = maxIndex(nums2, secondLeft, s + firstLeft - nums1.length);
		if( secondMax < nums2.length && (firstMax == nums1.length || nums1[firstMax] < nums2[secondMax]) ){
			result[0] = nums2[secondMax];
//			secondLeft = secondMax + 1;
			int[] sonResult = max2(nums1, nums2, firstLeft, secondMax + 1, k-1);
			merge(result, sonResult);
		}else if(secondMax == nums2.length || nums1[firstMax] > nums2[secondMax]){
			result[0] = nums1[firstMax];
//			firstLeft = firstMax + 1;
			int[] sonResult = max2(nums1, nums2, firstMax + 1, secondLeft, k-1);
			merge(result, sonResult);
		}else if(nums1[firstMax] == nums2[secondMax]){
			result[0] = nums2[secondMax];
			int[] sonResult1 = max2(nums1, nums2, firstLeft, secondMax + 1, k-1);
			int[] sonResult2 = max2(nums1, nums2, firstMax + 1, secondLeft, k-1);
			if(compare(sonResult1, sonResult2)){
				merge(result, sonResult1);
			}else{
				merge(result, sonResult2);
			}
		}
		
		return result;
	}
	
//	public boolean compare(int[] nums1, int[] nums2, List<Left> list, int k){
//		int maxValue = -1;
//		int max = 0;
//		int i = 0;
//		List<Status> statuses = new LinkedList<Status>();
//		List<Integer> maxIndex = new LinkedList<Integer>();
//		for(Left left : list){
//			if(left != null){
//				Status status = maxValue(nums1, nums2, left.firstLeft, left.secondLeft, k);	
//				if(status == null){
//					
//				}
//				if(status.maxValue > maxValue){
//					max = i;
//				}
//			}
//			i++;
//		}
//		
//		Status status1 = maxValue(nums1, nums2, firstLeft, secondLeft, k);
//		Status status2 = maxValue(nums1, nums2, firstLeft2, secondLeft2, k);
//		if(status1 == null){
//			return false;
//		}
//		if(status2 == null ){
//			return true;
//		}
//		if( status1.maxValue > status2.maxValue){
//			return true;
//		}else if( status1.maxValue < status2.maxValue){
//			return false;
//		}
//		if(status1.maxValue == status2.maxValue){
//			
//		}
//		return true;
//	}
//	
//	public Status maxValue(int[] nums1, int[] nums2, int firstLeft, int secondLeft, int k){
//		if(k == 0){
//			return null;
//		}
//		Status result = new Status();
//		Left left = new Left();
//		left.firstLeft = firstLeft;
//		left.secondLeft = secondLeft;
//		result.s = k;
//		int s = k;
//		int firstMax = maxIndex(nums1, firstLeft, s + secondLeft - nums2.length);
//		int secondMax = maxIndex(nums2, secondLeft, s + firstLeft - nums1.length);
//		if( secondMax < nums2.length && (firstMax == nums1.length || nums1[firstMax] < nums2[secondMax]) ){
//			left.secondLeft = secondMax + 1;
//			result.list.add(left);
//			result.maxValue = nums2[secondMax]; 
//			return result;
//		}else if(secondMax == nums2.length || nums1[firstMax] > nums2[secondMax]){
//			left.firstLeft = firstMax + 1;
//			result.list.add(left);
//			result.maxValue = nums1[firstMax]; 
//			return result;
//		}else if(nums1[firstMax] == nums2[secondMax]){
//			result.maxValue = nums1[firstMax]; 
//			
//			Left left1 = new Left();
//			left1.firstLeft = firstLeft;
////			left1.secondLeft = secondLeft;
//			left1.secondLeft = secondMax + 1;
//			result.list.add(left1);
//			
//			Left left2 = new Left();
////			left2.firstLeft = firstLeft;
//			left2.secondLeft = secondLeft;
//			left2.firstLeft = firstMax + 1;
//			result.list.add(left2);
//		}
//		return null;
//	}
	
	private void merge(int[] parent, int[] son) {
		if (son == null || son.length == 0) {
			return;
		}
		for (int i = 0; i < son.length; i++) {
			parent[i + 1] = son[i];
		}
	}

	private boolean compare(int[] sonResult1, int[] sonResult2) {
		int i = 0;
		while (i < sonResult1.length) {
			if (sonResult1[i] > sonResult2[i]) {
				return true;
			} else if (sonResult1[i] < sonResult2[i]) {
				return false;
			}
			i++;
		}
		return true;
	}

	public static void main(String args[]) {
		
		int k, data[];
		
//		int[] nums1 = { 3, 4, 6, 5 }, nums2 = { 9, 1, 2, 5, 8, 3 };
//		k = 5;
//		data = new MaxNumber().maxNumber(nums1, nums2, k);
//		for (int item : data) {
//			System.out.print(item + " ");
//		}
//		
//		System.out.println();
//		int[] nums11 = {6, 7}, nums21 = { 6, 0, 4 };
//		k = 5;
//		data = new MaxNumber().maxNumber(nums11, nums21, k);
//		for (int item : data) {
//			System.out.print(item + " ");
//		}
//		
//		System.out.println();
//		int[] nums12 = {3, 9}, nums22 = {8, 9};
//		k = 3;
//		data = new MaxNumber().maxNumber(nums12, nums22, k);
//		for (int item : data) {
//			System.out.print(item + " ");
//		}
		
		int num3[] = {8,9,7,3,5,9,1,0,8,5,3,0,9,2,7,4,8,9,8,1,0,2,0,2,7,2,3,5,4,7,4,1,4,0,1,4,2,1,3,1,5,3,9,3,9,0,1,7,0,6,1,8,5,6,6,5,0,4,7,2,9,2,2,7,6,2,9,2,3,5,7,4,7,0,1,8,3,6,6,3,0,8,5,3,0,3,7,3,0,9,8,5,1,9,5,0,7,9,6,8,5,1,9,6,5,8,2,3,7,1,0,1,4,3,4,4,2,4,0,8,4,6,5,5,7,6,9,0,8,4,6,1,6,7,2,0,1,1,8,2,6,4,0,5,5,2,6,1,6,4,7,1,7,2,2,9,8,9,1,0,5,5,9,7,7,8,8,3,3,8,9,3,7,5,3,6,1,0,1,0,9,3,7,8,4,0,3,5,8,1,0,5,7,2,8,4,9,5,6,8,1,1,8,7,3,2,3,4,8,7,9,9,7,8,5,2,2,7,1,9,1,5,5,1,3,5,9,0,5,2,9,4,2,8,7,3,9,4,7,4,8,7,5,0,9,9,7,9,3,8,0,9,5,3,0,0,3,0,4,9,0,9,1,6,0,2,0,5,2,2,6,0,0,9,6,3,4,1,2,0,8,3,6,6,9,0,2,1,6,9,2,4,9,0,8,3,9,0,5,4,5,4,6,1,2,5,2,2,1,7,3,8,1,1,6,8,8,1,8,5,6,1,3,0,1,3,5,6,5,0,6,4,2,8,6,0,3,7,9,5,5,9,8,0,4,8,6,0,8,6,6,1,6,2,7,1,0,2,2,4,0,0,0,4,6,5,5,4,0,1,5,8,3,2,0,9,7,6,2,6,9,9,9,7,1,4,6,2,8,2,5,3,4,5,2,4,4,4,7,2,2,5,3,2,8,2,2,4,9,8,0,9,8,7,6,2,6,7,5,4,7,5,1,0,5,7,8,7,7,8,9,7,0,3,7,7,4,7,2,0,4,1,1,9,1,7,5,0,5,6,6,1,0,6,9,4,2,8,0,5,1,9,8,4,0,3,1,2,4,2,1,8,9,5,9,6,5,3,1,8,9,0,9,8,3,0,9,4,1,1,6,0,5,9,0,8,3,7,8,5};
		int num32[] = {7,8,4,1,9,4,2,6,5,2,1,2,8,9,3,9,9,5,4,4,2,9,2,0,5,9,4,2,1,7,2,5,1,2,0,0,5,3,1,1,7,2,3,3,2,8,2,0,1,4,5,1,0,0,7,7,9,6,3,8,0,1,5,8,3,2,3,6,4,2,6,3,6,7,6,6,9,5,4,3,2,7,6,3,1,8,7,5,7,8,1,6,0,7,3,0,4,4,4,9,6,3,1,0,3,7,3,6,1,0,0,2,5,7,2,9,6,6,2,6,8,1,9,7,8,8,9,5,1,1,4,2,0,1,3,6,7,8,7,0,5,6,0,1,7,9,6,4,8,6,7,0,2,3,2,7,6,0,5,0,9,0,3,3,8,5,0,9,3,8,0,1,3,1,8,1,8,1,1,7,5,7,4,1,0,0,0,8,9,5,7,8,9,2,8,3,0,3,4,9,8,1,7,2,3,8,3,5,3,1,4,7,7,5,4,9,2,6,2,6,4,0,0,2,8,3,3,0,9,1,6,8,3,1,7,0,7,1,5,8,3,2,5,1,1,0,3,1,4,6,3,6,2,8,6,7,2,9,5,9,1,6,0,5,4,8,6,6,9,4,0,5,8,7,0,8,9,7,3,9,0,1,0,6,2,7,3,3,2,3,3,6,3,0,8,0,0,5,2,1,0,7,5,0,3,2,6,0,5,4,9,6,7,1,0,4,0,9,6,8,3,1,2,5,0,1,0,6,8,6,6,8,8,2,4,5,0,0,8,0,5,6,2,2,5,6,3,7,7,8,4,8,4,8,9,1,6,8,9,9,0,4,0,5,5,4,9,6,7,7,9,0,5,0,9,2,5,2,9,8,9,7,6,8,6,9,2,9,1,6,0,2,7,4,4,5,3,4,5,5,5,0,8,1,3,8,3,0,8,5,7,6,8,7,8,9,7,0,8,4,0,7,0,9,5,8,2,0,8,7,0,3,1,8,1,7,1,6,9,7,9,7,2,6,3,0,5,3,6,0,5,9,3,9,1,1,0,0,8,1,4,3,0,4,3,7,7,7,4,6,4,0,0,5,7,3,2,8,5,1,4,5,8,5,6,7,5,7,3,3,9,6,8,1,5,1,1,1,0,3};
		k=500;
		data = new MaxNumber().maxNumber(num3, num32, k);
		for (int item : data) {
			System.out.print(item + " ");
		}

	}

}
