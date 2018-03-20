/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import org.apache.taglibs.standard.lang.jstl.GreaterThanOperator;

/**
 * REST Web Service
 *
 * @author Usuario
 */
@Path("HoraServidor")
public class GenericResource {

    @Context
    private UriInfo context;
    private static String horaImpuesta = "";

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of resource.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        
        //Una forma de hacerlo
        /*Calendar calendar = new GregorianCalendar();
        int hora = calendar.get(Calendar.HOUR_OF_DAY);
        int minutos = calendar.get(Calendar.MINUTE);
        int segundos = calendar.get(Calendar.SECOND);
        System.out.println(hora + ":" + minutos + ":" + segundos);
        return hora + ":" + minutos + ":" + segundos;*/
        
        //Otra forma de hacerlo
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormater = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String hora = dateFormater.format(cal.getTime());
        if(horaImpuesta.equals("")) {
            return "{\"Hora\" : \"" + hora + "\"}";
        } else {
            return horaImpuesta;
        }
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
        horaImpuesta = content;
    }
}
