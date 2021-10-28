package si.fri.rso2021.workers.services.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.UriInfo;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;

import si.fri.rso2021.workers.models.entities.WorkerEntity;
import si.fri.rso2021.workers.models.objects.Worker;


@ApplicationScoped
public class workerBean implements java.io.Serializable {

    private Logger log = Logger.getLogger(workerBean.class.getName());

    @PersistenceContext(unitName = "workers-jpa")
    private static EntityManager em;


    public List<WorkerEntity> getWorkers() {
        TypedQuery<WorkerEntity> query = em.createNamedQuery(
                "Worker.getAll", WorkerEntity.class);
        return query.getResultList();
    }

    @Transactional
    public static void createWorker(Worker u) { em.persist(u); }


}
