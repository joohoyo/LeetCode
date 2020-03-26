# 27. Remove Element
# https://leetcode.com/problems/remove-element/
# 15:52 ~ 16:01 (9min)


import unittest
from typing import List


class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        head = 0
        for i in range(len(nums)):
            if nums[i] != val:
                nums[head] = nums[i]
                head += 1
        return head


class MyTest(unittest.TestCase):
    def test(self):
        nums = []
        val = 0
        result = Solution().removeElement(nums, val)
        self.assertEqual(0, result)
        self.assertEqual([], nums[:result])

        nums = [3, 2, 2, 3]
        val = 3
        result = Solution().removeElement(nums, val)
        self.assertEqual(2, result)
        self.assertEqual([2, 2], nums[:result])

        nums = [0, 1, 2, 2, 3, 0, 4, 2]
        val = 2
        result = Solution().removeElement(nums, val)
        self.assertEqual(5, result)
        self.assertEqual([0, 1, 3, 0, 4], nums[:result])


MyTest().test()
