class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
      unordered_map<string,vector<string>> tracker;
      for(int i=0;i<strs.size();i++){
        string s = strs[i];
        vector<int> arr1(26,0);
        for(int j=0;j<s.size();j++){
            arr1[s[j]-'a'] += 1;
        }
        string r = "";
        for(int j=0;j<26;j++){
            r += arr1[j];
            r += "#";
        }
        if(tracker.find(r) == tracker.end()){
            tracker[r] = vector<string>{s};
        }
        else{
            tracker[r].push_back(strs[i]);
        }
      } 
      vector<vector<string>> result;
      for(auto v : tracker){
        result.push_back(v.second);
      } 
      return result;
    }
};
