package si.fri.rso2021.workers.api;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@OpenAPIDefinition(info = @Info(title = "Worker API", version = "v1",
        license = @License(name = "David"), description = "API for managing worker data."),
        servers = @Server(url = "http://localhost:8080/"))
@ApplicationPath("/v1")
public class WorkerAPI extends Application {

}
