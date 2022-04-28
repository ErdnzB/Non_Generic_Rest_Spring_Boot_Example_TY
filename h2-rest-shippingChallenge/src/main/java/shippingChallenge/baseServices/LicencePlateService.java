package shippingChallenge.baseServices;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import shippingChallenge.entity.LicencePlate;
import shippingChallenge.requestModels.InnerRequestModel;

import java.util.List;
import java.util.Map;

public interface LicencePlateService {


    public LicencePlate getLicencePlate(@PathVariable Integer id);

    public LicencePlate getShipByPlate(@RequestBody InnerRequestModel innerRequestModel);

    public String addLicencePlate(@RequestBody LicencePlate licencePlate);

    public LicencePlate updateLicencePlate(@RequestBody LicencePlate licencePlate);

    public Map<String, String> deleteLicencePlate(@RequestParam Integer id);

    List<LicencePlate> getAllLicencePlate();

    String addAllLicencePlate(@RequestBody List<LicencePlate> licencePlate);

    String deleteAllLicencePlate();

}
