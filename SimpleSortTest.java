import java.util.*;

public class SimpleSortTest {

    static void quickSort(int[] arr)
    {
        int lo = 0, hi = arr.length;
        int i = lo, j = hi; 
        int pivot = arr[(hi - lo) / 2];

        do{
            while(arr[i] < pivot)i++;
            while(arr[j] < pivot)j--;
        }


    }

    static void quickSortTest(int[] arr)
    {
        quickSort(arr);
    }

    private interface FunctionPointer {
        void methodSignature(int[] arr);
    }
    
    public static void SortMethodTester(FunctionPointer func, String methodName, int n){
        int[] arr = createRandomArray(n);

        long start1 = System.nanoTime();
        func.methodSignature(arr);
        long end1 = System.nanoTime();
        double kesto = (end1 - start1) / 1000000.0f;

        System.out.println(methodName + kesto + " ms");

        printArray(arr);
    }

    static void bubbleSort(int[] arr){
        boolean swaps = false;

        do{
            swaps = false;
            for(int i = 0; i < arr.length - 1;++i){
                if(arr[i + 1] < arr[i]){
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;			
                    swaps = true;
                }	
            }
        }while(swaps);
    }

    static void shellSort(int[] arr){
        int len = arr.length;

        for(int gap = len / 2; gap > 0; gap /= 2){
            for(int i = gap; i < len;i++){
                
                int temp = arr[i];

                for(int j = i; j>=gap && arr[j - gap] > temp; j-=gap){
                    arr[j] = arr[j - gap];
                }
                arr[i] = temp;
                
            }
        }

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

    static int[] createAscendingArray(int n){
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i;
        }
        return arr;
    }

    static int[] createDescendingArray(int n){
        int arr[] = new int[n];
        int size = arr.length - 1;
        for(int i = 0; i < n; i++){
            arr[size - i] = i;
        }
        return arr;
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

        int N = 10000;
        /* 
        */
        FunctionPointer quickSort = SimpleSortTest::quickSortTest;
        FunctionPointer bubbleSort = SimpleSortTest::bubbleSort;
        FunctionPointer shellSort = SimpleSortTest::shellSort;
        FunctionPointer selectionSort = SimpleSortTest::selectionSort;
        FunctionPointer insertionSort = SimpleSortTest::insertionSort;
        //System.out.print("Original array: ");
        printArray(createAscendingArray(10));
        printArray(createDescendingArray(10));
        //printArray(arr);

        //System.out.print("Sorted array: ");
        //printArray(arr);
    }    
}
