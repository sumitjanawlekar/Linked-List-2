// Time Complexity : O(1), we are just swapping the values of the nodes and changing the refrences (so constant time)
// Space Complexity :O(1), no extra space needed
// Did this code successfully run on Leetcode : Yes (on GeeksForGeeks)
// Any problem you faced while coding this : can we do this without changing node value and actually deleting the reference?
                                                //also correct me on the time complexity.

//Three liner explanation of your code in plain english
//1. Swap the value of the node with the next node's value and change the refrence of node's next to node's next's next
//2. If the node to be deleted is the last node, just make the node null

// Your code here along with comments explaining your approach

// { Driver Code Starts
    import java.util.*;

    class Node
    {
        int data ;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    
    class Delete_Node
    {
        Node head;
        Node tail;
        
        void printList(Node head)
        {
            Node tnode = head;
            while(tnode != null)
            {
                System.out.print(tnode.data+ " ");
                tnode = tnode.next;
            }
            System.out.println();
        }
        
        void addToTheLast(Node node)
        {
            
            if(head == null)
            {
                head = node;
                tail = node;
            }
            else
            {
                tail.next = node;
                tail = node;
            }
        }
        
        Node search_Node(Node head, int k)
        {
            Node current = head;
            while(current != null)
            {
                if(current.data == k)
                    break;
                current = current.next;
            }
        return current;
        }
        
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            
            int t = sc.nextInt();
            while(t>0)
            {
                int n = sc.nextInt();
                Delete_Node llist = new Delete_Node();
                //int n=Integer.parseInt(br.readLine());
                int a1=sc.nextInt();
                Node head= new Node(a1);
                llist.addToTheLast(head);
                for (int i = 1; i < n; i++) 
                {
                    int a = sc.nextInt(); 
                    llist.addToTheLast(new Node(a));
                }
                
                int k = sc.nextInt();
                Node del = llist.search_Node(llist.head,k);
                
                GfG g = new GfG();
                if(del != null && del.next != null)
                {
                    g.deleteNode(del);
                }
                llist.printList(llist.head);
            t--;
            }
        }
    }
    
    
    // } Driver Code Ends
    
    
    /*
    class Node
    {
        int data ;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    */
    
    // This function should delete node from linked list. The function
    // may assume that node exists in linked list and is not last node
    // node: reference to the node which is to be deleted
    class GfG
    {
        void deleteNode(Node node)
        {
             // Your code here
             //if the node to be deleted is null, return
             if(node == null) return;
             
             //if the node to be deleted is the last node, then simply make the node null
             if(node.next == null){
                 node = null;
             }
             else{ //copy the data from the next node to current node and make node's next as node's next's next
                 node.data = node.next.data;
                 node.next = node.next.next;
             }
        }
    }
    
    