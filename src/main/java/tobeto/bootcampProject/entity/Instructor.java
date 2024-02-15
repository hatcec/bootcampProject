package tobeto.bootcampProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tobeto.bootcampProject.core.entities.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="instructors")
@Entity
@EqualsAndHashCode(callSuper = true)
public class Instructor extends User <Integer> {

    @Column(name = "companyName")
    private String companyName;
}
