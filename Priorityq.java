/*import java.util.Comparator;*/
import java.util.PriorityQueue;
public class Priorityq {
    static class Student implements Comparable<Student>{
        String name;
        int rank;
        
        public Student(String name , int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank ;
        }
    }
    public static void main(String[] args) {
        //PriorityQueue<Integer> pq = new PriorityQueue<>();// use Comparator.reverseOrder() for reversing the order
        PriorityQueue<Student> pq = new PriorityQueue<>();
        /*pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(7);

        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove();
        }
        */
        pq.add(new Student("a", 4));
        pq.add(new Student("b", 5));
        pq.add(new Student("c",2));
        pq.add(new Student("d",12));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + " -> " + pq.peek().rank);
            pq.remove();
        }
    }
}
