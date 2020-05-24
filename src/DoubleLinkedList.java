public class DoubleLinkedList<E> {
    private class ListNode {
        E e;
        ListNode next;
        ListNode prev;

        public ListNode(E e, ListNode next, ListNode prev) {
            this.e = e;
            this.prev = prev;
            this.next = next;
        }

        public ListNode(E e) {
            this(e, null, null);
        }

        public ListNode() {
            this(null, null, null);
        }
    }

    private int size;
    private ListNode dummyHead;
    private ListNode tail;

    public DoubleLinkedList() {
        size = 0;
        dummyHead = new ListNode();
        tail = new ListNode();
        dummyHead.next = tail;
        tail.prev = dummyHead;
    }

    public void addFirst(E e) {
        size++;
        ListNode oldHead = dummyHead.next;
        ListNode newHead = new ListNode(e);
        if (oldHead == null) {
            tail.prev = newHead;
        }
        newHead.prev = dummyHead;
        newHead.next = oldHead;
        dummyHead.next = newHead;
        oldHead.prev = newHead;

    }

    public void addLast(E e) {
        size++;
        ListNode prev = tail.prev;
        ListNode newNode = new ListNode(e);
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = tail;
        tail.prev = newNode;
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
            inseredtNode.prev = prevNode;
            nextNode.prev = inseredtNode;
        }
    }

    public void removeFirst() {
        if(dummyHead.next == tail) return;
        size--;
        ListNode newHead = dummyHead.next.next;
        if (newHead == null) {
            tail.prev = dummyHead;
        }
        newHead.prev = dummyHead;
        dummyHead.next = newHead;
        ListNode deletedNode = dummyHead.next;
        deletedNode.next = null;
    }

    public void removeLast() {
        if(tail.prev == dummyHead) return;
        size--;
        tail.prev = tail.prev.prev;
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
            deletedNode.next.prev = prevNode;
            deletedNode.next = null;
            deletedNode.prev = null;
        }
    }

    public E getFirst() {
        if (dummyHead.next == tail) {
            return null;
        } else {
            return dummyHead.next.e;
        }
    }

    public E getLast() {
        if (tail.prev == dummyHead) {
            return null;
        } else {
            return tail.prev.e;
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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
