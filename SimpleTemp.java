/**
 * Write a description of class SimpleTemp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SimpleTemp  
{
    /**el metodo Sytem.currentTimeMillis devuele la tiempo actual en milisegundos el valor 
    de retorno depende del sistema operativo que estes manejando por eso el tipo es long
    por que puede variar de sistema a sistema
    */
    private long UltimaMarca = System.currentTimeMillis();

    /**
     * Marca la hora actual y se guarda en una variable, la hora marcada
     */
    public void Marca()
    {
        UltimaMarca=System.currentTimeMillis();
    }
    /**
     * Este metodo devuelve un entero lo que hace es devolver el tiempo trascurrido
     * desde que se hizo la marca se hace el cast para asi devolver un valor exacto
     * en enteros y no en long
     */
    public int MiliTrascurridos(){
    return (int)(System.currentTimeMillis() - UltimaMarca);
  
    }

}
