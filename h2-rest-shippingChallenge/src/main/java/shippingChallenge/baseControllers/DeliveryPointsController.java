package shippingChallenge.baseControllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shippingChallenge.entity.DeliveryPoints;
import shippingChallenge.generic.GenericController;
import shippingChallenge.generic.GenericService;
import shippingChallenge.generic.IRepository;

@RestController
@RequestMapping("/api/deliveryPoint")
public class DeliveryPointsController extends GenericController<DeliveryPoints> {

    public DeliveryPointsController(GenericService<DeliveryPoints> service) {
        super(service);
    }

}
