package aimtooffer;

/**
 * @author qianfang, at 2019-09-05, 10:29
 * <p>
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 **/
public class NumberOf1 {
    public int numberOf1(int n) {
        int res = 0;
        while (n != 0) {
            n = (n - 1) & n;
            res++;
        }
        return res;
    }
}
