package in.kaixin.leetcode_byhand;

public class CountTriplets {
    public int countTriplets(int[] nums) {
//        https://leetcode.cn/problems/triples-with-bitwise-and-equal-to-zero/
        int cnt=0;
        for (int i=0;i<nums.length;i++){
            for (int j=i ;j<nums.length;j++){
                for (int k=j;k<nums.length;k++){
                    if((nums[i]&nums[j]&nums[k])==0){
                        if(i==j &&j==k){
                            cnt+=1;
                        }else if(i==j ||j==k){
                            cnt+=3;
                        }else {
                            cnt+=6;
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
