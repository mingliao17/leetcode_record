package xyz.mingliao.leetcode.s141环形链表;

import java.util.HashSet;

/**
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 有点作弊的嫌疑，刚看了漫画算法中提到的这个问题，最快就是使用快慢指针操作
 */
public class Solution {

    //快慢指针
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while(p2!=null && p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                return true;
            }
        }
        return false;
    }

    //使用hash表，判断这个内容是否存在
    public boolean hasCycle2(ListNode head){
        HashSet<ListNode> hashSet = new HashSet<ListNode>();
        while(head!=null){
            if(!hashSet.add(head)){
                return true;
            }else{
                head = head.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(14);
        ListNode node4 = new ListNode(14);
        ListNode node5 = new ListNode(12);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node2;

        Solution s = new Solution();
        System.out.println(s.hasCycle2(node1));;

    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
