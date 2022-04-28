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

}
