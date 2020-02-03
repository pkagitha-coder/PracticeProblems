package org.abc;

import java.util.ArrayList;
import java.util.List;

public class PrintPathSum {
    public static void main(String[] args) {
        //build tree;
        Node node = new Node(3);
        node.childNodes.add(new Node(5));
        node.childNodes.add(new Node(6));

        printPathSum(node, 9, "");
        printPathSum(node, 7, "");
        printPathSum(node, 8, "");
    }

    private static void printPathSum(Node node, int n, String path) {
        if (node == null) {
            return;
        }
        int reducedSum = n - node.data;
        path = path + " " + node.data;
        if (node.childNodes.isEmpty()) {
            if (reducedSum == 0) {
                System.out.println(path);
            }
        }else {
            if(reducedSum > 0) {
                for(Node childNode: node.childNodes) {
                    printPathSum(childNode,reducedSum,path);
                }
            }
        }
    }
}

class Node {
    int data;
    List<Node> childNodes = null;

    public Node(int i) {
        this.data = i;
        this.childNodes = new ArrayList<>();
    }
}