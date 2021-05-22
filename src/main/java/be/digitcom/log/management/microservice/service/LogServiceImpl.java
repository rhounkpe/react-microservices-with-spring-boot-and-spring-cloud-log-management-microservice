package be.digitcom.log.management.microservice.service;

import be.digitcom.log.management.microservice.model.Log;
import be.digitcom.log.management.microservice.model.Summary;
import be.digitcom.log.management.microservice.repository.LogRepository;
import be.digitcom.log.management.microservice.repository.SummaryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Transactional
@Service
public class LogServiceImpl implements LogService {
    private final LogRepository logRepository;

    private final SummaryRepository summaryRepository;

    public LogServiceImpl(LogRepository logRepository, SummaryRepository summaryRepository) {
        this.logRepository = logRepository;
        this.summaryRepository = summaryRepository;
    }

    @Override
    public Log saveOrUpdate(Log log) {
        Summary existSummary = summaryRepository
                .findByCourseId(log.getCourseId()).orElse(null);

        if (existSummary != null) {
            summaryRepository.delete(existSummary);
            existSummary.setHitCount(existSummary.getHitCount() +1);
            summaryRepository.save(existSummary);
        } else {
            Summary summary = new Summary();
            summary.setCourseId(log.getCourseId());
            summary.setHitCount(1L);
            summaryRepository.save(summary);
        }

        log.setId(UUID.randomUUID());
        logRepository.save(log);
        return log;
    }

    @Override
    public List<Summary> findPopularCourses() {
        return summaryRepository.findPopularCourses();
    }

    @Override
    public Summary findSummaryByCourseId(Long courseId) {
        return summaryRepository.findByCourseId(courseId).orElse(null);
    }
}
