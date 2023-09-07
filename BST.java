import java.util.*;
public class BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    } 
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST,int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    public static void inOrder(Node root) {
        if (root==null) {
            //System.out.print(-1 + ", ");
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + ", ");
        inOrder(root.right);
    }
    public static Node insert(Node root, int val){
        if(root == null)
        {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val); 
        }
        return root;
    }   
    public static boolean search(Node root, int key){
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }else if (root.data < key) {
            search(root.right, key);
        }else {
            search(root.left, key);
        }
        return true;
    }
    public static Node delete(Node root, int val){
        if (root.data<val) {
            root.right = delete(root.right, val);
        }else if (root.data>val) {
            root.left = delete(root.left, val);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            } else if(root.right == null){
                return root.left;
            }
            Node Is = findInOrderSuccessor(root.right);
            root.data = Is.data;
            root.right = delete(root.right, Is.data);
        }
        return root;
    }
    public static Node findInOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    public static void printInRange(Node root, int k1, int k2){
        if (root == null) {
            return;
        }
        if (k1 <= root.data && root.data<= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data > k2) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }
    public static void printRoot2Leaf(Node root , ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            System.out.println(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);
    }
    public static boolean isValidBST(Node root, Node min , Node max){
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        }else if (max != null && root.data >= max.data) {
            return false;
        }
        return isValidBST(root.left, min , root) && isValidBST(root.right, root, max);
    }
    public static Node mirror(Node root) {
            if(root == null)
            {
                return root;
            }
            Node temp = null;
            temp = mirror(root.right);
            root.right = mirror(root.left);
            root.left = temp;
            return root;
    }
    public static void preOrder(Node root) {
        if (root==null) {
            //System.out.print(-1 + ", ");
            return;
        }
        System.out.print(root.data + ", ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static Node array2BBST(Node root, int arr[], int start, int end) {
        if (start>end) {
            return null;
        }
        int mid = (start+end)/2;
        if (root==null) {
            root = new Node(arr[mid]);
        }
        root.left = array2BBST(root.left, arr, start, mid-1);
        root.right = array2BBST(root.right, arr, mid+1, end);
        return root;
    }
    public static Node createBST(ArrayList<Integer> inorder, int start, int end) {
        if (start>end) {
            return null;
        }
        int mid = (start + end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, start, mid-1);
        root.right =createBST(inorder, mid+1, end);
        return root;
    }
    public static void getInOrder(Node root , ArrayList<Integer> inorder) {
        if (root==null) {
            return;
        }
        getInOrder(root.left, inorder);
        inorder.add(root.data);
        getInOrder(root.right, inorder);
    }
    public static Node balancedBST(Node root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        getInOrder(root, inorder);
        root = createBST(inorder, 0, inorder.size()-1);
        return root;
    }
    public static int maxBST = 0;
    public static Info largestBST(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(leftInfo.min, Math.min(root.data, rightInfo.min));
        int max = Math.max(leftInfo.max, Math.max(root.data, rightInfo.max));
        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }
        if (leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(size, maxBST);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }
    public static Node mergeBSTs(Node root, Node root1) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInOrder(root, arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        getInOrder(root1, arr2);

        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i<arr1.size() && j<arr2.size()) {
            if (arr1.get(i)<arr2.get(j)) {
                arr.add(arr1.get(i));
                i++;
            }else{
                arr.add(arr2.get(j));
                j++;
            }
        }
        while (i<arr1.size()) {
            arr.add(arr1.get(i));
            i++; 
        }
        while (j<arr2.size()) {
            arr.add(arr2.get(j));
                j++;
        }

        root = createBST(arr, 0, arr.size()-1);
        return root;
    }
    public static void main(String[] args) {
        //int values[] ={8,5,3,1,4,6,10,11,14};
        //int values[] = {1,1,1};
        /*int values[] = {8,10,5,6,11,3};
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        /*
        if (search(root, 1)) {
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }
        *//*
        inOrder(root);
        System.out.println();
        root = delete(root, 1);
        inOrder(root);
        System.out.println();
        root = delete(root, 10);
        inOrder(root);
        */
        //printInRange(root, 5, 11);
        //printRoot2Leaf(root, new ArrayList<>());
        /*if (isValidBST(root, null, null)) {
            System.out.println(" Is valid");
        } else {
            System.out.println(" Is not valid");
        }
        *//*
        inOrder(root);
        mirror(root);
        System.out.println();
        preOrder(root);
        *//*
        int arr[] = {3,5,6,8,10,11,12};
        Node root = null;
        root = array2BBST(root, arr, 0, arr.length-1);
        inOrder(root);
        System.out.println();
        preOrder(root);
        *//*
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        root = balancedBST(root);
        preOrder(root);
        *//*
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70); 
        root.right.right.left = new Node(65); 
        root.right.right.right = new Node(80); 
        Info info = largestBST(root);
        System.out.println("Max Size of the valid BST : " + maxBST);
        */
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(4);

        Node root1 = new Node(9);
        root1.left = new Node(3);
        root1.right = new Node(12);

        Node r = mergeBSTs(root, root1);
        inOrder(r);
        System.out.println();
        preOrder(r);
    }
}