package si.fri.rso2021.workers.models.converters;
import si.fri.rso2021.workers.models.entities.WorkerEntity;
import si.fri.rso2021.workers.models.objects.Worker;


public class WorkerConverter {
    public static Worker toDto(WorkerEntity entity) {
        Worker dto = new Worker();
        dto.setMonday(entity.getMonday());
        dto.setTuesday(entity.getTuesday());
        dto.setWednesday(entity.getWednesday());
        dto.setThursday(entity.getThursday());
        dto.setFriday(entity.getFriday());
        dto.setSaturday(entity.getSaturday());
        dto.setSunday(entity.getSunday());

        dto.setHourlyRate(entity.getHourlyRate());
        dto.setAddress(entity.getAddress());
        dto.setLastName(entity.getLastName());
        dto.setFirstName(entity.getFirstName());
        dto.setId(entity.getId());
        return dto;
    }

    public static WorkerEntity toEntity(Worker dto) {

        WorkerEntity entity = new WorkerEntity();
        entity.setMonday(dto.getMonday());
        entity.setTuesday(dto.getTuesday());
        entity.setWednesday(dto.getWednesday());
        entity.setThursday(dto.getThursday());
        entity.setFriday(dto.getFriday());
        entity.setSaturday(dto.getSaturday());
        entity.setSunday(dto.getSunday());

        entity.setHourlyRate(dto.getHourlyRate());
        entity.setAddress(dto.getAddress());
        entity.setFirstName(dto.getFirstName());
        entity.setId(dto.getId());
        entity.setLastName(dto.getLastName());
        return entity;

    }
}
