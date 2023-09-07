import java.util.*;
public class Greedy {
    static class Job{
        int id;
        int deadline;
        int profit;

        public Job(int i, int d, int p){
            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String[] args) {
        //int start[] = {1, 3, 0, 5, 8, 5};
        //int end[] = {2, 4, 6, 7, 9, 9};
        //int activites[][] = new int [start.length][3];
        //for (int i = 0; i < start.length; i++) {
           // activites[i][0] = i;
           // activites[i][1] = start[i];
           // activites[i][2] = end[i];
        //}
        //Arrays.sort(activites,Comparator.comparingDouble(o -> o[2]));
        /*int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];
        for (int i = 0; i < end.length; i++) {
            if (lastEnd <= start[i]) {
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }
        System.out.println("Maximum Activites are "+ maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i)+ " ");
        }
        */
        /*int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int w = 50;
        double ratio[][] = new double[val.length][2];
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weight[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o->o[1]));
        int capacity = w;
        int fullVal = 0;
        for (int i = ratio.length -1 ; i >= 0; i--) {
           int idx = (int) ratio[i][0];
           if (capacity>= weight[idx]) {
              fullVal += val[idx];
              capacity -= weight[idx];
           } else {
            fullVal += (ratio[i][1]*capacity);
            capacity = 0;
            break;
           } 
        }
        System.out.println("final value = " + fullVal);
        */
        /*int A[] = {4, 1, 8, 7};
        int B[] = {2, 3, 6, 5};
        Arrays.sort(A);
        Arrays.sort(B);
        int minDiff = 0;
        for (int i = 0; i < A.length; i++) {
            minDiff += Math.abs(A[i]-B[i]);
        }
        System.out.println("Minimum absolute difference = " + minDiff);
        */
        /*int pairChain[][] = {{5,24}, {39,60}, {5,28}, {27,40}, {50,90}};
        Arrays.sort(pairChain,Comparator.comparingDouble(o -> o[1]));
        int maxChain = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        maxChain = 1;
        ans.add(0);
        int lastEnd = pairChain[0][1];
        for (int i = 0; i < pairChain.length; i++) {
                if (lastEnd < pairChain[i][0]) {
                    maxChain++;
                    ans.add(i);
                    lastEnd = pairChain[i][1];
                }
        }
        System.out.println("Maximum chainlength is = "+ maxChain);
        */
        /*Integer currency[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        Arrays.sort(currency, Comparator.reverseOrder());
        int countOfCurrency = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        int amount = 1059;
        for (int i = 0; i < currency.length; i++) {
            if (currency[i]<= amount) {
                while (currency[i]<= amount) {
                    countOfCurrency++;
                    amount -= currency[i];
                    ans.add(currency[i]);
                }
            }
        }
        System.out.println("Number of currency used = " + countOfCurrency);
        System.out.println("Currency used = " + ans);
        */
        /*int deadline[] = {4,1,1,1};
        int profit[] = {20,10,40,30};
        ArrayList<Integer> ans = new ArrayList<>();
        int jobs[][] = new int[profit.length][3];
        for (int i = 0; i < profit.length; i++) {
            jobs[i][0] = i;
            jobs[i][1] = deadline[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs,Comparator.comparingDouble(o -> o[2]));
        int max = 0;
        int totalProfit = 0;
        for (int i = jobs.length-1; i >= 0; i--) {
            if (jobs[i][1]>max) {
                ans.add((jobs[i][0]+1));
                max++;
                totalProfit += jobs[i][2];
            }
        }
        System.out.println("Total profit will be = " + totalProfit);
        System.out.println("Jobs done = " + ans);
        */
        /*int jobInfo[][] = {{4,20}, {1,10}, {1,40}, {1,30}};
        ArrayList<Job> jobs = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(i,jobInfo[i][0],jobInfo[i][1]));
        }
        Collections.sort(jobs, (obj1, obj2)-> obj2.profit-obj1.profit);
        int max = 0;
        int totalProfit = 0;
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline>max) {
                ans.add(curr.id);
                max++;
                totalProfit += curr.profit;
            }
        }
        System.out.println("Total profit will be = " + totalProfit);
        System.out.println("Jobs done = " + ans);
        */
        //int n = 4, m = 6;
        Integer verCost[] = {2, 1, 3, 1, 4};
        Integer horCost[] = {4, 1, 2};
        Arrays.sort(verCost, Collections.reverseOrder());
        Arrays.sort(horCost, Collections.reverseOrder());
        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;
        while (h < horCost.length && v < verCost.length) {
            if (verCost[v] <= horCost[h]) {
                cost += (horCost[h] *vp);
                h++;
                hp++;
            } else {
                cost += (verCost[v]*hp);
                v++;
                vp++;
            }
        }
        while (h < horCost.length) {
                cost += (horCost[h] *vp);
                h++;
                hp++;
        }
        while (v < verCost.length) {
                cost += (verCost[v]*hp);
                v++;
                vp++;
        }
        System.out.println("Minimumn cost of cuts = " + cost);
    }
}
