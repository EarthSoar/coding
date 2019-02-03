package binaryTree;

/**
 * @author Willing
 * @date 2019/2/3
 */
public class Traversal {
    static class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data = data;
        }
    }
    //递归遍历
    //前序遍历
    public static void preOrderRecur(Node head){
        if(head == null){
            return;
        }
        System.out.println(head.data + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
    //中序遍历
    public static void inOrderRecur(Node head){
        if(head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.data + " ");
        inOrderRecur(head.right);
    }
    //后序列遍历
    public static void posOrderRecur(Node head){
        if(head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.data + " ");
    }
}
