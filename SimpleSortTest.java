import java.util.*;

public class SimpleSortTest {
    
    //Uusi versio merge sortista, kirjoittanut Thomas H. Cormen
    public static void mergeSort(int[] arreglo, int lo, int hi) {
        if(hi - lo +1 <= 30){
            insertionSort(arreglo, lo, hi);
            return;
        }
        // Perusehto: Jos alitaulukon koko on 1 tai vähemmän, lopetetaan rekursio.
        if (lo < hi) {
            // Lasketaan taulukon keskikohta
            int m = ((lo + hi) / 2);
            
            // Rekursiivisesti järjestetään vasen ja oikea puolisko
            mergeSort(arreglo, lo, m);
            mergeSort(arreglo, m + 1, hi);
            
            // Yhdistetään järjestetyt osat
            merge(arreglo, lo, m, hi);
        }
    }

    public static void merge(int[] arreglo, int lo, int m, int hi) {
        // Lasketaan alitaulukoiden koot
        int n1 = (m - lo) + 1;
        int n2 = (hi - m);

        // Luodaan kaksi uutta väliaikaista taulukkoa
        int[] mitad1 = new int[n1 + 1]; // Ensimmäinen puolisko + ylimääräinen paikka
        int[] mitad2 = new int[n2 + 1]; // Toinen puolisko + ylimääräinen paikka

        // Kopioidaan tiedot ensimmäiseen alitaulukkoon
        for (int v = 0; v < n1; v++) {
            mitad1[v] = arreglo[lo + v];
        }

        // Kopioidaan tiedot toiseen alitaulukkoon
        for (int p = 0; p < n2; p++) {
            mitad2[p] = arreglo[p + m + 1];
        }

        // Käytetään Integer.MAX_VALUE merkkinä, että taulukon loppu on saavutettu
        mitad1[n1] = Integer.MAX_VALUE;
        mitad2[n2] = Integer.MAX_VALUE;

        // Yhdistetään kaksi alitaulukkoa takaisin alkuperäiseen taulukkoon
        for (int r = lo, m1 = 0, m2 = 0; r <= hi; r++) {
            if (mitad1[m1] <= mitad2[m2]) {
                arreglo[r] = mitad1[m1];
                m1++;
            } else {
                arreglo[r] = mitad2[m2];
                m2++;
            }
        }
    }

    // Tämä metodi toimii päämetodina, joka käynnistää merge sortin koko taulukolle
    public static void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length -1);
    }

    //Uusi versio insertion Sortista, joka ottaa listan rajat parametriksi
    public static void insertionSort(int[] arr, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= lo && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
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

    static void quickSort(int[] arr, int lo, int hi)
    { 
        int i = lo, j = hi, h; 
        int pivot = arr[(lo + hi) / 2]; //Valitaan pivotiksi keskimmäinen alkio
        
        do{
            while(arr[i] < pivot)i++;   //Etsitään oikealta alkio, joka on pivottia suurempi
            while(arr[j] > pivot)j--;   //Sama vasemmalle puolelle
            if(i<=j){   //Vaihdetaan alkioiden paikkaa
                h = arr[i];
                arr[i] = arr[j];
                arr[j] = h;
                i++;
                j--;
            }
        }while(i <= j); //Jatketaan kunnes lista käyty läpi

        //Rekursio oikealle ja vasemmalle puolelle listaa
        if(lo < j) quickSort(arr, lo, j);
        if(i < hi) quickSort(arr, i, hi);

    }

    static void quickSortTest(int[] arr)
    {
        quickSort(arr, 0, arr.length - 1);
    }

    private interface FunctionPointer {
        void methodSignature(int[] arr);
    }
    
    public static void SortMethodTester(FunctionPointer func, String methodName, int n){
        int[] arr = createRandomArray(n);
        int[] ascArr = createAscendingArray(n);
        int[] desArr = createDescendingArray(n);

        long start1 = System.nanoTime();
        func.methodSignature(arr);
        long end1 = System.nanoTime();
        double kesto = (end1 - start1) / 1000000.0f;

        System.out.println("Random array: " + methodName + " " + kesto + " ms");

        start1 = System.nanoTime();
        func.methodSignature(ascArr);
        end1 = System.nanoTime();
        kesto = (end1 - start1) / 1000000.0f;

        System.out.println("Ascending array: " + methodName  + " " + kesto + " ms");

        start1 = System.nanoTime();
        func.methodSignature(desArr);
        end1 = System.nanoTime();
        kesto = (end1 - start1) / 1000000.0f;

        System.out.println("Descending array: " + methodName  + " " + kesto + " ms");

        //printArray(arr);
        //printEveryTenth(arr);
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

                int j;
                for(j = i; j>=gap && arr[j - gap] > temp; j-=gap){
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
                
            }
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
    static void printEveryTenth(int[] arr){
        for(int i = 0; i < arr.length -1; i+=10){
            System.out.print(arr[i] + " | ");
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

        int N = 500000;
        /* 
        
        FunctionPointer quickSort = SimpleSortTest::quickSortTest;
        FunctionPointer bubbleSort = SimpleSortTest::bubbleSort;
        FunctionPointer shellSort = SimpleSortTest::shellSort;
        FunctionPointer selectionSort = SimpleSortTest::selectionSort;
        FunctionPointer insertionSort = SimpleSortTest::insertionSort;
        FunctionPointer arraysSort = Arrays::sort;*/
        FunctionPointer mergeSort = SimpleSortTest::mergeSort;
        //System.out.print("Original array: ");
        
        /*SortMethodTester(quickSort, "Quick sort", N);
        SortMethodTester(bubbleSort, "Bubble sort", N);
        SortMethodTester(shellSort, "Shell sort", N);
        SortMethodTester(selectionSort, "Selection sort", N);
        SortMethodTester(insertionSort, "Insertion sort", N);
        SortMethodTester(arraysSort, "Arrays.sort", N);*/
        SortMethodTester(mergeSort, "Merge sort", N);
        

        //System.out.print("Sorted array: ");
        //printArray(arr);
    }    
}
