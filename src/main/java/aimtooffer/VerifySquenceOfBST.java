package aimtooffer;

import java.util.Arrays;

/**
 * @author qianfang, at 2019-09-10, 10:47
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 **/
public class VerifySquenceOfBST {
    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }

        if (sequence.length < 3) {
            return true;
        }

        int val = sequence[sequence.length - 1];
        // index 为不小于val的起始位置
        int index = 0;
        for (; index < sequence.length - 1; index++) {
            if (sequence[index] > val) {
                break;
            }
        }
        for (int i = index; i < sequence.length - 1; i++) {
            if (sequence[i] <= val) {
                return false;
            }
        }

        boolean res = true;
        // 判断左子树
        if (index > 0) {
            res &= verifySquenceOfBST(Arrays.copyOfRange(sequence, 0, index));
        }
        // 判断右子树
        if (index < sequence.length - 1) {
            res &= verifySquenceOfBST(Arrays.copyOfRange(sequence, index, sequence.length - 1));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new VerifySquenceOfBST().verifySquenceOfBST(new int[]{4, 8, 6, 12, 14, 16, 10}));
    }
}
