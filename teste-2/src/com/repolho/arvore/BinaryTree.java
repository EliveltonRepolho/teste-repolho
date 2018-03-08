package com.repolho.arvore;

/**
 * Created by repolhoe on 07/03/2018.
 */
class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}
