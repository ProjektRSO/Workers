package si.fri.rso2021.workers.api.resources;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.logging.Logger;

import com.kumuluz.ee.cors.annotations.CrossOrigin;
import com.kumuluz.ee.logs.cdi.Log;
import com.kumuluz.ee.logs.cdi.LogParams;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.headers.Header;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import si.fri.rso2021.workers.models.objects.Worker;
import si.fri.rso2021.workers.services.beans.workerBean;

@Log
@ApplicationScoped
@Path("/workers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@CrossOrigin(supportedMethods = "GET, POST, PUT, DELETE")
public class WorkerResource {
    private Logger log = Logger.getLogger(WorkerResource.class.getName());

    @Inject
    private workerBean workerbean;

    @Context
    protected UriInfo uriInfo;

    @Operation(description = "Get all worker data.", summary = "Get all workers")
    @APIResponses({
            @APIResponse(responseCode = "200",
                    description = "List of worker data",
                    content = @Content(schema = @Schema(implementation = Worker.class, type = SchemaType.ARRAY))
            )})
    @Log
    @GET
    public Response getWorkerData() {

        List<Worker> workers = workerbean.getWorkers();

        return Response.status(Response.Status.OK).entity(workers).build();
    }


    @Operation(description = "Get one worker data.", summary = "Get one worker")
    @APIResponses({
            @APIResponse(responseCode = "200",
                    description = "Worker data",
                    content = @Content(schema = @Schema(implementation = Worker.class, type = SchemaType.OBJECT))
            ),
            @APIResponse( responseCode = "404",
                    description = "Worker with id does not exist"
            )})
    @GET
    @Path("/{id}")
    public Response getWorkerData_byId(@PathParam("id") Integer id) {
        Worker w = workerbean.getWorker_byId(id);
        if (w == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.OK).entity(w).build();
    }

    @Operation(description = "Create one worker.", summary = "Create one worker")
    @APIResponses({
            @APIResponse(responseCode = "201",
                    description = "Worker created"
            ),
            @APIResponse( responseCode = "400",
                    description = "Creation not successful"
            )})
    @POST
    public Response createWorker(Worker w) {
        if (w.getFirstName() == null || w.getAddress() == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        else {
            w = workerbean.createWorker(w);
        }
        return Response.status(Response.Status.CREATED).entity(w).build();
    }

    @Operation(description = "Update one worker data.", summary = "Update one worker")
    @APIResponses({
            @APIResponse(responseCode = "200",
                    description = "Worker data updated"
            ),
            @APIResponse( responseCode = "304",
                    description = "Worker with id does not exist"
            )})
    @PUT
    @Path("/{id}")
    public Response putWorker(@PathParam("id") Integer id, Worker w){
        w = workerbean.putWorker(id, w);
        if (w == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.NOT_MODIFIED).build();
    }

    @Operation(description = "Delete one worker.", summary = "Delete worker")
    @APIResponses({
            @APIResponse(responseCode = "204",
                    description = "Worker deleted"
            ),
            @APIResponse( responseCode = "404",
                    description = "Worker not found"
            )})
    @DELETE
    @Path("{id}")
    public Response deleteWorker(@PathParam("id") Integer id){
        boolean deleted = workerbean.deleteWorker(id);
        if (deleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
