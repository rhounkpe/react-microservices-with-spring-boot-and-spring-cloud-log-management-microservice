package be.digitcom.log.management.microservice.model;

import com.datastax.oss.driver.api.core.type.DataType;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table("log")
public class Log implements Serializable {
    @PrimaryKey
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID id;

    @Column("ip")
    private String ip;

    @Column("course_id")
    private Long courseId;

    @Column("log_date")
    private LocalDateTime logDate;
}
