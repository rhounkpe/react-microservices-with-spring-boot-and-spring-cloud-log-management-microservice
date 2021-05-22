package be.digitcom.log.management.microservice.repository;

import be.digitcom.log.management.microservice.model.Log;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface LogRepository extends CrudRepository<Log, UUID> {
}
