package tobeto.bootcampProject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="instructors")
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Instructor extends User  {
    @Column(name = "companyName")
    private String companyName;
    @OneToMany(mappedBy = "instructor")
    private List<BootCamp> bootcamps;
}
