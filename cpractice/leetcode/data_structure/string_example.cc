#include <string>
#include <iostream>

using namespace std;

int main()
{
  // 1. initiate string
  string SS;     // C++ STL string
  string SS2;    // C++ STL string

  SS = "This is a string";
  SS2 = SS;

  cout << SS << endl;
  cout << SS2 << endl;

  // 2. string replace with different characters
  string g("abc abc abd abc");
  cout << g.replace(4,1,"ijk",3) << endl;

  string h("abc abc abd abc");
  cout << h.replace(4,6,"ijk",3) << endl;

  string k("abc abc abd abc");
  cout << k.replace(4,3,"ijk",3) << endl;

  string l("abc abc abd abc");
  cout << k.replace(12,1,"xyz",3) << endl;
}
