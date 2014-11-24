#include <vector>
#include "node.h"
#include "stddef.h"
using namespace std;

class Solution {
public:
    vector<vector<int> > levelOrder(TreeNode *root) {
        vector<vector<int> > results;
        if(root == NULL)
            return results;

        vector<TreeNode *> prev;
        prev.push_back(root);
        vector<TreeNode *> cur;
        while(prev.size() > 0){
            cur.clear();
            vector<int> vals;
            for(int i = 0; i < prev.size(); i++){
                if(prev[i]->left != NULL)
                    cur.push_back(prev[i]->left);
                if(prev[i]->right != NULL)
                    cur.push_back(prev[i]->right);
                vals.push_back(prev[i]->val);
            }
            results.push_back(vals);
            prev = cur;
        }
        return results;
    }
};

int main(){

}
