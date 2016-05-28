import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
/**
 * Write a description of class Ba1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ba1 extends World
{
    private GreenfootImage p1;

    private Counter cvidas;
    private Counter csangre;
    private Counter cnivel;
    private Counter cenemigos;
    private Counter cadReloj;

    private Jugador j;
    private int segundos=0;
    private int totalenemigos;
    private int enemigos;
    private int nivel=1;
    private Mira m;
    private int mx,my;
    private int golpes;
    private int vidas;
    private int vel;
    private Presenta presenta;

    private int band=1;
    
    private SimpleTemp reloj;

    private GreenfootSound s1; //Musica para niveles del 1 al 3
    private GreenfootSound s2;
    private GreenfootSound s3;
    private GreenfootSound s4;

    /**
     * Constructor for objects of class Ba1.
     * 
     */
    public Ba1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        j=new Jugador(300,200);
        addObject(j,300,200);
        m=new Mira();
        mx=Greenfoot.getMouseInfo().getX();
        my=Greenfoot.getMouseInfo().getY();
        m.getImage().scale(50,50);
        addObject(m,mx,my);
        nivel=1;
        golpes=100;
        enemigos=0;
        totalenemigos=10;
        vidas=3;
        presenta=new Presenta();
        reloj=new SimpleTemp();
        cnivel=new Counter("Nivel : ");
        cvidas=new Counter("Vidas : ");
        csangre=new Counter("Sangre : ");
        cenemigos=new Counter("Enemigos : ");
       cadReloj=new Counter("Tiempo: ");
       cadReloj.setValue(0);
        
        addObject(cadReloj,50,80);
        cadReloj.setValue(0);

        addObject(cnivel,50,20);
        addObject(csangre,200,20);
        addObject(cvidas,350,20);
        addObject(cenemigos,500,20);

        s1=new GreenfootSound("nivel1.mp3");
        s2=new GreenfootSound("nivel2.mp3");
        s3=new GreenfootSound("nivel3.mp3"); //Poner ruta de canciones
        s4=new GreenfootSound("nivel4.mp3");
        // p1=new GreenfootImage("p1.png");  
    }

    public void act()
    {
        s4.playLoop();
        cnivel.setValue(nivel);
        cenemigos.setValue(totalenemigos);
        cvidas.setValue(vidas);
        csangre.setValue(golpes);
       
        
       
        
        if(Greenfoot.getRandomNumber(3000)<3)
            addObject(new Bota(),550, 350);
        if((golpes<=0)&&(vidas<=0))
                setpierde();
        if(nivel==1)
            nivel1();
        else if(nivel==2)
            nivel2();
        else if(nivel==3)
            nivel3();
            
         if(reloj.MiliTrascurridos()>=1000)
        {
            reloj.Marca();
            cadReloj.add(1);
            segundos++;
        }
            
         
    }

    public void agregaenemigo(int num)
    {
        if(num==1)
            addObject(new JefeB1(),Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
        else if(num==2)
            addObject(new JefeB2(),Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
        else if(num==3)
            addObject(new JefeB3(),Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
        else if(num==4)
            addObject(new JefeB4(),Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
        else if(num==5)
            addObject(new JefeB5(),Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
        else if(num==6)
            addObject(new JefeB6(),Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
        else if(num==7)
            addObject(new JefeB7(),Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
        else if(num==8)
            addObject(new JefeB8(),Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
        else if(num==9)
            addObject(new JefeB9(),Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
        else if(num==10)
            addObject(new JefeB10(),Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
        else if(num==11)
            addObject(new Jefe11(),Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
        else if(num==12)
            addObject(new JefeB12(),Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
        else if(num==13)
            addObject(new Jefe13(),Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
        else if(num==14)
            addObject(new Jefe14(),Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
        else if(num==15)
            addObject(new Jefe15(),Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
        else if(num==16)
            addObject(new Jefe16(),Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));       
    }

    public void nivel1()
    {
        if(band==1)
        {
            addObject(presenta,300,200);
            Greenfoot.delay(100);
            removeObject(presenta);
            presenta.aumenta();
            band++;
        }
        setBackground("base1.png");
        getBackground().scale(600,400);
        if(Greenfoot.getRandomNumber(2000)<50)
        {
            if(enemigos<5 && totalenemigos>0)
            {
                agregaenemigo(Greenfoot.getRandomNumber(16));
                totalenemigos--;
                enemigos++;
            }
            if(totalenemigos==0)
            {  
                nivel=999;

                totalenemigos=15;
                enemigos=0;

                Jefe1();
            }
        }
    }

    public void Jefe1()
    {
        if(band==2)
        {
            addObject(presenta,300,200);
            Greenfoot.delay(100);
            removeObject(presenta);
            presenta.aumenta();
            band++;
        }
        removeObjects(getObjects(JefeB.class));

        agregaenemigo(1);
        agregaenemigo(2);

        JefeA1 ja=new JefeA1();

        addObject(ja,300,50);

        if(ja.mori()==true)
            nivel=2;
    }

    public void nivel2()
    {
        if(band==3)
        {
            addObject(presenta,300,200);
            Greenfoot.delay(100);
            removeObject(presenta);
            presenta.aumenta();
            band++;
        }
        setBackground("base2.png");
        getBackground().scale(600,400);

        if(Greenfoot.getRandomNumber(2000)<50)
        {
            if(enemigos<5 && totalenemigos>0)
            {
                agregaenemigo(Greenfoot.getRandomNumber(16));
                totalenemigos--;
                enemigos++;
            }
            if(totalenemigos==0)
            {
                nivel=999;
                totalenemigos=15;
                enemigos=0;

                Jefe2();
            }
        }
    }

    public void Jefe2()
    {
        if(band==4)
        {
            addObject(presenta,300,200);
            Greenfoot.delay(100);
            removeObject(presenta);
            presenta.aumenta();
            band++;
        }
        removeObjects(getObjects(JefeB.class));

        agregaenemigo(3);
        agregaenemigo(4);

        JefeA2 ja=new JefeA2();

        addObject(ja,300,50);
    }

    public void nivel3()
    {
        if(band==5)
        {
            addObject(presenta,300,200);
            Greenfoot.delay(100);
            removeObject(presenta);
            presenta.aumenta();
            band++;
        }
        setBackground("base3.png");
        getBackground().scale(600,400);
        if(Greenfoot.getRandomNumber(2000)<50)
        {
            if(enemigos<5 && totalenemigos>0)
            {
                agregaenemigo(Greenfoot.getRandomNumber(16));
                totalenemigos--;
                enemigos++;
            }
            if(totalenemigos==0)
            {    
                nivel=999;
                totalenemigos=999;
                enemigos=0;

                Jefe3();
            }
        }
    }

    public void Jefe3()
    {
        if(band==6)
        {
            addObject(presenta,300,200);
            Greenfoot.delay(100);
            removeObject(presenta);
            presenta.aumenta();
            band++;
        }
        removeObjects(getObjects(JefeB.class));

        agregaenemigo(5);
        agregaenemigo(6);

        JefeA5 ja=new JefeA5();

        addObject(ja,300,50);       
    }

    public void Jefe999()
    {
        if(band==7)
        {
            addObject(presenta,300,200);
            Greenfoot.delay(100);
            removeObject(presenta);
            band++;
        }
        setBackground("base4.png");
        getBackground().scale(600,400);

        removeObjects(getObjects(JefeB.class));

        agregaenemigo(5);
        agregaenemigo(6);

        JefeF ja=new JefeF();

        addObject(ja,300,50);
    }

    public Jugador dimeJugador()
    {
        return j;
    }

    public void MurioUno()
    {
        enemigos--;
    }

    public int danivel()
    {
        return (nivel);

    }  

    public void aumentanivel()
    {
        nivel++;
        if(nivel>=4)
            nivel=999;
    }  

    public void restavidas()
    {
        golpes--;
        if(golpes<=0 && vidas>0)
        {
            vidas--;
            golpes=100;
            
        }
        

    }

    public void setniv2()
    {
        nivel=2;
    }

    public void setniv3()
    {
        nivel=3;
    }
    
    public void setgana()
    {  
        rec R=new rec();
        s4.stop();
        Ganaste g=new Ganaste();
        String nombre=Greenfoot.ask("Dame tu nombre: ");
        Player p=new Player(nombre,segundos);
        R.add(p);
        addObject(g,300,200);
        Greenfoot.delay(100);
        removeObject(g);
        Greenfoot.setWorld(new Menu());
    }
    
    public void setpierde()
    {
        s4.stop();
        Perdiste p=new Perdiste();
        addObject(p,300,200);
        Greenfoot.delay(100);
        removeObject(p);
        Greenfoot.setWorld(new Menu());
    }
    
    public void aumentavel()
    {
        j.tomabota();
    }
    
    public int dameseg(){
        return segundos;
    
    }
    public Jugador damejug(){
    return j; 
    } 
}
