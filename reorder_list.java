// Time Complexity : O(3n) i.e. O(n) (O(n) to find middle of the list, O(n) to reverse the list, O(n) to make the new connections)
                    //where n is the number of nodes in the linkedlist
// Space Complexity :O(1), no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner explanation of your code
//1. Find middle of the list
//2. Reverse the second half of the list
//3. Make the new connections of the first half and second reversed half of the list

// Your code here along with comments explaining your approach

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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        //Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        
        //move slow at 1x and fast at 2x speed
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow is now at the middle of the list
        
        //hold the slow's next in a temp and then make slow's next as null
        ListNode temp = slow.next;
        slow.next = null;
        //reset slow to head node
        slow = head;
        //Reverse the second half of the list
        ListNode reversed = reverse(temp);
        
        //assign temp to slow's next node, to keep refernce after changing slow's next
        temp = slow.next;
        //Make the connections
        while(temp != null){
            slow.next = reversed;
            reversed = reversed.next;
            slow.next.next = temp;
            slow = temp;
            temp = temp.next;
        }
        
        //handle the list with even length
        if(reversed != null){
            slow.next = reversed;
        }
    }
    
    private ListNode reverse( ListNode head){
        ListNode prev = null;
        ListNode current = head;
        ListNode fast = head.next;
        
        
        while(fast != null){
            current.next = prev;
            prev = current;
            current = fast;
            fast = fast.next;
        }
        //make the last connection of current, when fast is at null
        current.next = prev;
        
        //head holds the reversed list
        return current;
    }
}