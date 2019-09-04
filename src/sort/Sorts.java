package sort;

import java.util.Random;

/**
 * @author Steven Li
 *
 */
public class Sorts {
	
	//Creates an array size of n and puts in random between 0 and m-1
	public int[] randomArray(int m, int n) {
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			Random rand = new Random();
			int r = rand.nextInt(n);
			//prints a number between 0 and n-1 (inclusion to both)
			arr[i] = r;
		}
		return arr;
	}
	
	/* 
	 * Selection Sort:
	 * Searches through array for smallest integer, places it in the front (index i)
	 * Swaps element at index i with smallest integer at its index
	 * Loop repeats, and index i increases
	 * Runtime: Best: O(n^2) || Avg: O(n^2) || Worst: O(n^2)
	 */
	public void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			int min = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
	
	/* 
	 * Bubble Sort:
	 * Loop traverses through an array, comparing two elements at a time
	 * If first one is greater than second element, swap them 
	 * Largest elements will always go to the end (Becomes sorted)
	 * Repeats until entire array becomes sorted
	 * Runtime: Best: O(n) || Avg: O(n^2) || Worst: O(n^2) 
	 */
	public void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length-1 ; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
			/*		System.out.println("Swapping " + temp + " at index " + j + " with " +
							arr[j+1] + " at index " + (j+1)); */
					//Swap method with printout of each swap 
				}
			}
		}		
	}
	
	/* 
	 * Insertion Sort:
	 * Loop traverses through an array, comparing two elements at a time
	 * It compares two elements, if the first one is smaller than the second
	 * Then we know it is in the right order, and we consider that subarray to be sorted
	 * Next we compare, the second and third element and so on.
	 * If an element is smaller than the previous, we will put it in compare it to
	 * elements in the sorted array to place it where it belongs
	 * Runtime: Best: O(n) || Avg: O(n^2) || Worst: O(n^2) 
	 */
	public void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int idx = arr[i];
			int secondIdx = i - 1;
			while (secondIdx >= 0 && arr[secondIdx] > idx) {
				arr[secondIdx+1] = arr[secondIdx];
				secondIdx--;
			}
			arr[secondIdx + 1] = idx;
		}
	}
	
	public void mergeSort(int[] arr) {	
		
	}
	
	/* 
	 * Partition for quickSort:
	 * Uses the last element in the array as a pivot, puts the pivot into its sorted position
	 * by using low and high to find its correct spot via numbers smaller than it and larger than it.
	 * Elements smaller are on the pivot's left, and greater on its right
	 */
	public int partition(int[] arr, int low, int high) {
		
		int pivot = arr[high];
		int lowIdx = low - 1;
		
		for (int i = low; i < high; i++) {
			if (arr[i] < pivot) {
				lowIdx++;
				int temp = arr[lowIdx];
				arr[lowIdx] = arr[i];
				arr[i] = temp;
			}
		}
		
		int temp = arr[lowIdx+1];
		arr[lowIdx+1] = arr[high];
		arr[high] = temp;
		
		return lowIdx+1;
	}
	/* 
	 * QuickSort:
	 * Recursively sorts array by partitioning it using a pivot in order to get elements
	 * smaller than it and larger than it
	 * Runtime: Best: O(n log(n)) || Avg: O(n log(n)) || Worst: O(n^2) 
	 */
	public void quickSort(int[] arr, int low, int high) {
		
		if (low < high) {
			int pivot = partition(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot+1, high);
		}
	}
	
	public void heapSort(int[] arr) {
		
	}
	
	public static void main(String[] args) {
		Sorts s = new Sorts();
		int[] unsortedArray = s.randomArray(100, 100);
		s.quickSort(unsortedArray, 0, unsortedArray.length-1);
		for (int i = 0; i < unsortedArray.length; i++) {
			System.out.println(unsortedArray[i]);
		}
	}
}
