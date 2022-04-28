package shippingChallenge.baseServices;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import shippingChallenge.entity.Bags;
import shippingChallenge.requestModels.InnerRequestModel;

import java.util.List;
import java.util.Map;

public interface BagsService {


    public Bags getBag(@PathVariable Integer id);

    public String addBag(@RequestBody Bags bags);

    public Bags updateBag(@RequestBody Bags bags);

    public Bags findBagByBarcode(@RequestBody InnerRequestModel req);

    public Map<String, String> deleteBag(@RequestParam Integer id);

    List<Bags> getAllBags();

    String addAllBags(@RequestBody List<Bags> bags);

    String deleteAllBags();
}
