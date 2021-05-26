/**  Sorting Examples
 *   
 *  This program tests out how fast each sort algorithm can sort an array of random numbers.
 *  Sort algorithms in tested are quick sort, bubble sort, insertion sort, selection sort. 
 *  The sort algorithms are tested three times with different array sizes. 
 *  Array sizes are 10, 1000, and 10000.
 * 
 */
package Sorting.Example;

import java.util.Arrays;
    
/**
 *
 * @author storm
 */
public class Main {
    static int qSortCompares = 0;  // GLOBAL var declaration      
    
    
    /** Method swap
     *      The swap method swaps the contents of two elements in an integer
     *      array.
     *
     * @param The array containing the two elements.
     * @param a The subscript of the first element.
     * @param b The subscript of the second element.
     */
    private static void swap(int[] array, int a, int b) {
       int temp;
       temp = array[a];
       array[a] = array[b];
       array[b] = temp;        
    }/// End of method swap

      
    
    
    /** Method bubbleSort
     *      This bubble sort counts the number of comparisons and returns this
     *      value from the method. 
     * 
     * @param array
     * @return bubbleComparisons
     */
    public static int bubbleSort(int[] array) {
       int lastPos;     // Position of last element to compare
       int index;       // Index of an element to compare
       int bubbleComparisons =0;        
       // The outer loop positions lastPos at the last element to compare 
       // during each pass through the array. Initially lastPos is the index 
       // of the last element in the array. During each iteration, it is 
       // decreased by one. 
        for (lastPos = array.length - 1; lastPos >= 0; lastPos--) {
           // The inner loop steps through the array, comparing each 
           // element with its neighbor. All of the elements from index 0 
           // through lastPos are involved in the comparison. If two elements 
           // are out of order, they are swapped. 
           for (index = 0; index <= lastPos - 1; index++) {        
               bubbleComparisons++;    // Counts comparisons
               if (array[index] > array[index + 1]) {                
                   swap(array, index, index + 1);     // Swap the two elements.
               }
           }
        }
        return bubbleComparisons;        
    }/// End of method bubblessort

    
    
    
    /** Method insertionSort
     *      Insertion Sort
     * 
     * @param array 
     */
    public static int insertionSort(int[] array) {
        int unsortedValue;  // The first unsorted value
        int scan;           // Used to scan the array
        int compareInsert = 0;        
        // The outer loop steps the index variable through each subscript 
        // in the array, starting at 1. The portion of the array containing 
        // element 0  by itself is already sorted. 
        for (int index = 1; index < array.length; index++) {
            // The first element outside the sorted portion is array[index]. 
            // Store the value of this element in unsortedValue.  
            unsortedValue = array[index];
            // Start scan at the subscript of the first element outside the 
            // sorted part. 
            scan = index;
            // Move the first element in the still unsorted part into its 
            // proper position within the sorted part. */
            while (scan > 0 && array[scan - 1] > unsortedValue ) {
                // Each time a this while loop passess a comparison has been made.
                compareInsert++; 
                array[scan] = array[scan - 1];
                scan--;
            }
            compareInsert++; // Because a comparesion occurs if the while look gets broken.
            // Insert the unsorted value in its proper position
            // within the sorted subset.
            array[scan] = unsortedValue;
        }
        return compareInsert;        
    }/// End of method insertionSort

    
    
    
    /** Method selectionSort
     *      Performs selectionSort.
     * @param array
     * @return 
     */
    public static int selectionSort(int[] array) {
       int startScan;   // Starting position of the scan
       int index;       // To hold a subscript value
       int minIndex;    // Element with smallest value in the scan
       int minValue;    // The smallest value found in the scan
       int SelectCompare=0;  // The count for the comparisons        
       // The outer loop iterates once for each element in the
       // array. The startScan variable marks the position where
       // the scan should begin.
       for (startScan = 0; startScan < (array.length - 1); startScan++)  {
           // Assume the first element in the scannable area
           // is the smallest value.
           minIndex = startScan;
           minValue = array[startScan];
           // Scan the array, starting at the 2nd element in
           // the scannable area. We are looking for the smallest
           // value in the scannable area. 
           for (index = startScan + 1; index < array.length; index++) {
               SelectCompare++;// The comparison is in the if statement here.
               if (array[index] < minValue) {
                  minValue = array[index];
                  minIndex = index;
               }
           }
           // Swap the element with the smallest value 
           // with the first element in the scannable area.
           array[minIndex] = array[startScan];
           array[startScan] = minValue;
       }
       return SelectCompare;        
    }/// End of method selectionSort

    
    
    
    /** Method quickSort
     *      Performs the quickSort with the given array. Returns the count of 
     *      the accumulator.
     * 
     * @param array
     * @return 
     */
    public static int quickSort(int array[])  {
        qSortCompares =0;
        int count = 0;        
        count = doQuickSort(array, 0, array.length - 1, 0);
        return count;        
    }// End of method quickSort

    
    
    
    /** Method doQuickSort
     *      Uses the QuickSort algorithm to sort an int array.
     *
     * @param array The array to sort.
     * @param start The starting subscript of the list to sort
     * @param end The ending subscript of the list to sort
     * @param passCount The Count accumulator 
     */
    private static int doQuickSort(int array[], int start, int end, int passCount)  {
        int pivotPoint;
        int Qu=0;
        int[] recivingArray = new int[2];    
        if (start < end)  {
            // Get the pivot point.
            recivingArray = partition(array, start, end);
            pivotPoint = recivingArray[0];            
            passCount += recivingArray[1]; 
            // Sort the first sub list.
            passCount = doQuickSort(array, start, pivotPoint - 1, passCount);
            // Sort the second sub list.
            passCount = doQuickSort(array, pivotPoint + 1, end, passCount);
        }       
        return passCount;//CompareCount;        
    }/// End of method doQuickSort

    
    
    
    /** Method partition
     *       The partition method selects a pivot value in an array and arranges
     *       the array into two sub lists. All the values less than the pivot
     *       will be stored in the left sub list and all the values greater than 
     *       or equal to the pivot will be stored in the right sub list.
     * 
     *
     * @param array The array to partition.
     * @param start The starting subscript of the area to partition.
     * @param end The ending subscript of the area to partition.
     * @return The subscript of the pivot value.
     */
    private static int[] partition(int array[], int start, int end) {
        int pivotValue;    // To hold the pivot value
        int endOfLeftList; // Last element in the left sub list.
        int mid;           // To hold the mid-point subscript
        int count = 0;                
        // Find the subscript of the middle element. This will be our pivot 
        // value.
        mid = (start + end) / 2;
        // Swap the middle element with the first element.  This moves the pivot
        // value to the start of the list.
        swap(array, start, mid);
        // Save the pivot value for comparisons.
        pivotValue = array[start];
        // For now, the end of the left sub list is the first element.
        endOfLeftList = start;
        // Scan the entire list and move any values that are less than the pivot
        // value to the left sub list.
        for (int scan = start + 1; scan <= end; scan++) {
               count++;
               qSortCompares++;       
               if (array[scan] < pivotValue) {
               endOfLeftList++;
                swap(array, endOfLeftList, scan);
            }
        }  
        // Move the pivot value to end of the left sub list.
        swap(array, start, endOfLeftList);        
        // Array to hold two variables. The new pivot vaule and recored count. 
        int[] PivotandCount = {endOfLeftList ,count};        
        // Return the subscript of the pivot value.
        return PivotandCount;         
    }/// End of method partition.
  
    
    
    
    /** Method printArray
     *      Print an array to the Console
     *
     * @param A
    */
    public static void printArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.printf("%5d ", A[i]);
        }
        System.out.println();        
    }/// End of method printArray


  
    
    /** Method main
     *      Sets up program to test the sort algorithms.
     *     
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.printf("Lab#2 Sorting Algorithm Performance Analysis\n============================================\n");   
        int countforwhileControl = 0; 
        int SIZEofIndexForArray = 0;      
        do { 
            countforwhileControl++;   
            switch (countforwhileControl) {
                case 1:
                    SIZEofIndexForArray = 10;
                    break;
                case 2:
                    SIZEofIndexForArray = 1000;
                    break;
                case 3:
                    SIZEofIndexForArray= 10000;
                    break;
                default:
                    break;
            }            
            
            /// Create an array with random elements the SIZEofIndexForArray.
            System.out.printf("\nComparison for array size of  %d\n\n",SIZEofIndexForArray);             
            int[] A = new int[SIZEofIndexForArray];             
            for (int i=0; i<SIZEofIndexForArray; i++) {
                A[i] = (int)(Math.random()*SIZEofIndexForArray);
            }
            
            int[] B;    /// Initialize an array to hold copys of array A .
            long startTime; /// Initialize a long to hold the starttime.
            long timeRequired; /// Initalize a long to hold the time it took to preform the sort.
              
            //1 Quick Sort.
            B = Arrays.copyOf(A, A.length);                         // Copys array A to B array.
            startTime = System.nanoTime();                          // Start the timer.
            int QuickCount = quickSort(B);                          // Calls sort method.
            timeRequired = (System.nanoTime() - startTime) / 1000;  // End the timer.          
            System.out.printf("Number of compares for quicksort       = %8d time = %8d us Ratio = %6.1f compares/us\n", QuickCount, timeRequired, QuickCount/(double)timeRequired);

            //2 bubble Sort; number of comparisons
            B = Arrays.copyOf(A, A.length);
            startTime = System.nanoTime();
            int manyBubbles = bubbleSort(B);
            timeRequired = (System.nanoTime() - startTime) / 1000;
            System.out.printf("Number of compares for bubbleSort      = %8d time = %8d us Ratio = %6.1f compares/us\n", manyBubbles, timeRequired, manyBubbles/(double)timeRequired);

            //#3 insertion Sort; Number of comparisons
            B = Arrays.copyOf(A, A.length);
            startTime = System.nanoTime();
            int insertCount = insertionSort(B);
            timeRequired = (System.nanoTime() - startTime) / 1000;  
            System.out.printf("Number of compares for Insertion Sort  = %8d time = %8d us Ratio = %6.1f compares/us\n", insertCount, timeRequired, insertCount/(double)timeRequired);

            //#4 selection Sort; Number of comparisons
            B = Arrays.copyOf(A, A.length);
            startTime = System.nanoTime();
            int SelectCount = selectionSort(B);
            timeRequired = (System.nanoTime() - startTime) / 1000; 
            System.out.printf("Number of compares for Selection Sort  = %8d time = %8d us Ratio = %6.1f compares/us\n", SelectCount, timeRequired, SelectCount/(double)timeRequired);

        } while( countforwhileControl < 3); /// Stop after three loops.  
    }/// End of method main    
}///End of Class Comp10152_Lab2_Start.java




/**
 *  The relative efficiencies of each of the algorithms presented. Which one 
 *  should you use for different values of n (number of elements) and why?
 *  
 * Quick Sort.
 * QuickSort appears to be the fastest of the four sort algorithms. It takes the
 * least time to complete. It also requires the least amount of comparisons to 
 * complete. Quick sort takes less time but requires more memory for the 
 * recursive methods. If I had to sort a large array quickly and not worry about
 * memory size I would prefer to use quickSort for large arrays.
 * 
 * 
 * Bubble Sort.
 * BubbleSort appears to take the longest to complete. It is also takes the most
 * comparisons to complete. The comparisons are equal with selection sort. I 
 * would choose this sort if speed and memory were not an issue because of the 
 * simplicity to create in code.
 * 
 * 
 * Insertion Sort
 * This algorithm is faster than bubble sort and selection sort. This algorithm
 * is efficient for small arrays. Insertion sort is similar to selection sort. 
 * This algorithm writes to memory in on average O(n^2) times meaning it uses 
 * two nested loops  to scan the data. Its advantage is it only needs to scan as
 * many elements as it needs in order to place the k +1st element. I would use 
 * this algorithm if memory is not an valuable resource and speed is a 
 * requirement. 
.*
 * 
 * Selection Sort. 
 * This algorithm appears to require the most amount of time and the most amount
 * of comparisons. I would use this algorithm on small arrays over larger 
 * arrays. Than insertion sort which writes on average O(n^2) times to memory. I
 * would choose this algorithm if speed is not a requirement and  memory is a 
 * valuable resource.
 * 
 */