# 2. Add Two Numbers
# https://leetcode.com/problems/add-two-numbers/
# 16:12 ~ 16:22

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def getValue(self, l: ListNode) -> int:
        return 0 if l is None else l.val

    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        result = None
        head = None
        carry = 0
        while l1 is not None or l2 is not None:
            num = self.getValue(l1) + self.getValue(l2) + carry

            listNode = ListNode(num % 10)
            carry = 0 if num < 10 else 1
            if result is None:
                result = listNode
                head = result
            else:
                head.next = listNode
                head = head.next

            l1 = l1.next if l1 is not None else None
            l2 = l2.next if l2 is not None else None

        if carry == 1:
            head.next = ListNode(1)

        return result


l1_1 = ListNode(2)
l1_2 = ListNode(4)
l1_4 = ListNode(3)
l1_1.next = l1_2
l1_2.next = l1_4

l2_1 = ListNode(5)
l2_3 = ListNode(6)
l2_4 = ListNode(4)
l2_1.next = l2_3
l2_3.next = l2_4

result = Solution().addTwoNumbers(l1_1, l2_1)
while True:
    print(result.val)
    if result.next is None:
        break
    result = result.next

