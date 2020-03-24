# 14. Longest Common Prefix
# https://leetcode.com/problems/longest-common-prefix/
# 60

from typing import List


class Solution:
    def shortestWord(self, strs: List[str]) -> str:
        ret = strs[0]
        for i in range(len(strs)):
            if len(strs[i]) < len(ret):
                ret = strs[i]
        return ret

    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs) == 0:
            return ""

        baseStr = self.shortestWord(strs)
        result = ""
        for i in range(1, len(baseStr) + 1):
            hasPrefix = True
            prefix = strs[0][0:i]
            for word in strs:
                if word[0:i] != prefix:
                    hasPrefix = False
                    break
            if hasPrefix:
                result = prefix
            else:
                break

        return result


print(Solution().longestCommonPrefix(["a"]))
