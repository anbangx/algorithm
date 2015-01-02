#include <stdio.h>
#include <iostream>
#include <string>

void link(std::string &str1, int offset, int size, std::string str2){
  int oldSize = str1.size();
  if(offset + size > oldSize){
    str1.append(offset + size - oldSize, '0');
  }
  str1.replace(offset, size, str2);
}

int main(){
  std::string str1 = "abcde";
  std::string str2 = "efg";
  link(str1, 6, 3, str2);
  printf("test1 str1: %s\n", str1.c_str());
  
  str1 = "abcde";
  link(str1, 3, 3, str2);
  printf("test2 str1: %s\n", str1.c_str());
  
  str1 = "abcde";
  link(str1, 1, 3, str2);
  printf("test3 str1: %s\n", str1.c_str());
}
