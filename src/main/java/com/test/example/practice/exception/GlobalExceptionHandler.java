package com.test.example.practice.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class GlobalExceptionHandler {
//
//    Logger logger = LoggerFactory.getLogger(com.softserve.itacademy.exception.GlobalExceptionHandler.class);
//
//    @ExceptionHandler(NullEntityReferenceException.class)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    public ModelAndView nullEntityReferenceExceptionHandler(HttpServletRequest request, NullEntityReferenceException exception) {
//        return getModelAndView(request, HttpStatus.BAD_REQUEST, exception);
//    }
//
//    @ExceptionHandler(EntityNotFoundException.class)
//    @ResponseStatus(value= HttpStatus.NOT_FOUND)
//    public ModelAndView entityNotFoundExceptionHandler(HttpServletRequest request, EntityNotFoundException exception) {
//        return getModelAndView(request, HttpStatus.NOT_FOUND, exception);
//    }
//
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
//    public ModelAndView internalServerErrorHandler(HttpServletRequest request, Exception exception) {
//        return getModelAndView(request, HttpStatus.INTERNAL_SERVER_ERROR, exception);
//    }
//
//    private ModelAndView getModelAndView(HttpServletRequest request, HttpStatus httpStatus, Exception exception) {
//        logger.error("Exception raised = {} :: URL = {}", exception.getMessage(), request.getRequestURL());
//        ModelAndView modelAndView = new ModelAndView("error");
//        modelAndView.addObject("code", httpStatus.value() + " / " + httpStatus.getReasonPhrase());
//        modelAndView.addObject("message", exception.getMessage());
//        return modelAndView;
//    }
}
