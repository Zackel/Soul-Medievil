import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wcredito here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wcredito extends World
{

    private Salir salir;
    private GreenfootSound credi;
    public Wcredito()
    {    
        super(600, 400, 1); 
        credi=new GreenfootSound("credito.mp3");
        salir=new Salir();
        colocar();
    }

    //Coloca el boton de salir
    public void colocar()
    {
        addObject(salir,750,50);
    }

    public void act()
    {
        credi.play();
        if(Greenfoot.getMouseInfo()!=null){ 
            if(Greenfoot.getMouseInfo().getButton()==1 && Greenfoot.getMouseInfo().getActor() == salir)
            {
                Greenfoot.delay(30);
                credi.stop();
                Greenfoot.setWorld(new Menu());
            }

        }
    }
}
