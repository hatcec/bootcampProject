package tobeto.bootcampProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tobeto.bootcampProject.core.entities.BaseEntity;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="blackLists")
@AllArgsConstructor
@NoArgsConstructor
public class BlackList extends BaseEntity<Integer> {
    @Column(name="reason")
    private String reason;
    @Temporal(TemporalType.DATE)
    @Column (name="date")
    private Date date;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="appliantId")
    private  Applicant applicant;
}
