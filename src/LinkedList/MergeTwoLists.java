package LinkedList;

import other.LIS;

/**
 * Created by Administrator on 2020/4/25.
 */
public class MergeTwoLists {

    // 递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        l2.next = mergeTwoLists(l2.next,l1);
        return l2;
    }

    // 迭代 ,使用一个头结点
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode head = new ListNode(-1);
//        ListNode ret = head;
//        while(l1!= null && l2!= null) {
//            if (l1.val <= l2.val) {
//                head.next = l1;
//                l1 = l1.next;
//            }
//            else{
//                head.next = l2;
//                l2 = l2.next;
//            }
//            head = head.next;
//        }
//        if (l1 == null){
//            head.next = l2;
//        }
//        if (l2 == null){
//            head.next = l1;
//        }
//        return ret.next;
//    }



     /* Definition for singly-linked list.*/
     private static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }
}
