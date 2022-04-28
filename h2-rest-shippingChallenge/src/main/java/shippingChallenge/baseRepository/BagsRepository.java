package shippingChallenge.baseRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shippingChallenge.entity.Bags;
import shippingChallenge.generic.IRepository;

@Repository
public interface BagsRepository extends IRepository<Bags> {

    @Query(value ="SELECT * FROM bags WHERE barcode = :barcode", nativeQuery = true)
    Bags findBagByBarcode(@Param(value="barcode") String barcode);
}
