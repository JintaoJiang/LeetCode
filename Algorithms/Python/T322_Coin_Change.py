class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        m = amount
        n = len(coins)
        dp = [sys.maxint] * (m + 1)
        dp[0] = 0
        for i in range(1, n + 1):
            for j in range(1, m + 1):
                if j - coins[i - 1] >= 0:
                    dp[j] = min(dp[j], 1 + dp[j - coins[i - 1]])
        if dp[m] == sys.maxint:
            return -1
        return dp[m]
