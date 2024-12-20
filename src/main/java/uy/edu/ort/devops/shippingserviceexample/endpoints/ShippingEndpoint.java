package uy.edu.ort.devops.shippingserviceexample.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uy.edu.ort.devops.shippingserviceexample.domain.Shipping;
import uy.edu.ort.devops.shippingserviceexample.logic.ShippingLogic;

@RestController
@RequestMapping
public class ShippingEndpoint {

    @Autowired
    private ShippingLogic logic;

    @PostMapping(path = "/shipping/{id}")
    public ResponseEntity create(@PathVariable("id") String id) {
        logic.addShipping(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/shipping/{id}")
    public ResponseEntity getProduct(@PathVariable("id") String id) {
        if (logic.hasShipping(id)) {
            Shipping shipping = logic.getShipping(id);
            return ResponseEntity.ok(shipping);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/healthcheck")
    public String healthCheck() {
        return "Health Passed";
    }
}