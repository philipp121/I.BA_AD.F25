package ch.hslu.ad.D2_EX_Baeume.binarySearchTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySearchTreeTest {

    private MySearchTree tree;

    @BeforeEach
    void setUp() {
        tree = new MySearchTree();
        tree.add(new Node(5));
        tree.add(new Node(3));
        tree.add(new Node(7));
        tree.add(new Node(2));
        tree.add(new Node(4));
        tree.add(new Node(6));
        tree.add(new Node(8));
    }

    @Test
    void testSearch_existingValue() {
        Node result = tree.search(4);
        assertNotNull(result);
        assertEquals(4, result.getValue());
    }

    @Test
    void testSearch_nonExistingValue() {
        Node result = tree.search(99);
        assertNull(result);
    }

    @Test
    void testInOrderOnSingleNode() {
        MySearchTree tree = new MySearchTree();
        tree.add(new Node(42));
        List<Node> result = tree.inOrder();
        assertEquals(1, result.size());
        assertEquals(42, result.getFirst().getValue());
    }

    @Test
    void testAdd_newNode() {
        assertTrue(tree.add(new Node(9)));
        assertNotNull(tree.search(9));
    }

    @Test
    void testAdd_duplicateNode() {
        assertFalse(tree.add(new Node(5))); // already exists
    }

    @Test
    void testRemove_leafNode() {
        assertTrue(tree.remove(2));
        assertNull(tree.search(2));
    }

    @Test
    void testRemove_nodeWithOneChild() {
        tree.remove(2); // remove left leaf
        assertTrue(tree.remove(3)); // node with one child now
        assertNull(tree.search(3));
    }

    @Test
    void testRemove_nodeWithTwoChildren() {
        assertTrue(tree.remove(5)); // root node
        assertNull(tree.search(5));
    }

    @Test
    void testRemove_nonExistingNode() {
        assertFalse(tree.remove(42));
    }

    @Test
    void testHeight() {
        assertEquals(2, tree.height());
    }

    @Test
    void testIsEmpty_true() {
        MySearchTree emptyTree = new MySearchTree();
        assertTrue(emptyTree.isEmpty());
    }

    @Test
    void testIsEmpty_false() {
        assertFalse(tree.isEmpty());
    }

    @Test
    void testContains_existing() {
        assertTrue(tree.contains(6));
    }

    @Test
    void testContains_notExisting() {
        assertFalse(tree.contains(99));
    }

    @Test
    void testInOrderSubtree() {
        List<Node> subtree = tree.inOrder();
        assertEquals(7, subtree.size());
        assertEquals(2, subtree.get(0).getValue());
        assertEquals(3, subtree.get(1).getValue());
        assertEquals(4, subtree.get(2).getValue());
        assertEquals(5, subtree.get(3).getValue());
        assertEquals(6, subtree.get(4).getValue());
        assertEquals(7, subtree.get(5).getValue());
        assertEquals(8, subtree.get(6).getValue());
    }
}