package shippingChallenge.businessServices;


import shippingChallenge.responseModels.ShipmentModel;


public interface FleetService {

    public String shipLoad(ShipmentModel shipmentModel);

    public ShipmentModel shipUnLoad(ShipmentModel shipmentModel);
}
