# 28. Implement strStr()
# https://leetcode.com/problems/implement-strstr/
# 16:52 ~ 17:18 (26min)


import unittest


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle == "":
            return 0

        head = 0
        i = 0

        while i < len(haystack):
            if haystack[i] == needle[head]:
                i += 1
                head += 1
                if head == len(needle):
                    return i - head
            else:
                i = i - head + 1
                head = 0

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

        haystack = "mississippi"
        needle = "issip"
        self.assertEqual(4, Solution().strStr(haystack, needle))


MyTest().test()
