import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Contador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Contador extends Actor
{
     private static final Color transparente = new Color(0,0,0,0);
    private GreenfootImage fondo;
    private int valor;
    private int objetivo;
    private String cadena;

    public Contador()
    {
        this(new String());
    }

    /**
     * Crea un nuevo Contador y lo inicializa en ceros
     */
    public Contador(String prefi)
    {
        fondo = getImage();  // getImage obtiene la imagen de la clase 
        valor = 0;
        objetivo = 0;
        this.cadena= prefi;
        ImagenAc();
    }

    /**
     * Animacion en pantalla para poder contar en orden ascendente o descente 
     * con el valor actual
     */
    public void act() 
    {
        if (valor< objetivo) {
            valor++;
            ImagenAc();
        }
        else if (valor > objetivo) {
            valor--;
            ImagenAc();
        }
    }

    /**
     *Añadir un nueva puntuacion  en el valor actual del contador
     */
    public void añadir(int puntos)
    {
        objetivo += puntos;
    }

    /**
     * regresa el valor del contador
     */
    public int regresaValor()
    {
        return objetivo;
    }

    /**
     * Establece un nuevo valor al contador
     */
    public void insertaValor(int nValor)
    {
        objetivo = nValor;
        valor = nValor;
        ImagenAc();
    }

    /**
     *Establece una cadena de texto que se debe mostrar antes de mostrar el valor
     */
    public void insertaCadena(String prefi)
    {
        this.cadena = prefi;
        ImagenAc();
    }

    /**
     * Actualiza la imagen en la pantalla para mostrar el valor actual
     */
    private void ImagenAc()
    {
        GreenfootImage imagen = new GreenfootImage(fondo);
        GreenfootImage texto = new GreenfootImage(cadena + valor, 22, Color.BLACK, transparente);

        if (texto.getWidth() > imagen.getWidth() - 20)
        {
            imagen.scale(texto.getWidth() + 20, imagen.getHeight());
        }

        imagen.drawImage(texto, (imagen.getWidth()-texto.getWidth())/2, 
            (imagen.getHeight()-texto.getHeight())/2);
              setImage(imagen);
    }
}
