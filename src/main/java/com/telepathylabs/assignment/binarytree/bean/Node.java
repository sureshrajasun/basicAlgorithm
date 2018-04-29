package com.telepathylabs.assignment.binarytree.bean;

public class Node {

    public int data;
    public Node left, right, nextRight;

    public Node(int item) {
        data = item;
        left = right = nextRight = null;
    }
}