package shippingChallenge.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import shippingChallenge.enums.StatusOfPacks;
import shippingChallenge.generic.GenericEntity;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "packs")
public class Packs implements Serializable, GenericEntity<Packs> {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer id;

    @Column(name = "packBarcode", nullable = false)
    String packBarcode;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "delivery_point_deliveryValue", referencedColumnName = "deliveryValue", nullable = false)
    DeliveryPoints deliveryPoints;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "bags_barcode", referencedColumnName = "barcode", nullable = true)
    Bags bags;

    @Column(name = "volumetricWeight")
    Integer volumetricWeight;


    @Enumerated(value = EnumType.ORDINAL)
    StatusOfPacks statusOfPacks;


    @Override
    public void update(Packs source) {
        this.id=source.getId();
        this.packBarcode = source.getPackBarcode();
        this.deliveryPoints = source.getDeliveryPoints();
        this.bags = source.getBags();
        this.volumetricWeight = source.getVolumetricWeight();
        this.statusOfPacks = source.getStatusOfPacks();
    }

    @Override
    public Packs createNewInstance() {
        Packs newInstance = new Packs();
        newInstance.update(this);

        return newInstance;
    }
}
