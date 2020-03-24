# 7. Reverse Integer
# https://leetcode.com/problems/reverse-integer/
# 20


class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        minus = 1
        if x < 0:
            minus = -1
            x = x * -1

        result = 0
        max = 2 ** 31 - 1
        min = -(2 ** 31)
        while x != 0:
            if (minus * result) > (max - x % 10) / 10:
                return 0
            if (minus * result) < (min + x % 10) / 10:
                return 0

            result = (result * 10) + (x % 10)
            x = int(x / 10)

        return minus * result


x = -1563847412
print(Solution().reverse(x))
