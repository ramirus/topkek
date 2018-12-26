package TREE;




public interface BinarySearchTree<T extends Comparable> {

    void insert(T element);

   // boolean remove(T element);

    boolean contains(T element);

    void printByLevels();

    boolean remove(T k);

    void print();
}