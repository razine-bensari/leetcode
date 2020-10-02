class Solution {

    public static void main(String args[]) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        var ans = addTwoNumbers(l1, l2);

        var current = ans;
        System.out.print("[");
        while(current != null) {
            System.out.print(current.val);
            System.out.print(" -> ");
            current = current.next;
        }
        System.out.print("]");
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode ans = new ListNode(0);

        var current = ans;

        //Assuming both linekdlist have the same size
        while(l1 != null && l2 != null) {
            current.val = current.val + l1.val + l2.val;
          
            //Check for value bigger than 10
            if(current.val  > 9) {

                //Keep modulo in current value
                current.val = current.val % 10;

                //Increment consequent value
                current.next = new ListNode(1);
            }
            // point to next node
            l1 = l1.next;
            l2 = l2.next;

            if(current.next == null && (l1 != null && l2 != null)) {
                current.next = new ListNode(0);
            }
            if(l1 != null && l2 != null) { // change pointer only if not at the end
                current = current.next;
            } else {
                break;
            }
        }
        if(l1 == null && l2 == null) { //both l1 and l2 same size
            return ans;
        }
        else if(l1 != null && l2 == null) { // l1 bigger than l2
            if(current.next != null) {
                current.next = addTwoNumbers(current.next, l1);
                return ans;
            } else {
                current.next = l1;
                return ans;
            }
        }
        else if(l1 == null && l2 != null) { // l2 bigger than l1
            if(current.next != null) {
                current.next = addTwoNumbers(current.next, l2);
                return ans;
            } else {
                current.next = l2;
                return ans;
            }
        }
        return ans;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}