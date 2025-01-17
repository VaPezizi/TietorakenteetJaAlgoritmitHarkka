import java.util.*;

public class SimpleSortTest {

    static void quickSort(int[] arr, int lo, int hi)
    {

    }

    static void quickSortTest(int[] arr)
    {
        quickSort(arr, 0, arr.length-1);
    }
    static void bubbleSort(int[] arr){
        int swaps = 0;
        for(int i = 0; i < arr.length - 1;++i){
            if(arr[i + 1] < arr[i]){
                int temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;			
                swaps++;
            }	
        }
        if(swaps > 0) bubbleSort(arr);
    }

    // https://www.geeksforgeeks.org/insertion-sort-algorithm/
    static void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // kopioi koodi täältä
    // https://www.geeksforgeeks.org/selection-sort/     
    static void selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
          
            // Assume the current position holds
            // the minimum element
            int min_idx = i;

            // Iterate through the unsorted portion
            // to find the actual minimum
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                  
                    // Update min_idx if a smaller element
                    // is found
                    min_idx = j;
                }
            }

            // Move minimum element to its
            // correct position
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;           
        }
    }

    static void printArray(int[] arr){
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    static int[] createRandomArray(int N) {
        int[] arr = new int[N];

        Random gen = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = gen.nextInt(N);
        }

        return arr;
    }
  
    public static void main(String[] args){

        int[] arr = createRandomArray(100000);
        long selectionStart = System.nanoTime();
        selectionSort(arr);
        long selectionEnd = System.nanoTime();
        double duration = (selectionEnd - selectionStart) / 1000000.0;
        System.out.println("Selection sort : " + duration + " ms");

        int[] arr2 = createRandomArray(100000);
        long insertionStart = System.nanoTime();
        insertionSort(arr2);
        long insertionEnd = System.nanoTime();
        double duration2 = (insertionEnd - insertionStart) / 1000000.0;
        System.out.println("Insertion sort : " + duration2 + " ms");        

        int[] arr3 = createRandomArray(100);
        bubbleSort(arr3);
        printArray(arr3);
        //System.out.print("Original array: ");
        //printArray(arr);

        //System.out.print("Sorted array: ");
        //printArray(arr);
    }    
}
