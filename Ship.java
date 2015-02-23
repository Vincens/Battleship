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
    private String endpt1;
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
        GreenfootImage arrow = new GreenfootImage("black-arrow-md.png");
        this.setImage(arrow);
        while (!Greenfoot.isKeyDown("enter")){//needs to check for collisions and check boundaries
            if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")){
                orientation--;
                if (orientation < 0)
                    orientation = 3;
                arrow.rotate(-90);
            }
            if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")){
                orientation++;
                if (orientation > 3)
                    orientation = 0;
                arrow.rotate(90);
            }
        }
        //fills grid1 array with type elements at the location of the ship
        switch (orientation){
            case 0:
                for (int t = 0; t < this.shipHealth; t++)
                Battlefield.setGrid(1, Xcode, Ycode + t, type);
                break;
            case 1:
                for (int t = 0; t < this.shipHealth; t++)
                Battlefield.setGrid(1, Xcode + t, Ycode, type);
                break;
            case 2:
                for (int t = 0; t < this.shipHealth; t++)
                Battlefield.setGrid(1, Xcode, Ycode - t, type);
                break;
            case 3:
                for (int t = 0; t < this.shipHealth; t++)
                Battlefield.setGrid(1, Xcode - t, Ycode, type);
                break;
            default:
                break;
        }
        //_____ need to create the actual ship image at the proper location
        //maybe find endpt2 then create image at midpt?
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

