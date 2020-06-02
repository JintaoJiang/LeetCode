class Solution(object):
    def ways(self, pizza, k):
        """
        :type pizza: List[str]
        :type k: int
        :rtype: int
        """
        m, n = len(pizza), len(pizza[0])
        apples = [[0] * (n + 1) for i in range(m + 1)]
        dp = [[[0] * (n + 1) for i in range(m + 1)] for kk in range(k)]

        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                apples[i][j] = apples[i + 1][j] + apples[i][j + 1] - apples[i + 1][j + 1]
                if pizza[i][j] == 'A':
                    apples[i][j] += 1
                    
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if apples[i][j] > 0:
                    dp[k - 1][i][j] = 1
                    
        for kk in range(k - 2, -1, -1):
            for i in range(m - 1, -1, -1):
                for j in range(n - 1, -1, -1):
                    for it in range(i + 1, m):
                        if apples[i][j] - apples[it][j] > 0:
                            dp[kk][i][j] += dp[kk + 1][it][j]
                    for it in range(j + 1, n):
                        if apples[i][j] - apples[i][it] > 0:
                            dp[kk][i][j] += dp[kk + 1][i][it]
                    dp[kk][i][j] = int(dp[kk][i][j] % (10 ** 9 + 7))
        
        return dp[0][0][0]
