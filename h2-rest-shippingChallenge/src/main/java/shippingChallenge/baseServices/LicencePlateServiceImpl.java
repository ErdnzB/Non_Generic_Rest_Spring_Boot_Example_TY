package shippingChallenge.baseServices;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shippingChallenge.baseRepository.LicencePlateRepository;
import shippingChallenge.configuration.EnumMessages;
import shippingChallenge.configuration.ShippingChallengeApiException;
import shippingChallenge.entity.LicencePlate;
import shippingChallenge.requestModels.InnerRequestModel;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class LicencePlateServiceImpl implements LicencePlateService {


    private final LicencePlateRepository licencePlateRepository;

    @Override
    @Transactional
    public LicencePlate getShipByPlate(InnerRequestModel innerRequestModel) {
        try {
            return licencePlateRepository.getOrderByOrderNum(innerRequestModel.getPlateNo());
        } catch (Exception e) {
            throw new ShippingChallengeApiException(EnumMessages.LICENCE_PLATE_BARCODE_SEARCH);
        }
    }

}
