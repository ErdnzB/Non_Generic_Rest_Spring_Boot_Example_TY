package shippingChallenge.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import shippingChallenge.generic.GenericEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Builder
@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "delivery_points")
public class DeliveryPoints implements Serializable, GenericEntity<DeliveryPoints> {


    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer id;

    @Column(name = "deliveryPoint")
    String deliveryPoint;

    @Column(name = "deliveryValue")
    Integer deliveryValue;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "route_id", referencedColumnName = "id", nullable = true)
    Route route;

    @JsonIgnore
    @OneToMany(targetEntity = Bags.class, mappedBy = "deliveryPoints", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Bags> bagsList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(targetEntity = Packs.class, mappedBy = "deliveryPoints", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Packs> packsList = new ArrayList<>();


    @Override
    public void update(DeliveryPoints source) {
        this.id=source.getId();
        this.deliveryPoint=source.getDeliveryPoint();
        this.deliveryValue=source.getDeliveryValue();
        this.route=source.getRoute();
        this.bagsList=source.getBagsList();
        this.packsList=source.getPacksList();
    }

    @Override
    public DeliveryPoints createNewInstance() {
        DeliveryPoints newInstance = new DeliveryPoints();
        newInstance.update(this);

        return newInstance;
    }
}
