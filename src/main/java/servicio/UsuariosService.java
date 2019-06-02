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
            @ApiResponse(code = 201, message = "Successful",response = Usuario.class),
            @ApiResponse(code = 404, message = "No se ha podido realizar")
    })
    @Path("/crear/{nombre}/{pass}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response crearUsuario(@PathParam("nombre") String nombre, @PathParam("pass") String pass) throws Exception {

            Usuario u = this.ju.crearUsuario(nombre,pass);

            if(u != null){
                return Response.status(201).build();
            }else{
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
        try{

            List<UsuarioTO> usuarios = this.ju.dameUsuariosTO();
            GenericEntity<List<UsuarioTO>> entity = new GenericEntity<List<UsuarioTO>>(usuarios) {};
            return Response.status(201).entity(entity).build()  ;

        }catch (Exception e){
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
        try{
            Usuario u = this.ju.dameUsuarioById(id);
            GenericEntity<Usuario> entity = new GenericEntity<Usuario>(u) {};
            return Response.status(201).entity(entity).build()  ;

        }catch (Exception e){
            return Response.status(404).build();
        }

    }

    @POST
    @ApiOperation(value = "login usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class),
            @ApiResponse(code = 404, message = "No se ha encontrado al usuario")
    })
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Usuario user) {

        Logger log = Logger.getLogger(UsuariosService.class.getName());

        try{

            List<Usuario> listUsers = this.ju.dameUsuarios();

            boolean check = ju.login(user.getNombre(), user.getPass());

            log.info(user.getNombre() + "-----" + user.getPass());



            if(check == true){
                log.info("201");
                GenericEntity<Usuario> entity = new GenericEntity<Usuario>(user){};
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


/*




        @POST
        @ApiOperation(value = "verificar loguin", notes = "asdasd")
        @ApiResponses(value = {
                @ApiResponse(code = 201, message = "Successful", response =  boolean.class ),
                @ApiResponse(code = 404, message = "No logueado")
        })
        @Path("/{checkLoguin}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response checkLoguin(@PathParam("id") String id) {
            boolean t = this.i.verificarLogin(id);
            if (t = true){
                return Response.status(201).entity(t).build();

        }
            else return Response.status(404).build();
        }




        @POST
        @ApiOperation(value = "añadir dinero", notes = "asdasd")
        @ApiResponses(value = {
                @ApiResponse(code = 201, message = "Successful"),
                @ApiResponse(code = 500, message = "Error")

        })

        @Path("/añadirDinero")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response añadirDinero(@PathParam("idUser") String idUser, @PathParam("dinero") int Dinero ) {

            try {
                this.i.añadirDinero(idUser, Dinero  );

                return Response.status(201).build();

            }catch (
                    Exception e){
                return Response.status(500).build();

            }

        }

        @POST
        @ApiOperation(value = "quitar dinero", notes = "asdasd")
        @ApiResponses(value = {
                @ApiResponse(code = 201, message = "Successful"),
                @ApiResponse(code = 500, message = "Error")

        })
        @Path("/quitarDinero")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response quitarDinero(@PathParam("idUser") String idUser, @PathParam("dinero") int Dinero ) {

            try {
                this.i.quitarDinero(idUser, Dinero  );

                return Response.status(201).build();

            }catch (
                    Exception e){
                return Response.status(500).build();

            }

        }




        @GET
        @ApiOperation(value = "check partida en curso", notes = "asdasd")
        @ApiResponses(value = {
                @ApiResponse(code = 201, message = "Successful", response =  boolean.class ),
                @ApiResponse(code = 404, message = "No logueado")
        })
        @Path("/{checkPartidaEnCurso}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response checkPartidaEnCurso(@PathParam("id") String id) {
            boolean t = this.i.checkPartidaEnCurso(id);
            if (t = true){
                return Response.status(201).entity(t).build();

            }
            else return Response.status(404).build();
        }





        @GET
        @ApiOperation(value = "añadir partida en curso", notes = "asdasd")
        @ApiResponses(value = {
                @ApiResponse(code = 201, message = "Successful" ),
                @ApiResponse(code = 404, message = "No existe ninguna")
        })
        @Path("/{AñadirPartidaEnCurso}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response añadirPartidaEnCurso(@PathParam("id") String id, @PathParam("idPartida") String IdPartida, Partida partida) {
            try {
                this.i.añadirPartidaEnCurso(id, IdPartida, partida );
                return Response.status(201).build();

            }catch (Exception e){
                return Response.status(404).build();
            }
        }



        @GET
        @ApiOperation(value = "eliminar partida en curso", notes = "asdasd")
        @ApiResponses(value = {
                @ApiResponse(code = 201, message = "Successful" ),
                @ApiResponse(code = 404, message = "No existe ninguna")
        })
        @Path("/{eliminarPartidaEnCurso}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response eliminarPartidaEnCurso(@PathParam("id") String id, @PathParam("idPartida") String IdPartida) {
            try {
                this.i.eliminarPartidaEnCurso(id, IdPartida);
                return Response.status(201).build();

            }catch (Exception e){
                return Response.status(404).build();
            }
        }






        @GET
        @ApiOperation(value = "lista usuarios", notes = "asdasd")
        @ApiResponses(value = {
                @ApiResponse(code = 201, message = "Successful", response = Usuario.class, responseContainer = "LinkedList"),
                @ApiResponse(code = 404, message = "No existe ninguna")
        })
        @Path("/{listausuario}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response construirMapa() {
            try {

                LinkedList<Usuario> lista = this.i.dameListaUsuarios();
                GenericEntity<LinkedList<Usuario>> entity = new GenericEntity<LinkedList<Usuario>>(lista) {};

                return Response.status(201).entity(lista).build();

            }catch (Exception e){
                return Response.status(404).build();
            }
        }





        @POST
        @ApiOperation(value = "Suma puntuacion", notes = "asdasd")
        @ApiResponses(value = {
                @ApiResponse(code = 201, message = "Successful" ),
                @ApiResponse(code = 404, message = "No existe ninguna")
        })
        @Path("/{SumarPuntuacion}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response añadirPartidaEnCurso(@PathParam("id") String id, @PathParam("puntuacion") int puntos) {
            try {
                this.i.sumarPuntuacionFinal(id, puntos);
                return Response.status(201).build();

            }catch (Exception e){
                return Response.status(404).build();
            }
        }








//Para inventario :



        @GET //En caso de no bool, se puede cambiar por poner y ale
        @ApiOperation(value = "Habilitar Obejto", notes = "asdasd")
        @ApiResponses(value = {
                @ApiResponse(code = 201, message = "Successful" ),
                @ApiResponse(code = 404, message = "No se ha podido habilitar ")
        })
        @Path("/{habilitarObjeto}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response habiltarObjeto(@PathParam("idObjeto") String id) {
            try {
                this.i.habilitarObjeto(id);
                return Response.status(201).build();

            }catch (Exception e){
                return Response.status(404).build();
            }
        }




        @GET
        @ApiOperation(value = "Iniciar partida", notes = "asdasd")
        @ApiResponses(value = {
                @ApiResponse(code = 201, message = "Successful" ),
                @ApiResponse(code = 404, message = "No existe ninguna")
        })
        @Path("/{IniciarPartida}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response crearPartida(@PathParam("id") String id) {
            try {
                this.i.IniciarPartida(id);
                return Response.status(201).build();

            }catch (Exception e){
                return Response.status(404).build();
            }
        }



        @GET
        @ApiOperation(value = "Finalizar partida", notes = "asdasd")
        @ApiResponses(value = {
                @ApiResponse(code = 201, message = "Successful" ),
                @ApiResponse(code = 404, message = "No existe ninguna")
        })
        @Path("/{FinalizarPartida}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response FinalizarPartida(@PathParam("id") String id) {
            try {
                this.i.finalizarPartida(id);
                return Response.status(201).build();

            }catch (Exception e){
                return Response.status(404).build();
            }
        }




        @GET
        @ApiOperation(value = "parar partida", notes = "asdasd")
        @ApiResponses(value = {
                @ApiResponse(code = 201, message = "Successful" ),
                @ApiResponse(code = 404, message = "No existe ninguna")
        })
        @Path("/{pararPartida}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response pararPartida(@PathParam("id") String id) {
            try {
                this.i.pararPartida(id);
                return Response.status(201).build();

            }catch (Exception e){
                return Response.status(404).build();
            }
        }

@DELETE
@ApiOperation(value = "eliminar usuario")
@ApiResponses(value = {
        @ApiResponse(code = 201, message = "Successful" ),
        @ApiResponse(code = 404, message = "No existe ninguna")
})
@Path("/{cambioMapa}")
@Produces(MediaType.APPLICATION_JSON)
public Response construirMapa(Mapa mapa, @PathParam("idPartida") String IdPartida) {
    try {
        this.i.construirMapa(mapa, IdPartida);
        return Response.status(201).build();

    }catch (Exception e){
        return Response.status(404).build();
    }
}

        @GET
        @ApiOperation(value = "construir mapa", notes = "asdasd")
        @ApiResponses(value = {
                @ApiResponse(code = 201, message = "Successful" ),
                @ApiResponse(code = 404, message = "No existe ninguna")
        })
        @Path("/{cambioMapa}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response construirMapa(Mapa mapa, @PathParam("idPartida") String IdPartida) {
            try {
                this.i.construirMapa(mapa, IdPartida);
                return Response.status(201).build();

            }catch (Exception e){
                return Response.status(404).build();
            }
        }


        @GET
        @ApiOperation(value = "dame partida en curso", notes = "asdasd")
        @ApiResponses(value = {
                @ApiResponse(code = 201, message = "Successful", response = Partida.class),
                @ApiResponse(code = 404, message = "No existe ninguna")
        })
        @Path("/{damePartidaEnCurso}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response damePartidaEnCusro(Partida p, @PathParam("idPartida") String IdPartida, @PathParam("idUsuario") String idUsuario) {
            try {
                Partida partida = null;
                partida = this.i.damePartidaEnCurso(idUsuario, IdPartida);

                return Response.status(201).entity(partida).build();

            }catch (Exception e){
                return Response.status(404).build();
            }
        }




    }


*/

