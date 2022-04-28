package shippingChallenge.baseControllers;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shippingChallenge.baseServices.LicencePlateService;
import shippingChallenge.entity.LicencePlate;
import shippingChallenge.requestModels.InnerRequestModel;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class LicensePlateController {

    private final LicencePlateService licencePlateService;

    @RequestMapping(value = "/getShipByPlate", method = RequestMethod.POST)
    public ResponseEntity<LicencePlate> getShipByPlate(@RequestBody InnerRequestModel innerRequestModel){
        return  ResponseEntity.ok(licencePlateService.getShipByPlate(innerRequestModel));
    }

    @RequestMapping(value = "/licencePlate/{id}", method = RequestMethod.GET)
    public ResponseEntity<LicencePlate> getLicencePlate(@PathVariable Integer id) {
        return ResponseEntity.ok(licencePlateService.getLicencePlate(id));
    }

    @RequestMapping(value = "/addLicencePlate", method = RequestMethod.POST)
    public ResponseEntity<String> addLicencePlate(@RequestBody LicencePlate licencePlates) {
        return ResponseEntity.ok(licencePlateService.addLicencePlate(licencePlates));
    }

    @RequestMapping(value = "/updateLicencePlate", method = RequestMethod.PUT)
    public ResponseEntity<LicencePlate> updateLicencePlate(@RequestBody LicencePlate licencePlates) {
        return ResponseEntity.ok(licencePlateService.updateLicencePlate(licencePlates));
    }

    @RequestMapping(value = "/deleteLicencePlate", method = RequestMethod.DELETE)
    public Map<String, String> deleteLicencePlate(@RequestParam Integer id) {
        return licencePlateService.deleteLicencePlate(id);
    }

    @RequestMapping(value = "/getAllLicencePlates", method = RequestMethod.GET)
    List<LicencePlate> getAllLicencePlate() {
        return licencePlateService.getAllLicencePlate();
    }

    @RequestMapping(value = "/addAllLicencePlates", method = RequestMethod.POST)
    String addAllLicencePlate(@RequestBody List<LicencePlate> licencePlates) {
        return licencePlateService.addAllLicencePlate(licencePlates);
    }

    @RequestMapping(value = "/deleteAllLicencePlates", method = RequestMethod.DELETE)
    String deleteAllLicencePlate() {
        return licencePlateService.deleteAllLicencePlate();
    }
}
