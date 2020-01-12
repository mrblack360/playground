package BinaryTree;

public class BST {
    int key;    // value of the Binary Node
    BST leftChild;
    BST rightChild;

    public BST(int key, BST leftChild, BST rightChild) {
        this.key = key;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public int getData(BST bst) {
        return bst.key;
    }

    public int getLeftData(BST bst) {
        BST leftChild = bst.leftChild;
        return leftChild.key;
    }

    public int getRightChild(BST bst) {
        BST rightChild = bst.rightChild;
        return rightChild.key;
    }

    public void setData(int data) {
        this.key = data;
    }

    public void setLeftData(BST leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightData(BST rightChild) {
        this.rightChild = rightChild;
    }

}
