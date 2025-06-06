package ch.hslu.ad.D3_EX_HashesJavaPraxis.hashset;

public class SimpleHashSet implements MySet {
    public Integer[] data;
    private static final Integer TOMBSTONE = Integer.MIN_VALUE;
    private int size = 0;

    public SimpleHashSet(int size){
        data = new Integer[size];
    }

    public int findIndex(int value){
        return Math.floorMod(Integer.hashCode(value), data.length);
    }

    @Override
    public boolean add (int value){
        int index = findIndex(value);
        for (int i = 0; i < data.length; i++) {
            int probeIndex = (index + i) % data.length;

            if (data[probeIndex] == null || data[probeIndex].equals(TOMBSTONE)) {
                data[probeIndex] = value;
                size++;
                return true;
            } else if (data[probeIndex].equals(value)) {
                return false; // already exists
            }
        }
        return false;
    }

    @Override
    public boolean remove(int value) {
        int index = findIndex(value);

        for (int i = 0; i < data.length; i++) {
            int probeIndex = (index + i) % data.length;
            if (data[probeIndex] == null) {
                return false;
            }
            if (data[probeIndex].equals(value)){
                data[probeIndex] = TOMBSTONE;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(int value) {
        int index = findIndex(value);
        for (int i = 0; i < data.length; i++) {
            int probeIndex = (index + i) % data.length;
            if (data[probeIndex] == null) {
                return false;
            }
            if (!data[probeIndex].equals(TOMBSTONE) && data[probeIndex].equals(value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i]);
            if (i < data.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        for (Integer value : data) {
            if (value == null || value.equals(TOMBSTONE)) return false;
        }
        return true;
    }
}
