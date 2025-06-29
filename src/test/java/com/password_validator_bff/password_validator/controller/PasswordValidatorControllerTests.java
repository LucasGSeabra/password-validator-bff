package com.password_validator_bff.password_validator.controller;

import com.password_validator_bff.password_validator.dto.PasswordRequest;
import com.password_validator_bff.password_validator.dto.PasswordResponse;
import com.password_validator_bff.password_validator.service.PasswordValidatorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class PasswordValidatorControllerTest {

    @Test
    void validatePassword_shouldReturnPasswordResponse() {
        PasswordValidatorService serviceMock = mock(PasswordValidatorService.class);

        String senha = "Senha123!";
        PasswordRequest request = new PasswordRequest(senha);
        PasswordResponse responseMock = new PasswordResponse(true, java.util.Collections.emptyList());

        Mockito.when(serviceMock.validate(senha)).thenReturn(responseMock);

        PasswordValidatorController controller = new PasswordValidatorController(serviceMock);

        ResponseEntity<PasswordResponse> responseEntity = controller.validatePassword(request);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

        assertThat(responseEntity.getBody()).isNotNull();
        assertThat(responseEntity.getBody().isValid()).isTrue();
        assertThat(responseEntity.getBody().messages()).isEmpty();

        Mockito.verify(serviceMock, Mockito.times(1)).validate(senha);
    }
}