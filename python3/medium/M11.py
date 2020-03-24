# 11. Container With Most Water
# https://leetcode.com/problems/container-with-most-water/
# 19:00 ~ 19:15
# Time Limit Exceeded


import unittest
from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        result = 0
        for i in range(len(height) - 1):
            for j in range(i + 1, len(height)):
                area = (j - i) * min(height[i], height[j])
                if result < area:
                    result = area

        return result


class MyTest(unittest.TestCase):
    def test(self):
        testCases = [
            {"k": [1, 2], "v": 1},
            {"k": [1, 2, 2], "v": 2},
            {"k": [1, 8, 6, 2, 5, 4, 8, 3, 7], "v": 49},
        ]
        for case in testCases:
            self.assertEqual(Solution().maxArea(case["k"]), case["v"])


MyTest().test()
