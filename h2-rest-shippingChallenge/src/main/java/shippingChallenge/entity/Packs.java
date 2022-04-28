package shippingChallenge.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import shippingChallenge.enums.StatusOfPacks;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "packs")
public class Packs implements Serializable {

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


}
