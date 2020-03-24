# 15. 3Sum
# https://leetcode.com/problems/3sum/
# 10:40 ~ 10:55
# Time Limit Exceeded


from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        store = {}
        nums = sorted(nums)
        length = len(nums)
        for i in range(length):
            for j in range(i + 1, length):
                for k in range(j + 1, length):
                    s = nums[i] + nums[j] + nums[k]
                    if s > 0:
                        break
                    if s == 0:
                        store[str(nums[i]) + str(nums[j]) + str(nums[k])] = [
                            nums[i],
                            nums[j],
                            nums[k],
                        ]
                        continue
        return [x for x in store.values()]


print(Solution().threeSum([-1, 0, 1, 2, -1, -4]))

print(Solution().threeSum([0, 0, 0, 0]))
