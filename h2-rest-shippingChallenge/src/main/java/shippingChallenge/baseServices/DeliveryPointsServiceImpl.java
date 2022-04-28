package shippingChallenge.baseServices;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import shippingChallenge.baseRepository.DeliveryPointsRepository;
import shippingChallenge.configuration.EnumMessages;
import shippingChallenge.configuration.ShippingChallengeApiException;
import shippingChallenge.entity.Bags;
import shippingChallenge.entity.DeliveryPoints;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class DeliveryPointsServiceImpl implements DeliveryPointsService {


    private final DeliveryPointsRepository deliveryPointsRepository;

    @Override
    @Transactional
    public DeliveryPoints getDeliveryPoints(Integer id) {
        try {
            return deliveryPointsRepository.findById(id).get();
        }catch (Exception e){
            throw new ShippingChallengeApiException(EnumMessages.DELIVERY_POINT_NOT_FOUND);
        }

    }

    @Override
    @Transactional
    public String addDeliveryPoints(DeliveryPoints deliveryPoints) {
        try {
            DeliveryPoints savedDeliveryPoints = deliveryPointsRepository.save(deliveryPoints);
            return EnumMessages.COMPLETED.getMessage();
        }catch (Exception e){
            throw new ShippingChallengeApiException(EnumMessages.DELIVERY_POINT_CANT_SAVE);
        }

    }

    @Override
    @Transactional
    public DeliveryPoints updateDeliveryPoints(DeliveryPoints deliveryPoints) {
        try {
            return deliveryPointsRepository.save(deliveryPoints);
        }catch (Exception e){
            throw new ShippingChallengeApiException(EnumMessages.DELIVERY_POINT_NOT_UPDATE);
        }
    }


    @Override
    @Transactional
    public Map<String, String> deleteDeliveryPoint(Integer id) {
        Map<String, String> status = new HashMap<>();
        Optional<DeliveryPoints> deliveryPoints = deliveryPointsRepository.findById(id);
        if(deliveryPoints.isPresent()) {
            deliveryPointsRepository.delete(deliveryPoints.get());
            status.put("Status", "DeliveryPoints deleted successfully");
        }
        else {
            status.put("Status", "DeliveryPoints not exist");
        }
        return status;
    }

    @Override
    @Transactional
    public List<DeliveryPoints> getAllDeliveryPoints() {
        return deliveryPointsRepository.findAll();
    }

    @Override
    @Transactional
    public String addAllDeliveryPoints(List<DeliveryPoints> deliveryPoints) {
        deliveryPointsRepository.saveAll(deliveryPoints);
        return EnumMessages.COMPLETED.getMessage();
    }

    @Override
    @Transactional
    public String deleteAllDeliveryPoints() {
        deliveryPointsRepository.deleteAll();
        return EnumMessages.COMPLETED.getMessage();
    }
}
