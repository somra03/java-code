import java.util.HashMap;
import java.util.Set;

public class Hashmaps {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 100);
        hm.put("USA", 50);
        hm.put("China", 150);
        hm.put("Indonesia", 6);
        hm.put("Nepal", 5);

        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("Key = " + k + ",  Value = " + hm.get(k));
        }

        /*System.out.println(hm);

        int population = hm.get("India");
        System.out.println(population);

        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Indonesia"));

        hm.remove("China");
        hm.clear();
        System.out.println(hm);*/
    }
}
