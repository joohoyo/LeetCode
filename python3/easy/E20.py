# 20. Valid Parentheses
# https://leetcode.com/problems/valid-parentheses/
# 20


class Solution:
    def isValid(self, s: str) -> bool:
        brackets = [("(", ")"), ("{", "}"), ("[", "]")]
        stacks = []

        for p in s:
            if p in [x[0] for x in brackets]:
                stacks.append(p)
                continue

            if len(stacks) == 0:
                return False

            bracketSet = ()
            for x in brackets:
                if p == x[0] or p == x[1]:
                    bracketSet = x

            if stacks[-1] != bracketSet[0]:
                return False

            stacks.pop()

        return True if len(stacks) == 0 else False


print(Solution().isValid("{[]}"))
