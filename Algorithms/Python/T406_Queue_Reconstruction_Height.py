class Solution(object):
    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
        res = []
        left = [[p[0], p[1]] for p in people]
        while len(res) < len(people):
            small = sys.maxint
            index = -1
            for i, p in enumerate(left):
                if p[1] == 0 and p[0] < small:
                    small = p[0]
                    index = i
            res.append(people[index])              
            for i, p in enumerate(left):
                if p[0] <= small:
                    p[1] -= 1 
        return res
