class LRUCache {

    private ListNode dummy;

    private Map<Integer, ListNode> map;

    private int capacity; 

    public LRUCache(int capacity) {
        this.dummy = new ListNode();
        dummy.next = dummy;
        dummy.prev = dummy;
        this.map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        ListNode node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;

        ListNode tmp = dummy.next;
        dummy.next = node;
        node.next = tmp;
        tmp.prev = node;
        node.prev = dummy;
        return node.value;
    }
    
    public void put(int key, int value) {
        //update 
        if(map.containsKey(key)) {
            ListNode updatedNode = map.get(key);
            updatedNode.value = value;
            updatedNode.prev.next = updatedNode.next;
            updatedNode.next.prev = updatedNode.prev;
            
            ListNode tmp = dummy.next;
            dummy.next = updatedNode;
            updatedNode.next = tmp;
            tmp.prev = updatedNode;
            updatedNode.prev = dummy;
        }

        // add 
        else if(!map.containsKey(key)) {

            if(map.size() == 0) {
                dummy.next = new ListNode(key, value, dummy, dummy);
                dummy.prev = dummy.next;
                map.put(key, dummy.next);
            }

            else if(map.size() < capacity) {
                dummy.next = new ListNode(key, value, dummy.next, dummy);
                dummy.next.next.prev = dummy.next;
                map.put(key, dummy.next);
            }

            else if(map.size() == capacity) {
                int removedNodeKey = dummy.prev.key;
                map.remove(removedNodeKey);
                dummy.prev = dummy.prev.prev;
                dummy.prev.next = dummy;  

                ListNode tmp = dummy.next; 
                dummy.next = new ListNode(key, value, tmp, dummy);
                tmp.prev = dummy.next;
                map.put(key, dummy.next);
            }
        }
    }

    private static class ListNode {
        ListNode next; 
        ListNode prev;
        int key;
        int value;

        ListNode() {
            this.key = -1;
            this.value = -1;
            this.next = null;
            this.prev = null;
        }
        
        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        ListNode(int key, int value, ListNode next, ListNode prev) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}



 // else if(map.size() < capacity) {
        //     ListNode tmp = dummy.next; 
        //     dummy.next = new ListNode(key, value, tmp, dummy);
        // }
