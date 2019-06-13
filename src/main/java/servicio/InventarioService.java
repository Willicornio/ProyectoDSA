package servicio;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import juego.Juego;
import juego.JuegoManager;
import juego.Objeto;
import juego.UsuarioTO;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Api(value = "/Inventario", description = "Servicio de inventario")
@Path("/inventario/")
public class InventarioService {

    private Juego ju;

    public InventarioService() throws Exception {
        this.ju = JuegoManager.getInstance();


    }


    @GET
    @ApiOperation(value = "¿Está activado en mi inventario el siguiente objeto?", notes = "dame el idUser y idObjeto")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Lo tienes comprado", response = Objeto.class),
            @ApiResponse(code = 404, message = "No lo tienes comprado")
    })
    @Path("/consultaActivado/{idUser}/{idObjeto}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultaActivado(@PathParam("idUser") String idUser, @PathParam("idObjeto") String idObjeto) throws Exception {

        String activado = ju.consultaActivado(idUser, idObjeto);

        Objeto u = ju.dameObjetoPorId(idObjeto);


        if (activado.equals("true")) {

            GenericEntity<Objeto> entity = new GenericEntity<Objeto>(u){};
            return Response.status(201).entity(entity).build();

        } else {
            return Response.status(404).build();
        }

    }
}




