import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DoubleLinkedListTest {
    DoubleLinkedList<Integer> linkedList;
    @Test
    public void testAddFirst() {
        linkedList = new DoubleLinkedList<>();
        linkedList.add(1,0);
        assertEquals(1, linkedList.getFirst());
        linkedList.addFirst(3);
        assertEquals(3, linkedList.getFirst());
        assertEquals(2, linkedList.size());
    }

    @Test
    public void testAddLast() {
        linkedList = new DoubleLinkedList<>();
        linkedList.add(1,0);
        assertEquals(1, linkedList.getFirst());
        linkedList.addLast(2);
        assertEquals(1, linkedList.getFirst());
        assertEquals(2, linkedList.get(1));
        assertEquals(2, linkedList.size());
    }

    @Test
    public void testGetFirst() {
        linkedList = new DoubleLinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        assertEquals(3, linkedList.getFirst());
    }

    @Test
    public void testGetLast() {
        linkedList = new DoubleLinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        assertEquals(1, linkedList.getLast());
    }

    @Test
    public void testRemoveFirst() {
        linkedList = new DoubleLinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        assertEquals(3, linkedList.getFirst());
        linkedList.removeFirst();
        assertEquals(2, linkedList.getFirst());
        assertEquals(2, linkedList.size());
    }

    @Test
    public void testRemoveLast() {
        linkedList = new DoubleLinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        assertEquals(1, linkedList.getLast());
        linkedList.removeLast();
        assertEquals(2, linkedList.getLast());
        assertEquals(2, linkedList.size());
    }

    @Test
    public void testRemove() {
        linkedList = new DoubleLinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        assertEquals(1, linkedList.getLast());
        linkedList.remove(1);
        assertEquals(1, linkedList.get(1));
    }

    @Test
    public void testEmpty() {
        linkedList = new DoubleLinkedList<>();
        assertTrue(linkedList.isEmpty());
    }

}