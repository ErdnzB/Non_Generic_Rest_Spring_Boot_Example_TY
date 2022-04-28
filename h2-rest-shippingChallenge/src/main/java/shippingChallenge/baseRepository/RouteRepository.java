package shippingChallenge.baseRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shippingChallenge.entity.Route;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer>{

    @Query(value ="SELECT * FROM route WHERE plate = :plateNo", nativeQuery = true)
    List<Route> getRoutesByLicencePlate(@Param(value="plateNo") String plateNo);
}
