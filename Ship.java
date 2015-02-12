import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends Actor
{
    private int shipHealth;
    public Ship (int health)
    {
        this.shipHealth = health;
    }
    public void hit()
    {
        this.shipHealth--;
    }
    public int getHealth()
    {
        return this.shipHealth;
    }
}
