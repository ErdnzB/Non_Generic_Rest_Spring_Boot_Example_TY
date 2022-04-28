package shippingChallenge.baseControllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shippingChallenge.baseServices.LicencePlateService;
import shippingChallenge.entity.LicencePlate;
import shippingChallenge.generic.GenericController;
import shippingChallenge.generic.GenericService;
import shippingChallenge.generic.IRepository;
import shippingChallenge.requestModels.InnerRequestModel;

@RestController
@RequestMapping("/api/licensePlate")
public class LicensePlateController extends GenericController<LicencePlate> {

    private final LicencePlateService licencePlateService;

    public LicensePlateController(GenericService<LicencePlate> service, LicencePlateService licencePlateService) {
        super(service);
        this.licencePlateService = licencePlateService;
    }

    @RequestMapping(value = "/getShipByPlate", method = RequestMethod.POST)
    public ResponseEntity<LicencePlate> getShipByPlate(@RequestBody InnerRequestModel innerRequestModel) {
        return ResponseEntity.ok(licencePlateService.getShipByPlate(innerRequestModel));
    }

}
