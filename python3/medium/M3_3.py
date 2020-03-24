# 3. Longest Substring Without Repeating Characters
# https://leetcode.com/problems/longest-substring-without-repeating-characters/


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        i = 0
        j = 0
        n = len(s)
        result = 0
        d = {}
        while j < n:
            if s[j] in d:
                i = max(d[s[j]], i)
            result = max(result, j - i + 1)
            d[s[j]] = j + 1
            j += 1

        return result


val = "pwwkew"
print(Solution().lengthOfLongestSubstring(val))
