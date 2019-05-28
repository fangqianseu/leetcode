/*
Date:05.28,2019 23:11
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
calculate the number of 1's in their binary representation and return them as an array.
*/
package leetcode;

public class _338_CountingBits {
    /**
     * f[1] = (f[0]==0) + (1%1==1) = 1
     * f[11] = (f[1]==1) + (11%1==1)  = 2
     * f[110] = (f[11]==2) + (110%1==0) = 2
     * f[1101] = (f[110] ==2) + (1101%1==1) =3
     * <p>
     * f[i] = f[i/2] + i%2
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i >> 1] + (1 & i);
        }
        return dp;
    }
}
