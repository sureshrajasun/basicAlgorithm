package com.telepathylabs.assignment.binarytree;

import com.telepathylabs.assignment.binarytree.bean.Node;

public class RightNodeFinder{

    public static void main(String args[]){

        BinaryTree tree         = new BinaryTree();
        tree.root               = new Node(10);
        tree.root.left          = new Node(8);
        tree.root.right         = new Node(2);
        tree.root.left.left     = new Node(3);
        tree.root.right.right   = new Node(90);

        tree.connect(tree.root);

        int a = tree.root.nextRight != null ? tree.root.nextRight.data : -1;
        int b = tree.root.left.nextRight != null ? tree.root.left.nextRight.data : -1;
        int c = tree.root.right.nextRight != null ? tree.root.right.nextRight.data : -1;
        int d = tree.root.left.left.nextRight != null ? tree.root.left.left.nextRight.data : -1;
        int e = tree.root.right.right.nextRight != null ? tree.root.right.right.nextRight.data : -1;

        System.out.println("" +
                "Following results are populated NextRight pointers in "
                + " the tree. -1 will be printed, if there is no nextRight");

        System.out.println(String.format(" NextRight of %d is %d",  tree.root.data , a));

        System.out.println(String.format(" NextRight of %d is %d",  tree.root.left.data , b));

        System.out.println(String.format(" NextRight of %d is %d",  tree.root.right.data , c));

        System.out.println(String.format(" NextRight of %d is %d",  tree.root.left.left.data , d));

        System.out.println(String.format(" NextRight of %d is %d",  tree.root.right.right.data , e));
    }

}
