
package org.uao.cg.data;

import org.uao.cg.data.core.Base;

/**
 *
 * @author oarcila
 */
public class Valor extends Base
{
   
    private String texto;

    public Valor(String texto)
    {
        this.texto = texto;
    }

    /**
     * Get the value of texto
     *
     * @return the value of texto
     */
    public String getTexto()
    {
        return texto;
    }

    /**
     * Set the value of texto
     *
     * @param texto new value of texto
     */
    public void setTexto(String texto)
    {
        this.texto = texto;
    }

    @Override
    public String toString()
    {
        return texto;
    }

    @Override
    public Base copy()
    {
        return new Valor(texto);
    }
 
}
