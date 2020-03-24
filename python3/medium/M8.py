# 8. String to Integer (atoi)
# https://leetcode.com/problems/string-to-integer-atoi/
# 21:52 ~ gg
# 정규식 때문에 망함
# 실패

import re


class Solution:
    def getNumber(self, sign, numStr) -> int:
        return int(numStr) if sign is None else int(sign + numStr)

    def myAtoi(self, strs: str) -> int:
        min = -(2 ** 31)
        max = 2 ** 31 - 1

        p = re.compile("( )*([+-])?0*([1-9]\\d+)")
        m = p.search(strs)
        if m is None or m.span()[0] != 0:
            return 0

        sign = m.group(2)
        numStr = m.group(3)
        if len(numStr) <= 9 or int(numStr[-9]) == 1:
            return self.getNumber(sign, numStr)

        if int(numStr[-9]) > 2:
            return min if sign == "-" else max

        limitNumber = min if sign == "-" else max
        if int(str(limitNumber)[1:]) > int(numStr[-8:]):
            return min if sign == "-" else max

        return self.getNumber(sign, numStr)


s = "43"
s = "4193 with words"  # 4193
s = "words and 00987"  # 0
s = "   -41"  # -41
s = "-91283472332"  # -2147483648
s = "3.141592"  # 3
s = "3"
print(Solution().myAtoi(s))
