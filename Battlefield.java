import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Grid here.
 * 
 * @author PeterB BenL 
 * @version 1.0
 */
public class Battlefield extends World
{

//constructor
public Battlefield()
{    
        super(1008, 1010, 1); 
        Ship Submarine = new Ship(3);
        Ship Patrol = new Ship(2);
        Ship Battleship = new Ship(4);  
        Ship Carrier = new Ship(5);
        Ship Destroyer = new Ship(3);
        
        //establish char array for the grid, fill it with 'e' for empty
        char[] grid = new char[10][10];
        for (int row=0; row<10; row++){
            for (int column=0; column<10; column++){
                grid[row][column]== 'e';
        
        //run the placement method to fill grid array with ships based on user input
}

//firing/hit registration
//user inputs firing coordinates, char gets converted to num, array location is called upon
public void attack(){
    String firingcode = Greenfoot.ask("Input firing code");
    int Ycode = parseInt(firingcode.substring(1)) - 1;
    int Xcode = charToInt(firingcode.substring(0,1));
    checkLocation(Xcode, Ycode);
}

//checks coordinates for ship
//returns value at that location
public void checkLocation(int x, int y){
    switch (grid[x][y]){
        case 'e':
            grid[x][y] = 'm';
            //print miss, change to m, create miss obj in world
            break;
        case '"h"'h:
            //print miss
            break;
        case 'm':
            //print miss
            break;
        case 's':
            Submarine.hit();
            grid[x][y] = 'h';
            //print hit, reduce sub hp, change to h, create hit obj in world
            break;
        case 'b':
            grid[x][y] = 'h';
            Battleship.hit();
            //print hit, reduce battleship hp, change to h, create hit obj in world
            break;
        case 'c':
            grid[x][y] = 'h';
            Carrier.hit();
            //print hit, reduce carrier hp, change to h, create hit obj in world
            break;
        case 'd':
            grid[x][y] = 'h';
            Destroyer.hit();
            //print hit, reduce destroyer hp, change to h, create hit obj in world
            break;
        case 'p':
            grid[x][y] = 'h';
            Patrol.hit();
            //print hit, reduce patrol boat hp, change to h, create hit obj in world
            break;
        default:
            //error
            break;
    }
}

//converts char to int
public int charToInt(String input){
    int output = 0;
    boolean flag = false;
    char temp = input.toLowerCase()
    while (!flag){
        switch(temp) {
            case 'a':
                output = 0;
                flag = true;
                break;
            case 'b':
                output = 1;
                flag = true;
                break;
            case 'c': 
                output = 2;
                flag = true;
                break;
            case 'd': 
                output = 3;
                flag = true;
                break;
            case 'e': 
                output = 4;
                flag = true;
                break;
            case 'f': 
                output = 5;
                flag = true;
                break;
            case 'g': 
                output = 6;
                flag = true;
                break;
            case 'h': 
                output = 7;
                flag = true;
                break;
            case 'i': 
                output = 8;
                flag = true;
                break;
            case 'j': 
                output = 9;
                flag = true;
                break;
            default: 
                flag = false;
                break;
        }
    }
return output;
}

/* values for char array:
    e empty
    h hit
    m miss
    c carrier
    b battleship
    d destroyer
    s submarine
    p patrol boat
*/   
}
