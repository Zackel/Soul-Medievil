import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Whelp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Whelp extends World
{

    private int cuenta;
    private GreenfootSound ayuda;
    public Whelp()
    {    
        // Se define el tamaño que es el standar en cada una de las pantallas y una musica de fondo
        super(800,600, 1); 
        ayuda=new GreenfootSound ("instru.mp3");
    }

    public void act()
    {
        // Muestra una secuencia de imagenes que explican brevemente el fin y el funcionamiento del juego
        ayuda.play();
        setBackground("Ayuda1.png");
        Greenfoot.delay(300);
        setBackground("ayuda2.png");
        Greenfoot.delay(300);   
        setBackground("ayuda3.png");
        Greenfoot.delay(300);
        setBackground("ayuda4.png");
        Greenfoot.delay(300);
        setBackground("ayuda5.png");
        Greenfoot.delay(300);
        ayuda.stop();
        Greenfoot.setWorld(new Menu());

    }
}
