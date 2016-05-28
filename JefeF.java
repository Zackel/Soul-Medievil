import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JefeF here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JefeF extends JefeA
{
    /**
     * Act - do whatever the JefeF wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int x,y,vel=10,jx,jy;
    private boolean mueve;
    private int golpes=2;
    private Rayo r;
    private int nivel,band;
    public JefeF()
    {
        this.getImage().scale(175,175);
    }
    
    public void act() 
    {
       mover();
       verifica();
    }    
    public void cambio()
    {
        Ba1 mundo = (Ba1)getWorld();
        mundo.setgana();
    }
    public void verifica()
    {
        Ba1 mundo = (Ba1)getWorld();
        
        if(isTouching(Rayo.class))
        {
            golpes--;
            
                if(Greenfoot.getRandomNumber(3)==2)
                {
                    x=x+Greenfoot.getRandomNumber(50);
                    y=y+Greenfoot.getRandomNumber(50);
                }
                else
                {
                    x=x-Greenfoot.getRandomNumber(50);
                    y=y-Greenfoot.getRandomNumber(50);
                }
                setLocation(x,y);
            }
        
            
        if(golpes==0)
        {
            cambio();
            mundo.MurioUno();
            mundo.removeObject(this);
        }
    }
    
    public void mover()
    {
        int ran;
        Ba1 mundo = (Ba1)getWorld();
        Jugador j = mundo.dimeJugador(); 
        
        jx=j.getX();
        jy=j.getY();
        
        x=getX();
        y=getY();
       
        if(x>jx)
            x=x-vel;
        if(y>jy)
            y=y-vel;
        if(x<jx)
            x=x+vel;
        if(y<jy)
            y=y+vel;
        
        if(Greenfoot.getRandomNumber(500)<100)
            setLocation(x,y);
            
        if(isTouching(Jugador.class))
        {
            mundo.restavidas();
            mundo.restavidas();
            mundo.restavidas();
        }
    }
}
