package aimtooffer;

/**
 * @author qianfang, at 2019-09-16, 09:26
 * <p>
 * 从1 到 n 中1出现的次数
 **/
public class NumberOf1Between1AndN {
    /*
    设N = abcde ,其中abcde分别为十进制中各位上的数字。
    如果要计算百位上1出现的次数，它要受到3方面的影响：百位上的数字，百位以下（低位）的数字，百位以上（高位）的数字。
    ① 如果百位上数字为0，百位上可能出现1的次数由更高位决定。
        比如：12013，则可以知道百位出现1的情况可能是：100~199，1100~1199,2100~2199，，...，11100~11199，一共1200个。
        可以看出是由更高位数字（12）决定，并且等于更高位数字（12）乘以 当前位数（100）。
    ② 如果百位上数字为1，百位上可能出现1的次数不仅受更高位影响还受低位影响。
        比如：12113，则可以知道百位受高位影响出现的情况是：100~199，1100~1199,2100~2199，，....，11100~11199，一共1200个。
        和上面情况一样，并且等于更高位数字（12）乘以 当前位数（100）。但同时它还受低位影响，百位出现1的情况是：12100~12113,一共114个，
        等于低位数字（113）+1。
    ③ 如果百位上数字大于1（2~9），则百位上出现1的情况仅由更高位决定，
        比如12213，则百位出现1的情况是：100~199,1100~1199，2100~2199，...，11100~11199,12100~12199,一共有1300个，
        并且等于更高位数字+1（12+1）乘以当前位数（100）。
    */

    public int numberOf1Between1AndN(int n) {
        if (n < 1) {
            return 0;
        }
        int res = 0;
        int base = 1;
        while (base <= n) {
            // 当前数字
            int in = n / base % 10;
            // 前面数字
            int pre = n / (base * 10);
            // 后面数字
            int after = n - (n / base) * base;

            if (in < 1) {
                res += pre * base;
            } else if (in == 1) {
                res += pre * base + after + 1;
            } else {
                res += (pre + 1) * base;
            }

            base *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1Between1AndN().numberOf1Between1AndN(1));
    }
}
