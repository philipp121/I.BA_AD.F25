package ch.hslu.ad.D3_EX_HashesJavaPraxis.hashset;

public class Main {
    public static void main(String[] args) {
        SimpleHashSet set = new SimpleHashSet(10);
        set.add(20);
        set.add(14);
        set.add(7);
        set.add(1);
        set.add(6);
        set.add(8);
        set.add(9);
        set.add(15);
        set.add(23);
        set.add(17);
        System.out.println(set);

        set.remove(7);
        System.out.println(set);

        set.add(27);
        System.out.println(set);

        set.remove(27);
        System.out.println(set);

        set.remove(17);
        System.out.println(set);

        set.add(37);
        System.out.println(set);

        set.add(2);
        System.out.println(set);
    }

}
