import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JefeA2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JefeA2 extends JefeA
{
    /**
     * Act - do whatever the JefeA2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */


    private int golpes=30;
    
   
    
    public void act() 
    {
        // Add your action code here.
        
        mover();
        verifica();
    }    
     public void cambio()
    {
        Ba1 mundo = (Ba1)getWorld();
        mundo.setniv3();
    }

}
