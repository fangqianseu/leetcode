package aimtooffer;

/**
 * @author qianfang, at 2019-09-06, 10:08
 * <p>
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 **/
public class Power {
    // 递归法
    public double power(double base, int exponent) {
        boolean sign = exponent >= 0;

        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        double res = power(base, Math.abs(exponent) >> 1);
        res *= res;

        // 注意 指数为奇 则* 一次base
        if (exponent % 2 != 0) {
            res *= base;
        }

        return sign ? res : 1 / res;
    }

    // 累乘法 通过分解指数的二进制 如 13次方 为 1101, 对应位的累乘结果相乘
    public double fastPower(double base, int exponent) {
        boolean sign = exponent >= 0;

        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        exponent = Math.abs(exponent);
        double temp = base;
        double res = 1.0;

        while (exponent > 0) {
            if (exponent % 2 != 0) {
                res = res * temp;
            }
            exponent = exponent >> 1;
            temp *= temp;
        }

        return sign ? res : 1 / res;
    }

    public static void main(String[] args) {
        Power power = new Power();
        System.out.println(power.fastPower(2.0, 13));
    }
}
