package com.telepathylabs.assignment.binarytree;

import com.telepathylabs.assignment.binarytree.bean.Node;

public class BinaryTree{

    public Node root;

    /* This function returns the leftmost child of nodes at the same level
       as p. This function is used to getNExt right of p's right child
       If right child of is NULL then this can also be sued for the
       left child */
    Node getNextRight(Node p)  {
        Node temp = p.nextRight;

        /* Traverse nodes at p's level and find and return
           the first node's first child */
        while (temp != null) {
            if (temp.left != null)
                return temp.left;

            if (temp.right != null)
                return temp.right;

            temp = temp.nextRight;
        }

        // If all the nodes at p's level are leaf nodes then return NULL
        return null;
    }

    /* Sets nextRight of all nodes of a tree with root as p */
    void connect(Node parent) {
        if (parent == null)
            return;

        // Set nextRight for root
        parent.nextRight = null;

        // set nextRight of all levels one by one
        while (parent != null) {
            Node child = parent;

            /* Connect all childrem nodes of p and children nodes of all other
               nodes at same level as p */
            while (child != null) {
                // Set the nextRight pointer for p's left child
                if (child.left != null) {

                    // If q has right child, then right child is nextRight of
                    // p and we also need to set nextRight of right child
                    if (child.right != null)
                        child.left.nextRight = child.right;
                    else
                        child.left.nextRight = getNextRight(child);
                }

                if (child.right != null)
                    child.right.nextRight = getNextRight(child);

                // Set nextRight for other nodes in pre order fashion
                child = child.nextRight;
            }

            // start from the first node of next level
            if (parent.left != null)
                parent = parent.left;
            else if (parent.right != null)
                parent = parent.right;
            else
                parent = getNextRight(parent);
        }
    }

}