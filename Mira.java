import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mira here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mira extends Actor
{
    /**
     * Act - do whatever the Mira wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Ba1 mundo;
    private Jugador j;
    private boolean aba,arr,izq,der;
    private int x,y;
    public Mira()
    {
        aba=arr=izq=der=false;
        x=300;
        y=200;
    }
    public void act() 
    {
        // Add your action code here.
        CheckKeys();
    }    
    public void CheckKeys()
    {
        x=getX();
        y=getY();
        mundo = (Ba1)getWorld();
        j = mundo.dimeJugador();
        if (Greenfoot.isKeyDown("s"))
        {
            if(y<400)
            {
                aba=true;
            }
        }
        else
            aba=false;
        if (Greenfoot.isKeyDown("w"))
        {
            if(y>0)
            {
                arr=true;
            }
        }
        else
            arr=false;
     
        if (Greenfoot.isKeyDown("a"))
        {
            if(x>0)
            {
                izq=true;
            }
        }
        else 
            izq=false;
        
        if (Greenfoot.isKeyDown("d"))
        {
            if(x<600)
            {
                der=true;
            }
        }
        else
            der=false;
        
        if(Greenfoot.isKeyDown("space"))
        {
            mundo.addObject(new Rayo(),this.getX(),this.getY());
        }
        if(arr==true)
            y=y-3;
        
        if(aba==true)
            y=y+3;
            
        if(izq==true)
            x=x-3;
            
        if(der==true)
            x=x+3;
        
        setLocation(x,y);
    }
}
