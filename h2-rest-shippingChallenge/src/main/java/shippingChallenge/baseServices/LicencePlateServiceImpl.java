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
    public LicencePlate getLicencePlate(Integer id) {
        try {
            return licencePlateRepository.findById(id).get();
        } catch (Exception e) {
            throw new ShippingChallengeApiException(EnumMessages.LICENCE_PLATE_NOT_FOUND);
        }
    }

    @Override
    @Transactional
    public LicencePlate getShipByPlate(InnerRequestModel innerRequestModel) {
        try {
            return licencePlateRepository.getOrderByOrderNum(innerRequestModel.getPlateNo());
        } catch (Exception e) {
            throw new ShippingChallengeApiException(EnumMessages.LICENCE_PLATE_BARCODE_SEARCH);
        }
    }


    @Override
    @Transactional
    public String addLicencePlate(LicencePlate licencePlate) {
        try {
            LicencePlate savedLicencePlate = licencePlateRepository.save(licencePlate);
            return EnumMessages.COMPLETED.getMessage();
        } catch (Exception e) {
            throw new ShippingChallengeApiException(EnumMessages.DELIVERY_POINT_CANT_SAVE);
        }

    }

    @Override
    @Transactional
    public LicencePlate updateLicencePlate(LicencePlate licencePlate) {
        try {
            return licencePlateRepository.save(licencePlate);

        } catch (Exception e) {
            throw new ShippingChallengeApiException(EnumMessages.DELIVERY_POINT_NOT_UPDATE);
        }


    }


    @Override
    @Transactional
    public Map<String, String> deleteLicencePlate(Integer id) {
        Map<String, String> status = new HashMap<>();
        Optional<LicencePlate> licencePlate = licencePlateRepository.findById(id);
        if (licencePlate.isPresent()) {
            licencePlateRepository.delete(licencePlate.get());
            status.put("Status", "LicencePlate deleted successfully");
        } else {
            status.put("Status", "LicencePlate not exist");
        }
        return status;
    }

    @Override
    @Transactional
    public List<LicencePlate> getAllLicencePlate() {
        return licencePlateRepository.findAll();
    }

    @Override
    @Transactional
    public String addAllLicencePlate(List<LicencePlate> licencePlate) {
        licencePlateRepository.saveAll(licencePlate);
        return EnumMessages.COMPLETED.getMessage();
    }

    @Override
    @Transactional
    public String deleteAllLicencePlate() {
        licencePlateRepository.deleteAll();
        return EnumMessages.COMPLETED.getMessage();
    }
}
