# 13. Roman to Integer
# https://leetcode.com/problems/roman-to-integer/
# 5


class Solution:
    def romanToInt(self, s: str) -> int:

        subs = {"IV": 4, "IX": 9, "XL": 40, "XC": 90, "CD": 400, "CM": 900}
        symbols = {"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000}

        result = 0
        while len(s) > 0:
            if s[0:2] in subs:
                result += subs[s[0:2]]
                s = s[2:]
            elif s[0:1] in symbols:
                result += symbols[s[0:1]]
                s = s[1:]

        return result
