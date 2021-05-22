package be.digitcom.log.management.microservice.service;

import be.digitcom.log.management.microservice.model.Log;
import be.digitcom.log.management.microservice.model.Summary;

import java.util.List;

public interface LogService {
    Log saveOrUpdate(Log log);

    List<Summary> findPopularCourses();

    Summary findSummaryByCourseId(Long courseId);
}
