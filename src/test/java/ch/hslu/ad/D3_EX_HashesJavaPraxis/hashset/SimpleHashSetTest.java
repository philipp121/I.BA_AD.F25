package ch.hslu.ad.D3_EX_HashesJavaPraxis.hashset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleHashSetTest {

    private SimpleHashSet set;

    @BeforeEach
    void setUp() {
        set = new SimpleHashSet(10);
    }

    @Test
    void testAddAndContainsSuccess() {
        assertTrue(set.add(42));
        assertTrue(set.add(23));
        assertTrue(set.contains(42));
        assertTrue(set.contains(23));
        assertFalse(set.contains(99)); // not added
    }

    @Test
    void testAddDuplicate() {
        assertTrue(set.add(8));
        assertFalse(set.add(8)); // duplicate
    }

    @Test
    void testRemove() {
        set.add(5);
        assertTrue(set.contains(5));
        assertTrue(set.remove(5));
        assertFalse(set.contains(5));
        assertFalse(set.remove(5)); // already removed
    }

    @Test
    void testCollisionIgnored() {
        int a = 4;
        int b = a + 10; // Same index if size is 10

        assertTrue(set.add(a));
        assertFalse(set.add(b)); // will collide
        assertFalse(set.contains(b));
    }

    @Test
    void testToStringOutput() {
        set.add(3);
        set.add(7);
        String output = set.toString();
        assertTrue(output.contains("3"));
        assertTrue(output.contains("7"));
        assertTrue(output.startsWith("["));
        assertTrue(output.endsWith("]"));
    }
}