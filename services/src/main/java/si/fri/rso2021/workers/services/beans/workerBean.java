package si.fri.rso2021.workers.services.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;

import si.fri.rso2021.workers.models.entities.WorkerEntity;
import si.fri.rso2021.workers.models.objects.Worker;
import si.fri.rso2021.workers.models.converters.WorkerConverter;



@RequestScoped
public class workerBean {

    private Logger log = Logger.getLogger(workerBean.class.getName());

    @PersistenceContext(unitName = "workers-jpa")
    //@Inject
    private EntityManager em;


    public List<Worker> getWorkers() {
        TypedQuery<WorkerEntity> query = em.createNamedQuery(
                "WorkerEntity.getAll", WorkerEntity.class);
        List<WorkerEntity> resultList =  query.getResultList();
        return resultList.stream().map(WorkerConverter::toDto).collect(Collectors.toList());
    }
}
