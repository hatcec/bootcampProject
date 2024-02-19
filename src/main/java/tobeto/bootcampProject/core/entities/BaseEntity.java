package tobeto.bootcampProject.core.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@SuperBuilder
@Setter
@MappedSuperclass//super clas bunu gelir mappler
public abstract class BaseEntity<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  T id;
    @Column(name="createdAt")
    private LocalDateTime createdAt;


    @Column(name="updatedAt")
    private LocalDateTime updatedAt;



    @Column(name="deletedDate")
    private LocalDateTime deletedDate;

    @PrePersist
    private void prePersist(){
        this.createdAt=LocalDateTime.now();
    }
    @PreUpdate
    private void preUpdate(){
        this.updatedAt=LocalDateTime.now();
    }

}
