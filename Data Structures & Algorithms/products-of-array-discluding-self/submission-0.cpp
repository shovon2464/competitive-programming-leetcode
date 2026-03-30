class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n=nums.size();
        vector<int> product(nums.size(),0);
        int result = 1;
        int zero = 0;
        for(int i=0;i<n;i++){
            if(nums[i] != 0){
                result *= nums[i];
            }
            else{
                zero += 1;
            }
        }
        
        for(int i=0;i<n;i++){
            if(nums[i] == 0 && zero>1){
                //cout<<nums[i]<<"1 ";
                product[i] = 0 ;
            }
            else if(nums[i] == 0 && zero ==1){
                //cout<<nums[i]<<"2 ";
                product[i] = static_cast<int>(result);
            }
            else if(nums[i] !=0 && zero == 0){
                //cout<<nums[i]<<"3 ";
                product[i] =static_cast<int>(result/nums[i]);
            }
            else if(nums[i] !=0 && zero==1){
                //cout<<nums[i]<<"4 ";
                product[i] =0;
            }
        }
        return product;
    }
};
