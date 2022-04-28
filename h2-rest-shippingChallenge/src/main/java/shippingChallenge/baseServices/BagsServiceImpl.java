package shippingChallenge.baseServices;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.mapping.Bag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import shippingChallenge.baseRepository.BagsRepository;
import shippingChallenge.configuration.EnumMessages;
import shippingChallenge.configuration.ShippingChallengeApiException;
import shippingChallenge.entity.Bags;
import shippingChallenge.requestModels.InnerRequestModel;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class BagsServiceImpl implements BagsService {


    private final BagsRepository bagsRepository;

    @Override
    @Transactional
    public Bags getBag(Integer id) {
        try {
            return bagsRepository.findById(id).get();
        }catch (Exception e){
            throw new ShippingChallengeApiException(EnumMessages.BAG_NOT_FOUND);
        }
    }

    @Override
    @Transactional
    public String addBag(Bags bags) {
        try {
            Bags savedBag = bagsRepository.save(bags);
            return EnumMessages.COMPLETED.getMessage();
        }catch (Exception e){
            throw new ShippingChallengeApiException(EnumMessages.BAG_CANT_SAVE);
        }
    }

    @Override
    @Transactional
    public Bags updateBag(Bags bags) {
        try {
            return bagsRepository.save(bags);
        }catch (Exception e){
            throw new ShippingChallengeApiException(EnumMessages.BAG_NOT_UPDATE);
        }

    }

    @Override
    @Transactional
    public Bags findBagByBarcode(InnerRequestModel req) {
        try {
            Bags bag = bagsRepository.findBagByBarcode(req.getBarcode());
            if(bag == null){
                throw new ShippingChallengeApiException(EnumMessages.BAG_NOT_FOUND);
            }else{
                return bag;
            }
        }catch (Exception e){
            throw new ShippingChallengeApiException(EnumMessages.BAG_BARCODE_SEARCH);
        }
    }

    @Override
    @Transactional
    public Map<String, String> deleteBag(Integer id) {
        Map<String, String> status = new HashMap<>();
        Optional<Bags> bags = bagsRepository.findById(id);
        if(bags.isPresent()) {
            bagsRepository.delete(bags.get());
            status.put("Status", "Bags deleted successfully");
        }
        else {
            status.put("Status", "Bags not exist");
        }
        return status;
    }

    @Override
    @Transactional
    public List<Bags> getAllBags() {
        return bagsRepository.findAll();
    }

    @Override
    @Transactional
    public String addAllBags(List<Bags> bags) {
        bagsRepository.saveAll(bags);
        return EnumMessages.COMPLETED.getMessage();
    }

    @Override
    @Transactional
    public String deleteAllBags() {
        bagsRepository.deleteAll();
        return EnumMessages.COMPLETED.getMessage();
    }
}
