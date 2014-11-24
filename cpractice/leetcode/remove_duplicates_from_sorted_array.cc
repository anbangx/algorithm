class Solution {
public:
    int removeDuplicates(int A[], int n) {
        if(n == 0)
            return 0;
        int cur = 1;
        int preElem = A[0];
        for(int i = 1; i < n; i++){
            if(A[i] != preElem){
                A[cur++] = A[i];
                preElem = A[i];
                continue;
            }
        }
        return cur;
    }
};

int main(){

}
