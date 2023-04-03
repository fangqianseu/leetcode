package leetcode;

import java.util.HashMap;

/**
 * @author qianfang, at 2023/4/3, 00:51
 **/
public class _146_LRU {

    class Inner {
        private int val;
        private int key;
        private Inner pre;
        private Inner next;
    }

    private int capacity;
    private HashMap<Integer, Inner> map;
    private int count;
    private Inner head;
    private Inner tail;

    public _146_LRU(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Inner();
        this.tail = new Inner();
        this.head.next = this.tail;
        this.tail.pre = this.head;
        this.count = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Inner node = map.get(key);
            removeNode(node);
            addHead(node);
            return map.get(key).val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Inner node = null;
        if (!this.map.containsKey(key)) {
            if (this.count >= this.capacity) {
                Inner inner = removeTail();
                if (null != inner) {
                    this.map.remove(inner.key);
                }
            }
            // 新添加节点
            node = new Inner();
            node.val = value;
            node.key = key;
        } else {
            // 修改原有节点
            node = this.map.get(key);
            node.val = value;
            removeNode(node);
        }
        addHead(node);
        this.map.put(key, node);
    }

    private void removeNode(Inner node) {
        if (null == node) {
            return;
        }
        node.pre.next = node.next;
        node.next.pre = node.pre;
        this.count--;
    }

    private void addHead(Inner node) {
        node.next = this.head.next;
        node.pre = this.head;

        this.head.next.pre = node;
        this.head.next = node;

        this.count++;
    }

    private Inner removeTail() {
        if (this.tail == this.head) {
            return null;
        }
        Inner remove = this.tail.pre;
        removeNode(remove);
        return remove;
    }


    public static void main(String[] args) {
        _146_LRU obj = new _146_LRU(2);
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1));
        obj.put(3, 3);
        System.out.println(obj.get(2));
        obj.put(4, 1);
    }
}
