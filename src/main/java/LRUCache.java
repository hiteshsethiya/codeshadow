import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LRUCache {
    /*int capacity;

    private Map<String, Node> referenceMap = new HashMap<>();
    private List<Node> queue = new DoublyLinkedList<>();
    private Node lastNode = null;

    void evict() {

        if(!queue.isEmpty()) {
            Node first = queue.getFirst();
            referenceMap.remove(first.getKey());
            first.next.prev = null;
            queue.removeFirst();
        }

    }

    boolean isFull() {
        return queue.size() == capacity;
    }

    void used(Node node) {

        if(queue.isEmpty()) {
            queue.addLast(node);
            return;
        }

        Node prevNode = node.prev;
        Node nextNode = node.next;

        if(prevNode != null) {
            prevNode.next = nextNode;
        }

        if(nextNode != null) {
            nextNode.prev = prevNode;
        }

        queue.addLast(node);
        node.next = null;
        node.prev = lastNode;
        lastNode = node;



    }

    void put(String key, String value) {



        if(!referenceMap.containsKey(key) && isFull()) {
            evict();
        }

        Node cacheRef = referenceMap.getOrDefault(key, new Node());

        cacheRef.setKey(key);
        cacheRef.setValue(value);

        used(cacheRef);
        referenceMap.put(key, cacheRef);


    }

    String get(String key) {

        Node cacheRef = referenceMap.get(key);

        if(cacheRef != null) {
            used(cacheRef);
        }

        return cacheRef;

    }

    public static class Node {
        private String key;
        private String value;
        private Node prev;
        private Node next;
    }*/
}
