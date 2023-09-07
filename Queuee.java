import java.util.*;
public class Queuee {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class Queuel{
        static Node head = null;
        static Node tail = null;
        public static boolean isempty() {
            return head == null && tail == null;
        }
        public static void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
            }
            tail.next = newNode;
            tail = newNode;
        }
        public static int remove() {
            if (isempty()) {
                System.out.println("Queue is empty ");
                return -1;
            }
            int front = head.data;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;   
            }
            return front;
        }
        public static int peek() {
            if (isempty()) {
                System.out.println("Queue is empty ");
                return -1;
            }
            return head.data;
           }
    }
    static class Queues{
       static int arr[];
       static int size;
       static int rear;
       Queues(int n) {
        arr = new int[n];
        size = n;
        rear = -1;
       }
       public static boolean isempty() {
        return rear == -1;
       }
       public static void add(int data) {
        if (rear == size-1) {
            System.out.println("Queue is full");
            return;
        }
        rear = rear+1;
        arr[rear] = data;
       }
       public static int remove() {
        if (isempty()) {
            System.out.println("Queue is empty ");
            return -1;
        }
        int front = arr[0];
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i+1];
        }
        rear--;
        return front;
       }
       public static int peek() {
        if (isempty()) {
            System.out.println("Queue is empty ");
            return -1;
        }
        return arr[0];
       }
    }
    static class CircularQueue{
        static int arr[];
        static int size;
        static int rear;
        static int front;
        CircularQueue(int n) {
         arr = new int[n];
         size = n;
         rear = -1;
         front = -1;
        }
        public static boolean isempty() {
         return rear == -1 && front == -1;
        }
        public static boolean isfull() {
            return (rear+1)%size == front;
        }
        public static void add(int data) {
         if (isfull()) {
             System.out.println("Queue is full");
             return;
         }
         if (front == -1) {
            front = 0;
         }
         rear = (rear+1)%size;
         arr[rear] = data;
        }
        public static int remove() {
         if (isempty()) {
             System.out.println("Queue is empty ");
             return -1;
         }
         int result = arr[front];
         if (rear == front) {
            rear = front = -1;
         } else {
            front = (front+1)%size;
         }
         return result;
        }
        public static int peek() {
         if (isempty()) {
             System.out.println("Queue is empty ");
             return -1;
         }
         return arr[front];
        }
     }
    static class StackQueue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();
        public static boolean isempty() {
            return s1.empty();
        }
        public static void add(int data) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.empty()) {
                s1.push(s2.pop());
            }
        }
        public static int remove() {
            if (s1.empty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.pop();
        }
        public static int peek(){
            if (s1.empty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.peek();
        }
     }
    static class QueueStack{
        static Queue<Integer> q1 = new LinkedList<>(); 
        static Queue<Integer> q2 = new LinkedList<>();
        public static boolean isempty() {
            return q1.isEmpty() && q2.isEmpty();
        }
        public static void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }
        public static int pop() {
            if (isempty()) {
                System.out.println("Empty stack");
                return -1;
            }
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                       break; 
                    }
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                       break; 
                    }
                    q1.add(top);
                }
            }
            return top;
        }
        public static int peek() {
            if (isempty()) {
                System.out.println("Empty stack");
                return -1;
            }
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }
    static class StackDeQue{
        static Deque<Integer> d = new LinkedList<>();
        public static boolean isempty() {
            return d.isEmpty();
        }
        public static void push(int data) {
            d.addLast(data);
        }
        public static int pop() {
            if (isempty()) {
                System.out.println("Empty stack");
                return -1;
            }
            return d.removeLast();
        }
        public static int peek() {
            if (isempty()) {
                System.out.println("Empty stack");
                return -1;
            }
            return d.getLast();
        }
    }
    static class QueueDeQue{
        static Deque<Integer> d = new LinkedList<>();
        public static boolean isempty() {
            return d.isEmpty();
        }
        public static void add(int data) {
            d.addLast(data);
        }
        public static int remove() {
            if (isempty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            return d.removeFirst();
        }
        public static int peek() {
            if (isempty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            return d.getFirst();
        }
    }
    public static void printNonRepeating(String str) {
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while (!q.isEmpty() && freq[q.peek()-'a']>1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.println(-1 + " ");
            } else {
                System.out.println(q.peek() + " ");
            }
        }
        System.out.println();
    } 
    public static void interleave(Queue<Integer> q) {
        Queue<Integer> first = new LinkedList<>();
        int size =  q.size();
        for (int i = 0; i <size/2; i++) {
            first.add(q.remove());
        }
        int firsts = first.size();
        for (int i = 0; i < firsts; i++) {
            q.add(first.remove());
            q.add(q.remove());
        }
    }   
    public static void queueReversal(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.empty()) {
            q.add(s.pop());
        }
    }
    public static void main(String[] args) {
        //String str = "aabccxb";
        //printNonRepeating(str);
        /*
        Queues q = new Queues(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while (!q.isempty()) {
            System.out.print(q.remove() + " ");
        }
        */
        /*
        CircularQueue q = new CircularQueue(4);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.remove());
        q.add(5);
        System.out.println(q.remove());
        q.add(6);
        while (!q.isempty()) {
            System.out.println(q.remove() + " ");
        }
        */
        /*
        Queuel q = new Queuel();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.remove());
        q.add(5);
        System.out.println(q.remove());
        q.add(6);
        while (!q.isempty()) {
            System.out.println(q.remove() + " ");
        }
        */
        //Queue<Integer> q = new LinkedList<>();
        //Queue<Integer> q = new ArrayDeque<>();
        /*
        StackQueue q = new StackQueue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while (!q.isempty()) {
            System.out.print(q.remove() + " ");
        }
        */
        /*
        QueueStack s = new QueueStack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        while (!s.isempty()) {
            System.out.println(s.pop());
        }
        */
        /*
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        interleave(q);
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
        */
        /*
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        queueReversal(q);
        System.out.println(q);
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
        */
        /*
        Deque<Integer> d = new LinkedList<>();
        d.addFirst(2);
        d.addFirst(1);
        d.addLast(3);
        d.addLast(4);
        System.out.println(d);
        d.removeLast();
        System.out.println(d);
        d.removeFirst();
        System.out.println(d);
        System.out.println(d.getFirst());
        System.out.println(d.getLast());
        */
        /*
        QueueDeQue q = new QueueDeQue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while (!q.isempty()) {
            System.out.print(q.remove() + " ");
        }
        */
        //System.out.println();
        /*
        StackDeQue s = new StackDeQue();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        while (!s.isempty()) {
            System.out.print(s.pop() + " ");
        }
        */
    }
}
