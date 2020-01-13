package BinaryTree;

public class BSToperations {
    public BSToperations() {

    }

    public BST findMin(BST myBST) {
        if (myBST == null)
            return null;
        else {
            if (myBST.leftChild == null)
                return myBST;
            else {
                return findMin(myBST.leftChild);
            }
        }
    }

    public BST findMax(BST myBST) {
        if (myBST == null)
            return null;
        else {
            if (myBST.rightChild == null)
                return myBST;
            else
                return findMax(myBST.rightChild);
        }
    }

    public BST find(Comparable key, BST bst) {
        if (bst == null)
            return null;
        else if (key.compareTo(bst.key) == -1)
            return find(key, bst.leftChild);
        else if (key.compareTo(bst.key) == 1)
            return find(key, bst.rightChild);
        else
            return bst;
    }

    // TODO
    public BST insert(Comparable key, BST myBST) {
        return myBST;
    }

    // TODO
    public void delete(Comparable key, BST myBST) {
    }

    // TODO
    public void replace(Comparable replace, Comparable replaceWith, BST myBST) {

    }
}