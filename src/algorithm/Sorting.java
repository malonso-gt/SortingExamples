/**
 * 
 */
package algorithm;

import common.Logging;
import java.io.File;
import java.io.IOException;

/**
 * @author Moises Alonso
 * @version V100R001C00
 */
public class Sorting {
	
	/***
	 * Sorts the specified array of objects using the Bubble
	 * sort algorithm
	 * @param list List of elements need to be sorted.
	 */
	public static void bubbleSort(Comparable[] list) {
		
		int countCompareOps = 0;
		int countReplacement = 0;
		String logFile = "";
		String newLine = "";
		
		try {
			System.out.println(logFile);
			logFile = Logging.createFile("Log_bubblesort_" + java.lang.System.currentTimeMillis());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		for (int i = 0; i < list.length; i++) {
			newLine += " " + list[i];
		}
		newLine += "\r\n";
		
		try {
			Logging.appendTextInNewLine(logFile, " *** BUbblesort ***\r\n");
			Logging.appendTextInNewLine(logFile, "Original: " + newLine);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		for (int i = 0; i < list.length - 1; i++) {
			for (int j = i + 1; j < list.length; j++) {
				countCompareOps++;
				if (list[i].compareTo(list[j]) > 0) {
					
					String actualArray = "";
					for (int k = 0; k < list.length; k++) {
						if (k == i) {
							actualArray += " i => (";
						}
						
						if (k == j) {
							actualArray += " j => (";
						}
						
						actualArray += " " + list[k];
						
						if (k == i || k == j) {
							actualArray += " ) ";
						}
						
					}
					
					actualArray += "\r\n";
					
					try {
						Logging.appendTextInNewLine(logFile, actualArray);
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
					
					
					Comparable temp = list[i];
					list[i] = list[j];
					list[j] = temp;
					countReplacement++;
					
				}
			}
		}
		
		newLine = "";
		
		for (int i = 0; i < list.length; i++) {
			newLine += " " + list[i];
		}
		newLine += "\r\n";
				
		try {
			Logging.appendTextInNewLine(logFile, "Ordenado: " + newLine);
			Logging.appendTextInNewLine(logFile, "Comparaciones: " + countCompareOps + " Intercambios: " + countReplacement);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	/***
	 * Sorts the specified array of objects using the selection
	 * sort algorithm.
	 * @param list List of elements need to be sorted
	 */
   public static void selectionSort (Comparable[] list)
   {
      int min;
      Comparable temp;
      
      int countCompareOps = 0;
      int countReplacement = 0;
      String logFile = "";
		String newLine = "";
		
		try {
			System.out.println(logFile);
			logFile = Logging.createFile("Log_selectionsort_" + java.lang.System.currentTimeMillis());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		for (int i = 0; i < list.length; i++) {
			newLine += " " + list[i];
		}
		newLine += "\r\n";
		
		try {
			Logging.appendTextInNewLine(logFile, " *** Selectionsort  ***\r\n");
			Logging.appendTextInNewLine(logFile, "Original: " + newLine);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
      

      for (int index = 0; index < list.length-1; index++)
      {
         min = index;
         for (int scan = index+1; scan < list.length; scan++) {
        	 countCompareOps++;
        	 if (list[scan].compareTo(list[min]) < 0) {
             	min = scan;
             } 
         }
         
         	String actualArray = "";
			for (int k = 0; k < list.length; k++) {
				if (k == min) {
					actualArray += " min => (";
				}
				
				if (k == index) {
					actualArray += " index => (";
				}
				
				actualArray += " " + list[k];
				
				if (k == min || k == index) {
					actualArray += " ) ";
				}
				
			}
			
			actualArray += "\r\n";
			
			try {
				Logging.appendTextInNewLine(logFile, actualArray);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

         // Swap the values
         temp = list[min];
         list[min] = list[index];
         list[index] = temp;
         countReplacement++;
      }
      
      newLine = "";
		
		for (int i = 0; i < list.length; i++) {
			newLine += " " + list[i];
		}
		newLine += "\r\n";
				
		try {
			Logging.appendTextInNewLine(logFile, "Ordenado: " + newLine);
			Logging.appendTextInNewLine(logFile, "Comparaciones: " + countCompareOps + " Intercambios: " + countReplacement);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
   }


   /***
	 * Sorts the specified array of objects using the insertion
	 * sort algorithm.
	 * @param list List of elements need to be sorted
	 */
   public static void insertionSort (Comparable[] list)
   {
      for (int index = 1; index < list.length; index++)
      {
         Comparable<Comparable<Comparable>> key = list[index];
         int position = index;

         //  Shift larger values to the right
         while (position > 0 && key.compareTo(list[position-1]) < 0)
         {
            list[position] = list[position-1];
            position--;
         }
            
         list[position] = key;
      }
   }
   
   /***
	 * Sorts the specified array of objects using recursive quicksort 
	 * sort algorithm.
	 * @param list List of elements need to be sorted
	 * @param inf lower index limit of the array, when you call this method you should us 0
	 * @param sup upper index limit of the array, when you call this method you should us .size  - 1 or .length - 1 
	 */
   public static void quickSort(Comparable[] list, int inf, int sup, String logFileName) {
	   int i = inf - 1;
	   int j = sup;
	   boolean flag = true;
	   Comparable temp = 0;
	   
	   /*<Log in file>*/
		String newLine = "";
		
		try {
			File logFile = new File(logFileName);
			
			if (!logFile.exists()) {
				
				for (int k = inf; k < sup + 1; k++) {
					newLine += " " + list[k];
				}
				
				newLine += "\r\n";
				
				Logging.createFile(logFileName);
				
				Logging.appendTextInNewLine(logFileName + ".txt", newLine);
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		/*<Log in file />*/
	   
	   if (inf >= sup) {
		   return;
	   }
	   
	   Comparable elem_div = list[sup];
	   
	   try {
		   Logging.appendTextInNewLine(logFileName + ".txt", "inf => " + inf + " sup => " + sup + " elem_div => " + elem_div + " \r\n");   
	   } catch (IOException e) {
		   System.out.println(e.getMessage());   
	   }
	   
	   
	   while (flag) {
		   while(list[++i].compareTo(elem_div) < 0) ; //Move the index i until it finds an element bigger than elem_div
		   while((list[--j].compareTo(elem_div) > 0) && (j > inf)); //Move the index j until it finds element smaller than elem_div
		   
		   if (i < j) {
			   temp = list[i];
			   list[i] = list[j];
			   list[j] = temp;
		   } else {
			   flag = false;
		   }
	   }
	   
	   temp = list[i];
	   list[i] = list[sup];
	   list[sup] = temp;
	   quickSort(list, inf, i - 1, logFileName);
	   quickSort(list, i + 1, sup, logFileName);
   }

}
