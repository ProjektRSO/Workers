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
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.metrics.annotation.Timed;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;

import si.fri.rso2021.workers.models.entities.WorkerEntity;
import si.fri.rso2021.workers.models.objects.Worker;
import si.fri.rso2021.workers.models.converters.WorkerConverter;

import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;


@RequestScoped
public class workerBean {



    private Logger log = Logger.getLogger(workerBean.class.getName());

    //@PersistenceContext(unitName = "workers-jpa")
    @Inject
    private EntityManager em;


    @Timed(name="get all workers")
    public List<Worker> getWorkers() {
        TypedQuery<WorkerEntity> query = em.createNamedQuery(
                "WorkerEntity.getAll", WorkerEntity.class);
        List<WorkerEntity> resultList =  query.getResultList();
        return resultList.stream().map(WorkerConverter::toDto).collect(Collectors.toList());
    }

    @Timeout(value = 2, unit = ChronoUnit.SECONDS)
    public Worker getWorker_byId(Integer id) {
        WorkerEntity workerEntity = em.find(WorkerEntity.class, id);
        if (workerEntity == null) {
            throw new NotFoundException();
        }
        Worker w = WorkerConverter.toDto(workerEntity);
        return w;
    }

    public Worker createWorker(Worker w) {
        WorkerEntity workerEntity = WorkerConverter.toEntity(w);
        try {
            beginTx();
            em.persist(workerEntity);
            commitTx();
        }
        catch (Exception e) {
            rollbackTx();
        }
        if (workerEntity.getId() == null) {
            throw new RuntimeException("Worker entity was not persisted.");
        }
        return WorkerConverter.toDto(workerEntity);
    }

    public Worker putWorker(Integer id, Worker w) {
        WorkerEntity workerEntity = em.find(WorkerEntity.class, id);
        if (workerEntity == null) return null;
        WorkerEntity updatedworkerEntity = WorkerConverter.toEntity(w);

        try {
            beginTx();
            updatedworkerEntity.setId(id);
            updatedworkerEntity = em.merge(updatedworkerEntity);
            commitTx();
        }
        catch (Exception e) {
            rollbackTx();
        }
        return WorkerConverter.toDto(updatedworkerEntity);
    }

    public boolean deleteWorker(Integer id) {
        WorkerEntity workerEntity = em.find(WorkerEntity.class, id);
        if (workerEntity != null) {
            try {
            beginTx();
            em.remove(workerEntity);
            commitTx();
            }
            catch (Exception e) {
                rollbackTx();
            }
        }
        else {return false;}
        return true;
    }

    private void beginTx() {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
    }

    private void commitTx() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
    }

    private void rollbackTx() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    }
}
