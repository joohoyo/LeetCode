# 15. 3Sum
# https://leetcode.com/problems/3sum/
# 10:40 ~ 11:40
# Time Limit Exceeded

from typing import List


class Solution:
    def updateStore(self, store, a, b, c):
        sortedList = sorted([a, b, c])
        store["".join([str(x) for x in sortedList])] = sortedList
        return store

    def threeSum(self, nums: List[int]) -> List[List[int]]:
        store = {}
        nums = sorted(nums)
        numsDict = {}
        for n in nums:
            if n not in numsDict:
                numsDict[n] = 1
            else:
                numsDict[n] = numsDict[n] + 1

        length = len(nums)

        for i in range(length):
            numsDict[nums[i]] = numsDict[nums[i]] - 1
            for j in range(i + 1, length):
                numsDict[nums[j]] = numsDict[nums[j]] - 1
                target = -(nums[i] + nums[j])
                if target in numsDict and numsDict[target] > 0:
                    store = self.updateStore(store, nums[i], nums[j], target)
                numsDict[nums[j]] = numsDict[nums[j]] + 1
            numsDict[nums[i]] = numsDict[nums[i]] + 1

        return [x for x in store.values()]


print(Solution().threeSum([-1, 0, 1, 2, -1, -4]))

print(Solution().threeSum([0, 0, 0, 0]))
