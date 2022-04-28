package shippingChallenge.baseRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shippingChallenge.entity.Route;
import shippingChallenge.generic.IRepository;

import java.util.List;

@Repository
public interface RouteRepository extends IRepository<Route> {

    @Query(value ="SELECT * FROM route WHERE plate = :plateNo", nativeQuery = true)
    List<Route> getRoutesByLicencePlate(@Param(value="plateNo") String plateNo);
}
