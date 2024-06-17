package org.zerock.springbackendproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class BoardNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(BoardNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> boardHandler(BoardNotFoundException exception) {
        Map<String, String> errorMsg = new HashMap<>();
        errorMsg.put("errorMessage", exception.getMessage());
        return errorMsg;
    }

}
