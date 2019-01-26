package com.javathon.projectTeam45.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Map;
import java.util.stream.Collectors;
/**
    Класс для Получения ошибок с @Valid параметра
 */
class ControllerUtils {
    static Map<String, String> getErrors(BindingResult bindingResult) {
        return bindingResult.getFieldErrors().stream().collect(Collectors.toMap(
                fieldError -> fieldError.getField() + "Error",
                FieldError::getDefaultMessage
        ));
    }
}
