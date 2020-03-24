# 21. Merge Two Sorted Lists
# https://leetcode.com/problems/merge-two-sorted-lists/
# 60

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def getIndex(self, l0: ListNode, l1: ListNode) -> int:
        if l0 is None:
            return 1
        elif l1 is None:
            return 0
        return 0 if l0.val < l1.val else 1

    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        result = None
        pointer = {0: l1, 1: l2}
        while pointer[0] is not None or pointer[1] is not None:
            index = self.getIndex(pointer[0], pointer[1])
            if result is not None:
                resultIndex = result
                while resultIndex.next is not None:
                    resultIndex = resultIndex.next

            listNode = ListNode(pointer[index].val)
            if result is None:
                result = listNode
            else:
                resultIndex.next = listNode

            pointer[index] = pointer[index].next

        return result


l1_1 = ListNode(1)
l1_2 = ListNode(2)
l1_4 = ListNode(4)
l1_1.next = l1_2
l1_2.next = l1_4

l2_1 = ListNode(1)
l2_3 = ListNode(3)
l2_4 = ListNode(4)
l2_1.next = l2_3
l2_3.next = l2_4

result = Solution().mergeTwoLists(l1_1, l2_1)
while True:
    print(result.val)
    if result.next is None:
        break
    result = result.next

