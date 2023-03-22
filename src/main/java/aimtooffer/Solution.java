package aimtooffer;

import java.util.*;

/**
 * @author qianfang, at 2023/3/21, 23:28
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.nextLine());

        String line = "aksdkasjd";
        line.length();
        line.charAt(0);
        char[] chars = line.toCharArray();
        line.substring(0, 9);

        String[] split = line.split("\\|");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }

        List<String> ls1 = Arrays.asList(split);
        List<String> ls = new ArrayList<>();
        ls.size();
        ls.add("asda");
        ls.remove(0);
        ls.contains("asd");
        ls.clear();
        for (String s : ls) {
            System.out.println(s);
        }

        String[] newArray = ls.toArray(new String[]{});
        for (String s : newArray) {
            System.out.println(s);
        }

        HashMap<String, String> mp = new HashMap<>();
        mp.containsKey("asd");
        Collection<String> values = mp.values();
        Set<String> strings = mp.keySet();
        Set<Map.Entry<String, String>> entries = mp.entrySet();
        for (Map.Entry<String, String> e : mp.entrySet()) {
            String key = e.getKey();
            String value = e.getValue();
        }
        Double a = 0.3;
        Double b = 0.4;
        System.out.println(a+b);
    }
}
