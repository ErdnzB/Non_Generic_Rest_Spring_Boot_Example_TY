package shippingChallenge.baseRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shippingChallenge.entity.LicencePlate;
import shippingChallenge.generic.IRepository;

@Repository
public interface LicencePlateRepository extends IRepository<LicencePlate> {

    @Query(value ="SELECT * FROM licence_plate WHERE plate_name = :plateNo", nativeQuery = true)
    LicencePlate getOrderByOrderNum(@Param(value="plateNo") String plateNo);
}
