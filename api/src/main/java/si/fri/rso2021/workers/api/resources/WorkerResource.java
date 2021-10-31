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
}
