package si.fri.rso2021.workers.services.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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


@RequestScoped
public class workerBean {
    private Logger log = Logger.getLogger(workerBean.class.getName());

    @Inject
    private EntityManager em;

    public List<WorkerEntity> getImageMetadata() {
        TypedQuery<WorkerEntity> query = em.createNamedQuery(
                "Worker.getAll", WorkerEntity.class);
        List<WorkerEntity> resultList = query.getResultList();
        return new ArrayList<>(resultList);
    }




}
