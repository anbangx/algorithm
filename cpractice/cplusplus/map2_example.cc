#include <stdio.h>
#include <iostream>
#include <map>

main()
{
  std::map<int, char> first;
  first[1] = 'p';
  printf("first[1]=%c", first[1]);
}

