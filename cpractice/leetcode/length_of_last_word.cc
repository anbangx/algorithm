#include <string.h>

class Solution {
public:
    int lengthOfLastWord(const char *s) {
        int len = strlen(s);
        if(len == 0)    return 0;
        int res = 0;
        for(int i = len - 1; i >= 0; i--){
            if(s[i] != ' ')
                res++;
            else{
                if(res > 0)
                    return res;
            }
        }
        return res;
    }
};

int main(){
}