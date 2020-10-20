package hotel_app.hotel.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AddressMapperNotFoundException extends RuntimeException {

    public AddressMapperNotFoundException(String mapper) {
    }
}
