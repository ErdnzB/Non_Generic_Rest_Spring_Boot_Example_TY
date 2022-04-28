package shippingChallenge.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
public class Route implements Serializable {

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


}
