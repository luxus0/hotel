package hotel_app.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CheckOutDateExeption extends Throwable {
    public CheckOutDateExeption(String date) {
    }
}
