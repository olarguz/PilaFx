package org.uao.cg.gui;

import org.uao.cg.data.Valor;
import org.uao.cg.data.core.OperacionesPilas;
import org.uao.cg.data.core.Pila;

/**
 *
 * @author oarcila
 */
public class Tools
{
    public static String convertirPilaAHtml(Pila<Valor> p)
    {
        StringBuilder sb = new StringBuilder("<html>");
        Pila<Valor> q = OperacionesPilas.duplicar(p);

        sb.append("<script>").append("</script>");

        if (!q.estaVacio())
        {
            sb.append("<table align=\"center\" border=\"2\">");
            sb.append("<tr>").append("<th>").append("Texto").append("</th>").append("</tr>");
            do
            {
                Valor e = q.desapilar();
                sb.append("<tr>").append("<td>");
                sb.append(e.getTexto());
                sb.append("</td>").append("</tr>");
            }
            while (!q.estaVacio());
            sb.append("</table>");
        }
        else
        {
            sb.append("<h1 align=\"center\">").append("Pila Vacia").append("</h1>");
        }

        sb.append("</html>");

        return sb.toString();
    }

    public static String convertirPilaAHtml(Pila<Valor> p, String texto)
    {
        String html = "<br><center>Se retiro "+texto+"</center></br>";
        StringBuilder sb = new StringBuilder(convertirPilaAHtml(p));
        try
        {
        sb.replace(sb.indexOf("<script>"), sb.indexOf("</script>"), html);
        }
        catch(StringIndexOutOfBoundsException ex){}
        
        return sb.toString();
    }
}
