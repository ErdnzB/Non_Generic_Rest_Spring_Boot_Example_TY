package shippingChallenge.baseServices;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import shippingChallenge.entity.DeliveryPoints;

import java.util.List;
import java.util.Map;

public interface DeliveryPointsService {


    public DeliveryPoints getDeliveryPoints(@PathVariable Integer id);

    public String addDeliveryPoints(@RequestBody DeliveryPoints deliveryPoints);

    public DeliveryPoints updateDeliveryPoints(@RequestBody DeliveryPoints deliveryPoints);

    public Map<String, String> deleteDeliveryPoint(@RequestParam Integer id);

    List<DeliveryPoints> getAllDeliveryPoints();

    String addAllDeliveryPoints(@RequestBody List<DeliveryPoints> deliveryPoints);

    String deleteAllDeliveryPoints();
}
