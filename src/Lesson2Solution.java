/**
 * description: 两数相加
 *
 * @author 李志恒(lizhiheng @ tansun.com.cn)
 * @version 1.0
 * @date 2020-07-09
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 *
 */

public class Lesson2Solution {

    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry =0;
        while (l1!=null||l2!=null){
            int x = l1 ==null?0:l1.val;
            int y = l2 == null?0:l2.val;
            int sum = x + y +carry;
            carry = sum /10;
            sum = sum%10;
            cur.nextNode = new ListNode(sum);
            cur = cur.nextNode;

            if(l1!=null)
                l1=l1.nextNode;
            if(l2!=null)
                l2=l2.nextNode;

        }
        if(carry==1){
            cur.nextNode = new ListNode(carry);
        }
        return pre.nextNode;
    }
   public static void main(String args[]){
       // 链表 1
       ListNode list1Node1 = new ListNode(2);
       ListNode list1Node2 = new ListNode(4);
       ListNode list1Node3 = new ListNode(3);
       list1Node1.nextNode = list1Node2;
       list1Node2.nextNode = list1Node3;

       // 链表 2
       ListNode list2Node1 = new ListNode(5);
       ListNode list2Node2 = new ListNode(6);
       ListNode list2Node3 = new ListNode(4);
       list2Node1.nextNode = list2Node2;
       list2Node2.nextNode = list2Node3;


       ListNode resListNode = addTwoNumbers(list1Node1, list2Node1);

       listNodePrint(resListNode);
   }

    /**
     * 递归打印
     *
     * @param listNode 需打印的链表
     */
    public static void listNodePrint(ListNode listNode) {

        if (listNode == null) {
            return;
        }

        if (listNode.nextNode == null) {
            System.out.print(listNode.val);
            return;
        }

        System.out.print(listNode.val);
        listNodePrint(listNode.nextNode);
    }

}

class ListNode{
    int val;
    ListNode nextNode;
    ListNode(int val){
        this.val=val;
        this.nextNode=null;
    }
}
