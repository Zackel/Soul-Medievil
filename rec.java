import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.io.*;
import java.util.ArrayList;
/**
 * Write a description of class rec here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class rec extends Actor
{
    private File file;
    private FileWriter escritor;
    private BufferedWriter bufer;
    private PrintWriter salida;
    private ArrayList<Player>  records;
    /**
     * Act - do whatever the rec wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    public rec()
    {
        records = new ArrayList<Player>();
        file = new File ("Records.txt");
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException ex){}
        }
        else {
            this.leeRecords();
        }
    }
    public void escribeRecords(){
        PrintWriter escritor;
        String num;
        BufferedWriter bw;
        PrintWriter s;
        try{
            escritor = new PrintWriter(file);
            bw = new BufferedWriter(escritor);
            s = new PrintWriter(bw);
            for(Player i : records)
            {
                s.println(i.getName());
                s.println(i.getPoints()+"");
            }
            s.close();
            bw.close();
        }catch(IOException e){}

    }
    private void leeRecords(){
        
        Player persona;
        String nombre = "";
        int puntos = 0;
        String texto = "";
        FileReader lector = null;
        String linea = "";
        try {
            lector = new FileReader(file);
            BufferedReader bl = new BufferedReader(lector);
            while ((linea = bl.readLine()) != null) {
                persona = new Player();
                texto = linea;
                persona.setName(texto);
                //System.out.println(texto);
                if((linea = bl.readLine()) != null){
                    texto = linea;
                    puntos = Integer.parseInt(texto);
                    persona.setPoints(puntos);
                    //System.out.println(puntos);
                }
                records.add(persona);
            }   

        } catch (IOException e) {

        } finally {
            if (lector != null) {
                try {
                    lector.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    
     public void add(Player p){        
        records.add(p);
        this.acomodaRecords();
        if(records.size()>4){
            records.remove(0);      
        }
        this.escribeRecords();
    }
     public ArrayList<Player> escribeTabla(){
        return records;
    }
     private void acomodaRecords(){
        Player aux;
        int n = records.size();
        for(int c=0;c<n-1;c++){
            for(int c2=0;c2<n-1;c2++){
                if((records.get(c2).getPoints()) > (records.get(c2+1).getPoints())){
                    aux = records.get(c2);
                    records.add(c2,records.get(c2+1));
                    records.remove(c2+2);                    
                }
            }
        }

    }
}
