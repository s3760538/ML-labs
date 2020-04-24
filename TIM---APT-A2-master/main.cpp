#include <iostream>
#include <string>

#include "Menu.h"


using std::cin;
using std::cout;
using std::endl;

int main(int argc, char** argv) {
    Menu* menu = new Menu();

    delete menu;

    return EXIT_SUCCESS;
}