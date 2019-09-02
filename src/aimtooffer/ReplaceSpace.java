package aimtooffer;

/**
 * by qianfang, at 2019-09-02, 19:42
 * <p>
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”
 **/
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toString().toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
