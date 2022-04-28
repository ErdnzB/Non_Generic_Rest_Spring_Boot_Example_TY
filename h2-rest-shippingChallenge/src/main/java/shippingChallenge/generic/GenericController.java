package shippingChallenge.generic;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public abstract class GenericController<T extends GenericEntity<T>> {

    private final GenericService<T> service;

    public GenericController(GenericService<T> service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<T> get(@PathVariable Integer id) {
        return ResponseEntity.ok(service.get(id));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> add(@RequestBody T req) {
        return ResponseEntity.ok(service.add(req));
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<T> update(@RequestBody T req) {
        return ResponseEntity.ok(service.update(req));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Map<String, String> delete(@RequestParam Integer id) {
        return service.deleteT(id);

    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    List<T> getAllT() {
        return service.getAllT();
    }


}