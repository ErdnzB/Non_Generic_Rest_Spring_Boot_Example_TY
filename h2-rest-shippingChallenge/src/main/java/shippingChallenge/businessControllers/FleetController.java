package shippingChallenge.businessControllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shippingChallenge.businessServices.FleetService;
import shippingChallenge.responseModels.ShipmentModel;

@RestController
@RequiredArgsConstructor
public class FleetController {

    private final FleetService fleetService;

    @RequestMapping(value = "/shipLoad", method = RequestMethod.POST)
    ResponseEntity<String> shipLoad(@RequestBody ShipmentModel shipmentModelRequest) {
        return ResponseEntity.ok(fleetService.shipLoad(shipmentModelRequest));

    }

    @RequestMapping(value = "/shipUnload", method = RequestMethod.POST)
    ResponseEntity<ShipmentModel> shipUnLoad(@RequestBody ShipmentModel shipmentModelRequest) {
        return ResponseEntity.ok(fleetService.shipUnLoad(shipmentModelRequest));

    }


}
