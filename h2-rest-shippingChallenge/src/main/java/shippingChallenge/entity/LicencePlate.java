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
@Table(name = "licence_plate")
public class LicencePlate implements Serializable, GenericEntity<LicencePlate> {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer id;

    @Column(name = "plateName")
    String plateName;

    @JsonIgnore
    @OneToMany(targetEntity = Route.class, mappedBy = "licencePlate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Route> routeList = new ArrayList<>();


    @Override
    public void update(LicencePlate source) {
        this.id=source.getId();
        this.plateName = source.getPlateName();
        this.routeList = source.getRouteList();
    }

    @Override
    public LicencePlate createNewInstance() {
        LicencePlate newInstance = new LicencePlate();
        newInstance.update(this);

        return newInstance;
    }
}
