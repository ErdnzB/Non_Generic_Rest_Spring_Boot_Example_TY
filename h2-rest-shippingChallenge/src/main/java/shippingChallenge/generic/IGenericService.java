package shippingChallenge.generic;


import java.util.List;
import java.util.Map;

public interface IGenericService<T> {

    T get(Integer id);

    String add(Object req);

    T update(Object req);

    Map<String, String> deleteT(Integer id);

    List<T> getAllT();

}