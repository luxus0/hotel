package hotel_app.hotel.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RegionNameException extends RuntimeException {
    public RegionNameException(String s) {
    }
}
