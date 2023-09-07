public class RecursionBasic {
    public static int factorial(int n) {
        if(n==1)
        {
            return 1;
        }
            int facn = factorial(n-1);
            int fac = n*facn;
        //System.out.println(fac);
        return fac;
    }
    public static int naturalNumberSum(int n) {
        if(n==1)
        {
            return 1;
        }
            int sumn = naturalNumberSum(n-1);
            int sum = n+sumn;
        //System.out.println(fac);
        return sum;
    }
    public static int fibonacci(int n) {
        if(n==0 || n == 1)
        {
            return n;
        }
            int sum = fibonacci(n-1)+fibonacci(n-2);
        return sum; 
    }
    public static boolean sortedArray(int arr[], int n) {
        if(arr[n] == arr.length){
           return true; 
        }
        if(arr[n] > arr[n+1])
        {
            return false;
        }
        return sortedArray(arr, n+1);
}
    public static int firstOccurance(int arr[], int k,int n) {
        if (n == arr.length) {
            return -1;
        }
        else if(arr[n] == k){
            return n; 
        }else{
            return firstOccurance(arr, k, n+1);
        }
    }
    public static int lastOccurance(int arr[], int k,int n) {
        if (n < 0) {
            return -1;
        }
        else if(arr[n] == k){
            return n; 
        }else{
            return firstOccurance(arr, k, n-1);
        }
    }
    public static int pow(int a ,int b) {
        if (b==1) {
            return a;
        }
        int c = a * pow(a, b-1);
        return c;
    }
    public static int power(int a , int b) {
        if (b==1) {
            return a;
        }
        if(b%2 == 0)
        {
           int c =  power(a, (b/2));
           c = c*c;
           return c;
        }
        else
            {
                int c = power(a, ((b-1)/2));
                c = a*c*c;
                return c;
             }
    }
    public static int tile(int n) {
        if(n==0 || n == 1)
        {
            return n;
        }
            int tw = tile(n-1)+tile(n-2);
        return tw; 
    }
    public static void dublicate(String str, int n , StringBuilder newstr, boolean arr[]) {
        if(n == str.length()){
            System.out.println(newstr);
            return;
        }
        int i = str.charAt(n) - 'a';
        if (arr[i] == true) {
            dublicate(str, n+1, newstr, arr);
        }else{
            arr[i] = true;
            dublicate(str, n+1, newstr.append(str.charAt(n)), arr);}
    }
    public static int friends(int n) {
        if (n==1 || n == 2) {
            return n;
        }
        int fn1 = friends(n-1);
        int fn2 = (n-1)*friends(n-2);
        return fn1 + fn2 ;
    }
    public static void printBinaryString(int n , int lastDigit , String str) {
        if (n == 0) {
            System.out.println(str);
            return;
        }
        printBinaryString(n-1, 0, str+"0");
        if (lastDigit == 0) {
            printBinaryString(n-1, 1, str+"1");
        }
    }
    //practice
    public static int numberOfOccurance(int arr[], int k,int n) {
        if (n == arr.length) {
            return -1;
        }
        else if(arr[n] == k){
            System.out.print(n + " ");
        }
         return numberOfOccurance(arr, k, n+1);
    }
    public static void numberConvertion(int num, String st[]) {
        if(num == 0){
            return;
        }
        int m = num%10;
        numberConvertion(num/10, st);
        System.out.print(st[m]+ " ");
    }
    public static void main(String[] args) {
        //int arr[] = new int[9];
        String st [] = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        //String str ="";
        //StringBuilder str = new StringBuilder();
        //StringBuilder newstr = new StringBuilder();
        //boolean arr[] = new boolean[26];
        //System.out.println(factorial(5));
        //System.out.println(naturalNumberSum(10));
        //System.out.println(fibonacci(5));
        //int arr[] = {3,2,4,5,6,2,7,2,2};
        //boolean s = sortedArray(arr, 0);
        //if (s) { System.out.println("The array is a sorted array");   
        //} else {System.out.println("The array is not a sorted array"); }
        //int k = firstOccurance(arr, 4, 0);
        //if (k >= 0) { System.out.println("The number first occured at the position :" + (k+1));   
        //} else {System.out.println("The number is not present in the array"); }
        //int s = lastOccurance(arr, 4, arr.length-1);
        //if (s >= 0) { System.out.println("The number last occured at the position :" + (s+1));   
        //} else {System.out.println("The number is not present in the array"); }
        //System.out.println(pow(5, 5));
        //System.out.println(power(2, 10));
        //dublicate("apnacollege", 0, newstr, arr);
        System.out.println(friends(2));
        //printBinaryString(5, 0, "");
        //numberOfOccurance(arr, 2, 0);
        numberConvertion(1940, st);
    }
}