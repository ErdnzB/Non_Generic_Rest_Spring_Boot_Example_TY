package shippingChallenge.enums;

import javax.persistence.Entity;

public enum StatusOfBags {

    NONE(0),
    CREATED( 1),
    NONE_VALID(2),
    LOADED(3),
    UNLOADED(4);

    private final Integer key;


    StatusOfBags(Integer key) {
        this.key = key;

    }

    public Integer getKey() {
        return key;
    }

}
