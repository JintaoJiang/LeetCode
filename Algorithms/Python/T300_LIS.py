class Solution(object):
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        tails = [sys.maxsize] * len(nums)
        for num in nums:
            pos = bisect.bisect(tails, num)
            if pos == 0 or num > tails[pos - 1]:
                tails[pos] = num
        res = 0
        for tail in tails:
            if tail != sys.maxsize:
                res += 1
        return res
