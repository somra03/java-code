public class BitManipulation {
    public static void oddEven(int i) {
        int k = i&1;
        if (k == 1) {
            System.out.println("The number is an odd number");
        } else {
            System.out.println("The number is an even number");
        }
    }
    public static void getithBit(int n, int i) {
        int k = n & (1<<i) ;
        if (k != 0) {
            System.out.println("The ith bit is 1");
        } else {
            System.out.println("The ith bit is 0");
        }
    }
    public static void setithBit(int n, int i) {
        n = n | (1<<i);
         System.out.println(n);
    }
    public static void clearithBit(int n ,int i) {
        n = n & (~(1<<i));
        System.out.println(n);
    }
    public static void updateithBit(int n, int i , int j) {
        if (j==0) {
            clearithBit(n, i);
        } else {
            setithBit(n, i);
        }
    }
    public static void clearLastiBit(int n, int i) {
        n = n & ((~0)<<i);
        System.out.println(n);
    }
    public static void clearRangeOfBit(int n, int i ,int j) {
        int a = ((~0)<<j+1);
        int b = (1<<i)-1;
        n = n & (a|b);
        System.out.println(n);
    }
    public static void powerOfTwo(int n) {
        int k = n & (n-1);
        if (k==0) {
            System.out.println("The number is a power of 2");
        } else {
            System.out.println("The number is not a power of 2");
        }
    }
    public static void setBits(int n) {
        int count = 0;
        while (n>0) {  
            if ((n & 1) == 1) {
                count++;
            }
            n = n>>1;
        }
        System.out.println("The number of set bit present is : " + count);
    }
    public static void fastExpo(int a, int n) {
        int ans = 1;
        while (n>0) {  
            if ((n & 1) == 1) {
                ans = ans*a;
            }
            a = a*a;
            n = n>>1;
        }
        System.out.println(ans);
    }
    //Assignment
    public static void toLowerCase(char ch) {
       ch = (char) (ch|32);
       System.out.print(ch + " ");
    }
    public static void power(int n) {
        int ans = 1;
        int a = n;
        while (n>0) {  
            if ((n & 1) == 1) {
                ans = ans*a;
            }
            a = a*a;
            n = n>>1;
        }
        System.out.println(ans);
    }
    public static void swap(int x , int y) {
        System.out.println("Before Swap X : " + x + " and Y : " + y);
        x = x^y;
        y = x^y;
        x = x^y;
        System.out.println("After Swap X : " + x + " and Y : " + y);
    }
    public static void addOne(int n) {
        System.out.println("X after adding 1 is : " + -~n);
    }
    public static void main(String[] args) {
        //System.out.println(5&6);
        //System.out.println(5|6);
        //System.out.println(5^6);
        //System.out.println(~6);
        //System.out.println(5<<6);
        //System.out.println(5>>2);
        //oddEven(8);
        //getithBit(11, 2);
        //setithBit(10, 2);
        //clearithBit(10, 1);
        //updateithBit(10, 2, 1);
        //clearLastiBit(15, 2);
        //clearRangeOfBit(10, 2, 4);
        //powerOfTwo(8);
        //setBits(16);
        //fastExpo(2, 6);
        //toLowerCase('J');
        //power(3);
        //swap(3, 0);
        addOne(3);
    }
}
