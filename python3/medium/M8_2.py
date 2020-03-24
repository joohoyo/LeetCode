# 8. String to Integer (atoi)
# https://leetcode.com/problems/string-to-integer-atoi/
# 17:52 ~ 18:24
# 음..

import unittest


import re


class Solution:
    min = -(2 ** 31)
    max = 2 ** 31 - 1

    def getNumber(self, sign, numStr) -> int:
        if numStr == "":
            return 0
        num = int(numStr) if sign is None else int(sign + numStr)
        if num > self.max:
            return self.max
        if num < self.min:
            return self.min
        return num

    def myAtoi(self, strs: str) -> int:
        p = re.compile("\\d")
        sign = ""
        numStr = ""
        startNum = False
        for s in strs:
            if startNum is False and s == " ":
                continue
            elif startNum is True and s == " ":
                break

            if (s == "-" or s == "+") and startNum is False and sign == "":
                sign = s
                startNum = True
                continue

            if startNum is False and s == "0":
                startNum = True
                continue

            m = p.match(s)
            if m is None:
                break

            numStr += s
            startNum = True

        return self.getNumber(sign, numStr)


class MyTest(unittest.TestCase):
    def test(self):
        testCases = {
            "3": 3,
            "43": 43,
            "4193 with words": 4193,
            "words and 00987": 0,
            "   -41": -41,
            "-91283472332": -2147483648,
            "3.141592": 3,
            "+-123": 0,
            "010": 10,
            "  +0 123": 0,
            "-   234": 0,
            "0-1": 0,
        }
        for k, v in testCases.items():
            self.assertEqual(Solution().myAtoi(k), v)


MyTest().test()
