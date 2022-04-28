package shippingChallenge.baseControllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shippingChallenge.baseRepository.BagsRepository;
import shippingChallenge.baseServices.BagsService;
import shippingChallenge.entity.Bags;
import shippingChallenge.entity.DeliveryPoints;
import shippingChallenge.generic.GenericController;
import shippingChallenge.generic.GenericService;
import shippingChallenge.requestModels.InnerRequestModel;

@RestController
@RequestMapping("/api/book")
public class BagsController extends GenericController<Bags> {

    private final BagsService bagsService;

    public BagsController(GenericService<Bags> service, BagsService bagsService) {
        super(service);
        this.bagsService = bagsService;
    }

    @RequestMapping(value = "/findBagByBarcode", method = RequestMethod.POST)
    public ResponseEntity<Bags> findBagByBarcode(@RequestBody InnerRequestModel req) {
        return ResponseEntity.ok(bagsService.findBagByBarcode(req));
    }

}
