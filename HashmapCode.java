import java.util.*;
public class HashmapCode {
   static class HashMaps<K, V>{
    private class Node{
        K key;
        V value;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    private int n;
    private int N;
    private LinkedList<Node> buckets[];

    @SuppressWarnings("unchecked")
    public HashMaps(){
        this.N = 4;
        this.buckets = new LinkedList[4];
        for (int i = 0; i < 4; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        int bi = hashFunction(key);
        int di = searchInLL(key,bi);

        if (di != -1) {
            Node node = buckets[bi].get(di);
            node.value = value;
        }else{
            buckets[bi].add(new Node(key, value));
            n++;
        }
        double lambda = (double)n/N;
        if (lambda>2.0) {
            rehas();
        }
    }

    private void rehas() {
        LinkedList<Node> oldBucket[] = buckets;
        buckets = new LinkedList[2*N];
        N = 2*N;
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
        for (int i = 0; i < oldBucket.length; i++) {
            LinkedList<Node> ll = oldBucket[i];
            for (int j = 0; j < ll.size(); j++) {
                Node node = ll.remove();
                put(node.key, node.value);
            }
        }
    }

    private int searchInLL(K key, int bi) {
        LinkedList<Node> ll = buckets[bi];
        int di = 0;
        for (int i = 0; i < ll.size(); i++) {
            Node node = ll.get(i);
            if (node.key == key) {
                return di;
            }
            di++;
        }
        return -1;
    }

    private int hashFunction(K key) {
        int hc = key.hashCode();
         return Math.abs(hc) % N;
    }

    public boolean containsKey(K key){
        int bi = hashFunction(key);
        int di = searchInLL(key,bi);

        if (di != -1) {
            return true;
        }else{
            return false;
        }
    }

    public V remove(K key){
        int bi = hashFunction(key);
        int di = searchInLL(key,bi);

        if (di != -1) {
            Node node = buckets[bi].remove(di);
            n--;
            return node.value;
        }else{
            return null;
        }
    }

    public V get(K key) {
        int bi = hashFunction(key);
        int di = searchInLL(key,bi);

        if (di != -1) {
            Node node = buckets[bi].get(di);
            return node.value;
        }else{
            return null;
        }
    }

    public ArrayList<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();
        for (int i = 0; i < buckets.length; i++) {
            LinkedList<Node> ll = buckets[i];
            for (Node node : ll) {
                keys.add(node.key);
            }
        }
        return keys;
    }

    public boolean isEmpty() {
        return n == 0;
    }
   } 
   public static Boolean isAnalog(String s, String t){
    HashMap<Character, Integer> hm = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
        hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0)+1);
    }
    for (int i = 0; i < t.length(); i++) {
        if (!hm.containsKey(t.charAt(i))) {
            return false;
        }
        if (hm.get(t.charAt(i)) == 1) {
            hm.remove(t.charAt(i));
        }
        else
        {
            hm.put(s.charAt(i), hm.get(t.charAt(i))-1);
        }
    }
        return hm.isEmpty();
   }
   public static void main(String[] args) {
    String s = "race";
    String t = "care";
    System.out.println(isAnalog(s, t));
    /*int arr[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
    HashMap<Integer, Integer> hm = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
        *//*if (hm.containsKey(arr[i])) {
            hm.put(arr[i], hm.get(arr[i])+1);
        } else {
            hm.put(arr[i], 1);
        }
        *//*
        hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
    }

    System.out.println(hm);
    for (Integer key : hm.keySet()) {
        if (hm.get(key)> arr.length/3) {
            System.out.println(key + " = " + hm.get(key));
        }
    }*/
    //HashMap<String, Integer> hm = new HashMap<>();
    /*LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
    
        lhm.put("India", 100);
        lhm.put("USA", 50);
        lhm.put("China", 150);
        lhm.put("Nepal", 5);
        System.out.println(lhm);

        HashMap<String, Integer> hm = new HashMap();
        hm.put("India", 100);
        hm.put("USA", 50);
        hm.put("China", 150);
        hm.put("Nepal", 5);
        System.out.println(hm);

        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 100);
        tm.put("USA", 50);
        m.put("China", 150);
        hm.put("Nepal", 5);

        *//*
        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key);
        }

        System.out.println(hm.get("India"));
        System.out.println(hm.remove("India"));
        System.out.println(hm.get("India"));*/
   }
}
