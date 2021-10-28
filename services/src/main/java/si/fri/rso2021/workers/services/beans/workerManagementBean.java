package si.fri.rso2021.workers.services.beans;

import si.fri.rso2021.workers.models.objects.Worker;
import si.fri.rso2021.workers.services.dtos.WorkerDTO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestScoped
public class workerManagementBean implements java.io.Serializable{

    @Inject
    private workerBean workerbean;
    @PersistenceContext(unitName = "workers-jpa")
    private EntityManager em;

    private UUID id;
    private Logger log;

    // Koda za demonstriranje razlik med @RequestScoped in @ApplicationScoped
    // inicializiraj UUID instance ter Logger.
    @PostConstruct
    public void workerManagementBean(){
        id = java.util.UUID.randomUUID();
        log = Logger.getLogger("workerManagementBean");
        log.setLevel(Level.ALL);
    }

    public void addWorker(WorkerDTO u) {
        Worker n = new Worker();
        n.setId(u.getId());
        n.setFirstName(u.getFirstName());
        n.setLastName(u.getLastName());
        n.setAddress(u.getAddress());
        n.setDateOfBirth(u.getDateOfBirth());
        workerBean.createWorker(n);
        log.info("Metoda zrna UUZ z " + id + " uporabljena.");
    }
}
