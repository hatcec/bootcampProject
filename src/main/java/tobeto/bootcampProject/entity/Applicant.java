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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "applicants")
@Entity
@EqualsAndHashCode(callSuper = true)
public class Applicant extends User <Integer> {
    @Column(name = "about")
    private String about;


}
