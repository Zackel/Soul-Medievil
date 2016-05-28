import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JefeB here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JefeB extends Enemigo
{
    /**
     * Act - do whatever the JefeB wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int x,y,vel,jx,jy;
    private boolean mueve;
    private int golpes;
    private Rayo r;
    private int nivel,band;
    public JefeB()
    {

        mueve=false;
        vel=Greenfoot.getRandomNumber(1);
        vel++;
        band=0;
    }

    public void act() 
    {

    }

    public void verifica()
    {
        Ba1 mundo = (Ba1)getWorld();
        int niv;
        niv=mundo.danivel();
        if(niv==1 && band==0)
        {
            golpes=1;
            vel=1;
            band++;
        }
        else if(niv==2 && band==0)
        {
            golpes=1;
            vel=2;
            band++;
        }
        else if(niv==3 && band==0)
        {
            golpes=1;
            vel=4;
            band++;
        }
        if(isTouching(Rayo.class))
        {
            golpes--;
            if(niv==3)
            {
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
        }
        if(isTouching(Jugador.class))
            mundo.restavidas();
        if(golpes==0)
        {
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
    }
}
