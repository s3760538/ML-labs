#include "Menu.h"

using std::cin;
using std::cout;
using std::endl;
using std::string;

Menu::Menu() {
    mainMenu =
        ("Menu\n----\n1. New Game\n2. Load Game\n3. Credits (Show student "
         "information)\n4. Quit\n");

    printMenu();
}

Menu::~Menu() { mainMenu = ""; }

// Print basic menu and call handleUserInput
void Menu::printMenu() {
    cout << mainMenu << endl;
    handleUserInput();
}

// Accept user input and call appropriate methods accordingly - If input invalid
// print exception and recall handleUserInput Assumed user prompt is given by >
// followed by any text - See 2.3 in A2 spec
void Menu::handleUserInput() {
    // Print prompt
    cout << "> ";

    string input = "";
    cin >> input;

    //  Since switch statements are banned :'(
    if (input == "1") {
        newGame();
    } else if (input == "2") {
        loadGame();
    } else if (input == "3") {
        showCredits();
    } else if (input == "4") {
        quit();
    } else {
        cout << "Please type the number of an option in the menu." << endl;
        handleUserInput();
    }
}

// Start a new game
void Menu::newGame() {}

// Load a new game
void Menu::Menu::loadGame() {}

// Print student (our) information - See pg6 of A2 spec for example print
void Menu::showCredits() {
    //array of each contributor's attributes
    string names[] = {"Rylee Randall", "Marcus Matic", "Alana Tobgui"};
    string id[] = {"s3780297", "s3703981", "s3760538"};
    string email[] = {"s3780297@student.rmit.edu.au", "s3703981@student.rmit.edu.au", "s3760538@student.rmit.edu.au"};
    //iteratively print out student information
    for (int i = 0; i < sizeof(names); i++) {
        cout << "Name: " << names[i] << endl;
        cout << "Student ID: " << id[i] <<  endl;
        cout << "Email: " << email[i] <<  endl;
        cout << " " <<endl;

    }
    //go back to print menu 
    printMenu();

   

}

// Empty method to cease further input, thus returns to main to delete menu and
// close
void Menu::quit() {}