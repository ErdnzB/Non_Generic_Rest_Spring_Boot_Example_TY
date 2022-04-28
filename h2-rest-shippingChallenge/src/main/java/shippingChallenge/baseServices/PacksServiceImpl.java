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
}
