#include <stdio.h>
#include <iostream>
#include <string>

int main()
{
  std::string s = "test string replace";
  std::string replace = "hello hadoop hello world";
  std::string new_str = s.replace(15, replace.size(), replace);
  printf("new_str: %s\n", new_str.c_str());
}
