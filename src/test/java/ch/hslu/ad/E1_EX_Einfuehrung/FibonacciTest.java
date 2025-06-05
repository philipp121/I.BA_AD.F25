package ch.hslu.ad.E1_EX_Einfuehrung;

import org.junit.jupiter.api.Test;

import static ch.hslu.ad.E1_EX_Einfuehrung.Fibonacci.fiboRec1;
import static ch.hslu.ad.E1_EX_Einfuehrung.Fibonacci.fiboRec2;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    @Test
    public void testFiboRec1_ValidInputs() {

        // Base case
        assertEquals(0, fiboRec1(0));

        // Small known values
        assertEquals(1, fiboRec1(1));
        assertEquals(1, fiboRec1(2));
        assertEquals(2, fiboRec1(3));

        // Larger known value
        assertEquals(55, fiboRec1(10));
        assertEquals(6765, fiboRec1(20));
    }

    @Test
    public void testFiboRec2_ValidInputs() {

        // Base case
        assertEquals(0, fiboRec2(0, new Integer[0 + 1]));

        // Small known values
        assertEquals(1, fiboRec2(1, new Integer[1 + 1]));
        assertEquals(1, fiboRec2(2, new Integer[2 + 1]));
        assertEquals(2, fiboRec2(3, new Integer[3 + 1]));

        // Larger known value
        assertEquals(55, fiboRec2(10, new Integer[10 + 1]));
        assertEquals(6765, fiboRec2(20, new Integer[20 + 1]));
    }
}