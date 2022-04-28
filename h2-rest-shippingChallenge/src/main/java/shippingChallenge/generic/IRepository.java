package shippingChallenge.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IRepository<T extends GenericEntity<T>> extends JpaRepository<T, Integer> {


}