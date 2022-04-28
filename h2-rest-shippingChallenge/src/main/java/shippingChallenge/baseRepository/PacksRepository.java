package shippingChallenge.baseRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shippingChallenge.entity.Packs;
import shippingChallenge.generic.IRepository;

@Repository
public interface PacksRepository extends IRepository<Packs> {

    @Query(value ="SELECT * FROM packs WHERE pack_barcode = :barcode", nativeQuery = true)
    Packs findPackByBarcode(@Param(value="barcode") String barcode);

}
