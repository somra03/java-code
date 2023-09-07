//import java.util.Arrays;
//import java.util.Collections;
public class Sorting {
    public static void bubbleSort(int arr[]) {
        int swap = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int index = 0; index < arr.length-1-i; index++) {
                if(arr[index] > arr[index+1])
                {
                    int temp = arr[index+1];
                    arr[index+1] = arr[index];
                    arr[index] = temp;
                    swap++;
                }
            }
        }System.out.println(swap);
    }
    public static void selectionSort(int arr[]) {
        int swap = 0;
        for (int i = 0; i < arr.length; i++) {
            int m = i;
            for (int index = i; index < arr.length-1 ; index++) {
                if(arr[m] > arr[index+1])
                {
                     m = index+1;
                }
            }  int temp = arr[i];
               arr[i] = arr[m];
               arr[m] = temp;
               swap++;
        }System.out.println(swap);
    }
    public static void countingSort(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (largest < arr[i]) {
                largest = arr[i];
            }
        }
        int count[] = new int[largest+1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int k = 0;
        for (int j = 0; j < count.length; j++) {
            while (count[j] > 0) {
                arr[k] = j;
                count[j]--;
                k++;
            }
        }
    }
    public static void insertionSort(int arr[]){
        for (int i = 1; i < arr.length; i++) {
            int c = arr[i];
            int p = i-1;    
                while (p>=0 && arr[p]>c) {
                    arr[p+1] = arr[p];
                    p--;
                }
                arr[p+1] = c;
        }
    }
    public static void bubbleSortDescending(int arr[]) {
        int swap = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int index = 0; index < arr.length-1-i; index++) {
                if(arr[index] < arr[index+1])
                {
                    int temp = arr[index+1];
                    arr[index+1] = arr[index];
                    arr[index] = temp;
                    swap++;
                }
            }
        }System.out.println(swap);
    }
    public static void selectionSortDescending(int arr[]) {
        int swap = 0;
        for (int i = 0; i < arr.length; i++) {
            int m = i;
            for (int index = i; index < arr.length-1 ; index++) {
                if(arr[m] < arr[index+1])
                {
                     m = index+1;
                }
            }  int temp = arr[i];
               arr[i] = arr[m];
               arr[m] = temp;
               swap++;
        }System.out.println(swap);
    }
    public static void insertionSortDescending(int arr[]){
        for (int i = 1; i < arr.length; i++) {
            int c = arr[i];
            int p = i-1;    
                while (p>=0 && arr[p]<c) {
                    arr[p+1] = arr[p];
                    p--;
                }
                arr[p+1] = c;
        }
    }
    public static void countingSortDescending(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (largest < arr[i]) {
                largest = arr[i];
            }
        }
        int count[] = new int[largest+1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int k = 0;
        for (int j = count.length-1; j >= 0 ; j--) {
            while (count[j] > 0) {
                arr[k] = j;
                count[j]--;
                k++;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = { 5 , 2 , 4 , 3, 1};
        //bubbleSort(arr);
        //selectionSort(arr);
        //insertionSort(arr);
        //Arrays.sort(arr);
        //Arrays.sort(arr,0,5); 
        //Arrays.sort(arr, 0, 3, Collections.reverseOrder());
        //countingSort(arr);
        //bubbleSortDescending(arr);
        //selectionSortDescending(arr);
        //insertionSortDescending(arr);
        //countingSortDescending(arr);
        for (int index = 0; index < arr.length; index++) {
            System.out.print(arr[index] + " ");}
    }
}