import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Grid here.
 * 
 * @author PeterB BenL 
 * @version 1.0
 */
public class Battlefield extends World
{
private static char[][] grid1;
private static  char[][] grid2;
private static int p1Score;
private static int p2Score;
public Ship Submarine, Patrol, Battleship, Carrier, Destroyer;
//constructor
public Battlefield()
{    
        super(1200, 600, 1);
        GreenfootImage backg = new GreenfootImage("Background2.png");
        setBackground(backg);
        p1Score = 0;
        p2Score = 0;        
        grid1 = createGrid();
        grid2 = createGrid();
        displayShips();
        //run the placement method to fill grid array with ships based on user input
}
public void playGame()
{
    this.showText("Please place a Submarine (3x1)",this.getWidth()/2, this.getHeight()/2);
    Greenfoot.delay(10);
    Submarine.placement();
    this.showText("Please place a Patrol (2x1)",this.getWidth()/2, this.getHeight()/2);
    Greenfoot.delay(10);
    Patrol.placement();
    this.showText("Please place a Battleship (4x1)",this.getWidth()/2, this.getHeight()/2);
    Greenfoot.delay(10);
    Battleship.placement();
    this.showText("Please place a Carrier (5x1)",this.getWidth()/2, this.getHeight()/2);
    Greenfoot.delay(10);
    Carrier.placement();
    this.showText("Please place a Destroyer (3x1)",this.getWidth()/2, this.getHeight()/2);
    Greenfoot.delay(10);
    Destroyer.placement();
    this.showText("",this.getWidth()/2, this.getHeight()/2);
}
//method for creating the array, so we can call it twice
public char[][] createGrid()
{
    //establish char array for the grid, fill it with 'e' for empty
    char[][] grid;
    grid = new char[10][10];
    for (int row = 0; row < 10; row++){
        for (int column=0; column<10; column++){
            grid[row][column]= 'e';
        }
    }
    return grid;
}
//firing/hit registration
//user inputs firing coordinates, char gets converted to num, array location is called upon
public void attack(){
    String firingcode = Greenfoot.ask("Input firing code");
    int Ycode = Integer.parseInt(firingcode.substring(1)) - 1;
    int Xcode = charToInt(firingcode);
    checkLocation(Xcode, Ycode);
}

//changes array, hits ship, prints result, creates hit and miss objects
//we'll  probably want to move the text boxes but I set them up in the middle of the screen for now
public void checkLocation(int x, int y){
    char placeholder = grid1 [x][y];
    switch (placeholder){
        case 'e':
            grid1[x][y] = 'm';
            this.showText("Miss",this.getWidth()/2, this.getHeight()/2);
            Greenfoot.delay(2);
            this.showText("",this.getWidth()/2, this.getHeight()/2);
            //create miss obj in world
            break;
        case 'h':
            this.showText("Miss", this.getWidth()/2, this.getHeight()/2);
            Greenfoot.delay(2);
            this.showText("",this.getWidth()/2, this.getHeight()/2);
            break;
        case 'm':
            this.showText("Miss", this.getWidth()/2, this.getHeight()/2);
            Greenfoot.delay(2);
            this.showText("",this.getWidth()/2, this.getHeight()/2);
            break;
        case 's':
            Submarine.hit();
            grid1[x][y] = 'h';
            this.showText("Hit", this.getWidth()/2, this.getHeight()/2);
            Greenfoot.delay(2);
            this.showText("",this.getWidth()/2, this.getHeight()/2);
            //create hit obj in world
            break;
        case 'b':
            grid1[x][y] = 'h';
            Battleship.hit();
            this.showText("Hit", this.getWidth()/2, this.getHeight()/2);
            Greenfoot.delay(2);
            this.showText("",this.getWidth()/2, this.getHeight()/2);
            //create hit obj in world
            break;
        case 'c':
            grid1[x][y] = 'h';
            Carrier.hit();
            this.showText("Hit", this.getWidth()/2, this.getHeight()/2);
            Greenfoot.delay(2);
            this.showText("",this.getWidth()/2, this.getHeight()/2);
            //create hit obj in world
            break;
        case 'd':
            grid1[x][y] = 'h';
            Destroyer.hit();
            this.showText("Hit", this.getWidth()/2, this.getHeight()/2);
            Greenfoot.delay(2);
            this.showText("",this.getWidth()/2, this.getHeight()/2);
            //create hit obj in world
            break;
        case 'p':
            grid1[x][y] = 'h';
            Patrol.hit();
            this.showText("Hit", this.getWidth()/2, this.getHeight()/2);
            Greenfoot.delay(2);
            this.showText("",this.getWidth()/2, this.getHeight()/2);
            //create hit obj in world
            break;
        default:
            this.showText("Error", this.getWidth()/2, this.getHeight()/2);
            Greenfoot.delay(2);
            this.showText("",this.getWidth()/2, this.getHeight()/2);
            break;
    }
}
/**
//returns true if the ship will run off the edge of the grid
//called on in placement() in ship class
public boolean checkBoundaries(int direction, int x, int y, int length)
{
    switch (direction){
        case 0:
            if (y + length > 10)
                return true;
            else
                return false;
            break;
        
        case 1:
            if (x + length > 10)
                return true;
            else 
                return false;
            break;
        case 2:
            if (y - length < 0)
                return true;
            else 
                return false;
            break;
        case 3:
            if (x - length < 0)
                return true;
            else 
                return false;
            break;
        default:
                return false;
            break;
        
    }
}

//checks grid array where ship will be placed to check for existing ships
//returns true if overlap exists
public boolean checkOverlap(int direction, int x, int y, int length)
{
    switch (direction){
        case 0:
            
            break;
        case 1:
            
            break;
        case 2:
            
            break;
        case 3:
            
            break;
        default:
            return false;
            break;
        
    }
}
**/
//called on in checkSunk() in ship class
public void checkVictory()
{
    if (p1Score == 5){
        this.showText("Player One wins!", this.getWidth()/2, this.getHeight()/2);
        Greenfoot.delay(5);
        Greenfoot.stop();
    }
    else if (p2Score == 5){
        this.showText("Player Two wins!", this.getWidth()/2, this.getHeight()/2);
        Greenfoot.delay(5);
        Greenfoot.stop();
    }
}
//converts char to int
public static int charToInt(String input){
    int output = 0;
    boolean flag = false;
    char temp = input.toLowerCase().charAt(0);
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

public static void incrementScore(int playerNum)
{
    if (playerNum == 1)
        p1Score++;
    else
    if (playerNum == 2)
        p2Score++;
}

public static void incrementScore()
{
    p1Score++;
}

//sets grid element
//called in placement method of ship class
public static void setGrid(int gridNum, int x, int y, char fill)
{
    if (gridNum == 1)
        grid1[x][y] = fill;
    if (gridNum == 2)
        grid2[x][y] = fill;
}
public void printGrid()
{
    for (int row = 0; row < 10; row++){
        for (int column=0; column<10; column++){
            System.out.print(grid1[row][column]);
        }
        System.out.println();
    }
}
private void displayShips()
{
    Submarine = new Ship(3,'s');
    Patrol = new Ship(2, 'p');
    Battleship = new Ship(4, 'b');  
    Carrier = new Ship(5, 'c');
    Destroyer = new Ship(3, 'd');
    addObject(Submarine, 82, 300);
    addObject(Patrol, 132, 300);
    addObject(Battleship, 182, 300);
    addObject(Carrier, 232, 300);
    addObject(Destroyer, 282, 300);
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
