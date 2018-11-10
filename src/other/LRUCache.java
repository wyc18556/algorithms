package other;

import java.util.HashMap;

/**
 * @Author wyc1856
 * @Date 2018/11/10 17:00
 * @Reference https://mp.weixin.qq.com/s/h_Ns5HY27NmL_odCYLgx_Q
 * @Description LRU(Least Recently Used)算法
 **/
public class LRUCache {
    private Node head;
    private Node end;
    private int limit;
    private HashMap<String, Node> hashMap;

    public LRUCache(int limit) {
        this.limit = limit;
        hashMap = new HashMap<>();
    }

    class Node {
        String key;
        String value;
        Node pre;
        Node next;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private void removeNode(Node node){
        if (node == head){//删除头结点
            head = node.next;
            head.pre = null;
        }else if (node == end){//删除尾节点
            end = node.pre;
            end.next = null;
        }else {//删除中间节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }

    private void addNode(Node node){
        if (end == null){
            head = node;
        }else {
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end = node;
    }

    private void refreshNode(Node node){
        if (node == end){
            return;
        }
        removeNode(node);
        addNode(node);
    }

    public String get(String key){
        Node node = hashMap.get(key);
        if (node == null){
            return null;
        }
        refreshNode(node);
        return node.value;
    }

    public String put(String key, String value){
        Node node = hashMap.get(key);
        if (node == null){
            if (hashMap.size() >= limit){//已满
                removeNode(head);
            }
            node = new Node(key,value);
            addNode(node);
            hashMap.put(node.key,node);
        }else {
            node.value = value;
            refreshNode(node);
        }
        return node.value;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Node current = head;
        while (current != null){
            stringBuffer.append(current.value).append("\n");
            current = current.next;
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put("001","学生001的信息");
        lruCache.put("002","学生002的信息");
        lruCache.put("003","学生003的信息");
        lruCache.put("004","学生004的信息");
        lruCache.put("005","学生005的信息");

        System.out.println(lruCache);
        lruCache.get("002");
        System.out.println(lruCache);
        lruCache.put("004","学生004的信息更新了");
        System.out.println(lruCache);
        lruCache.put("006","学生006的信息");
        System.out.println(lruCache);
    }
}
