import java.util.Scanner;
public class Array {
public static int linearSearch(int arr[], int k) {
     for (int i = 0; i <= 10; i++) {
      if(arr[i] == k){
      return i;
      }
     }return -1;
   }
public static int LSNumber(int arr[]) {
  int largestNumber = Integer.MIN_VALUE;
  int smallestNumber = Integer.MAX_VALUE;
  for (int index = 0; index < arr.length; index++) {
   if (largestNumber < arr[index]) {
    largestNumber = arr[index];
   }
   if(smallestNumber > arr[index]){
     smallestNumber = arr[index];
   }
  }System.out.println("Smallest number : "+ smallestNumber);
   return largestNumber;
}
public static int binarySearch(int arr[], int search) {
  int begin = 0; 
  int end = arr.length-1;
  while (begin <= end) {
    int mid = (begin+end)/2;
    if (arr[mid] == search) {
      return mid;
    }
    if (arr[mid] < search) {
      begin = mid+1;
    } else {
      end = mid-1;
    }
  } return -1;
}
public static void reverse1(int arr[] ,int n) {
  int array[] = new int[n];
  int x = n-1;
  for (int index = 0; index <=x; index++) {
      array[index] = arr[x-index];
  }System.out.print("reversed array is : ");
  for (int index = 0; index <= x; index++) {
      System.out.print(array[index] + " ");
  }
}   
public static void reverse(int arr[], int n)
{ int first = 0;
  int last = n-1;
  while(first< last)
  {
    int temp = arr[first];
    arr[first] = arr[last];
    arr[last] = temp;
    first++;
    last--;
  }
}
public static void pairs(int arr[], int n) {
  for (int x = 0; x < n-1; x++) {
    for (int i = x+1; i <n; i++) {
      System.out.print("("+arr[x]+ ","+ arr[i] + ")  ");
    }System.out.println(); 
  }
}
public static void subArray(int arr[], int n) {
  for (int x = 0; x < n; x++) {
    for (int i = x; i <n; i++) {
      System.out.print("[");
      for (int index = x ; index <i+1; index++) {
        System.out.print(" " + arr[index] ); 
      }System.out.print("]  ");
    }System.out.println(); 
  }
}
public static void subArrayMaxMinSum(int arr[], int n) {
  int m = 0;
  int s[] = new int[50];
  for (int x = 0; x < n; x++) {
    for (int i = x; i <n; i++) {
      int sum = 0;
      for (int index = x ; index <=i; index++) {
           sum = sum + arr[index]; 
           System.out.print(arr[index] +" ");
      } System.out.print("   ");
        s[m] = sum;
        m++;
    }System.out.println();
  }
  int max = s[0];int min = s[0];
  for (int index = 0; index < m-1; index++) {
        if (s[index]>max) {
           max = s[index];
        }
        if (s[index]<min) {
          min = s[index];
        }
  }
  System.out.println("Maximum number :" + max);
  System.out.println("Minimum number :" + min);
}
public static void prefixArray(int arr[], int n) {
  int p []= new int[n];
  p[0] = arr[0];
  for (int index = 1; index < n; index++) {
    p[index] = p[index-1]+arr[index]; 
  }
  int sum = 0;
  int maxSum = Integer.MIN_VALUE;
  for (int x = 0; x < n; x++) {
    for (int i = x; i <n; i++) {
      sum = x==0?p[i]:p[i]-p[x-1];
    } if(sum>maxSum)
    {
      maxSum = sum;
    }
  }System.out.println("Maximum Sum :" + maxSum);
}
public static void kadanAlgo(int arr[], int n) {
  int sum = arr[0];
  int maxSum = Integer.MIN_VALUE;
  for (int index = 1; index < n; index++) {
    sum = sum+arr[index];
    if (sum<0) {
      sum = 0;
    }
    if (sum>maxSum) {
      maxSum = sum;
    }
  }System.out.println("Maximum Sum :" + maxSum);
}
public static void tapWater(int arr[], int n) {
  int leftA[] = new int[n];
  int rightA[] = new int[n];
  int maxl = arr[0];
  int maxr = arr[0];
  int sum = 0;
  for (int i = 0; i <n; i++) {
       if (maxl<arr[i]) {
       maxl = arr[i];}
      //maxl = Math.max(arr[i], leftA[i]);
      leftA[i] = maxl;
  } 
  for (int j = n-1 ; j >=0; j--) {
     if (maxr<arr[j]) {
     maxr = arr[j];}
     //maxr = Math.max(arr[j], rightA[j]);
    rightA[j] = maxr;
  }
  for (int index = 0; index < n; index++) {
    int in = Math.min(leftA[index], rightA[index]);
    int k = in - arr[index];
    if (k<0) {
      k = 0;
    } sum += k;
  }
  System.out.println("Volume of the water stored is " + sum);
}
public static int stoke(int arr[], int n) {
  int h = arr[0];
  int profit = 0;
  for (int i = 1; i <n; i++) {
    if(h>arr[i]){
      h = arr[i];
    }
    else{
      int k = arr[i]-h;
      profit = Math.max(profit,k);
    }
  }
  return profit;
}
public static boolean check(int arr[], int n) {
  for (int k = 1; k < n; k++) {
     for (int index = k+1; index < n; index++) {
          if (arr[index]== arr[k]) {
            return true;
          }
     }
  }
  return false;
}
public static void main(String[] args) {
      int arr[] = new int [50];
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter the length of the array (not more than 50) :");
      int n = sc.nextInt();
      System.out.print("Enter " + n + " elements :");
      for (int index = 0; index < n; index++) {
        arr[index] = sc.nextInt();}
      //System.out.println("subArrays of array are : ");
      //System.out.println(check(arr, n));
      sc.close();
   }
}