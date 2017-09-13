package com.company;

import static java.lang.StrictMath.abs;

/**
 * Created by jenny on 2016-11-16.
 */

public class Node {
    int value;
    int quantity;
    Node left;
    Node right;


    public Node(int value){
        this.value = value;
        this.quantity = 1;
    }

    public void insert(int value) {
        if(value < this.value){
            if(this.left == null)
                this.left = new Node(value);
            else
                this.left.insert(value);
        }
        else if(value > this.value) {
            if (this.right == null)
                this.right = new Node(value);
            else
                this.right.insert(value);
        }
        else
            quantity++;
    }

    public int quantity(int key){
        if(key < this.value){
            if(this.left == null)
                return 0;
            else
                return this.left.quantity(key);
        }
        else if(key > this.value){
            if(this.right == null)
                return 0;
            else
                return this.right.quantity(key);
        }
        else
            return this.quantity;
    }

    public void preorder(){
        for(int i = 0; i < quantity; i++) {
            System.out.print(value + " ");
        }
        if(left != null)
            left.preorder();
        if(right != null)
            right.preorder();
    }

    public void inorder(){
        if(left != null)
            left.inorder();
        for(int i = 0; i < quantity; i++) {
            System.out.print(value + " ");
        }
        if(right != null)
            right.inorder();
    }

    public void postorder(){
        if(left != null)
            left.postorder();
        if(right != null)
            right.postorder();
        for(int i = 0; i < quantity; i++) {
            System.out.print(value + " ");
        }
    }

    public int sum() {
        int leftSum = 0;
        int rightSum = 0;
        if(left != null)
            leftSum =left.sum();
        if(right != null)
            rightSum = right.sum();
        return value*quantity + leftSum + rightSum;
    }

    public int leaf() {
        if(this.left == null && this.right == null)
            return 1;
        int leftLeaf = 0;
        int rightLeaf = 0;
        if(this.left != null)
            leftLeaf += this.left.leaf();
        if(this.right != null)
            rightLeaf += this.right.leaf();
        return leftLeaf + rightLeaf;
    }

    public int levels() {
        int leftLevel = 0;
        int rightLevel = 0;
        if(this.left == null && this.right == null)
            return 1;
        if(this.left != null)
            leftLevel = 1 + this.left.levels();
        if(this.right != null)
            rightLevel = 1 + this.right.levels();
        return leftLevel <= rightLevel ? rightLevel: leftLevel;
    }

    public boolean balance() {
        int leftLevel = 0;
        int rightLevel = 0;
        if(this.left == null && this.right == null)
            return true;
        if (this.left != null)
            leftLevel = this.left.levels();
        if (this.right!= null)
            rightLevel = this.right.levels();
        if(abs(leftLevel - rightLevel) < 2) {
            if (this.left != null && this.right != null) {
                return this.left.balance() && this.right.balance();
            }
            return true;
        }
        return false;
    }
}

