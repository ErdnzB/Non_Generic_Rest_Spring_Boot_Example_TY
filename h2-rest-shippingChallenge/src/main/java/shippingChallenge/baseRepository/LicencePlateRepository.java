package shippingChallenge.baseRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shippingChallenge.entity.LicencePlate;

@Repository
public interface LicencePlateRepository extends JpaRepository<LicencePlate, Integer>{

    @Query(value ="SELECT * FROM licence_plate WHERE plate_name = :plateNo", nativeQuery = true)
    LicencePlate getOrderByOrderNum(@Param(value="plateNo") String plateNo);
}
