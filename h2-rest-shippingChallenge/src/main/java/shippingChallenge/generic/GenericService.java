package shippingChallenge.generic;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import shippingChallenge.configuration.EnumMessages;
import shippingChallenge.configuration.ShippingChallengeApiException;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public abstract class GenericService<T extends GenericEntity<T>> implements IGenericService {

    public final IRepository<T> iRepo;

    @Transactional
    public T get(Integer id) {
        try {
            return iRepo.findById(id).get();
        } catch (Exception e) {
            throw new ShippingChallengeApiException(EnumMessages.BAG_NOT_FOUND);
        }
    }


    @Transactional
    public String add(T req) {
        try {
            T savedBag = iRepo.save(req);
            return EnumMessages.COMPLETED.getMessage();
        } catch (Exception e) {
            throw new ShippingChallengeApiException(EnumMessages.BAG_CANT_SAVE);
        }
    }


    @Transactional
    public T update(T req) {
        try {
            return iRepo.save(req);
        } catch (Exception e) {
            throw new ShippingChallengeApiException(EnumMessages.BAG_NOT_UPDATE);
        }

    }


    @Transactional
    public Map<String, String> deleteT(Integer id) {
        Map<String, String> status = new HashMap<>();
        Optional<T> bags = iRepo.findById(id);
        if (bags.isPresent()) {
            iRepo.delete(bags.get());
            status.put("Status", "T deleted successfully");
        } else {
            status.put("Status", "T not exist");
        }
        return status;
    }


    @Transactional
    public List<T> getAllT() {
        return iRepo.findAll();
    }


}
