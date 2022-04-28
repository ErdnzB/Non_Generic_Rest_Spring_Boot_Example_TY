package shippingChallenge.baseControllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shippingChallenge.baseServices.RouteService;
import shippingChallenge.entity.Route;
import shippingChallenge.generic.GenericController;
import shippingChallenge.generic.GenericService;
import shippingChallenge.generic.IRepository;
import shippingChallenge.requestModels.InnerRequestModel;

import java.util.List;

@RestController
@RequestMapping("/api/route")
public class RouteController extends GenericController<Route> {

    private final RouteService routesService;

    public RouteController(GenericService<Route> service, RouteService routesService) {
        super(service);
        this.routesService = routesService;
    }


    @RequestMapping(value = "/getRoutsForPlate", method = RequestMethod.POST)
    public ResponseEntity<List<Route>> getRoutesByLicencePlate(@RequestBody InnerRequestModel innerRequestModel) {
        return ResponseEntity.ok(routesService.getRoutesByLicencePlate(innerRequestModel));
    }


}
