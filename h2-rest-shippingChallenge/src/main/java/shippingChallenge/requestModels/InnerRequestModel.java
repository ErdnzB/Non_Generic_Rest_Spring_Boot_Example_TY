package shippingChallenge.requestModels;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InnerRequestModel {

    String plateNo;

    String barcode;

}
