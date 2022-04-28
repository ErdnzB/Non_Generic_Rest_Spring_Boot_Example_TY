package shippingChallenge.baseControllers;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shippingChallenge.baseServices.DeliveryPointsService;
import shippingChallenge.entity.DeliveryPoints;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class DeliveryPointsController {


    private final DeliveryPointsService deliveryPointsService;

    @RequestMapping(value = "/deliveryPoint/{id}", method = RequestMethod.GET)
    public ResponseEntity<DeliveryPoints> getDeliveryPoints(@PathVariable Integer id) {
        return ResponseEntity.ok(deliveryPointsService.getDeliveryPoints(id));
    }

    @RequestMapping(value = "/addDeliveryPoint", method = RequestMethod.POST)
    public ResponseEntity<String> addDeliveryPoints(@RequestBody DeliveryPoints deliveryPoints) {
        return ResponseEntity.ok(deliveryPointsService.addDeliveryPoints(deliveryPoints));
    }

    @RequestMapping(value = "/updateDeliveryPoint", method = RequestMethod.PUT)
    public ResponseEntity<DeliveryPoints> updateDeliveryPoints(@RequestBody DeliveryPoints deliveryPoints) {
        return ResponseEntity.ok(deliveryPointsService.updateDeliveryPoints(deliveryPoints));
    }

    @RequestMapping(value = "/deleteDeliveryPoint", method = RequestMethod.DELETE)
    public Map<String, String> deleteDeliveryPoint(@RequestParam Integer id) {
        return deliveryPointsService.deleteDeliveryPoint(id);
    }

    @RequestMapping(value = "/getAllDeliveryPoints", method = RequestMethod.GET)
    List<DeliveryPoints> getAllDeliveryPoints() {
        return deliveryPointsService.getAllDeliveryPoints();
    }

    @RequestMapping(value = "/addAllDeliveryPoints", method = RequestMethod.POST)
    String addAllDeliveryPoints(@RequestBody List<DeliveryPoints> deliveryPoints) {
        return deliveryPointsService.addAllDeliveryPoints(deliveryPoints);
    }

    @RequestMapping(value = "/deleteAllDeliveryPoints", method = RequestMethod.DELETE)
    String deleteAllDeliveryPoints() {
        return deliveryPointsService.deleteAllDeliveryPoints();
    }
}
