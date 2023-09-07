import java.util.*;
public class Stacks {
    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                s.push(ch);
            }else{
                if (s.empty()) {
                    return false;
                }
                if ((ch == ')' && s.peek()=='(') || (ch == ']' && s.peek()=='[') || (ch == '}' && s.peek()=='{')) {
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        if (s.empty()) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isDublicate(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ')') {
                int count = 0;
                while (s.pop()!= '(') {
                    count++;
                }
                if (count<1) {
                    return true;
                }
            }else{
                s.push(ch);
            }
        } 
        return false;  
    }
    /*static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class StackA{
        static ArrayList<Integer> list = new ArrayList<>();
        public static int pop() {
            if(isempty())
            {
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        } 
        public static void push(int data) {
            list.add(data);
        }
        public static int peek() {
            if(isempty())
            {
                return -1;
            }
            return list.get(list.size()-1);
        }
        public static boolean isempty() {
            return list.size()==0;
        }
    }
    static class StackL{
        static Node head = null;
        static LinkedList<Integer> list = new LinkedList<>();
        public static int pop() {
            if(isempty())
            {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        } 
        public static void push(int data) {
            Node newNode = new Node(data);
            if(isempty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
        public static int peek() {
            if(isempty())
            {
                return -1;
            }
            return head.data;
        }
        public static boolean isempty() {
            return head==null;
        }
    }
    */
    public static void pushAtBottom(Stack<Integer> s ,int data) {
        if (s.empty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder();
        while (!s.empty()) {
            char curr = s.pop();
            result.append(curr);
        }
        str = result.toString();
        return str;
    }
    public static void reverseStack(Stack<Integer> s){
        if (s.empty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }
    public static void stockSpan(int[] stocks, int[] spans) {
        Stack<Integer> s = new Stack<>();
        spans[0] = 1;
        s.push(0);
        for (int i = 1; i < spans.length; i++) {
           int currentPrice = stocks[i];
           while (!s.empty() && currentPrice > stocks[s.peek()]) {
            s.pop();
           } 
           if (s.empty()) {
             spans[i] = i+1;
           }else{
            int prevHigh = s.peek();
            spans[i] = i-prevHigh;
           }
           s.push(i);
        }
    }
    public static void main(String[] args) {
    //String str = "((a+b)+((c+d)))";
    //int arr[] = {2,4};
    //int arr[] = {3,1,5,6,2,3};
    /*int arr[] = {6,8,0,1,3};
     Stack<Integer> s = new Stack<>();
     int nxtGreater[] = new int[arr.length];
     for (int i = arr.length-1; i >= 0 ; i--) {
        while (!s.empty()  && arr[s.peek()]<= arr[i]) {
            s.pop();
        }
        if (s.empty()) {
            nxtGreater[i] = -1;
        } else {
            nxtGreater[i] = arr[s.peek()];
        }
        s.push(i);
     }
     for (int index = 0; index < nxtGreater.length; index++) {
        System.out.print(nxtGreater[index] + " ");}
        */
        //System.out.println(isValid(str));
        //System.out.println(isDublicate(str));
        /*Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        int nxtGreater[] = new int[arr.length];
        for (int i = arr.length-1; i >= 0 ; i--) {
        while (!s.empty()  && arr[s.peek()]>= arr[i]) {
            s.pop();
        }
        if (s.empty()) {
            nxtGreater[i] = arr.length;
        } else {
            nxtGreater[i] = s.peek();
        }
        s.push(i);
    }
        s = new Stack<>();
        int nxtSmaller[] = new int[arr.length];
        for (int i = 0; i < arr.length ; i++) {
        while (!s.empty()  && arr[s.peek()]>= arr[i]) {
            s.pop();
        }
        if (s.empty()) {
            nxtSmaller[i] = -1;
        } else {
            nxtSmaller[i] = s.peek();
        }
        s.push(i);
    }
        for (int i = 0; i < arr.length; i++) {
            int index = nxtGreater[i] - nxtSmaller[i]-1;
            int currentArea = arr[i]*index;
            maxArea = Math.max(maxArea, currentArea);
        }
        System.out.println("maximum area of histogram is : " + maxArea);*/
        //StackA s = new StackA();
        //StackL s = new StackL();
        /*Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        //pushAtBottom(s, 0);
        reverseStack(s);
        while (!s.empty()) {
            System.out.println(s.pop());
        }*/
        //System.out.println(reverseString("abc"));
        int stocks[] = {100,80,60,70,60,85,100};
        int spans[] = new int[stocks.length];
        stockSpan(stocks,spans);
        for (int i = 0; i < spans.length; i++) {
            System.out.print(spans[i]+ " ");
        }
 }
}