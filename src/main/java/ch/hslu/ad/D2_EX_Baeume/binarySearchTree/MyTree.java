package ch.hslu.ad.D2_EX_Baeume.binarySearchTree;

/**
 * Interface for a binary search tree.
 * Defines basic operations for managing and searching nodes.
 */
public interface MyTree {

    /**
     * Searches for a node with the given value in the tree.
     *
     * @param value the integer value to search for
     * @return the Node containing the value, or null if not found
     */
    Node search(int value);

    /**
     * Adds a node to the tree. Duplicate values are not allowed.
     *
     * @param node the node to be added
     * @return true if the node was successfully added, false if a node with the same value already exists
     */
    boolean add(Node node);

    /**
     * Removes the specified node from the tree.
     *
     * @param value the value to be removed
     * @return true if the node was successfully removed, false if it was not found
     */
    boolean remove(int value);
}
