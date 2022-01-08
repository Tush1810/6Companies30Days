/*
    https://practice.geeksforgeeks.org/problems/total-decoding-messages1235/1/#
*/

class Solution
{
    private long mod=1_000_000_007;
    public int CountWays(String str)
    {
        int n=str.length();
        char[] arr=str.toCharArray();
        if(arr[0]=='0') return 0;
        for(int i=1;i<n;i++){
            if(arr[i]=='0'&&((arr[i-1]-'0')==0||(arr[i-1]-'0')>2)){
                return 0;
            }
        }
        long[] dp=new long[str.length()+1];
        Arrays.fill(dp,-1);
        return (int)CountWays(arr,0,dp);
    }

    private long CountWays(char[] arr,int left,long[] dp)
    {
        if(dp[left]!=-1) return dp[left];
        if(left<arr.length&&arr[left]=='0') return 0;
        if(left==arr.length-1) return 1;
        if(left==arr.length) return 1;
        long ans=CountWays(arr,left+1,dp)%mod;
        if(left+1<arr.length){
            int num1=arr[left]-'0',num2=arr[left+1]-'0';
            int temp=num1*10+num2;
            if(temp<=26&&temp>=1){
                ans=(ans+(CountWays(arr,left+2,dp)%mod))%mod;
            }
        }
        return dp[left]=ans;
    }
}
