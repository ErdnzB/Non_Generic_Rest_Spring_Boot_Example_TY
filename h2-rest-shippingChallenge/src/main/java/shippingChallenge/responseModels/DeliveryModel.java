package shippingChallenge.responseModels;



import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryModel {

    String barcode;

    Integer state;


}
