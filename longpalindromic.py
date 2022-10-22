def longestPalindrome(self, s: str) -> str:
        if not s:
            return ''
        l = len(s)
        dp = [[None for j in range(l)] for i in range(l)]
        lp = s[0]
        for i in range(l - 1, -1, -1):
            for j in range(i, l):
                if i == j:
                    dp[i][j] = True
                elif j == i + 1:
                    dp[i][j] = s[i] == s[j]
                elif j > i + 1:
                    dp[i][j] = dp[i + 1][j - 1] and s[i] == s[j]
                if dp[i][j] and j - i + 1 > len(lp):
                    lp = s[i:j + 1]

        return lp
