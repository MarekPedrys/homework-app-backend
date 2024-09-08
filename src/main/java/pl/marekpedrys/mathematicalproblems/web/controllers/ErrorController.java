package pl.marekpedrys.mathematicalproblems.web.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import pl.marekpedrys.mathematicalproblems.web.errors.ImageSavingError;
import pl.marekpedrys.mathematicalproblems.web.errors.ImageTypeError;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(ImageTypeError.class)
    public String handleImageTypeError() {
        return "errors/imageTypeError";
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleImageSizeError() {
        return "errors/imageSizeError";
    }

    @ExceptionHandler(ImageSavingError.class)
    public String handleImageSavingError() {
        return "errors/imageSavingError";
    }

    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "errors/error";
    }

}
