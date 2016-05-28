import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Presenta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Presenta extends Actor
{

    private int niv;
    private int band=1;
    public Presenta()
    {
        setImage("lvl"+band+".png");
    }
    public void act()
    {
        
    }
    public void aumenta()
    {
        band++;
        setImage("lvl"+band+".png");
    }
}
