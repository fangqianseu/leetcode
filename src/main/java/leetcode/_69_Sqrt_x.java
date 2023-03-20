package leetcode;

/**
 * @author qianfang, at 2021/9/3, 上午12:27
 **/
/*
Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 */
public class _69_Sqrt_x {

    public int mySqrtBest(int x) {
        if (x < 2) {
            return x;
        }
        int l = 0;
        int r = x;
        int res = 0;
        while (l < r) {
            int t = l + (r - l) / 2;
            if (t == x / t) {
                return t;
            }
            if (t < x / t) {
                l = t + 1;
                res = t;
            } else if (t > x / t) {
                r = t;
            }
        }
        return res;
    }

    public int mySqrt(int x) {
        for (int i = 1; i <= x / i; i++) {
            int temp = (i + 1);
            if (temp == x / temp) {
                return temp;
            } else if (temp > x / temp) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        _69_Sqrt_x sqrt_x = new _69_Sqrt_x();
        System.out.println(sqrt_x.mySqrtBest(8));
    }
}
