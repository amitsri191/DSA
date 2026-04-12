/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
         Set<ListNode> set=new HashSet<>();
        boolean flag=false;
        ListNode currnode2=head;
        if(currnode2 == null || currnode2.next==null){
            return false;
        }
        while (currnode2!=null){
            if (set.contains(currnode2)){
                return true;
            }
            if (!flag){
                set.add(currnode2);
            }
            currnode2=currnode2.next;
        }
        return false;
    }
}