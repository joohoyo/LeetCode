# 12. Integer to Roman
# https://leetcode.com/problems/integer-to-roman/
# 20:07 ~ 20:18

import unittest


class Solution:
    characters = [
        (1000, "M"),
        (900, "CM"),
        (500, "D"),
        (400, "CD"),
        (100, "C"),
        (90, "XC"),
        (50, "L"),
        (40, "XL"),
        (10, "X"),
        (9, "IX"),
        (5, "V"),
        (4, "IV"),
        (1, "I"),
    ]

    def intToRoman(self, num: int) -> str:
        answer = ""
        while num > 0:
            for tup in self.characters:
                if num >= tup[0]:
                    num -= tup[0]
                    answer += tup[1]
                    break
        return answer


class MyTest(unittest.TestCase):
    def test(self):
        testCases = {
            3: "III",
            4: "IV",
            9: "IX",
            58: "LVIII",
            1994: "MCMXCIV",
        }
        for k, v in testCases.items():
            self.assertEqual(Solution().intToRoman(k), v)


MyTest().test()
