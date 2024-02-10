package leetcode;
import java.util.*;

public class lc2_addTwoNumbers {
   
    public static void main(String[] args) throws Exception {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry == 1){
            int sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum/10;
            ListNode node = new ListNode(sum % 10);
            current.next = node;
            current = current.next;
        }

        return dummy.next;
    }
}
