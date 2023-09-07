import java.util.*;
public class Heaps {
    static class Heap{
        static ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data) {
            arr.add(data);
            int x = arr.size()-1;
            int par = (x-1)/2;
            while (arr.get(x) < arr.get(par)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x-1)/2;
            }
        }
        public int peek() {
            return arr.get(0);
        }
        public int remove(){
            int data = arr.get(0);

            int temp = arr.get(0);
                arr.set(0, arr.get(arr.size()-1));
                arr.set(arr.size()-1, temp);

            arr.remove(arr.size()-1); 
            
            heapify(0);
            return data;   
        }
        private static void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }
            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }
            if (minIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
                heapify(minIdx);
            }
        }
        public boolean isEmpty() {
            return arr.size() == 0;
        }
        public void heapsort(int arr[]) {
            int n = arr.length;
            for (int i = n/2; i >= 0; i--) {
                heapifyy(arr,i,n);
            }
            for (int i = n-1 ; i > 0; i--) {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                heapifyy(arr,0, i);
            }
        }
        private static void heapifyy(int arr[], int i, int n) {
            int left = 2*i+1;
            int right = 2*i+2;
            int maxIdx = i;
            if (left < n && arr[maxIdx] < arr[left]) {
                maxIdx = left;
            }
            if (right < n && arr[maxIdx] < arr[right]) {
                maxIdx = right;
            }
            if (maxIdx != i) {
                int temp = arr[i];
                arr[i] = arr[maxIdx];
                arr[maxIdx] = temp;
                heapifyy(arr,maxIdx,n);
            }
        }
    }
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2){
            return this.distSq - p2.distSq;
        }
    }
    static class Rows implements Comparable<Rows>{
        int soldier;
        int idx;

        public Rows(int soldier, int idx){
            this.soldier = soldier;
            this.idx = idx;
        }

        @Override
        public int compareTo(Rows r2) {
            if (this.soldier == r2.soldier) {
                return this.idx - r2.idx;
            }
            return this.soldier - r2.soldier;
        }
    }
    static class Pair implements Comparable<Pair>{
        int val;
        int idx;
        public Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p){
            return p.val - this.val;
        }
    }
    public static void main(String[] args) {
        /*Heap h =new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
        *//*
        int arr[] = {1, 2, 4, 5, 3};
        Heap h = new Heap();
        h.heapsort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();*//* 
        int pts[][] = {{3,3} , {5 , -1} , {2 , 4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < pts.length; i++) {
            int distSq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1] ;
            pq.add(new Point(pts[i][0], pts[i][1], distSq , i));
        }
        //System.out.println(pq);
        while (k != 0) {
            System.out.println(pq.peek().idx+1 +" "+ pq.peek().distSq);
            pq.remove();
            k--;
        }
        *//*
        int ropes[] = {2,3,3,4,6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0;
        while (pq.size()>1) {
            int min1 = pq.remove();
            int min2 = pq.remove();
            int newCost = min1 +min2;
            cost += newCost;
            pq.add(newCost);
        }
        System.out.println("Minimum cost of the ropes : " + cost);
        *//* 
        int arr[][] = {{1, 0, 0, 0},
                       {1, 1, 1, 1},
                       {1, 0, 0, 0},
                       {1, 0, 0, 0}};

        int k = 2;

        PriorityQueue<Rows> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int index = 0; index < arr[0].length; index++) {
                count += arr[i][index] == 1 ? 1 : 0;
            }
            pq.add(new Rows(count, i));
        }
        while (k != 0) {
            System.out.println("S"+pq.peek().idx +" "+ pq.peek().soldier);
            pq.remove();
            k--;
        }*/
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int res[] = new int[arr.length-k+1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }
        res[0] = pq.peek().val;

        for (int i = k; i < arr.length; i++) {
            while (pq.size() >0 && pq.peek().idx <= (i -k)) {
                pq.remove();
            }
            pq.add(new Pair(arr[i], i));
            res[i-k+1] = pq.peek().val;
        }

        for (int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }
    }
}
