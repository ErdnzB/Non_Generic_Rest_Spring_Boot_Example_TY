package shippingChallenge.baseServices;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import shippingChallenge.entity.Route;
import shippingChallenge.requestModels.InnerRequestModel;

import java.util.List;
import java.util.Map;

public interface RouteService {


    public Route getRoute(@PathVariable Integer id);

    public String addRoute(@RequestBody Route bags);

    public Route updateRoute(@RequestBody Route bags);

    public List<Route> getRoutesByLicencePlate(@RequestBody InnerRequestModel req);

    public Map<String, String> deleteRoute(@RequestParam Integer id);

    List<Route> getAllRoute();

    String addAllRoute(@RequestBody List<Route> bags);

    String deleteAllRoute();
}
