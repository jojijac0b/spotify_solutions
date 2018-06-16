class ChangePossibilities{


  public static void main(String[] args){
    ChangePossibilities c = new ChangePossibilities();
    System.out.println(c.changePossibilities(new int[]{1,2,3}, 4)); // should be 4
    System.out.println(c.changePossibilities(new int[]{1,4,6,8,9}, 25)); // should be 52
  }

  public int changePossibilities(int[] coins, int target){
    int[][] dp = new int[coins.length+1][target+1];

    for(int i = 1; i < dp.length; i++){
      int value = coins[i-1];
      dp[i][0] = 1;
      for(int j = 1; j < dp[0].length; j++){
        dp[i][j] = dp[i-1][j];
        if(j >= value) dp[i][j] += dp[i][j-value];
      }
    }

    return dp[dp.length-1][dp[0].length-1];
  }
}


/*
  goal: given a coin values array and a target number return how many different ways you can get to that value using the coins
        given

  approach:
    - this is a dynamic programming problem because we can use the values we have previously calculated and use them
      to build up our answer(overlapping sub problem)
    - use a 2d array where dp[i][j] = the number of ways to get to value j using all the given coins from 0 to i in the
      given coin values array
    - relation: dp[i][j] = dp[i-1][j] + (if j >= the value at coins[j-1]) dp[i][j-coins[j-1]]

  time complexity: O(n*m) where n = the number of coins and m = the target value
  space complexity: O(n*m) where n = the number of coins and m = the target value (for our 2d array)

*/
