//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
import java.util.*;
public class longestIncreasingPathMatrix {
    public static int longestIncreasingPath(int[][] matrix) {
      if(matrix==null||matrix.length==0||matrix[0].length==0){
        return 0;
      }  
      int [][]cache = new int[matrix.length][matrix[0].length];
      int max = 0;
      for(int i = 0;i<matrix.length;i++){
        for(int j = 0;j<matrix[0].length;j++){
            int length = find(i, j, matrix, cache, Integer.MAX_VALUE);
            max = Math.max(length, max);
        }
      }
      return max;
    }
    public static int find(int i,int j,int [][]matrix,int [][]cache,int pre){
        //If out of bounds or current cell value ins more then prev cell value
        if(i<0||i>=matrix.length||j<0||j>=matrix[0].length||matrix[i][j]>=pre){
            return 0;
        }
        //if calculated before no need to calculate again
        if(cache[i][j]>0){
            return cache[i][j];
        }
        else{
            int curr = matrix[i][j];
            int tempMax = 0;
            tempMax = Math.max(find(i - 1, j, matrix, cache, curr), tempMax);
            tempMax = Math.max(find(i + 1, j, matrix, cache, curr), tempMax);
            tempMax = Math.max(find(i, j - 1, matrix, cache, curr), tempMax);
            tempMax = Math.max(find(i, j + 1, matrix, cache, curr), tempMax);
            cache[i][j] = ++tempMax;
            return tempMax;
        }
    }
    public static void main(String[] args) {
        int [][]matrix = {{9,9,4},{6,6,8},{2,1,1}};
        int ans = longestIncreasingPath(matrix);
        System.out.print(ans);
        
    }
}
