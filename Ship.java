import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @PeterB BenL
 * @1.0
 */
 
public class Ship extends Actor
{
    private int shipHealth; // i.e. length of ship
    private int owner;
    private static String endpt1;
    private char type; //will fill the array at ship's location
    public Ship (int health, char shiptype)
    {
        this.shipHealth = health;
        this.owner = 1;
        this.type = shiptype;
        GreenfootImage Ship = new GreenfootImage("ShipPlaceholder.png");
        this.setImage(Ship);
    }
    
    public Ship (int health, int player, char shiptype)
    {
        this.shipHealth = health;
        this.type = shiptype;
        this.owner = player;
        GreenfootImage Ship = new GreenfootImage("ShipPlaceholder.png");
        this.setImage(Ship);
    }
      
    public void placement()
    {
        endpt1 = Greenfoot.ask("Input coordinate: ");
        int Ycode = Integer.parseInt(endpt1.substring(1)) - 1;
        int Xcode = Battlefield.charToInt(endpt1);
        // ____________ need to create arrow image at endpt1
        int orientation = 0;
        // 0=up 1=right 2=down 3=left
        //rotate left and right by 90 degrees until position is set with enter
        while (!Greenfoot.isKeyDown("enter")){
            if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")){
                orientation--;
                if (orientation < 0)
                    orientation = 3;
                arrow.turn(-90);
            }
            if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")){
                orientation++;
                if (orientation > 3)
                    orientation = 0;
                arrow.turn(90);
            }
        }
        
    }
    
    public void hit()
    {
        this.shipHealth--;
        checkSunk();
    }
    
    public int getHealth()
    {
        return this.shipHealth;
    }
    
    private void checkSunk()
    {
        if (this.shipHealth == 0)
            Battlefield.incrementScore();
    }
    
}

