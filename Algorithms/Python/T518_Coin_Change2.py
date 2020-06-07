class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        m = amount
        n = len(coins)
        dp = [0] * (m + 1)
        dp[0] = 1
        for i in range(1, n + 1):
            for j in range(1, m + 1):
                if j - coins[i - 1] >= 0:
                    dp[j] += dp[j - coins[i - 1]]
        return dp[m]
