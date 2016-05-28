import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemigo extends Actor
{
    /**
     * Act - do whatever the Enemigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }   
    public void muere()
    
   {
       Ba1 mundo = (Ba1)getWorld();
       
       if(this.isTouching(Jugador.class))
       {
           
           mundo.restavidas();
           Jugador j=mundo.dimeJugador();
           j.setLocation(350,50);
           
        } 
    }
}
