package tobeto.bootcampProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor

@NoArgsConstructor
@Table(name="employees")
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Employee extends User  {
    @Column(name="position")
    private String position;
   /* @OneToMany(mappedBy = "employee")//bir çalışanın birden fazla başvurusu olabilir
    private List<Applicant> applicants;*/
}
