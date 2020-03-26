# 26. Remove Duplicates from Sorted Array
# https://leetcode.com/problems/remove-duplicates-from-sorted-array/
# 15:29 ~ 15:44 (15min)


import unittest
from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0

        head = 1
        targetNumber = nums[0]
        index = 1
        while index < len(nums):
            if nums[index] != targetNumber:
                nums[head] = nums[index]
                targetNumber = nums[index]
                head += 1
            index += 1
        nums = nums[:head]
        return head


class MyTest(unittest.TestCase):
    def test(self):
        nums = [1, 1, 2]
        result = Solution().removeDuplicates(nums)
        self.assertEqual(2, result)
        self.assertEqual([1, 2], nums[:result])

        nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
        result = Solution().removeDuplicates(nums)
        self.assertEqual(5, result)
        self.assertEqual([0, 1, 2, 3, 4], nums[:result])


MyTest().test()
