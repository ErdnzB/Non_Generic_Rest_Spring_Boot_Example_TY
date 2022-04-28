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
@Table(name = "licence_plate")
public class LicencePlate implements Serializable {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer id;

    @Column(name = "plateName")
    String plateName;

    @JsonIgnore
    @OneToMany(targetEntity = Route.class, mappedBy = "licencePlate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Route> routeList = new ArrayList<>();



}
