import java.util.*;
public class insertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
       List<int[]> result = new ArrayList<>();
       
       //Iterate through all slots
       for(int[] slot:intervals){
        //if newInterval before slot inset new interval
        if(newInterval[1]<slot[0]){
            result.add(newInterval);
            newInterval = slot;
        }
        //if slot is lesser than new Interval
        else if(slot[1]<newInterval[0])
        result.add(slot);

        //if above conditions fail it is an overlap
        else{
            newInterval[0] = Math.min(newInterval[0],slot[0]);
            newInterval[1] =Math.max(newInterval[1],slot[1]);

        }
       }
       //insert the last newInterval]
       result.add(newInterval);

       return result.toArray(new  int[result.size()][]);
    }
    public static void main(String[] args) {
        int [][]intervals = {{1,3},{6,9}}; 
        int []newInterval ={2,5};
        int ans[][] = new int[intervals.length][intervals[0].length];
       ans = insert(intervals, newInterval);
        System.out.print(Arrays.deepToString(ans));
    }
}
