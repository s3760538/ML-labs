//Menu Class: Focuses on printing the main menu and accepting input from user to navigate through program
// Each method prompts handleUserInput after finishing to await further input from user. 
// Once input is no longer requested (e.g. quit() is called), returns to menu and deletes menu to close

#include <iostream>
#include <string>

class Menu {
public:
    // Constructor/Destructor
    Menu();
    ~Menu();

    //Print basic menu and call handleUserInput 
    void printMenu();

    //Accept user input and call appropriate methods accordingly
    void handleUserInput();

    //Start a new game
    void newGame();

    //Load a new game
    void loadGame();

    //Print student (our) information - See pg6 of A2 spec for example print
    void showCredits();

    //Blank method to cease further input, thus returns to main to delete menu and close
    void quit();

private:
    
    std::string mainMenu; 
};

