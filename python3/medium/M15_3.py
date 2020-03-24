# 15. 3Sum
# https://leetcode.com/problems/3sum/
# 10:40 ~ gg

from typing import List


class Solution:
    def updateStore(self, store, a, b, c):
        store[str(a) + str(b) + str(c)] = [a, b, c]
        return store

    def threeSum(self, nums: List[int]) -> List[List[int]]:
        store = {}
        nums = sorted(nums)
        length = len(nums)
        for i in range(length - 2):
            if nums[i] > 0:
                break
            if i > 0 and nums[i] == nums[i - 1]:  # 이부분이 중요. reuse 하는것을 다시 할 필요 없음
                continue
            left = i + 1
            right = length - 1
            while left < right:
                while nums[i] + nums[left] + nums[right] > 0 and left + 1 < right:
                    right -= 1
                if nums[i] + nums[left] + nums[right] == 0:
                    store = self.updateStore(store, nums[i], nums[left], nums[right])
                left += 1

        return [x for x in store.values()]


print(Solution().threeSum([-1, 0, 1, 2, -1, -4]))

print(Solution().threeSum([0, 0, 0, 0]))

print(
    Solution().threeSum(
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    )
)
