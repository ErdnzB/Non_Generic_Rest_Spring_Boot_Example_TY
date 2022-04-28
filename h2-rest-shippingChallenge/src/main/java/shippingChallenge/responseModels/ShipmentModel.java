package shippingChallenge.responseModels;


import lombok.*;

import java.util.ArrayList;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentModel {

    String plate;

    ArrayList<RouteModel> route;


}
