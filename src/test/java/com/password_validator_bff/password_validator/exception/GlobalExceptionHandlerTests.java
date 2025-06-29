package com.password_validator_bff.password_validator.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class GlobalExceptionHandlerTest {

    @Test
    void handleValidation_shouldReturnBadRequestWithFieldErrors() {
        BindingResult bindingResult = mock(BindingResult.class);

        FieldError fieldError1 = new FieldError("objectName", "field1", "Erro 1");
        FieldError fieldError2 = new FieldError("objectName", "field2", "Erro 2");

        when(bindingResult.getFieldErrors()).thenReturn(List.of(fieldError1, fieldError2));

        MethodArgumentNotValidException exception = mock(MethodArgumentNotValidException.class);
        when(exception.getBindingResult()).thenReturn(bindingResult);

        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        ResponseEntity<Map<String, String>> response = handler.handleValidation(exception);

        assertThat(response.getStatusCodeValue()).isEqualTo(400);

        Map<String, String> errors = response.getBody();
        assertThat(errors)
                .containsEntry("field1", "Erro 1")
                .containsEntry("field2", "Erro 2");

        assertThat(errors).isNotNull();
    }
}