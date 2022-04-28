package shippingChallenge.baseControllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shippingChallenge.baseServices.RouteService;
import shippingChallenge.entity.Route;
import shippingChallenge.requestModels.InnerRequestModel;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class RouteController {

    private final RouteService routesService;

    @RequestMapping(value = "/route/{id}", method = RequestMethod.GET)
    public ResponseEntity<Route> getRoute(@PathVariable Integer id) {
        return ResponseEntity.ok(routesService.getRoute(id));
    }

    @RequestMapping(value = "/getRoutsForPlate", method = RequestMethod.POST)
    public ResponseEntity<List<Route>> getRoutesByLicencePlate(@RequestBody InnerRequestModel innerRequestModel){
        return  ResponseEntity.ok(routesService.getRoutesByLicencePlate(innerRequestModel));
    }

    @RequestMapping(value = "/addRoute", method = RequestMethod.POST)
    public ResponseEntity<String> addRoute(@RequestBody Route routes) {
        return ResponseEntity.ok(routesService.addRoute(routes));
    }

    @RequestMapping(value = "/updateRoute", method = RequestMethod.PUT)
    public ResponseEntity<Route> updateRoute(@RequestBody Route routes) {
        return ResponseEntity.ok(routesService.updateRoute(routes));
    }

    @RequestMapping(value = "/deleteRoute", method = RequestMethod.DELETE)
    public Map<String, String> deleteRoute(@RequestParam Integer id) {
        return routesService.deleteRoute(id);
    }


    @RequestMapping(value = "/getAllRoute", method = RequestMethod.GET)
    List<Route> getAllRoute() {
        return routesService.getAllRoute();
    }

    @RequestMapping(value = "/addAllRoute", method = RequestMethod.POST)
    String addAllRoute(@RequestBody List<Route> routes) {
        return routesService.addAllRoute(routes);
    }

    @RequestMapping(value = "/deleteAllRoute", method = RequestMethod.DELETE)
    String deleteAllRoute() {
        return routesService.deleteAllRoute();
    }
    

    
}
