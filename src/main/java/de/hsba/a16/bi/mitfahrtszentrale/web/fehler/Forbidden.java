package de.hsba.a16.bi.mitfahrtszentrale.web.fehler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// TODO: 08.08.2018 ist zu verbinden  
@ResponseStatus(HttpStatus.FORBIDDEN)
public class Forbidden extends RuntimeException {
}
