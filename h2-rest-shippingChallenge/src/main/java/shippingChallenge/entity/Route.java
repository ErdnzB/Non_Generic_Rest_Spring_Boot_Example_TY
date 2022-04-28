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
@Table(name = "route")
public class Route implements Serializable, GenericEntity<Route> {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer id;

    @JsonIgnore
    @ManyToOne(targetEntity = LicencePlate.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "plate", referencedColumnName = "plateName", nullable = false)
    LicencePlate licencePlate;

    @JsonIgnore
    @OneToMany(targetEntity = DeliveryPoints.class, mappedBy = "route", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<DeliveryPoints> deliveryPointsList = new ArrayList<>();


    @Override
    public void update(Route source) {
        this.id=source.getId();
        this.licencePlate=source.getLicencePlate();
        this.deliveryPointsList=source.getDeliveryPointsList();
    }

    @Override
    public Route createNewInstance() {
        Route newInstance = new Route();
        newInstance.update(this);

        return newInstance;
    }
}
