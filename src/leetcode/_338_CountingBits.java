/*
Date:05.28,2019 23:11
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
calculate the number of 1's in their binary representation and return them as an array.
*/
package leetcode;

import java.util.Arrays;

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
        Arrays.fill(dp, 0);

        for (int i = 1; i < num + 1; i++) {

            //  f(1110) = f(111) + 个位数是否为1
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

    public static void main(String[] args) {
        _338_CountingBits countingBits = new _338_CountingBits();
        System.out.println(countingBits.countBits(5));
    }
}
