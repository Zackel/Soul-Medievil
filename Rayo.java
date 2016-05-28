import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rayo extends Actor
{
    /**
     * Act - do whatever the Bala wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int fx,fy;
    private int mx,my;
    private Ba1 mundo;
    private Jugador j;
    private GifImage thunder = new GifImage("t.gif");
    public Rayo()
    {
       
    }
    public void act() 
    {
        setImage(thunder.getCurrentImage());
        mundo = (Ba1)getWorld();
        if(Greenfoot.getRandomNumber(1000)<50 || isTouching(Actor.class))
            mundo.removeObject(this);
    }    
}
