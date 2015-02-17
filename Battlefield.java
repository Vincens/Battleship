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
}

//firing/hit registration  
public void attack(){
    String firingcode = Greenfoot.ask("Input firing code");
    int Ycode = parseInt(firingcode.substring(1)) - 1;
    int Xcode = charToInt(firingcode.substring(0,1));
    checkHit(Xcode, Ycode);
}

//checks coordinates and returns what is at the location
public void checkHit(int x, int y){
    
}

//converts char to int
public int charToInt(String input){
    int output = 0;
    boolean flag = false;
    char temp = input.toLowerCase()
    while (!flag){
        switch(temp) {
            case "a":
                output = 0;
                flag = true;
                break;
            case "b":
                output = 1;
                flag = true;
                break;
            case "c": 
                output = 2;
                flag = true;
                break;
            case "d": 
                output = 3;
                flag = true;
                break;
            case "e": 
                output = 4;
                flag = true;
                break;
            case "f": 
                output = 5;
                flag = true;
                break;
            case "g": 
                output = 6;
                flag = true;
                break;
            case "h": 
                output = 7;
                flag = true;
                break;
            case "i": 
                output = 8;
                flag = true;
                break;
            case "j": 
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
