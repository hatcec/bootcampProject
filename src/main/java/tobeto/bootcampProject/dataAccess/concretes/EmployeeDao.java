package tobeto.bootcampProject.dataAccess.concretes;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import tobeto.bootcampProject.business.responses.employee.GetByEmailResponse;
import tobeto.bootcampProject.dataAccess.abstracts.EmployeeRepository;

import java.util.List;

@AllArgsConstructor
public abstract class EmployeeDao implements EmployeeRepository {
    private final EntityManager entityManager;
    public List<GetByEmailResponse> getByEmail(String email){
        TypedQuery<GetByEmailResponse> query=entityManager
                .createQuery("SELECT u FROM users  u where u.email= :email", GetByEmailResponse.class);
        query.setParameter("email",email);
        return query.getResultList();
    }
}
