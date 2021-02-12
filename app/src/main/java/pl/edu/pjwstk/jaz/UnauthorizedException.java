package pl.edu.pjwstk.jaz;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)         //401
public class UnauthorizedException extends Throwable {
}
