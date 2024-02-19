package tobeto.bootcampProject.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.SuperCall;

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
}
