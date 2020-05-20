public class SingleLinkedList<E> {

    private class ListNode {
        E e;
        ListNode next;

        public ListNode(E e, ListNode next) {
            this.e = e;
            this.next = next;
        }

        public ListNode(E e) {
            this(e, null);
        }

        public ListNode() {
            this(null, null);
        }
    }

    private int size;
    private ListNode dummyHead;
    private ListNode tail;

    public SingleLinkedList() {
        size = 0;
        dummyHead = new ListNode();
        tail = dummyHead;
    }

    public void addFirst(E e) {
        size++;
        ListNode oldHead = dummyHead.next;
        ListNode newHead = new ListNode(e);
        dummyHead.next = newHead;
        newHead.next = oldHead;
        if (oldHead == null) {
            tail = newHead;
        }
    }

    public void addLast(E e) {
        size++;
        tail.next = new ListNode(e);
        tail = tail.next;
    }

    private void isValidIdx(int idx) {
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException();
        }
    }
    public void add(E e, int idx) {
        isValidIdx(idx);

        if (idx == 0) {
            addFirst(e);
        } else if (idx == size) {
            addLast(e);
        } else {
            size++;
            ListNode prevNode = dummyHead;
            for (int i = 0; i < idx; i++) {
                prevNode = prevNode.next;
            }
            ListNode nextNode = prevNode.next;
            ListNode inseredtNode = new ListNode(e);
            prevNode.next = inseredtNode;
            inseredtNode.next = nextNode;
        }
    }

    public void removeFirst() {
        if(dummyHead.next == null) return;
        size--;
        ListNode newHead = dummyHead.next.next;
        dummyHead.next = newHead;
        ListNode deletedNode = dummyHead.next;
        deletedNode.next = null;
        if (newHead == null) {
            tail = dummyHead;
        }
    }

    public void removeLast() {
        if(tail == dummyHead) return;
        size--;
        ListNode curr = dummyHead;
        while (curr != null) {
            curr = curr.next;
        }
        curr.next = null;
        tail = curr;
    }
     public void remove(int idx) {
        isValidIdx(idx);
        if (idx == 0) {
            removeFirst();
        } else if (idx == size) {
            removeLast();
        } else {
            size--;
            ListNode prevNode = dummyHead;
            for (int i = 0; i < idx; i++) {
                prevNode = prevNode.next;
            }
            ListNode deletedNode = prevNode.next;
            prevNode.next = deletedNode.next;
            deletedNode.next = null;
        }
     }

     public E getFirst() {
        if (dummyHead.next == null) {
            return null;
        } else {
            return dummyHead.next.e;
        }
     }

    public E getLast() {
        if (tail == null) {
            return null;
        } else {
            return tail.e;
        }
    }

    public E get(int idx) {
        isValidIdx(idx);
        if (idx == 0) {
            return getFirst();
        } else if (idx == size) {
            return getLast();
        } else {
            ListNode curr = dummyHead;
            for (int i = 0; i <= idx; i++) {
                curr = curr.next;
            }
            return curr.e;
        }
    }

    public void setFirst(E e) {
        dummyHead.next.e = e;
    }

    public void setLast(E e) {
        tail.e = e;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
