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
@Table(name="bootCampstates")
public class BootCampState extends BaseEntity<Integer> {
    @Column(name="name")
    private  String name;
    @OneToMany(mappedBy = "bootcampState")
    private List<BootCamp> bootcamps;

}
