package shippingChallenge.baseServices;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import shippingChallenge.entity.Packs;
import shippingChallenge.requestModels.InnerRequestModel;

import java.util.List;
import java.util.Map;

public interface PacksService {


    public Packs getPacks(@PathVariable Integer id);

    public String addPacks(@RequestBody Packs bags);

    public Packs updatePacks(@RequestBody Packs bags);

    public Packs findPackByBarcode(@RequestBody InnerRequestModel req);

    public Map<String, String> deletePack(@RequestParam Integer id);

    List<Packs> getAllPacks();

    String addAllPacks(@RequestBody List<Packs> bags);

    String deleteAllPacks();
}
