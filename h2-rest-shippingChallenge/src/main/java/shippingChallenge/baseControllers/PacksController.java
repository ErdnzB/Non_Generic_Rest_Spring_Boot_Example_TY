package shippingChallenge.baseControllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shippingChallenge.baseServices.PacksService;
import shippingChallenge.entity.Packs;
import shippingChallenge.generic.GenericController;
import shippingChallenge.generic.GenericService;
import shippingChallenge.generic.IRepository;
import shippingChallenge.requestModels.InnerRequestModel;

@RestController
@RequestMapping("/api/pack")
public class PacksController extends GenericController<Packs> {


    private final PacksService packsService;

    public PacksController(GenericService<Packs> genericService, PacksService packsService) {
        super(genericService);
        this.packsService = packsService;
    }


    @RequestMapping(value = "/findPackByBarcode", method = RequestMethod.POST)
    public ResponseEntity<Packs> findPackByBarcode(@RequestBody InnerRequestModel req) {
        return ResponseEntity.ok(packsService.findPackByBarcode(req));
    }


}
