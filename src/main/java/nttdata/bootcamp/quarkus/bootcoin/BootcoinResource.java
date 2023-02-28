package nttdata.bootcamp.quarkus.bootcoin;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import nttdata.bootcamp.quarkus.bootcoin.entity.BootcoinEntity;
import org.bson.types.ObjectId;

@Path("/api/bootcoin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BootcoinResource {

    @GET
    public Multi<BootcoinEntity> listAll() {
        return BootcoinEntity.streamAll();
    }
    @POST
    public Uni<Response> savePromotion(BootcoinEntity bootcoinEntity){
        return bootcoinEntity.persist().map(r->Response.ok(r).build());
    }
    @PUT
    @Path("/{id}")
    public Uni<BootcoinEntity> updatePromotion(@PathParam("id") String id, BootcoinEntity bootcoinEntity){
        bootcoinEntity.setId(new ObjectId(id));
        return bootcoinEntity.update();
    }

    @GET
    @Path("/search/{dniClient}")
    public Uni<BootcoinEntity> searchClienteByDocumentNumber(@PathParam("dniClient") String dniClient){
        return BootcoinEntity.find("dniClient",dniClient).firstResult();
    }

}
