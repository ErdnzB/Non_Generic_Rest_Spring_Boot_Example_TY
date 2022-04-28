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
@Table(name = "delivery_points")
public class DeliveryPoints implements Serializable {


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



}
