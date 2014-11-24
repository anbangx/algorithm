// cin with strings
#include <iostream>
#include <string.h>
#include <stdlib.h>
using namespace std;

int main ()
{
  // 1. test cin, cout and how to print char
//  char mybuffer [100];
//  cout << "What's your name? ";
//  cin.getline (mybuffer,100);
//  cout << "Hello " << mybuffer << ".\n";
//  cout << "Which is your favourite team? ";
//  cin.getline (mybuffer,100);
//  cout << "I like " << mybuffer << " too.\n";

  // 2. different format of char arrays
  char str1[] = { 'h', 'e', 'l', 'l', 'o', '\0' };
  char str2[] = "hello";
  char str3[6];
  str3[0] = 'h';
  str3[1] = 'e';
  str3[2] = 'l';
  str3[3] = 'l';
  str3[4] = 'o';
  str3[5] = '\0';
  char *str4 = str1;

  cout << "str1: " << str1 << endl;
  cout << "str2: " << str2 << endl;
  cout << "str3: " << str3 << endl;
  cout << "str4: " << str4 << endl;

  // 3. strcpy
  char szMyName [20];
  strcpy (szMyName, "J. Soulie");
  cout << szMyName << endl;
  return 0;

  // 4. ato* functions
  char mybuffer [100];
  float price;
  int quantity;
  cout << "Enter price: ";
  cin.getline (mybuffer,100);
  price = atof (mybuffer);
  cout << "Enter quantity: ";
  cin.getline (mybuffer,100);
  quantity = atoi (mybuffer);
  cout << "Total price: " << price * quantity;

  // 5. compare with string
  char CC[17];   // C character string (16 characters + NULL termination)
                  // Storage pre-allocated
  char *CC2;     // C character string. No storage allocated.

  strcpy(CC,"This is a string");

  CC2 = (char *) malloc(17);    // Allocate memory for storage of string.
  strcpy(CC2,"This is a string");

  cout << CC << endl;
  cout << CC2 << endl;

  return 0;
}
