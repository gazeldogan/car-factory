package tr.com.vodafone.carfactory.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse unknownException(Exception ex) {
        return getApiErrorResponse(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse handleConflict(RuntimeException ex) {
        return getApiErrorResponse(ex, HttpStatus.BAD_REQUEST);
    }

    public ApiErrorResponse getApiErrorResponse(Exception ex, HttpStatus status) {
        logger.warn(ex.getMessage(), ex);
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(status.value(), ex.getMessage());
        return apiErrorResponse;
    }


}