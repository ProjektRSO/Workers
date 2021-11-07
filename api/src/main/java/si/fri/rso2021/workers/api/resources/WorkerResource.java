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

import si.fri.rso2021.workers.models.objects.Worker;
import si.fri.rso2021.workers.services.beans.workerBean;


@ApplicationScoped
@Path("/workers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WorkerResource {
    private Logger log = Logger.getLogger(WorkerResource.class.getName());

    @Inject
    private workerBean workerbean;

    @Context
    protected UriInfo uriInfo;

    @GET
    public Response getWorkerData() {

        List<Worker> workers = workerbean.getWorkers();

        return Response.status(Response.Status.OK).entity(workers).build();
    }

    @GET
    @Path("/{id}")
    public Response getWorkerData_byId(@PathParam("id") Integer id) {
        Worker w = workerbean.getWorker_byId(id);
        if (w == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.OK).entity(w).build();
    }

    @POST
    public Response createWorker(Worker w) {
        if (w.getFirstName() == null || w.getAddress() == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        else {
            w = workerbean.createWorker(w);
        }
        return Response.status(Response.Status.CONFLICT).entity(w).build();
    }

    @PUT
    @Path("/{id}")
    public Response putWorker(@PathParam("id") Integer id, Worker w){
        w = workerbean.putWorker(id, w);
        if (w == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.NOT_MODIFIED).build();
    }

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
