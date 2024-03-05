package tobeto.bootcampProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tobeto.bootcampProject.core.entities.BaseEntity;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "application_states")
public class ApplicationState extends BaseEntity<Integer> {

    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "applicationState")
    private List<Application> applications;
}
