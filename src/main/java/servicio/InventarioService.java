package servicio;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import juego.*;

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

    @GET
    @ApiOperation(value = "dame el inventario de un usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = juego.Inventario.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "No se ha podido realizar")
    })
    @Path("/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dameInventarioByID(@PathParam("idUser") String id) {
        try{

            List<Inventario> inventario = this.ju.dameInventarioPorID(id);
            GenericEntity<List<Inventario>> entity = new GenericEntity<List<Inventario>>(inventario) {};
            return Response.status(201).entity(entity).build()  ;

        }catch (Exception e){
            return Response.status(404).build();
        }

    }
}




