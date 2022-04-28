package shippingChallenge.baseServices;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import shippingChallenge.baseRepository.RouteRepository;
import shippingChallenge.configuration.EnumMessages;
import shippingChallenge.configuration.ShippingChallengeApiException;
import shippingChallenge.entity.Bags;
import shippingChallenge.entity.Packs;
import shippingChallenge.entity.Route;
import shippingChallenge.requestModels.InnerRequestModel;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class RouteServiceImpl implements RouteService {


    private final RouteRepository routeRepository;

    @Override
    @Transactional
    public Route getRoute(Integer id) {
        try {
            return routeRepository.findById(id).get();
        }catch (Exception e){
            throw new ShippingChallengeApiException(EnumMessages.ROUTE_NOT_FOUND);
        }

    }

    @Override
    @Transactional
    public String addRoute(Route route) {
        try {
            Route savedRoute = routeRepository.save(route);
            return EnumMessages.COMPLETED.getMessage();
        }catch (Exception e){
            throw new ShippingChallengeApiException(EnumMessages.ROUTE_CANT_SAVE);
        }
    }

    @Override
    @Transactional
    public Route updateRoute(Route route) {
        try {
            return routeRepository.save(route);
        }catch (Exception e){
            throw new ShippingChallengeApiException(EnumMessages.ROUTE_NOT_UPDATE);
        }
    }

    @Override
    @Transactional
    public List<Route> getRoutesByLicencePlate(InnerRequestModel req) {
        try {
            List<Route> findingRoute = routeRepository.getRoutesByLicencePlate(req.getBarcode());
            if(findingRoute == null || findingRoute.size() == 0){
                throw new ShippingChallengeApiException(EnumMessages.ROUTE_NOT_FOUND);
            }else{
                return findingRoute;
            }
        }catch (Exception e){
            throw new ShippingChallengeApiException(EnumMessages.ROUTE_BARCODE_SEARCH);
        }
    }

    @Override
    @Transactional
    public Map<String, String> deleteRoute(Integer id) {
        Map<String, String> status = new HashMap<>();
        Optional<Route> route = routeRepository.findById(id);
        if(route.isPresent()) {
            routeRepository.delete(route.get());
            status.put("Status", "Route deleted successfully");
        }
        else {
            status.put("Status", "Route not exist");
        }
        return status;
    }

    @Override
    @Transactional
    public List<Route> getAllRoute() {
        return routeRepository.findAll();
    }

    @Override
    @Transactional
    public String addAllRoute(List<Route> route) {
        routeRepository.saveAll(route);
        return EnumMessages.COMPLETED.getMessage();
    }

    @Override
    @Transactional
    public String deleteAllRoute() {
        routeRepository.deleteAll();
        return EnumMessages.COMPLETED.getMessage();
    }
}
