package leetcode;

/**
 * @author qianfang, at 2021/9/2, 上午12:42
 **/
/*
Given two binary strings a and b, return their sum as a binary string.
 */
public class _67_Add_Binary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int add = 0;
        for (; i >= 0 || j >= 0; i--, j--) {
            int aVal = 0;
            if (i >= 0) {
                aVal = Integer.parseInt(a.charAt(i) + "");
            }
            int bVal = 0;
            if (j >= 0) {
                bVal = Integer.parseInt(b.charAt(j) + "");
            }
            int temp = aVal + bVal + add;
            sb.append(temp % 2);
            add = temp / 2;
        }
        if (add > 0) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        _67_Add_Binary add_binary = new _67_Add_Binary();
        System.out.println(add_binary.addBinary("111", "10"));
    }
}
