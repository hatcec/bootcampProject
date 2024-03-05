package tobeto.bootcampProject.business.requests.bootcamp;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampRequest {
    private String name;
    private int instructorId;
    @Temporal(TemporalType.DATE)
    private LocalDateTime startDate;
    @Temporal(TemporalType.DATE)
    private LocalDateTime endDate;
    private int bootcampStateId;
}
