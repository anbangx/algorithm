class Solution {
public:
    int removeElement(int A[], int n, int elem) {
        int last = n - 1;
        for(int i = 0; i < n; ){
            if(i > last)
                break;
            if(A[i] == elem){
                swap(A, i, last);
                last--;
            }else
                i++;
        }
        return last + 1;
    }

    void swap(int A[], int idx1, int idx2){
        int temp = A[idx1];
        A[idx1] = A[idx2];
        A[idx2] = temp;
    }
};

int main(){

}
