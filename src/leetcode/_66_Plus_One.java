package leetcode;

/**
 * @author qianfang, at 2021/9/2, 上午12:25
 **/
/*
You are given a large integer represented as an integer array digits,
where each digits[i] is the ith digit of the integer.
The digits are ordered from most significant to least significant in left-to-right order.
The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.


 */
public class _66_Plus_One {
    public int[] plusOne(int[] digits) {
        int add = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + add;
            add = temp / 10;
            digits[i] = temp % 10;
            if (add == 0) {
                break;
            }
        }
        if (add > 0) {
            int[] res = new int[digits.length + 1];
            System.arraycopy(digits, 0, res, 1, digits.length);
            res[0] = 1;
            return res;
        } else {
            return digits;
        }
    }

    public static void main(String[] args) {
        _66_Plus_One plus_one = new _66_Plus_One();
        System.out.println(plus_one.plusOne(new int[]{9, 9, 9}));
    }
}
