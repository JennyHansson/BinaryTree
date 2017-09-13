package com.company;

/**
 * Created by jenny on 2016-11-16.
 */
public class Tree {
    Node root;


    public void insert(int value){
        if(root == null)
            root = new Node(value);
        else
            root.insert(value);
    }

    public int quantity(int key){
        if(root == null)
            return 0;
        else
            return root.quantity(key);
    }

    public void preorder(){
        if(root != null)
            root.preorder();
    }

    public void inorder() {
        if(root != null)
            root.inorder();
    }

    public void postorder() {
        if(root != null)
            root.postorder();
    }

    public int sum(){
        if(root == null)
            return 0;
        return root.sum();
    }

    public boolean delete(int key){
        if (root == null)
            return false;
        if (root.value == key)
        {
            if (root.left == null)// om bara barn på höger sida
                root = root.right; // sätt om roten att refera till högerbarnet
            else if ( root.right == null)
                root = root.left;
            else  // 2 barn
                root.value = getAt(root);
            return true;
        }
        Node current = root;
        Node parent = root;
        while( current.value != key){
            parent = current;
            if(key < current.value) {//lägre värde, leta till vänster
                if (current.left == null)
                    return false; //värdet fanns inte i trädet
                current = current.left;
            }
            else{// högre värde leta vidare till höger
                if( current.right == null)
                    return false;
                current = current.right; // Flytta till nästa nod
            }
        }
        if (current == parent.left){//Kommer från förälderns vänstra sida
            if (current.left == null)//inga barn på vänster sida, länka om till ev. högerbarn
                parent.left = current.right;
            else if ( current.right == null)//inga barn på höger sida, länka om till vänsterbarn
                parent.left = current.left;
            else  // 2 barn
                current.value = getAt(current);
            return true;
        }
        if (current == parent.right){
            if (current.left == null)
                parent.right = current.right;
            else if ( current.right == null)
                parent.right = current.left;
            else  // 2 barn
                current.value = getAt(current);
            return true;
        }
        return false;
    }

    public int getAt(Node parent){
        //leta upp det närmast högre värdet
        Node current = parent.right; // ta ett steg till höger
        if (current.left == null){//ersättaren har inget vänsterbarn
            parent.right = current.right; //länka bort ersättarens node
            return current.value;
        }
        while( current.left != null){
            parent = current; // leta upp den sista noden på vänster sida
            current = current.left;
        }
        parent.left = current.right; //Länka ut ersättaren
        return current.value;
    }

    public int levels(){
        if (root == null)
            return 0;
        return root.levels();
    }

    public boolean balance(){
        if (root == null)
            return true;
        return root.balance();
    }

    public int leaf(){
        if (root == null)
            return 0;
        return root.leaf();
    }
}
