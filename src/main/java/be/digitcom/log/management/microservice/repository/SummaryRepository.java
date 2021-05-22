package be.digitcom.log.management.microservice.repository;

import be.digitcom.log.management.microservice.model.Summary;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SummaryRepository extends CrudRepository<Summary, Long> {
    Optional<Summary> findByCourseId(Long courseId);

    @Query("SELECT * FROM summary LIMIT 100")
    List<Summary> findPopularCourses();
}
