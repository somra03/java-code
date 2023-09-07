public class AVLTrees {
    static class Node{
        int data;
        int height;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            height = 1;
            this.left = null;
            this.right = null;
        }
    }
    public static Node root;
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }  
    static int max(int a, int b){
        return (a > b) ? a:b;
    }
    public static Node rightRotation(Node y){
        Node x = y.left;
        Node t2 = x.right;

        // perform rotation
        x.right = y;
        y.left = t2;

        // update height
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return x;
    }
    public static Node leftRotation(Node x){
        Node y = x.right;
        Node t2 = y.left;

        // perform rotation
        y.left = x;
        x.right = t2;

        // update height
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + ", ");
        preorder(root.left);
        preorder(root.right);
    }
    public static int getBalance(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }
    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (root.data<key) {
            root.right = insert(root.right, key);
        } else if (root.data>key) {
            root.left = insert(root.left, key);
        } else {
            return root;
        }

        root.height = 1 + Math.max(height(root.left), height(root.right));

        int bf = getBalance(root);

        //left left case
        if (bf>1 && key < root.left.data) {
            return rightRotation(root);
        } 

        //right right case
        if (bf< -1 && key > root.right.data) {
            return leftRotation(root);
        }

        //left right case
        if (bf>1 && key > root.left.data) {
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }

        //right left case
        if (bf<-1 && key < root.right.data) {
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }

        return root;
    }
    public static Node getMinNode(Node root) {
        Node curr = root;
        //Minimum value is at the left most node

        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
    public static Node deleteNode(Node root, int key) {
        if (root == null) {
            return root;
        }

        // if the value lies in left
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        }
        //if the values lies in right
        else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } 
        // if the value is found
        else {
            // node with only one child or no child
            if ((root.left) == null || (root.right == null)) {
                Node temp = null;
                if (temp == root.left) {
                    temp = root.right;
                } else {
                    temp = root.left;
                }
                // no child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } 
                // one child case
                else {
                    root = temp; // copy the content of non empty child 
                }
            } else {
                Node temp = getMinNode(root.right);
                root.data = temp.data;
                root.right = deleteNode(root.right, temp.data);
            }
        }
        if (root == null) {
            return root;
        }

        root.height = 1 + Math.max(height(root.left),height(root.right));

        int bf = getBalance(root);

        if (bf > 1 && getBalance(root.left) >= 0) {
            return rightRotation(root);
        }
        if (bf > 1 && getBalance(root.left) <= 0) {
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }
        if (bf < -1 && getBalance(root.right) <= 0) {
            return leftRotation(root);
        }
        if (bf < -1 && getBalance(root.left) >= 0) {
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }
        
        return root;
    }
    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        preorder(root);
        deleteNode(root, 10);
        preorder(root);
    }
}
