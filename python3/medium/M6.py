# 6. ZigZag Conversion
# https://leetcode.com/problems/zigzag-conversion/
# 19:45 ~ 20:05 (20min)
# 이중배열까진 아니고 그냥 문자열을 이어 붙여도 되겠다

from typing import Tuple


class Solution:
    def getXY(self, step: int, xy: Tuple) -> Tuple:
        x, y = xy
        if step == 0:
            x += 1
        else:
            x = 0 if x == 0 else x - 1
            y += 1
        return (x, y)

    def convert(self, s: str, numRows: int) -> str:
        d = {}
        for i in range(numRows):
            d[i] = {}

        x = 0
        y = 0
        step = 0
        for i in range(len(s)):
            d[x][y] = s[i]
            if step == 1 and x == 0:
                step = 0

            if step == 0 and x == numRows - 1:
                step = 1

            x, y = self.getXY(step, (x, y))

        result = ""
        for i in range(numRows):
            result += "".join([d[i][y] for y in sorted(d[i].keys())])

        return result


s = "PAYPALISHIRING"
numRows = 4
# s = "AB"
# numRows = 1
output = "PINALSIGYAHRPI"
print(Solution().convert(s, numRows))

