package servicio;


import juego.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;




@Api(value = "/Usuarios", description = "Servicio de usuarios")
    @Path("/usuarios/")
    public class UsuariosService {

    private Juego ju;

    public UsuariosService() throws Exception {
        this.ju = JuegoManager.getInstance();



    }


    @POST
    @ApiOperation(value = "Crear usuario", notes = "Creamos el usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful",response = UsuarioTO.class),
            @ApiResponse(code = 404, message = "No se ha podido realizar")
    })
    @Path("/crear")
    @Produces(MediaType.APPLICATION_JSON)
    public Response crearUsuario(Auth a) throws Exception {
        Logger log = Logger.getLogger(UsuariosService.class.getName());

            UsuarioTO u = this.ju.crearUsuario(a);

        if(u != null){
            log.info("Usuario creado correctamente");
            GenericEntity<UsuarioTO> entity = new GenericEntity<UsuarioTO>(u){};
            return Response.status(201).entity(entity).build();

        }
        else{
            log.info("Error al crear, ya existe el usuario ");
            return Response.status(404).build();
        }

    }


    @POST
    @ApiOperation(value = "modificar puntuacion", notes = "suma o resta")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful",response = UsuarioTO.class),
            @ApiResponse(code = 404, message = "No se ha podido realizar")
    })
    @Path("/modificarpuntuacion/{idUser}/{puntuacion}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response modificarPuntuacion(@PathParam("idUser") String id, @PathParam("puntuacion") int puntuacion) throws Exception {
        Logger log = Logger.getLogger(UsuariosService.class.getName());

        ju.sumarPuntuacionFinal(id, puntuacion);
        UsuarioTO u= ju.dameUsuarioTOById(id);

        if(u != null){

            log.info ("Puntuacion modificada de " + u.getNombre() + ", puntuacion :" + u.getPuntuacionTotal());
            GenericEntity<UsuarioTO> entity = new GenericEntity<UsuarioTO>(u){};
            return Response.status(201).entity(entity).build();

        }
        else{
            return Response.status(404).build();
        }
    }


    @POST
    @ApiOperation(value = "modificar dinero", notes = "suma o resta")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful",response = UsuarioTO.class),
            @ApiResponse(code = 404, message = "No se ha podido realizar")
    })
    @Path("/modificardinero/{idUser}/{dinero}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response modificarDinero(@PathParam("idUser") String id, @PathParam("dinero") int dinero) throws Exception {
        Logger log = Logger.getLogger(UsuariosService.class.getName());

        ju.modificarDinero(id, dinero);
        UsuarioTO u= ju.dameUsuarioTOById(id);

        if(u != null){

            log.info ("Dinero modificado de " + u.getNombre() + ", dinero :" + u.getDinero());
            GenericEntity<UsuarioTO> entity = new GenericEntity<UsuarioTO>(u){};
            return Response.status(201).entity(entity).build();

        }
        else{
            return Response.status(404).build();
        }

    }


    @GET
    @ApiOperation(value = "get all users")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = UsuarioTO.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "No se ha podido realizar")
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dameUsuarios() {
        Logger log = Logger.getLogger(UsuariosService.class.getName());
        try{

            List<UsuarioTO> usuarios = this.ju.dameUsuariosTO();
            GenericEntity<List<UsuarioTO>> entity = new GenericEntity<List<UsuarioTO>>(usuarios) {};
            log.info("Tenemos los siguientes usuarios en la lista:");

            for(int i = 0; i< usuarios.size();i++){
                log.info(usuarios.get(i).getNombre());
            }
            return Response.status(201).entity(entity).build()  ;

        }catch (Exception e){
            log.info("No se ha podido realizar");
            return Response.status(404).build();
        }

    }

    @GET
    @ApiOperation(value = "Dame un usuario por su id")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class),
            @ApiResponse(code = 404, message = "No existe este usuario")
    })
    @Path("/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response dameUsuarioById(@PathParam("idUser") String id) {
        Logger log = Logger.getLogger(UsuariosService.class.getName());
        try{
            Usuario u = this.ju.dameUsuarioById(id);
            GenericEntity<Usuario> entity = new GenericEntity<Usuario>(u) {};
            log.info("Usuario :" +u.getNombre());
            return Response.status(201).entity(entity).build()  ;

        }catch (Exception e){
            log.info("No se ha podido realizar");
            return Response.status(404).build();
        }

    }





    @POST
    @ApiOperation(value = "login usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = UsuarioTO.class),
            @ApiResponse(code = 404, message = "No se ha encontrado al usuario")
    })
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Auth a) {

        Logger log = Logger.getLogger(UsuariosService.class.getName());

        try{

            List<Usuario> listUsers = this.ju.dameUsuarios();

            boolean check = ju.login(a.getNombre(), a.getPass());

            log.info(a.getNombre() + "-----" + a.getPass());

            UsuarioTO b = ju.dameUsuarioTOById("id"+a.getNombre());

            if(check == true){
                log.info("201");
                GenericEntity<UsuarioTO> entity = new GenericEntity<UsuarioTO>(b){};
                return Response.status(201).entity(entity).build();

            }
            else{
                log.info("404");
                return Response.status(404).build();
            }




        }catch (Exception e){
            return Response.status(404).build();
        }

    }


}



