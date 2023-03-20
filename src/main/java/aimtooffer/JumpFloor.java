package aimtooffer;

/**
 * @author qianfang, at 2019-09-05, 09:45
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 **/
public class JumpFloor {
    public int JumpFloor(int target) {
        if (target < 3) {
            return target;
        }

        // 第 n 阶台阶 只能由 n-1 或者 n-2 跳上
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }
}
