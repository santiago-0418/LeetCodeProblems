import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class prob2 {
    //You are given two non-empty linked lists representing two non-negative integers.
    // The digits are stored in reverse order, and each of their nodes contains a single digit.
    // Add the two numbers and return the sum as a linked list.
    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(9);
        b.next = new ListNode(9);
        ListNode result = addTwoNumbers(a, b);
        System.out.println(result.next.next.val);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sol = new ListNode(0, new ListNode(0));
        ListNode temp;
        temp = sol;
        int carry = 0;
        int curr;
        while(l1!=null || l2!=null){
            if(l1==null){l1= new ListNode(0);}else if(l2==null){l2= new ListNode(0);}
            ListNode new_node = new ListNode();
            curr = l1.val + l2.val + carry;
            if(l1.val+l2.val+carry>=10){
                carry = 1;
                new_node.val = (curr%10);
            }
            else{
                new_node.val = curr;
                carry = 0;
            }
            sol.next = new_node;
            sol = sol.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(carry==1){sol.next = new ListNode(1);}
        temp = temp.next;
        return temp;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        //constructor
        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next)
        { this.val = val;
            this.next = next; }
    }
}
