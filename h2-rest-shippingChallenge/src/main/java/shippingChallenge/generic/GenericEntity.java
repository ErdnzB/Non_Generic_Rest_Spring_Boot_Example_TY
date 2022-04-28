package shippingChallenge.generic;

public interface GenericEntity<T> {

    // update current instance with provided data
    void update(T source);

    Integer getId();

    // based on current data create new instance with new id
    T createNewInstance();

}