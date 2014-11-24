#include <iostream>
#include <vector>
#include <map>
#include <set>
#include <algorithm>
#include <string>
using namespace std;

class Solution {
public:
    vector<string> anagrams(vector<string> &strs) {
        int len = strs.size();
        vector<string> result;
        if(len == 0) return result;

        multimap<string, string> mmp;
        set<string> order;
        vector<string>::iterator it; //scan the string vector
        for (it = strs.begin(); it!= strs.end(); it++){
            string ss = *it;
            sort(ss.begin(), ss.end());
            mmp.insert(pair<string, string>(ss, *it));
            order.insert(ss);
        }
        pair<multimap<string,string>::iterator,multimap<string,string>::iterator> ret;
        multimap<string,string>::iterator iit;
        set<string>::iterator oit;
        for(oit = order.begin(); oit != order.end(); oit++){
            if(mmp.count(*oit) > 1){
                ret = mmp.equal_range((*oit));
                for(iit = ret.first; iit != ret.second; iit++){
                    result.push_back((*iit).second);
                }
            }
        }
    }
};

int main(){

}
