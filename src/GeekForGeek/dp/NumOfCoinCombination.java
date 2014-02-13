package GeekForGeek.dp;

public class NumOfCoinCombination {
	
	public int count(int[] coins, int m, int N){
		if(N == 0)
			return 1;
		if(N < 0)
			return 0;
		if(m <= 0 && N >= 1)
			return 0;
		
		return count(coins, m - 1, N) + count(coins, m, N - coins[m]);
	}
	
	public int countByDP(int[] S, int m, int N){
		int[] dp = new int[N + 1];
		dp[0] = 1;
		for(int i = 1; i < N + 1; i++){
			for(int j = 0; j < m; j++){
				if(i - S[j] >= 0){
					dp[i] += dp[i - S[j]];
				}
			}
		}
		return dp[N];
	}
	
	public int countByDP2(int[] S, int m, int N){
		int dp[][] = new int[N + 1][m];
		for(int j = 0; j < m; j++){
			dp[0][j] = 1;
		}

		for(int i = 1; i < N + 1; i++){
			for(int j = 0; j < m; j++){
				// including S[j]
				int x = i - S[j] >= 0 ? dp[i - S[j]][j] : 0;
				// excluding S[j]
				int y = j >= 1 ? dp[i][j - 1] : 0;
				
				dp[i][j] = x + y;
			}
		}
		return dp[N][m - 1];
	}
	
	public static void main(String[] args) {
		int[] S = {1,2,3};
		int N = 4;
		NumOfCoinCombination ncc = new NumOfCoinCombination();
		System.out.println(ncc.countByDP(S, 3, N));
		System.out.println(ncc.countByDP2(S, 3, N));
	}

}
