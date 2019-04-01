package leetcode;

public class _11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;

        int l = 0, r = height.length - 1;
        int maxarea = 0;
        while (l < r) {
            maxarea = Math.max(maxarea, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) l++;
            else r--;
        }
        return maxarea;
    }
}
