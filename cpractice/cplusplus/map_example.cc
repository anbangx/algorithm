#include <stdio.h>
#include <iostream>
#include <map>

struct extent_value {
  std::string data;
  int count;
};

main()
{
  std::map<int, extent_value *> first;
  extent_value *p = new extent_value();
 // extent_value v;
  p->data = "hi";
  p->count = 10;
 // p = &v;
  first[1] = p;
  if(first.find(1) != first.end())
    printf("first[1]->data=%s\n", first[1]->data.c_str());
  if(first.find(2) != first.end())
    printf("first[2]->data=%s\n", first[2]->data.c_str());
}

