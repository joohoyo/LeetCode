# 9. Palindrome Number
# https://leetcode.com/problems/palindrome-number/
# 10


class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        if x != 0 and x % 10 == 0:
            return False

        f = x
        a = 0
        while x != 0:
            a = (a * 10) + (x % 10)
            x = int(x / 10)

        if a == f:
            return True
        return False
