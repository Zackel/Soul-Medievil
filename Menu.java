import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private World m;
    private int se;
    private Play jugar;
    private Help ayuda;
    private Record rec;
    private Ba1 mundo;
    private Creditos C;
    private Jugador jug1;

    private GreenfootSound press;
    private GreenfootSound fondo;
    /**
     * Construye los objetos que requiere, cada uno de los botones y musica
     *
     */
    public Menu()
    {    
        // Crea los botones y selecciona la musica
        super(800,600, 1); 
        press=new GreenfootSound("boton.wav");
        fondo=new GreenfootSound("menu.mp3");
        jugar=new Play();
        ayuda=new Help();
        rec=new Record();
        C=new Creditos();

        colocar();
    }

    // Coloca los botones
    public void colocar()
    {
        addObject(jugar,340,187);
        addObject(ayuda,340,287);
        addObject(rec,370,387);
        addObject(C,390,540);

    }

    // Comprueba si se toco alguno para acceder a otro mundo
    public void act()
    {
        fondo.playLoop();
        if(Greenfoot.getMouseInfo()!=null){ 
            if(Greenfoot.getMouseInfo().getButton()==1 && Greenfoot.getMouseInfo().getActor() == jugar)
            {
                press.play();
                Greenfoot.delay(30);
                fondo.stop();
                mundo=new Ba1();
                Greenfoot.setWorld(mundo);
                jug1=mundo.damejug();
                se=mundo.dameseg();
            }

        }

        if(Greenfoot.getMouseInfo()!=null){
            if(Greenfoot.getMouseInfo().getButton()==1 && Greenfoot.getMouseInfo().getActor()==ayuda)
            {
                press.play();
                Greenfoot.delay(5);
                fondo.stop();
                Greenfoot.setWorld(new Whelp());
            }
        }

        if(Greenfoot.getMouseInfo()!=null){
            if(Greenfoot.getMouseInfo().getButton()==1 && Greenfoot.getMouseInfo().getActor()==rec)
            {
                press.play();
                Greenfoot.delay(5);
                fondo.stop();
                
                Greenfoot.setWorld(new Wrecord());
            }
        }
        
         if(Greenfoot.getMouseInfo()!=null){
            if(Greenfoot.getMouseInfo().getButton()==1 && Greenfoot.getMouseInfo().getActor()==C)
            {
                press.play();
                Greenfoot.delay(5);
                fondo.stop();
                Greenfoot.setWorld(new Wcredito());
            }
        }
    }
}
