package ch.hslu.ad.D1_EX_ArrayListenQueueStack.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    public void linkedListAddSize() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(10);
        myLinkedList.add(20);
        assertEquals(2,myLinkedList.size());;
    }

    @Test
    public void linkedListAddOrder() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(10);
        myLinkedList.add(20);
        myLinkedList.add(30);

        assertEquals(30, myLinkedList.head.value);
        assertEquals(20, myLinkedList.head.next.value);
        assertEquals(10, myLinkedList.head.next.next.value);
        assertEquals(3,myLinkedList.size());;
    }

    @Test
    public void linkedListContains() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        myLinkedList.add(10);
        myLinkedList.add(20);
        myLinkedList.add(30);

        assertTrue(myLinkedList.contains(10));
        assertTrue(myLinkedList.contains(20));
        assertTrue(myLinkedList.contains(30));
        assertFalse(myLinkedList.contains(50));
    }

    @Test
    public void linkedListRemoveHeadNode() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        myLinkedList.add(10);
        myLinkedList.add(20);
        myLinkedList.add(30);
        assertEquals(3, myLinkedList.size());
        assertTrue(myLinkedList.removeHeadNode());
        assertEquals(2, myLinkedList.size());
    }

    @Test
    void testRemoveAtHead() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(3);
        list.add(2);
        list.add(1); // List: 1 → 2 → 3
        assertTrue(list.remove(1));
        assertEquals(2, list.head.value);
        assertEquals(3, list.head.next.value);
    }

    @Test
    void testRemoveAtMiddle() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(3);
        list.add(2);
        list.add(1); // List: 1 → 2 → 3
        assertTrue(list.remove(2));
        assertEquals(1, list.head.value);
        assertEquals(3, list.head.next.value);
    }

    @Test
    void testRemoveAtEnd() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(3);
        list.add(2);
        list.add(1); // List: 1 → 2 → 3
        assertTrue(list.remove(3));
        assertEquals(1, list.head.value);
        assertEquals(2, list.head.next.value);
    }

    @Test
    void testRemoveNotFound() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3); // List: 3 → 2 → 1
        assertFalse(list.remove(99));
    }

    @Test
    void linkedListIterator() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(20);
        list.add(20);
        list.add(20);
        list.add(20);

        for (Integer i : list) {
            assertEquals(20, i);
        }

    }

}