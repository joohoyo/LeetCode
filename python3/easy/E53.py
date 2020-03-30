# 53. Maximum Subarray
# https://leetcode.com/problems/maximum-subarray/
# 15:19 ~ 15:44 (25min)

import unittest
from typing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        answer = nums[0]
        sum = 0
        for i in range(len(nums)):
            sum += nums[i]
            if sum > answer:
                answer = sum
            if sum < 0:
                sum = 0

        return answer


class MyTest(unittest.TestCase):
    def test(self):
        self.assertEqual(1, Solution().maxSubArray([1]))
        self.assertEqual(6, Solution().maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]))


MyTest().test()
