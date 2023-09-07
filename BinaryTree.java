import java.util.*;
public class BinaryTree {
    static class Info{
        int diameter;
        int height;
        Info(int d, int h){
            diameter = d;
            height = h;
        }
    }
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
    static class Binarytree{
        static int idx = -1;
        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
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
        public static void inOrder(Node root) {
            if (root==null) {
                //System.out.print(-1 + ", ");
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + ", ");
            inOrder(root.right);
        }
        public static void postOrder(Node root) {
            if (root==null) {
                //System.out.print(-1 + ", ");
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + ", ");
        }
        public static void levelOrder(Node root) {
            if (root==null) {
                //System.out.print(-1 + ", ");
                return;
            } 
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
        public static int height(Node root) {
            if (root == null) {
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            int mh = Math.max(lh, rh)+1;
            return mh;
        }
        public static int count(Node root) {
            if (root == null) {
                return 0;
            }
            int leftCount = count(root.left);
            int rightCount = count(root.right);
            int totalCount = leftCount + rightCount + 1;
            return totalCount;
        }
        public static int sum(Node root) {
            if (root == null) {
                return 0;
            }
            int leftSum = sum(root.left);
            int rightSum = sum(root.right);
            int totalSum = leftSum + rightSum + root.data;
            return totalSum;
        }
        public static int diameter2(Node root) {
            if (root==null) {
                return 0;
            }
            int rootDiameter = height(root.left)+height(root.right)+1;
            int leftDiameter = diameter2(root.left);
            int rightDiameter = diameter2(root.right);
            int diameter = Math.max(Math.max(leftDiameter, rightDiameter), rootDiameter);
            return diameter;
        }
        public static Info diameter(Node root) {
            if (root == null) {
                return new Info(0, 0);
            }
            Info leftInfo = diameter(root.left);
            Info rightInfo = diameter(root.right);
            int diameter = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), leftInfo.height+rightInfo.height+1);
            int height = Math.max(leftInfo.height, rightInfo.height)+1;
            return new Info(diameter, height);
        }
    }
    public static boolean isSubTree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if (isIdentical(root , subRoot)) {
                return true;
            }
        }
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }
    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        }
        else if(node == null || subRoot == null || node.data != subRoot.data)
        {
            return false;
        }
        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }
         if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }
        return true;
    }
    static class Information{
        Node node;
        int hd;

        Information(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topView(Node root){
        Queue<Information> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max= 0;
        q.add(new Information(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Information curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            }
            else{
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }
    
                if (curr.node.left != null) {
                    q.add(new Information(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
    
                if (curr.node.right != null) {
                    q.add(new Information(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }

        for (int i = min; i <= max ; i++) {
            System.out.print(map.get(i).data + " ");
        }
    }
    public static void klevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data + " ");
            return ;
        }
        klevel(root.left, level+1, k);
        klevel(root.right, level+1, k);
    }
    public static Node lca(Node root, int n1 , int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }
        Node lca = path1.get(i-1);
        return lca;
    }
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }
        path.add(root);

        if (root.data == n) {
            return true;
        }
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft||foundRight) {
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public static Node lca2(Node root, int n1 , int n2){
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node left = lca2(root.left, n1, n2);
        Node right = lca2(root.right, n1, n2);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
    public static int minDist(Node root, int n1 , int n2){
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);
        return dist1 + dist2;
    }
    public static int lcaDist(Node root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);
        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }
    public static int kAncestor(Node root, int n, int k){
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftA = kAncestor(root.left, n, k);
        int rightA = kAncestor(root.right, n, k);

        if (leftA == -1 && rightA == -1) {
            return -1;
        }

        int max = Math.max(leftA, rightA);
        if (max+1 == k) {
            System.out.println(root.data);
        }
        return max+1;
    }
    public static int transform(Node root){
        if (root == null) {
            return 0;
        }
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);
        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;
        root.data = newLeft + leftChild + newRight + rightChild;
        return data;
    }
    public static void main(String[] args) {
        //int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6 ,-1, -1};
        //Binarytree tree = new Binarytree();
        //Node root = tree.buildTree(nodes);
        //tree.preOrder(root);
        //tree.inOrder(root);
        //tree.postOrder(root);
        //tree.levelOrder(root);
        //System.out.println(root.data);
        //System.out.println("Height of the tree : " + tree.height(root));
        //System.out.println("Total Count of Nodes : " + tree.count(root));
        //System.out.println("Sum of nodes : " + tree.sum(root));
        //System.out.println("Diameter of the Tree : " + tree.diameter2(root));
        //System.out.println("Diameter of the Tree : " + tree.diameter(root).diameter);
        //System.out.println("Height of the Tree : " + tree.diameter(root).height);
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        //Node subRoot = new Node(2);
        //subRoot.left = new Node(4);
        //subRoot.right = new Node(5);
        //System.out.println(isSubTree(root, subRoot));
        //topView(root);
        //klevel(root, 1, 4);
        //System.out.println(lca(root, 4, 7).data);
        //System.out.println(lca2(root, 6, 7).data);
        //System.out.println(minDist(root, 4, 6));
        //kAncestor(root, 6, 1);
        transform(root);
        //tree.preOrder(root);
    }
}
