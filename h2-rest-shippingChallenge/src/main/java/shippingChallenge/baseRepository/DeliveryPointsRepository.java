package shippingChallenge.baseRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shippingChallenge.entity.DeliveryPoints;

@Repository
public interface DeliveryPointsRepository extends JpaRepository<DeliveryPoints, Integer>{
}
