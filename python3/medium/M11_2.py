# 11. Container With Most Water
# https://leetcode.com/problems/container-with-most-water/
# 19:00 ~ 19:37


import unittest
from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        result = 0
        start = 0
        end = len(height) - 1
        while start != end:
            area = (end - start) * min(height[start], height[end])
            if result < area:
                result = area
            if height[start] > height[end]:
                end -= 1
            else:
                start += 1

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
