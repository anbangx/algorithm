#include <string>
#include <stdio.h>

int main()
{
  std::string s = "hello world";
  std::string substr = s.substr(0, 3);
  printf("substr: %s\n", substr.c_str());
}
