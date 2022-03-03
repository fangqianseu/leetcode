package leetcode;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that
 * the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * <p>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant the container.
 */
public class _11_ContainerWithMostWater {

    // 双指针  从两端向中间逼近；  每次移动当前边界较短的那一个； 因为随着宽度减少，高度必须要增高才可能面积最大；高度少的那一条边一定不是边界
    public int maxArea(int[] height) {
        int res = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int h = Math.min(height[i], height[j]);
            res = Math.max(res, h * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _11_ContainerWithMostWater c = new _11_ContainerWithMostWater();
        System.out.println(c.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
