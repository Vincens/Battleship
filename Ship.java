import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @PeterB BenL
 * @1.0
 */
public class Ship extends Actor
{
    private int shipHealth;
    private int owner;
    public Ship (int health)
    {
        this.shipHealth = health;
        this.owner = 1;
    }
    
    public Ship (int health, int player)
    {
        this.shipHealth = health;
        this.owner = player;
    }
      
    public void placement()
    {
        String endpt1 = Greenfoot.ask("Input coordinate: ");
        int Ycode = Integer.parseInt(endpt1.substring(1)) - 1;
        int Xcode = Battlefield.charToInt(endpt1);
        
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

