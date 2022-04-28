package shippingChallenge.configuration;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(callSuper = true)
public class ShippingChallengeApiException extends RuntimeException {

    private final EnumMessages errorCode;

    public ShippingChallengeApiException(EnumMessages errorCode) {
        super();
        this.errorCode = errorCode;
    }

}

