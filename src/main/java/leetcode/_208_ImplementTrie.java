/*
Date:05.06,2019 23:07
Implement a trie with insert, search, and startsWith methods.

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
*/
package leetcode;

public class _208_ImplementTrie {

    private _208_ImplementTrie[] nodes;
    private boolean isEnd;

    public _208_ImplementTrie() {
        nodes = new _208_ImplementTrie[26];
        isEnd = false;
    }

    public void insert(String word) {
        _208_ImplementTrie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.nodes[index] == null) {
                node.nodes[index] = new _208_ImplementTrie();
            }
            node = node.nodes[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        _208_ImplementTrie node = getSuffex(word);
        if (node == null) {
            return false;
        }
        return node.isEnd;
    }

    // 只有insert之后 对应的节点才会初始化
    public boolean startsWith(String prefix) {
        _208_ImplementTrie node = getSuffex(prefix);
        return node != null;
    }

    private _208_ImplementTrie getSuffex(String prefix) {
        _208_ImplementTrie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.nodes[index] == null) {
                return null;
            }
            node = node.nodes[index];
        }
        return node;
    }
}
