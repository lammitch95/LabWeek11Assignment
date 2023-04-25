package com.mycompany.csc229_bst_example;
/**
 *
 * @author MoaathAlrajab
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {

        // ToDo 1: complete InOrder Traversal 
        if(root == null) return;//
        doInOrder(root.getLeft());
        System.out.print(root.getData() + " ");
        doInOrder(root.getRight());
        //Time Complexity: O(n)
        //Follows left->root->right pattern
    }
     public void preOrderTraversal() {
         doPreOrder(this.root);
    }
    
    // ToDo 2: complete the pre-order travesal . 
     public void doPreOrder(BstNode root){
         
         if(root == null) return;
         System.out.print(root.getData() + " ");
         doPreOrder(root.getLeft());
         doPreOrder(root.getRight());
         //Time Complexity: O(n)
         //Follows root->left->right pattern
     }

    public Integer findHeight() {

        // ToDo 3: Find the height of a tree
        return height(root);
        
         
    }
    
    public int height(BstNode bst){
        if(bst == null)return 0; //return 0 if tree is empty
        int leftHeight = height(root.getLeft());
        int rightHeight = height(root.getRight());
        /*finds depth of sub tree*, by calling left and right child nodes of root/
        
        /* gets maxmium value + 1*/
        if(leftHeight > rightHeight)
            return leftHeight + 1;
        else
            return rightHeight + 1;
        
        //Time Complexity: O(n)
        
    }

    

    public int getDepth(int  target) {
        //ToDo 4: complete getDepth of a node 
        return depth(target,root,0);
    }
    
    public int depth(int target, BstNode root, int depthCounter){
       
        if(root == null){// check if node is not found in the tree
            return -1;
        } else if(root.getData() == target){// return depth level if node is found
            return depthCounter;
        }else{
            //recursively search left and right subtrees
            int lDepth = depth(target,root.getLeft(), depthCounter + 1);
            if(lDepth != -1){
                 return depth(target,root.getRight(), depthCounter + 1);
            }else{
                return lDepth;
            }
        }
    }
   public void print() {
       System.out.println("\n==== BST Print ===== \n");
        printTree( root, 0);
        // ToDo 5: complete the print of the BST
    }

   public void printTree(BstNode root,int depthLevel){
       if (root != null) {//checks if tree is not null than it prints each level of tree from left to right
        printTree(root.getRight(), depthLevel + 1);
        for (int i = 0; i < depthLevel; i++) {
            System.out.print("    ");
        }
        System.out.println(root.getData());
       printTree(root.getLeft(), depthLevel + 1);
        
    }
    }
}
