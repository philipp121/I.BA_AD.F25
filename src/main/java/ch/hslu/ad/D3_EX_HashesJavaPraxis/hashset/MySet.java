package ch.hslu.ad.D3_EX_HashesJavaPraxis.hashset;

/**
 * A simple generic set interface that defines basic operations
 * for storing and managing unique Integer elements.
 *
 */
public interface MySet {

    /**
     * Adds the specified value to the set if it is not already present.
     *
     * @param value the value to add
     * @return true if the set did not already contain the specified value
     */
    boolean add(int value);

    /**
     * Removes the specified value from the set if it is present.
     *
     * @param value the value to remove
     * @return true if the set contained the specified value
     */
    boolean remove (int value);

    /**
     * Checks whether the specified value exists in the set.
     *
     * @param value the value to check for
     * @return true if the set contains the specified value
     */
    boolean contains(int value);
}
