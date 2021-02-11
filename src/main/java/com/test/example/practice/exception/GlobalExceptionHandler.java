package com.test.example.practice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;


@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ModelAndView nullEntityReferenceExceptionHandler(HttpServletRequest request, EntityNotFoundException exception) {
        return getModelAndView(request, HttpStatus.NOT_FOUND,
                exception, exception.getLocalizedMessage());
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView internalServerErrorHandler(HttpServletRequest request, Exception exception) {
        return getModelAndView(request, HttpStatus.INTERNAL_SERVER_ERROR, exception,
                "Error happened while processing your request. We resolve it soonest time. In urgency case, please call 123");
    }

    private ModelAndView getModelAndView(HttpServletRequest request, HttpStatus httpStatus, Exception e, String hint) {
        logger.error("Exception raised = {} :: URL = {}", e.getStackTrace()[0].toString(), request.getRequestURL());
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("code", httpStatus.value() + " / " + httpStatus.getReasonPhrase());
        modelAndView.addObject("message", hint);
        modelAndView.addObject("msg", e.getStackTrace()[0].toString() + "\r" + e.getLocalizedMessage());
        modelAndView.addObject("hint", hint);
        modelAndView.addObject("timestamp", LocalDateTime.now());
        return modelAndView;
    }
}
