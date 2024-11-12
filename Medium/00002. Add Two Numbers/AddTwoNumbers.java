class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode();
        ListNode nodeBeforeResult = dummyNode;
        int total = 0, carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            total = carry;

            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }

            int resultDigit = total % 10;
            carry = total / 10;
            dummyNode.next = new ListNode(resultDigit);
            dummyNode = dummyNode.next;
        }

        return nodeBeforeResult.next;
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
        // l1 = [2, 4, 3], l2 = [5, 6, 4]
        ListNode list1_node3 = new ListNode(3, null);
        ListNode list1_node2 = new ListNode(4, list1_node3);
        ListNode list1_node1 = new ListNode(2, list1_node2);

        ListNode list2_node3 = new ListNode(4, null);
        ListNode list2_node2 = new ListNode(6, list2_node3);
        ListNode list2_node1 = new ListNode(5, list2_node2);

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(list1_node1, list2_node1);

        System.out.print("[");
        ListNode currentNode = result;
        while (currentNode != null) {
            System.out.print(currentNode.val);
            if (currentNode.next != null) {
                System.out.print(", ");
            }
            currentNode = currentNode.next;
        }
        System.out.println("].");
    }
}