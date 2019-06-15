package servicio;
import juego.*;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import juego.Juego;
import juego.JuegoManager;
import juego.Usuario;
import juego.UsuarioTO;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;


@Api(value = "/Mapas", description = "Servicio de mapas")
    @Path("/mapas/")
    public class MapasService {

    private Juego ju;

    public MapasService() throws Exception {
        this.ju = JuegoManager.getInstance();

    }

    @GET
    @ApiOperation(value = "get all mapas")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Mapa.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "No se ha podido realizar")
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dameMapas() {
        try{
            Logger log = Logger.getLogger(MapasService.class.getName());
            List<Mapa> mapas = ju.dameMapas();
            log.info("Los mapas que hay son:");
            for(int i=0;i<mapas.size();i++){
                log.info(mapas.get(i).getMapa());
            }

            GenericEntity<List<Mapa>> entity = new GenericEntity<List<Mapa>>(mapas) {};
            return Response.status(201).entity(entity).build();

        }catch (Exception e){
            return Response.status(404).build();
        }

    }
}
