package com.ds.binarySearchTree;

/**
 * Method of creation of Binary Tree 
 * Methods of operations which can perform on Binary tree
 * @author sheetal
 * @since 2021-08-25
 */
public class BinarySearchTree<K extends Comparable<K>> {
	
	public static void main(String[] args) {
		System.out.println("Welcome to BinarySearchTree program");
        BinarySearchTree<Integer> binaryTree = new BinarySearchTree<>();
        binaryTree.add(56);
        binaryTree.add(30);
        binaryTree.add(70);
        binaryTree.add(22);
        binaryTree.add(40);
        binaryTree.add(60);
        binaryTree.add(95);
        binaryTree.add(11);
        binaryTree.add(65);
        binaryTree.add(3);
        binaryTree.add(16);
        binaryTree.add(63);
        binaryTree.add(67);
        int size = binaryTree.getSize();
        System.out.println(binaryTree);
        System.out.println("size of binary tree:"+size);
        System.out.println("Inorder Traversal of Binary Search tree");
        binaryTree.inorderTraversal(binaryTree.root);
        System.out.println("\n");
        binaryTree.searchNode(binaryTree.root, 63);

        if(flag)
            System.out.println("Element 63 is not present in the binary tree");
        else
            System.out.println("Element 63 is present in the binary tree");
    }
    BinaryNode<K> root;
    static boolean flag = false;
    
    public  BinarySearchTree(){
        root=null;
    }

    public void add(K key)
    {
        this.root = this.insertData(root,key);
    }

    /**
     * Ability to insert Node in Binary Search Tree
     * @param current
     * @param key
     * @return current
     */
    public BinaryNode<K> insertData(BinaryNode<K> current, K key)
    {
        if(current ==  null)
            return new BinaryNode<>(key);
        int compareResult = key.compareTo(current.key);
        if(compareResult==0)
            return current;
        if(compareResult<0)
        {
            current.left = insertData(current.left, key);
        }
        else
        {
            current.right = insertData(current.right, key);
        }
        return current;
    }
    
    public int getSize()
    {
        return this.getSizeBinary(root);
    }

    public int getSizeBinary(BinaryNode<K> current)
    {
        return current == null ? 0 : 1 + this.getSizeBinary(current.left)+this.getSizeBinary(current.right);
    }
    
    /**
     * Ability to say whether tree is empty or not
     * returning value in order if not empty
     * @param node
     */
    public void inorderTraversal(BinaryNode node) {
        if(root == null)
            System.out.println("Tree is empty");
        else {
            if(node.left != null)
                inorderTraversal(node.left);
            System.out.print(node.key + " ");
            if(node.right != null)
                inorderTraversal(node.right);
        }
    }

    /**
     * Ability to search the whole tree for given element
     * Return the flag data after searching 
     * @param node
     * @param value
     */
    public void searchNode(BinaryNode node, int value) {
        if(root == null)
            System.out.println("Tree is empty");
        else {
            if(node.key.compareTo(root.key) == value) {
                flag = true;
                return;
            }
            if(flag == false && node.left != null){
                searchNode(node.left, value);
            }
            if(flag == false && node.right != null){
                searchNode(node.right, value);
            }
        }
    }
}
