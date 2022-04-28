package shippingChallenge.businessServices;



import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import shippingChallenge.responseModels.ShipmentModel;


public interface FleetService {

    public String shipLoad(ShipmentModel shipmentModel);

    public ShipmentModel shipUnLoad(ShipmentModel shipmentModel);
}
