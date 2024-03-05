package tobeto.bootcampProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tobeto.bootcampProject.core.entities.BaseEntity;

import java.time.LocalDateTime;
import java.util.List;

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
    @JoinColumn(name = "instructorid")
    private  Instructor  instructor;
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private LocalDateTime startDate;
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private  LocalDateTime endDate;
    @OneToOne
    @JoinColumn(name = "bootcampStateid")
    private  BootCampState bootCampState;
    @OneToMany(mappedBy = "bootcamp")
    private List<Application> applications;
}
