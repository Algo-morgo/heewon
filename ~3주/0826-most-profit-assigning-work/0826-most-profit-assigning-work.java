import java.util.*;
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        
         int n = difficulty.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(difficulty[i], profit[i]);
        }
        
        
        Arrays.sort(worker);
        Arrays.sort(jobs, (a, b) -> a.difficulty - b.difficulty);
        
        int maxProfit = 0, totalProfit = 0, i = 0;
        for (int ability : worker) {
            while (i < n && jobs[i].difficulty <= ability) {
                maxProfit = Math.max(maxProfit, jobs[i].profit);
                i++;
            }
            totalProfit += maxProfit;
        }
        
        return totalProfit;
    }
    
    class Job {
        int difficulty;
        int profit;
        
        Job(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }
}