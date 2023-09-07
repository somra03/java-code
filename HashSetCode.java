import java.util.*;

public class HashSetCode {
    public static void main(String[] args) {
        String str[][] = {{"Chennai","Bengaluru"},
                          {"Mumbai", "Delhi"},
                          {"Goa", "Chennai"},
                          {"Delhi", "Goa"}
                          };

        HashMap<String , String> fromTo = new HashMap<>();
        HashMap<String , String> toFrom = new HashMap<>();
        LinkedHashSet<String> ans = new LinkedHashSet<>();
        for (int i = 0; i < str.length; i++) {
            fromTo.put(str[i][0], str[i][1]);
            toFrom.put(str[i][1], str[i][0]);
        }
        String start = "null";
        for (String key : fromTo.keySet()) {
            if (!toFrom.containsKey(key)) {
                start = key;
            }
        }
        System.out.print(start);
        for (String key : fromTo.keySet()) {
            System.out.print(" -> "+fromTo.get(start));
            start = fromTo.get(start);
        }
        /*int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};
        HashSet<Integer> union = new HashSet<>();
        HashSet<Integer> ints = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            union.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (union.contains(arr2[i])) {
                ints.add(arr2[i]);
            }
            else
            union.add(arr2[i]);
        }

        System.out.println("Elements in union = " + union.size());
        System.out.println("Union elements of both the array is = " + union);
        System.out.println("Elements in Intersection = " + ints.size());
        System.out.println("Intersection elements of both the array is = " + ints);
        *//*HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(12);
        set.add(5);
        set.add(2);
        set.add(8);
        set.add(9);
        set.add(null);

        System.out.println(set);

        LinkedHashSet<Integer> lset = new LinkedHashSet<>();
        lset.add(1);
        lset.add(12);
        lset.add(5);
        lset.add(2);
        lset.add(8);
        lset.add(9);
        lset.add(null);

        System.out.println(lset);

        TreeSet<Integer> tset = new TreeSet<>();
        tset.add(1);
        tset.add(12);
        tset.add(5);
        tset.add(2);
        tset.add(8);
        tset.add(9);

        System.out.println(tset);
        */
        //System.out.println(set.size());
        //set.clear();
        //System.out.println(set.isEmpty());
        /*Iterator itr = set.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + ", ");
        }
        for (int i : set) {
            System.out.print( i + ", ");
        }*/
    }
}
