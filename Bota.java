import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bota here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bota extends Actor
{
    /**
     * Act - do whatever the Bota wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int x,y;
    public void act() 
    {
        mueve();
       verifica();
       
      
    }
    
    public void mueve()
    {
         Ba1 mundo = (Ba1)getWorld();
         x=getX();
         y=getY();
         x--;
         y--;
        
         if(x<0)
            mundo.removeObject(this);
         if(Greenfoot.getRandomNumber(500)<100)
            setLocation(x,y);
    }
    public void verifica()
    {
        Ba1 mundo = (Ba1)getWorld();
        if(isTouching(Jugador.class))
        {
            mundo.aumentavel();
            mundo.removeObject(this);
        }
    }
}
