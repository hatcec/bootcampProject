package tobeto.bootcampProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tobeto.bootcampProject.core.entities.BaseEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="applications")
@PrimaryKeyJoinColumn(name = "user_id")
public class Application extends BaseEntity<Integer> {
    @ManyToOne
    @JoinColumn(name="applicantid")
    private  Applicant applicant ;
    @ManyToOne
    @JoinColumn(name="bootcampid")
    private  BootCamp bootCamp ;
    @ManyToOne
    @JoinColumn(name="applicationStateid")
    private  ApplicationState applicationState ;
}
