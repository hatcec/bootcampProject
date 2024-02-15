package tobeto.bootcampProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tobeto.bootcampProject.core.entities.User;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="employees" )
@EqualsAndHashCode(callSuper = true)
public class Employee extends User <Integer> {
    @Column(name="position")
    private String position;
   /* @OneToMany(mappedBy = "employee")//bir çalışanın birden fazla başvurusu olabilir
    private List<Applicant> applicants;*/
}
