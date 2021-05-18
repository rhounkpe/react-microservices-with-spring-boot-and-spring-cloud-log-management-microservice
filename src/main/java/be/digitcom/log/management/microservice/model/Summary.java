package be.digitcom.log.management.microservice.model;


import lombok.Data;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Data
@Table("summary")
public class Summary implements Serializable {
    @PrimaryKeyColumn(name = "course_id", type = PrimaryKeyType.PARTITIONED)
    private Long courseId;

    @PrimaryKeyColumn(value = "hit_count", ordinal = 0, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private Long hitCount;
}
