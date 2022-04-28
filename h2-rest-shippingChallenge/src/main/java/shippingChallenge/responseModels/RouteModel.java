package shippingChallenge.responseModels;

import lombok.*;

import java.util.ArrayList;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RouteModel {

    Integer deliveryPoint;

    ArrayList<DeliveryModel> deliveries;


}
