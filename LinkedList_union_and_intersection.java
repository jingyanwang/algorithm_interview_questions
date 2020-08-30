/*

https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/

Union and Intersection of two Linked Lists

Given two Linked Lists, create union and intersection lists that contain union and intersection of the elements present in the given lists. Order of elements in output lists doesn’t matter.
Example:

Input:
   List1: 10->15->4->20
   lsit2:  8->4->2->10
Output:
   Intersection List: 4->10
   Union List: 2->8->20->4->15->10
*/

import java.util.*;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode result = null;
        HashSet<Integer> hset = new HashSet<>();
        
        ListNode n1 = headA;
        while(n1!=null){
            hset.add(n1.val);
            n1=n1.next;
        }

        ListNode n2 = headB;
        while(n2!=null){
            if(hset.contains(n2.val)){
                ListNode n = new ListNode(n2.val);
                n.next = result;
                result = n;
            }
            n2 = n2.next;
        }
        
        return result;
    }
    
    public ListNode getUnionNode(ListNode headA, ListNode headB) {
        ListNode result = null;
        HashSet<Integer> hset = new HashSet<>();
        
        ListNode n1 = headA;
        while(n1!=null){
            hset.add(n1.val);
            n1=n1.next;
        }

        n1 = headB;
        while(n1!=null){
            hset.add(n1.val);
            n1=n1.next;
        }
        
        Iterator<Integer> i = hset.iterator();
        while(i.hasNext()){
            ListNode n = new ListNode(i.next());
            n.next = result;
            result = n;
        }

        return result;
    }
    
    public void printList(ListNode head){
        while(head != null){
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println("null");

    }
}

class Playground {
    public static void main(String[ ] args) {
        Solution s = new Solution();
        
        ListNode head1 = new ListNode(10);
        head1.next = new ListNode(15);
        head1.next.next = new ListNode(4);
        head1.next.next.next = new ListNode(20);
        s.printList(head1);
        
        ListNode head2 = new ListNode(8);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(10);
        s.printList(head2);
        
        ListNode intersectionHead = s.getIntersectionNode(head1, head2);
        s.printList(intersectionHead);

        ListNode unionHead = s.getUnionNode(head1, head2);
        s.printList(unionHead);

        System.out.println("Hello Java");
    }
}
