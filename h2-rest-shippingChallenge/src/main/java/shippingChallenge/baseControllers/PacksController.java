package shippingChallenge.baseControllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shippingChallenge.baseServices.PacksService;
import shippingChallenge.entity.Packs;
import shippingChallenge.requestModels.InnerRequestModel;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class PacksController {


    private final PacksService packsService;

    @RequestMapping(value = "/pack/{id}", method = RequestMethod.GET)
    public ResponseEntity<Packs> getPacks(@PathVariable Integer id) {
        return ResponseEntity.ok(packsService.getPacks(id));
    }

    @RequestMapping(value = "/addPack", method = RequestMethod.POST)
    public ResponseEntity<String> addPacks(@RequestBody Packs packs) {
        return ResponseEntity.ok(packsService.addPacks(packs));
    }

    @RequestMapping(value = "/updatePack", method = RequestMethod.PUT)
    public ResponseEntity<Packs> updatePacks(@RequestBody Packs packs) {
        return ResponseEntity.ok(packsService.updatePacks(packs));
    }

    @RequestMapping(value = "/findPackByBarcode", method = RequestMethod.POST)
    public ResponseEntity<Packs> findPackByBarcode(@RequestBody InnerRequestModel req) {
        return ResponseEntity.ok(packsService.findPackByBarcode(req));
    }

    @RequestMapping(value = "/deletePack", method = RequestMethod.DELETE)
    public Map<String, String> deletePack(@RequestParam Integer id) {
        return packsService.deletePack(id);
    }


    @RequestMapping(value = "/getAllPacks", method = RequestMethod.GET)
    List<Packs> getAllPacks() {
        return packsService.getAllPacks();
    }

    @RequestMapping(value = "/addAllPacks", method = RequestMethod.POST)
    String addAllPacks(@RequestBody List<Packs> packs) {
        return packsService.addAllPacks(packs);
    }

    @RequestMapping(value = "/deleteAllPacks", method = RequestMethod.DELETE)
    String deleteAllPacks() {
        return packsService.deleteAllPacks();
    }
}
