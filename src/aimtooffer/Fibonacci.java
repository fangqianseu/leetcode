package aimtooffer;

/**
 * @author qianfang, at 2019-09-05, 09:39
 * <p>
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 **/
public class Fibonacci {
    public int Fibonacci(int n) {
        if (n < 1) {
            return 0;
        }
        if (n < 3) {
            return 1;
        }

        int l = 1, r = 1;
        while (n-- > 2) {
            int s = l + r;
            l = r;
            r = s;
        }

        return r;
    }
}
