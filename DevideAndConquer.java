public class DevideAndConquer {
   public static void printArray(int arr[]) {
    for (int index = 0; index < arr.length; index++) {
        System.out.print(arr[index] +" ");
    }
   } 
   public static void mergeSort(int arr[] , int si ,int ei) {
    if (si>= ei) {
        return;
    }
     int mid = si +(ei-si)/2;
     mergeSort(arr, si , mid);
     mergeSort(arr, mid+1, ei);
     merge(arr,si, ei, mid);
   }
   public static void merge(int arr[], int si ,int ei, int mid) {
     int i = si;
     int j = mid+1;
     int k = 0;
     int temp[] = new int[ei-si+1];
     while (i<= mid && j<= ei) {
        if (arr[i]<arr[j]) {
            temp[k] = arr[i];
            i++;
        }
        else{
            temp[k] = arr[j];
            j++;
        }
        k++;
     } 
     while (i<= mid) {
        temp[k] = arr[i];
        i++;
        k++;
     }
     while (j<=ei) {
        temp[k] = arr[j];
        j++;
        k++;
     }
     for (k = 0 , i = si; k < temp.length; i++,k++) {
        arr[i] = temp[k];
     }
   }
   public static void quickSort(int arr[], int si , int ei) {
   
    if (si>=ei) {
        return;
    }
            int pix = partion(arr,si,ei);
            quickSort(arr, si, pix-1);
            quickSort(arr, pix+1, ei);
   } 
   public static int partion(int[] arr, int si, int ei) {
    int pivot = arr[ei];
    int i = si -1; 
    for (int j = si; j < ei; j++) {
        if (arr[j] <= pivot) {
            i++;
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;

        }
    }
        i++;
        int temp = arr[ei];
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
   }
   public static int search(int arr[], int target , int si , int ei) {
    if (si>ei) {
        return -1;
    }
    int mid = si +(ei-si)/2;
    if (arr[mid] == target ) {
        return mid;
    }
    if (arr[si] <= arr[mid]) {
        if (target >= arr[si] && target<= arr[mid]) {
            return search(arr, target, si, mid-1);
        } else {
            return search(arr, target, mid+1, ei);
        }
    } else {
        if (target > arr[mid] && target<= arr[ei]) {
            return search(arr, target, si, mid+1);
        } else {
            return search(arr, target, mid-1, ei);
        }
    }
   }
   public static void main(String[] args) {
       int arr[] = {4,5,6,7,0,1,2};
       //mergeSort(arr, 0, arr.length-1);
       //quickSort(arr, 0, arr.length-1);
       //printArray(arr);
       int x = search(arr, 0, 0, arr.length);
       System.out.println(x);
    }
}
