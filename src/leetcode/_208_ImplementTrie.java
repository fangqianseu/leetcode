/*
Date:05.06,2019 23:07
Implement a trie with insert, search, and startsWith methods.

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
*/
package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _208_ImplementTrie {
    private TireNode root;

    /**
     * Initialize your data structure here.
     */
    public _208_ImplementTrie() {
        root = new TireNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TireNode now = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (now.getSubNode(c) == null) {
                now.addSubNode(c, new TireNode());
            }
            now = now.getSubNode(c);
        }
        now.setEnd(true);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TireNode now = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (now.getSubNode(c) == null)
                return false;
            now = now.getSubNode(c);
        }
        return now.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TireNode now = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (now.getSubNode(c) == null)
                return false;
            now = now.getSubNode(c);
        }
        return true;
    }

    class TireNode {
        private boolean end = false;
        private Map<Character, TireNode> subNodes = new HashMap<>();

        private TireNode getSubNode(Character c) {
            return subNodes.get(c);
        }

        private void addSubNode(Character c, TireNode node) {
            subNodes.put(c, node);
        }

        private boolean isEnd() {
            return end;
        }

        private void setEnd(boolean end) {
            this.end = end;
        }
    }
}
