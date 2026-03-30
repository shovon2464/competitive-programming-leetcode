class Solution {
public:
    string stringify(string s){
        vector<int> tracker(26,0);
        for(int i=0;i<s.size();i++){
            int c = s[i]-'a';
            tracker[c] += 1;
        }
        string r = "";
        for(int i=0;i<26;i++){
            r += to_string(tracker[i]);
            r += "#";
        }
        return r;
    }
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string,vector<string>> tracker;
        for(int i=0;i<strs.size();i++){
            string stringified = stringify(strs[i]);
            if(tracker.find(stringified) == tracker.end()){
                tracker[stringified] = vector<string>{strs[i]};
            }
            else{
                tracker[stringified].push_back(strs[i]);
            }
        }
        vector<vector<string>> result;
        for(auto v : tracker){
            result.push_back(v.second);
        }
        return result;
    }
};
