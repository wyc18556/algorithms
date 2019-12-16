package other;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wyc1856
 * @date 2019/12/16
 * @description 二叉树遍历
 **/
public class BinaryTree {
    public static void main(String[] args) throws Exception {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;

        //前序遍历
        System.out.println("前序遍历:");
        preOrder(A);
        System.out.println();
        //中序遍历
        System.out.println("中序遍历:");
        inOrder(A);
        System.out.println();
        //后续遍历
        System.out.println("后序遍历:");
        postOrder(A);
        System.out.println();
        //层序遍历
        System.out.println("层序遍历:");
        levelOrder(A);
    }

    private static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    private static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    private static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    private static void levelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node pop = queue.poll();
            System.out.print(pop.value + " ");
            if (pop.left != null) {
                queue.offer(pop.left);
            }
            if (pop.right != null) {
                queue.offer(pop.right);
            }
        }
    }

    static class Node {
        String value;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
        }
    }
}
