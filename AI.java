/**
 * Write a description of class AI here.
 * 
 * @author PeterB BenL
 * @version 1.0
 */
public class AI  
{
    //mode for AI to search for a new ship
   //picks 10 random potential shots. Uses primitive probability density algorithms to determine best shot to take
   public void seek()
   {
       
   }
   
   //once a new ship has been struck, destroy mode sinks the rest of the ship
   public void destroy()
   {
       
   }
   
   //finds larges ship still on board and finds how many instances of that ship could exist in the square,
   //returns that number
   public int checkDensity()
   {
        
   }
   
   //returns largest ship still on board
   public int getLargest()
   {
        if (!Carrier.isSunk())
            return 5;
        else if (!Battleship.isSunk())
            return 4;
        else if (!Submarine.isSunk() || !Destroyer.isSunk())
            return 3;
        else if (!Patrol.isSunk())
            return 2;
        else
            return 0;
   }
   
   
   public void pickShot()
   {
        
    }
}
