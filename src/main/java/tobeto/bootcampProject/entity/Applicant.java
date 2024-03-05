package tobeto.bootcampProject.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Table(name="applicants")
@Entity
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "user_id")
public class Applicant extends User  {
    @Column(name = "about")
    private String about;
    @OneToOne(mappedBy = "applicant", cascade =CascadeType.REMOVE)
    private BlackList blackList;
    @OneToMany(mappedBy = "applicant", cascade = CascadeType.REMOVE)
    private List<Application> applications;
}
