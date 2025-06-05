package ch.hslu.ad.D1_EX_ArrayListenQueueStack.list;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void testEqualsContract() {
        Node<Integer> red = new Node<>(1);
        Node<Integer> black = new Node<>(2);
        EqualsVerifier.forClass(Node.class)
                .withIgnoredFields("next")
                .withPrefabValues(Node.class, red, black)
                .verify();
    }

}