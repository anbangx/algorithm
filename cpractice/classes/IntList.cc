#include <iostream>

#include "IntList.h"

IntList::IntList(){
  Items = new int[SIZE];
  numItems = 0;
  arraySize = SIZE;
}

int IntList::Length(){
  return arraySize;
}

int main()
{
  using namespace std;
  IntList intList;
  cout << "Length: " << intList.Length() << endl;
}
