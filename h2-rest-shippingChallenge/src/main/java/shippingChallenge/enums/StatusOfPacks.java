package shippingChallenge.enums;



public enum StatusOfPacks {

    NONE(0),
    CREATED( 1),
    LOADED_INTO_BAG( 2),
    LOADED(3),
    UNLOADED( 4);

    private final Integer key;

    StatusOfPacks(Integer key) {
        this.key = key;

    }

    public Integer getKey() {
        return key;
    }

}