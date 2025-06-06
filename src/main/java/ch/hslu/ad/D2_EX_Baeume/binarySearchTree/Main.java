package ch.hslu.ad.D2_EX_Baeume.binarySearchTree;

public class Main {
    public static void main(String[] args) {
        MySearchTree tree = new MySearchTree();
        tree.add(new Node(5));
        tree.add(new Node(3));
        tree.add(new Node(7));
        tree.add(new Node(2));
        tree.add(new Node(4));
        tree.add(new Node(6));
        tree.add(new Node(8));

        System.out.println(tree.inOrder());
    }
}
