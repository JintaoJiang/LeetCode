class Solution(object):
    def smallestSufficientTeam(self, req_skills, people):
        """
        :type req_skills: List[str]
        :type people: List[List[str]]
        :rtype: List[int]
        """
        n, m = len(req_skills), len(people)
        dic = {skill : i for i, skill in enumerate(req_skills)}
        dp = {0 : []}
        
        for i, p in enumerate(people):
            skills = 0
            for skill in p:
                if skill in dic:
                    skills |= 1 << dic[skill]
            for req, team in dp.items():
                with_skills = skills | req
                if with_skills not in dp or len(dp[with_skills]) > len(team) + 1:
                    dp[with_skills] = team + [i]
        
        return dp[(1 << n) - 1]
