package tobeto.bootcampProject.business.requests.bootcamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampRequest {
    private String userName;
    private int instructorId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int bootcampStateId;
}
