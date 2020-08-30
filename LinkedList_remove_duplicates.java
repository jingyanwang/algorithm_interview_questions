/*
https://leetcode.com/problems/remove-duplicates-from-sorted-list-i

82. Remove Duplicates from Sorted List II

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Return the linked list sorted as well.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3

*/


public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public void printList(ListNode n){
        while(n != null){
            System.out.print(n.val+"->");
            n = n.next;
        }
        System.out.println("null");
    }
    
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next == null) return head;
        
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = head.next;
        ListNode activePrev = null;
        ListNode activeNext = null;
        boolean flagDuplicate = false;
        boolean flagPreDuplicate = flagDuplicate;
        while(curr.next != null){
            next = curr.next;
            
            flagPreDuplicate = flagDuplicate;
            if(curr.val == curr.next.val){
                flagDuplicate = true;
            }else{
                flagDuplicate = false;
            }

            /*
            System.out.print(curr.val +"->"+ curr.next.val+" : "+flagPreDuplicate+" : "+flagDuplicate);
            if(prev != null) System.out.print(" prev "+prev.val);
            if(next != null) System.out.println(" next "+next.val);
            */

            if(flagPreDuplicate == false && flagDuplicate == true){
                //System.out.println("duplicat start ");
                activePrev = prev;
            }

            if(flagPreDuplicate == true && flagDuplicate == false){
                //System.out.println("duplicat end ");
                if(activePrev != null) activePrev.next = next;
                else head = next;
                prev = activePrev;
                curr = next;
                printList(head);
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
        if(flagDuplicate == true){
            if(activePrev != null) activePrev.next = null;
            else return null;
        }
        return head;
    }
}

class Playground {
    public static void main(String[ ] args) {
        Solution s = new Solution();
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        /*
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next = new ListNode(5);
        */
        s.printList(head);
        
        ListNode newHead = s.deleteDuplicates(head);
        s.printList(newHead);
    }
}
