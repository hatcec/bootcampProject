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

    @Column(name="name")
    private String name;

    @Column(name = "startDate")
    private LocalDateTime startDate;

    @Column(name = "endDate")
    private  LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "instructorId")
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "bootcampStateId")
    private BootCampState bootcampState;

    @OneToMany(mappedBy = "bootcamp", cascade = CascadeType.REMOVE)
    private List<Application> applications;

}
