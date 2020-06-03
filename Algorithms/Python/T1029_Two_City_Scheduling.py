class Solution(object):
    def twoCitySchedCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        N = len(costs) / 2
        dp = [[0] * (N + 1) for i in range(N + 1)]
        
        for i in range(1, N + 1):
            dp[i][0] = dp[i - 1][0] + costs[i - 1][0]
            dp[0][i] = dp[0][i - 1] + costs[i - 1][1]
        
        for i in range(1, N + 1):
            for j in range(1, N + 1):
                dp[i][j] = min(costs[i + j - 1][0] + dp[i - 1][j], costs[i + j - 1][1] + dp[i][j - 1])
        
        return dp[N][N]
