#include "node.h"

class Solution {
public:
    int maxDepth(TreeNode *root) {
        if(root == NULL)
            return 0;
        return maxDepth(root, 0);
    }
    int maxDepth(TreeNode *root, int curDepth){
        if(root == NULL)
            return curDepth;
        int leftDepth = maxDepth(root->left, curDepth + 1);
        int rightDepth = maxDepth(root->right, curDepth + 1);
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }
};

int main(){
}