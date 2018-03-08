package com.repolho.arvore;

/**
 * Created by repolhoe on 07/03/2018.
 */
public class BinaryTreeCalc {
    BinaryTree root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public int calcFromNumber(int value) {
        BinaryTree nodeFrom = findNumberRecursive(root, value);
        return calcRecursive(nodeFrom, value, 0);
    }

    private BinaryTree addRecursive(BinaryTree from, int value) {
        if (from == null) return new BinaryTree(value);

        if (value < from.value)
            from.left = addRecursive(from.left, value);
        else if (value > from.value)
            from.right = addRecursive(from.right, value);

        return from;
    }

    private BinaryTree findNumberRecursive(BinaryTree from, int value) {
        if (from == null)  return null;

        if (value == from.value)
            return from;

        return value < from.value
                ? findNumberRecursive(from.left, value)
                : findNumberRecursive(from.right, value);
    }

    private int calcRecursive(BinaryTree from, int value, Integer sum) {
        sum += from.value;

        if(from.left != null)
            sum = calcRecursive(from.left, value, sum);

        if(from.right != null)
            sum = calcRecursive(from.right, value, sum);

        return sum;
    }

    public static void main(String[] args) {
        BinaryTreeCalc tree = new BinaryTreeCalc();
        tree.add(10);
        tree.add(8);
        tree.add(9);
        tree.add(4);
        tree.add(6);
        tree.add(2);
        tree.add(20);
        tree.add(15);
        tree.add(13);
        tree.add(25);

        System.out.printf("Soma de todos os nós da árvore - nó base: -> ", tree.calcFromNumber(10));
        System.out.printf("\nSoma a partir do nó 4: -> ", tree.calcFromNumber(4));
        System.out.printf("\nSoma a partir do nó 3: -> ", tree.calcFromNumber(13));
    }
}
