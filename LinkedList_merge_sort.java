/*
https://leetcode.com/problems/sort-list/
https://www.geeksforgeeks.org/merge-sort-for-linked-list/
*/


/*
Merge Sort for Linked Lists

Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
*/

/**
Definition for singly-linked list.
 */
 
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; this.next = null;}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next == null){
            //System.out.println("find null");
            return head;
        }
        
        ListNode middle = findMiddleNode(head);
        //System.out.println("middle.val "+middle.val);
        
        ListNode leftHead = head;
        ListNode rightHead = middle.next;
        middle.next = null;
        
        //printList(leftHead);
        //printList(rightHead);
        
        ListNode sortedLeftHead = sortList(leftHead);
        ListNode sortedRightHead = sortList(rightHead);

        //printList(sortedLeftHead);
        //printList(sortedRightHead);
        
        return mergeSortedList(sortedLeftHead, sortedRightHead);
    }
    
    public void printList(ListNode curr){
        while(curr != null){System.out.print(curr.val+"->");curr=curr.next;}
        System.out.println(" ");
    }

    
    public ListNode mergeSortedList(ListNode leftHead, ListNode rightHead){
        if(leftHead == null) return rightHead;
        if(rightHead == null) return leftHead;

        ListNode resultHead = null;
        ListNode curr = null;
        ListNode leftCurr = leftHead;
        ListNode rightCurr = rightHead;
        
        while(leftCurr != null && rightCurr != null){
            ListNode n;
            if(leftCurr.val < rightCurr.val){
                n = new ListNode(leftCurr.val);
                leftCurr = leftCurr.next; 
            }else{
                n = new ListNode(rightCurr.val);
                rightCurr = rightCurr.next; 
            }
            if(curr == null){
                curr = n;
                resultHead = n;
            }else{
                curr.next = n;
                curr = n;                
            }
        }
        if(leftCurr != null) curr.next = leftCurr;
        if(rightCurr != null) curr.next = rightCurr;
        return resultHead;
    }
    
    public ListNode findMiddleNode(ListNode head){
        if(head == null) return head;
        ListNode fast =head, slow = head;
        while(fast.next !=null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

class Playground {
    public static void main(String[ ] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        //head.next.next.next.next = new ListNode(6);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);

        ListNode curr;
        
        curr = head;
        while(curr != null){System.out.print(curr.val+"->");curr=curr.next;}
        System.out.println("Hello Java");
        
        Solution s = new Solution();
        ListNode resultHead = s.sortList(head);
        //ListNode resultHead = s.mergeSortedList(head, head2);

        curr = resultHead;
        while(curr != null){System.out.print(curr.val+"->");curr=curr.next;}
        
        System.out.println("Hello Java");
    }
}
