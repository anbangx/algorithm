package GeekForGeek.dp;

import java.util.ArrayList;

public class CoinCombination {

	public void dfs(int N, ArrayList<Integer> coins, int startIdx,
			ArrayList<Integer> candidate, ArrayList<ArrayList<Integer>> results) {
		if(N == 0){
			results.add(new ArrayList<Integer>(candidate));
			return;
		}
		for(int i = startIdx; i < coins.size(); i++){
			int coin = coins.get(i);
			if(coin <= N){
				candidate.add(coins.get(i));
				dfs(N - coin, coins, i, candidate, results);
				candidate.remove(candidate.size() - 1);
			} else
				break;
		}
	}

	public static void main(String[] args) {
		CoinCombination cc = new CoinCombination();
		ArrayList<Integer> coins = new ArrayList<Integer>();
		coins.add(1); coins.add(2); coins.add(3); //coins.add(6);
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		cc.dfs(4, coins, 0, new ArrayList<Integer>(), results);
		System.out.println(results);
	}

}
