package leetcode;

/**
 * @author qianfang, at 2021/8/18, 下午11:56
 **/
/*
Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1],
then return 0.
 */
public class _7_Reverse_Integer {
    public int reverse(int x) {
        int res = 0;

        // 循环条件为 x != 0 包含负数场景
        // 因为负数最后为 -1 再到 0
        while (x != 0) {
            int temp = x % 10;
            x = x / 10;
            int newRes = res * 10 + temp;

            // 反向运算 避免溢出
            if ((newRes - temp) / 10 != res) {
                return 0;
            }
            res = newRes;
        }
        return res;
    }

    public static void main(String[] args) {
        _7_Reverse_Integer reverse_integer = new _7_Reverse_Integer();
        System.out.println(reverse_integer.reverse(1534236469));
    }
}
