package basic.search;

/**
 * @author qianfang, at 2019-09-20, 09:26
 **/
public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch_squre(new int[]{1, 3, 3, 4}, 1.5));
        System.out.println(binarySearch_squre(new int[]{1, 3, 3, 4}, 2.5));
    }

    public static int binarySearch(int[] in, int target) {
        if (in == null || in.length == 0) {
            return -1;
        }
        int l = 0, r = in.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (in[mid] == target) {
                return mid;
            } else if (in[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    // 二分查找重复出现的数字
    public static int binarySearch_squre(int[] in, double target) {
        if (in == null || in.length == 0) {
            return -1;
        }
        int l = 0, r = in.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (in[mid] == target) {
                return mid;
            } else if (in[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    // 另一种重复数字的二分查找 最开始出现下标
    public int getLower(int[] data, int k) {
        int start = 0, end = data.length - 1;
        int mid = (start + end) / 2;

        while (start <= end) {
            if (data[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return start;
    }

    //最后一次出现的下标
    int getUpper(int[] data, int k) {
        int start = 0, end = data.length - 1;
        int mid = (start + end) / 2;

        while (start <= end) {
            if (data[mid] <= k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }

        return end;
    }
}
