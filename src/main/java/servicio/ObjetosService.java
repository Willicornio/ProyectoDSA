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
import java.util.logging.Logger;


@Api(value = "/Objetos", description = "Servicio de objetos")
    @Path("/objetos/")
    public class ObjetosService {

    private Juego ju;

    public ObjetosService() throws Exception {
        this.ju = JuegoManager.getInstance();



    }


    @POST
    @ApiOperation(value = "Comprar obejeto", notes = "Compramos el objeto")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Comprado",response = UsuarioTO.class),
            @ApiResponse(code = 404, message = "No existe el usuario o objeto especificado"),
            @ApiResponse(code = 403, message = "Dinero insuficiente"),
            @ApiResponse(code = 408, message = "Ya se ha comprado este objeto")
    })
    @Path("/comprarObjeto/{idUser}/{idObjeto}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response comprarObjeto(@PathParam("idUser") String idUser, @PathParam("idObjeto") String idObjeto) throws Exception {
        Logger log = Logger.getLogger(ObjetosService.class.getName());
        String check = ju.comprarObjeto(idUser, idObjeto);
        UsuarioTO u= ju.dameUsuarioTOById(idUser);

        if(check.equals("ok")){
            log.info("Ok");
            GenericEntity<UsuarioTO> entity = new GenericEntity<UsuarioTO>(u){};
            return Response.status(201).entity(entity).build();

        }else if(check.equals("Dinero inferior")){
            log.info("Dinero inferior");
            return  Response.status(403).build();
        }else if(check.equals("Ya comprado")){
            log.info("Ya comprado");
            return  Response.status(408).build();
        }
        else{
            return Response.status(404).build();
        }

    }


    @GET
    @ApiOperation(value = "dame objeto", notes = "dame el objeto")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful",response = Objeto.class),
            @ApiResponse(code = 404, message = "No se ha podido realizar")
    })
    @Path("/dame/{idObjeto}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dameObjetoId(@PathParam("idObjeto") String idObjeto) throws Exception {
        Logger log = Logger.getLogger(ObjetosService.class.getName());
        ju.dameObjetoPorId(idObjeto);
        Objeto u= ju.dameObjetoPorId(idObjeto);

        if(u != null){
            log.info("Objeto :" + u.getNombre());
            GenericEntity<Objeto> entity = new GenericEntity<Objeto>(u){};
            return Response.status(201).entity(entity).build();

        }
        else{
            return Response.status(404).build();
        }

    }


    @GET
    @ApiOperation(value = "get all objetos")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objeto.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "No se ha podido realizar")
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dameUsuarios() {
        Logger log = Logger.getLogger(ObjetosService.class.getName());
        try{

            List<Objeto> objetos = this.ju.dameObjetos();

            log.info("Objetos :");
            for (int i = 0; i<objetos.size();i++){
                log.info(objetos.get(i).getNombre());
            }

            GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(objetos) {};
            return Response.status(201).entity(entity).build()  ;

        }catch (Exception e){
            return Response.status(404).build();
        }

    }
}


