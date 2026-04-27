/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow=reverse(slow);
        fast=head;
        while(slow!=null){
            if(fast.val!=slow.val){
                return false;
            }
            fast=fast.next;
            slow=slow.next;
        }
        return true;
    }
    public static ListNode reverse(ListNode head){
        ListNode prev=head;
        ListNode curnode= head.next;
        if(prev==null || curnode==null){
            return prev;
        }
        while(curnode!=null){
            ListNode temp=curnode.next;
            curnode.next=prev;
            prev=curnode;
            curnode=temp;
        }
        head.next=null;
        head=prev;
        return head;
    }
}