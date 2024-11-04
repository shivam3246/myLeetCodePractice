//https://leetcode.com/problems/perfect-squares/
import java.util.*;
public class perfSquares {
    //1st attempt this is solved using recursion and will give TLE
    // public static int numSquares(int n) {
    //     if(n<4)
    //     return n;
    //     int ans = n;
    //     for(int i = 1;i*i<=n;i++){
    //         int square = i*i;
    //         ans = Math.min(ans,1+numSquares(n-square));
    //     }
    //     return ans;
        
    // }
//Approach 2 recursion + memoization[Top-Down] Approach T.C O(n*sqrt(n)) S.C = O(n)
    // public static int numSquares(int n) { 
    //    int memo[] = new int[n+1];
    //    return helper(n,memo);
    // }
    // private static int helper(int n,int []memo){
    //     if(n<4){
    //         return n;
    //     }
    //     if(memo[n]!=0)
    //     return memo[n];
    //     int ans = n;
    //     for(int i = 1;i*i<=n;i++){
    //         int square = i*i;
    //         ans = Math.min(ans,1+helper(n-square,memo));
    //     }
    //     return memo[n] = ans;
    // }
    //3 Bottom up approach using dp array
    // public static int numSquares(int n) {
    //     int dp[] = new int[n+1];
    //     dp[0] = 0;
    //     for(int i=1;i<=n;i++){
    //         dp[i]=i;
    //         for(int j=1;j*j<=i;j++){
    //             int square = j*j;
    //             dp[i] = Math.min(dp[i],1+dp[i-square]);
    //         }
    //     }
    //     return dp[n];
    // }
    //Using legrange's 4 Square's Theorem T.C = O(sqrt(N))
    public static int numSquares(int n) {
        int sqrt = (int)Math.sqrt(n);
        if(sqrt*sqrt==n)
        return 1; //this will be perfect square
        while(n%4==0) //4^a(8b+7)
        n = n/4;

        if(n%8==7){
            return 4;
        }
        for (int i = 1; i * i <= n; i++) { // Sum of two perfect squares
            int square = i * i;
            int base = (int) Math.sqrt(n - square);
    
            if (base * base == n - square)
                return 2;
        }
    
        return 3;
    }
    public static void main(String[] args) {
        int n = 12;
        int ans = numSquares(n);
        System.out.print(ans);
        
    }
}
