package tobeto.bootcampProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tobeto.bootcampProject.core.entities.BaseEntity;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="bootCamps")
public class BootCamp extends BaseEntity<Integer> {

    @Column(name = "name")
    private  String name;
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private  Instructor  instructor;
    @Column(name = "startDate")
    private LocalDateTime startDate;
    @Column(name = "endDate")
    private  LocalDateTime endDate;
    @OneToOne
    @JoinColumn(name = "bootcampState_id")
    private  BootCampState bootCampState;
}
