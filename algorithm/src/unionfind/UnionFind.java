package unionfind;

/**
 * @author Willing
 * @date 2019/2/17
 */

import java.util.*;

/**
 * 并查集结构,包含两个方法
 *      判断两个节点是否在一个集合
 *      合并两个节点所在的两个集合
 */

public class UnionFind {
    public static class Node{
        //String,Integer....
        private String str;
        public Node(String str){
            this.str = str;
        }
    }
    //并查集结构
    public static class UnionSet{
        private Map<Node,Node> fatherMap;//key: 当前节点  value: 当前节点的父节点
        private Map<Node,Integer> sizeMap;//key: 当前节点  value: 当前节点所在集合的大小

        public UnionSet(List<Node> nodeList){
            makeSet(nodeList);
        }

        /**
         * //初始化并查集 结构
         * @param nodeList  多个节点集合
         */
        private void makeSet(List<Node> nodeList) {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();

            //迭代每个节点,初始每个节点的父节点都是自己，并且所在的集合大小也都是1
            for (Node node : nodeList) {
                fatherMap.put(node,node);
                sizeMap.put(node,1);
            }
        }

        /**
         * 寻找节点所在结构中的 头结点,并且如果在寻找的过程中把途中经过的节点都直接作为 头结点的 直接子节点
         * @param node
         * @return
         */
        private Node findHead(Node node){
            //①:递归
            Node fatherNode = fatherMap.get(node);
            if(node != fatherNode){
                fatherNode = findHead(fatherNode);
            }
            fatherMap.put(node,fatherNode);
            //②: 非递归
//            Stack<Node> stack = new Stack<>();
//            Node cur = node;
//            Node fatherNode = fatherMap.get(node);
//            while(cur != fatherNode){
//                stack.push(cur);
//                cur = fatherNode;
//                fatherNode = fatherMap.get(cur);
//            }
//            while(!stack.isEmpty()){
//                fatherMap.put(stack.pop(),fatherNode);
//            }
            return fatherNode;
        }

        /**
         * 判断两个节点是否在一个集合中
         * @param node1
         * @param node2
         */
        public boolean isSameSet(Node node1,Node node2){
            return findHead(node1).str == findHead(node2).str;
        }

        /**
         * 合并两个节点所在的集合,节点少的连在节点多的节点下
         * @param a
         * @param b
         */
        public void union(Node a,Node b){
            if(a == null || b == null){
                return;
            }
            //得到两个节点的头节点
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            //不是同一个节点时执行合并操作
            if(aHead != bHead){

                //得到两集合的大小
                Integer aSize = sizeMap.get(aHead);
                Integer bSize = sizeMap.get(bHead);

                //比较两个集合的大小,较小的集合连在较大集合下面,同时较大集合大小增加为两个之和
                if(aSize <= bSize){
                    fatherMap.put(aHead,bHead);
                    sizeMap.put(bHead,aSize + bSize);
                }else {
                    fatherMap.put(bHead,aHead);
                    sizeMap.put(aHead,aSize + bSize);
                }
            }
        }
    }

    //test
    public static void main(String[] args) {
        Node node1 = new Node("张三");
        Node node2 = new Node("李四");
        Node node3 = new Node("李四");
        List<Node> nodeList = Arrays.asList(node1,node2,node3);
        UnionSet unionSet = new UnionSet(nodeList);
        boolean b = unionSet.isSameSet(node2,node3);
        System.out.println(b);
    }
}
