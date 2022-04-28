package shippingChallenge.baseControllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shippingChallenge.baseServices.BagsService;
import shippingChallenge.entity.Bags;
import shippingChallenge.requestModels.InnerRequestModel;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class BagsController {


    private final BagsService bagsService;

    @RequestMapping(value = "/bag/{id}", method = RequestMethod.GET)
    public ResponseEntity<Bags> getBag(@PathVariable Integer id) {
        return ResponseEntity.ok(bagsService.getBag(id));
    }

    @RequestMapping(value = "/addBag", method = RequestMethod.POST)
    public ResponseEntity<String> addBag(@RequestBody Bags bags) {
        return ResponseEntity.ok(bagsService.addBag(bags));
    }

    @RequestMapping(value = "/updateBag", method = RequestMethod.PUT)
    public ResponseEntity<Bags> updateBag(@RequestBody Bags bags) {
        return ResponseEntity.ok(bagsService.updateBag(bags));
    }


    @RequestMapping(value = "/findBagByBarcode", method = RequestMethod.POST)
    public ResponseEntity<Bags> findBagByBarcode(@RequestBody InnerRequestModel req) {
        return ResponseEntity.ok(bagsService.findBagByBarcode(req));
    }


    @RequestMapping(value = "/deleteBag", method = RequestMethod.DELETE)
    public Map<String, String> deleteBag(@RequestParam Integer id) {
        return bagsService.deleteBag(id);
    }


    @RequestMapping(value = "/getAllBags", method = RequestMethod.GET)
    List<Bags> getAllBags() {
        return bagsService.getAllBags();
    }

    @RequestMapping(value = "/addAllBags", method = RequestMethod.POST)
    String addAllBags(@RequestBody List<Bags> bags) {
        return bagsService.addAllBags(bags);
    }

    @RequestMapping(value = "/deleteAllBags", method = RequestMethod.DELETE)
    String deleteAllBags() {
        return bagsService.deleteAllBags();
    }
}
