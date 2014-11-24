#include "stddef.h"
#include "node.h"

class Solution {
public:
    ListNode *swapPairs(ListNode *head) {
        if(head == NULL || head->next == NULL)
            return head;
        ListNode *second = head->next;
        ListNode *third = swapPairs(second->next);
        second->next = head;
        head->next = third;
        return second;
    }
};

int main(){
}
