package shippingChallenge.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum EnumMessages {

    INTERNAL_SERVER_ERROR(1000, "Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR),
    SHIP_NOT_FOUND(1001, "Ship not found", HttpStatus.BAD_REQUEST),
    COMPLETED(1002,"Process Completed Successfully",HttpStatus.OK),
    ROUTE_AND_DELIVERIES_NOT_FOUND(1003, "Route , Deliveries Define Error", HttpStatus.BAD_REQUEST),


    DELIVERY_POINT_CANT_SAVE(2000, "Delivery Point Save Error", HttpStatus.BAD_REQUEST),
    DELIVERY_POINT_NOT_UPDATE(2001, "Delivery Point  Update Error", HttpStatus.BAD_REQUEST),
    DELIVERY_POINT_NOT_FOUND(2003, "Delivery Point  not found", HttpStatus.BAD_REQUEST),

    BAG_CANT_SAVE(3000, "Bag Save Error", HttpStatus.BAD_REQUEST),
    BAG_NOT_UPDATE(3001, "Bag Update Error", HttpStatus.BAD_REQUEST),
    BAG_BARCODE_SEARCH(3002,"Barcode Related Bag Error",HttpStatus.BAD_REQUEST),
    BAG_NOT_FOUND(3003, "Bag not found", HttpStatus.BAD_REQUEST),

    LICENCE_PLATE_CANT_SAVE(4000, "Licence Plate Save Error", HttpStatus.BAD_REQUEST),
    LICENCE_PLATE_NOT_UPDATE(4001, "Licence Plate Update Error", HttpStatus.BAD_REQUEST),
    LICENCE_PLATE_BARCODE_SEARCH(4002,"Barcode Related Bag Error",HttpStatus.BAD_REQUEST),
    LICENCE_PLATE_NOT_FOUND(4003, "Licence Plate not found", HttpStatus.BAD_REQUEST),

    PACK_CANT_SAVE(5000, "Pack Save Error", HttpStatus.BAD_REQUEST),
    PACK_NOT_UPDATE(5001, "Pack Update Error", HttpStatus.BAD_REQUEST),
    PACK_BARCODE_SEARCH(5002,"Barcode Related Pack Error",HttpStatus.BAD_REQUEST),
    PACK_NOT_FOUND(5003, "Pack not found", HttpStatus.BAD_REQUEST),

    ROUTE_CANT_SAVE(5000, "Pack Save Error", HttpStatus.BAD_REQUEST),
    ROUTE_NOT_UPDATE(5001, "Pack Update Error", HttpStatus.BAD_REQUEST),
    ROUTE_BARCODE_SEARCH(5002,"Route Related Plate Error",HttpStatus.BAD_REQUEST),
    ROUTE_NOT_FOUND(5003, "Pack not found", HttpStatus.BAD_REQUEST);


    private int code;
    private String message;
    private HttpStatus httpStatus;
}
