import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.StringTokenizer;
/**
 * Write a description of class Wrecord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wrecord extends World
{      private Salir salir;

    /**
     * Constructor for objects of class Wrecord.
     * 
     */
    private rec Act;
    public Wrecord()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        Act=new rec();
        salir=new Salir();
        addObject(salir,500,50);
        
        
        
    }
    public void act(){
    this.escribeRecords();
    if(Greenfoot.getMouseInfo()!=null){ 
            if(Greenfoot.getMouseInfo().getButton()==1 && Greenfoot.getMouseInfo().getActor() == salir)
            {
                Greenfoot.delay(30);
                
                Greenfoot.setWorld(new Menu());
            }

        }
    }
    
    public void escribeRecords(){
        int y1 = 170;
           for(Player aux : Act.escribeTabla())
            {
                showText(aux.getName(),200,y1);
                showText(aux.getPoints()+"",400,y1);
                y1 = y1 + 30;
            }
    }
    
   
   
}

