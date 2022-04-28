package shippingChallenge.baseServices;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import shippingChallenge.baseRepository.PacksRepository;
import shippingChallenge.configuration.EnumMessages;
import shippingChallenge.configuration.ShippingChallengeApiException;
import shippingChallenge.entity.Bags;
import shippingChallenge.entity.Packs;
import shippingChallenge.requestModels.InnerRequestModel;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class PacksServiceImpl implements PacksService {


    private final PacksRepository packsRepository;

    @Override
    @Transactional
    public Packs getPacks(Integer id) {
        try {
            return packsRepository.findById(id).get();
        }catch (Exception e){
            throw new ShippingChallengeApiException(EnumMessages.PACK_NOT_FOUND);
        }

    }

    @Override
    @Transactional
    public String addPacks(Packs packs) {
        try {
            Packs savedPack = packsRepository.save(packs);
            return EnumMessages.COMPLETED.getMessage();
        }catch (Exception e){
            throw new ShippingChallengeApiException(EnumMessages.PACK_CANT_SAVE);
        }

    }

    @Override
    @Transactional
    public Packs updatePacks(Packs packs) {
        try {
            return packsRepository.save(packs);
        }catch (Exception e){
            throw new ShippingChallengeApiException(EnumMessages.PACK_NOT_UPDATE);
        }

    }

    @Override
    @Transactional
    public Packs findPackByBarcode(InnerRequestModel req) {
        try {
            Packs findingPack = packsRepository.findPackByBarcode(req.getBarcode());
            if(findingPack == null){
                throw new ShippingChallengeApiException(EnumMessages.PACK_NOT_FOUND);
            }else{
                return findingPack;
            }
        }catch (Exception e){
            throw new ShippingChallengeApiException(EnumMessages.PACK_BARCODE_SEARCH);
        }
    }

    @Override
    @Transactional
    public Map<String, String> deletePack(Integer id) {
        Map<String, String> status = new HashMap<>();
        Optional<Packs> packs = packsRepository.findById(id);
        if(packs.isPresent()) {
            packsRepository.delete(packs.get());
            status.put("Status", "Packs deleted successfully");
        }
        else {
            status.put("Status", "Packs not exist");
        }
        return status;
    }

    @Override
    @Transactional
    public List<Packs> getAllPacks() {
        return packsRepository.findAll();
    }

    @Override
    @Transactional
    public String addAllPacks(List<Packs> packs) {
        packsRepository.saveAll(packs);
        return EnumMessages.COMPLETED.getMessage();
    }

    @Override
    @Transactional
    public String deleteAllPacks() {
        packsRepository.deleteAll();
        return EnumMessages.COMPLETED.getMessage();
    }
}
