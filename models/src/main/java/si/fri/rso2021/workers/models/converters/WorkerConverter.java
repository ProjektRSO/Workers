package si.fri.rso2021.workers.models.converters;
import si.fri.rso2021.workers.models.entities.WorkerEntity;
import si.fri.rso2021.workers.models.objects.Worker;


public class WorkerConverter {
    public static Worker toDto(WorkerEntity entity) {
        Worker dto = new Worker();
        dto.setMonday(entity.isMonday());
        dto.setTuesday(entity.isTuesday());
        dto.setWednesday(entity.isWednesday());
        dto.setThursday(entity.isThursday());
        dto.setFriday(entity.isFriday());
        dto.setSaturday(entity.isSaturday());
        dto.setSunday(entity.isSunday());

        dto.setHourlyRate(entity.getHourlyRate());
        dto.setAddress(entity.getAddress());
        dto.setLastName(entity.getLastName());
        dto.setFirstName(entity.getFirstName());
        dto.setId(entity.getId());
        dto.setIBAN(entity.getIBAN());
        return dto;
    }

    public static WorkerEntity toEntity(Worker dto) {

        WorkerEntity entity = new WorkerEntity();
        entity.setMonday(dto.isMonday());
        entity.setTuesday(dto.isTuesday());
        entity.setWednesday(dto.isWednesday());
        entity.setThursday(dto.isThursday());
        entity.setFriday(dto.isFriday());
        entity.setSaturday(dto.isSaturday());
        entity.setSunday(dto.isSunday());

        entity.setHourlyRate(dto.getHourlyRate());
        entity.setAddress(dto.getAddress());
        entity.setFirstName(dto.getFirstName());
        entity.setId(dto.getId());
        entity.setLastName(dto.getLastName());
        entity.setIBAN(dto.getIBAN());
        return entity;

    }
}
