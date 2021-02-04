/**
 * 
 */
package gui;

import java.util.Scanner;
import java.util.Random;
import algorithm.Sorting;

/**
 * @author moise
 *
 */
public class ConsoleGUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner inputConsole = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("*** SORTING ALGORITHMS ***");
		System.out.println("Enter the quantity of numbers you want to sort");
		int size = inputConsole.nextInt();
		
		Integer[] numbers_for_bubble = new Integer[size];
		Integer[] numbers_for_selection = new Integer[size];
		Integer[] numbers_for_insertion = new Integer[size];
		Integer[] numbers_for_quicksort = new Integer[size];
		
		for (int i = 0; i < size; i++) {
			numbers_for_bubble[i] = rand.nextInt() % 1000;
			numbers_for_selection[i] = numbers_for_bubble[i];
			numbers_for_insertion[i] = numbers_for_bubble[i];
			numbers_for_quicksort[i] = numbers_for_bubble[i];
			System.out.print(" " + numbers_for_bubble[i]);
		}
		
		/*<BubbleSort section>*/
		System.out.println();
		
		Sorting.bubbleSort(numbers_for_bubble);
		
		System.out.println("Sorted array using bubble sort:");
		
		for (int i = 0; i < size; i++) {
			System.out.print(" " + numbers_for_bubble[i]);
		}
		/*<BubbleSort section />*/
		
		/*<SelectionSort section>*/
		System.out.println();
		
		Sorting.selectionSort(numbers_for_selection);
		
		System.out.println("Sorted array using selection sort:");
		
		for (int i = 0; i < size; i++) {
			System.out.print(" " + numbers_for_selection[i]);
		}
		System.out.println();
		/*<SelectionSort section />*/
		
		/*<Quicksort section>*/
		System.out.println();
		
		Sorting.quickSort(numbers_for_quicksort, 0, numbers_for_quicksort.length  - 1, "Log_quicksort_" + java.lang.System.currentTimeMillis());
		
		System.out.println("Sorted array using recursive quick sort:");
		
		for (int i = 0; i < size; i++) {
			System.out.print(" " + numbers_for_quicksort[i]);
		}
		/*<Quicksort section />*/
	}

}
