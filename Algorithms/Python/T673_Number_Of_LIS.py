class Solution(object):
    def findNumberOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        dp = [1] * n
        count = [1] * n
        res = 0
        maxlen = 0
        for i in range(n):
            for j in range(i):
                if nums[i] > nums[j]:
                    if dp[i] == dp[j] + 1:
                        count[i] += count[j]
                    elif dp[i] < dp[j] + 1:
                        dp[i] = dp[j] + 1
                        count[i] = count[j]
            if maxlen == dp[i]:
                res += count[i]
            elif maxlen < dp[i]:
                res = count[i]
                maxlen = dp[i]
        return res
