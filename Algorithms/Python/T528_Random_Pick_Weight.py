class Solution(object):

    def __init__(self, w):
        """
        :type w: List[int]
        """
        self.acc = [0] * len(w)
        for i, weight in enumerate(w):
            self.acc[i] = w[i]
            if i > 0:
                self.acc[i] += self.acc[i - 1]

    def pickIndex(self):
        """
        :rtype: int
        """
        rand = random.randint(1, self.acc[len(self.acc) - 1])
        pos = bisect.bisect_left(self.acc, rand)
        return pos
