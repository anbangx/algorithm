#include <vector>
#include <string>
#include <iostream>
using namespace std;

struct item{
  string key;
  string value;
};

int main()
{
  vector<item> items;
  item item1;
  item1.key = "a";
  item1.value = "aa";
  item item2;
  item2.key = "b";
  item2.value = "bb";
  items.push_back(item1);
  items.push_back(item2);

  // print
  for(int i = 0; i < items.size(); i++){
    cout << items[i].key << endl;
  }
}
