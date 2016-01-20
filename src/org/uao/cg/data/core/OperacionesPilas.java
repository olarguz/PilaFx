
package org.uao.cg.data.core;

import org.uao.cg.data.core.Pila;
import org.uao.cg.data.core.Base;


/**
 *
 * @author oarcila
 * @param <T>
 */
public class OperacionesPilas<T extends Base>
{

    public  static <T extends Base> Pila<T> duplicar(Pila<T> pilaOriginal)
    {
        Pila<T> pilaAux = new Pila<>();
        Pila<T> pilaCopia = new Pila<>();
                
        while (!pilaOriginal.estaVacio())
        {
            pilaAux.apilar(pilaOriginal.desapilar());
        }
        
        while(!pilaAux.estaVacio())
        {
            T e = pilaAux.desapilar();
            T c = (T) e.copy();
            pilaOriginal.apilar(e);
            pilaCopia.apilar(c);
        }
        
        return pilaCopia;
    }
    
    public static <T extends Base> Pila<T> invertir(Pila<T> pilaOriginal)
    {
        Pila<T> pilaCopia = duplicar(pilaOriginal);
        Pila<T> pilaIntertida = new Pila<>();
        
        while ( !pilaCopia.estaVacio())
        {
            pilaIntertida.apilar(pilaCopia.desapilar());
        }
        
        return pilaIntertida;
    }

    public static <T extends Base> Pila<T> concatenar(Pila<T> pila1, Pila<T> pila2)
    {
        Pila<T> pilaAux1 = duplicar(pila1);
        Pila<T> pilaAux2 = invertir(pila2);
        
        while(!pilaAux2.estaVacio())
        {
            pilaAux1.apilar(pilaAux2.desapilar());
        }
        
        return pilaAux1;
    }
    
    public static<T extends Base> Pila<T> mezclaMedia(Pila<T> pilaOriginal)
    {
        Pila<T> pilaCopia = invertir ( pilaOriginal);
        Pila<T> pilaAux1 = new Pila<>();
        Pila<T> pilaAux2 = new Pila<>();
        
        while ( !pilaCopia.estaVacio())
        {
            pilaAux1.apilar(pilaCopia.desapilar());
            if (!pilaCopia.estaVacio())
            {
                pilaAux2.apilar(pilaCopia.desapilar());
            }
        }
        
        return concatenar( pilaAux1, invertir(pilaAux2));
    }

}
