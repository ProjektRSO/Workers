package si.fri.rso2021.workers.models.converters;
import si.fri.rso2021.workers.models.entities.WorkerEntity;
import si.fri.rso2021.workers.models.objects.Worker;


public class WorkerConverter {
    public static Worker toDto(WorkerEntity entity) {
        Worker dto = new Worker();
        dto.setDateOfBirth(entity.getDateOfBirth());
        dto.setAddress(entity.getAddress());
        dto.setLastName(entity.getLastName());
        dto.setFirstName(entity.getFirstName());
        dto.setId(entity.getId());
        return dto;
    }

    public static WorkerEntity toEntity(Worker dto) {

        WorkerEntity entity = new WorkerEntity();
        entity.setAddress(dto.getAddress());
        entity.setFirstName(dto.getFirstName());
        entity.setId(dto.getId());
        entity.setLastName(dto.getLastName());
        entity.setDateOfBirth(dto.getDateOfBirth());
        return entity;

    }
}
