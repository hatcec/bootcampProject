package tobeto.bootcampProject.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import tobeto.bootcampProject.core.entities.BaseEntity;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract  class User extends BaseEntity<Integer>{

    @Column(name = "userName")
    private String userName;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "dateOfBirth")
    private LocalDateTime dateOfBirth;
    @Column(name = "nationalIdentity")
    private  String nationalIdentity;
    @Column(name = "email")
    private  String email;
    @Column(name="password")
    private String password;
}
