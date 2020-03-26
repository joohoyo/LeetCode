# 28. Implement strStr()
# https://leetcode.com/problems/implement-strstr/
# 16:52 ~  (min)
# time limit exceeded

import unittest


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle == "":
            return 0

        for i in range(len(haystack)):
            if haystack[i] == needle[0]:
                find = True
                for j in range(1, len(needle)):
                    if i + j == len(haystack):
                        find = False
                        break
                    if haystack[i + j] != needle[j]:
                        find = False
                        break
                if find:
                    return i

        return -1


class MyTest(unittest.TestCase):
    def test(self):
        haystack = "hello"
        needle = ""
        self.assertEqual(0, Solution().strStr(haystack, needle))

        haystack = "hello"
        needle = "o"
        self.assertEqual(4, Solution().strStr(haystack, needle))

        haystack = "hello"
        needle = "ll"
        self.assertEqual(2, Solution().strStr(haystack, needle))

        haystack = "aaaa"
        needle = "ab"
        self.assertEqual(-1, Solution().strStr(haystack, needle))

        haystack = "aaa"
        needle = "aaa"
        self.assertEqual(0, Solution().strStr(haystack, needle))


MyTest().test()
