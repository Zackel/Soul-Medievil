import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador extends Actor
{
    /**
     * Act - do whatever the Jugador wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int x,y;
    private int vel=2;
    private boolean dir,izq,der,arr,aba;
    
    public Jugador(int a,int b)
    {
        x=a;
        y=b;
        dir=true;
        izq=der=arr=aba=false;
    }
    public void act() 
    {
        // Add your action code here.
        Ba1 mundo = (Ba1)getWorld();
        CheckKeys();
    }
    
    public void CheckKeys()
    {
        x=getX();
        y=getY();
        
        if (Greenfoot.isKeyDown("Down"))
        {
            if(y<400)
            {
                aba=true;
            }
        }
        else
            aba=false;
        if (Greenfoot.isKeyDown("Up"))
        {
            if(y>0)
            {
                arr=true;
            }
        }
        else
            arr=false;
            //                this.setImage(_image_);
        
        if (Greenfoot.isKeyDown("Left"))
        {
            if(x>0)
            {
                izq=true;
            }
        }
        else 
            izq=false;
        
        if (Greenfoot.isKeyDown("Right"))
        {
            if(x<600)
            {
                der=true;
            }
        }
        else
            der=false;
        
            
        if(arr==true)
            y=y-vel;
        
        if(aba==true)
            y=y+vel;
            
        if(izq==true)
            x=x-vel;
            
        if(der==true)
            x=x+vel;
        
        setLocation(x,y);
    }
    public void tomabota()
    {
        vel++;
    }
}
