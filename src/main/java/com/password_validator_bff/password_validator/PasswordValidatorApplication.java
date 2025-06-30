package com.password_validator_bff.password_validator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Aplicação principal do Password Validator BFF.
 *
 * <p>Esta aplicação serve como Backend for Frontend (BFF) para validação de senhas,
 * implementando um microsserviço que valida senhas de acordo com critérios específicos
 * de segurança e integra com autenticação OAuth2.</p>
 *
 * <p>Funcionalidades principais:</p>
 * <ul>
 *   <li>Validação de senhas com múltiplos critérios de segurança</li>
 *   <li>Integração com OAuth2 usando client credentials</li>
 *   <li>API REST para comunicação com frontend</li>
 *   <li>Autenticação via JWT tokens</li>
 * </ul>
 *
 * @author Sistema de Validação de Senhas
 * @version 1.0
 * @since 1.0
 */
@SpringBootApplication
public class PasswordValidatorApplication {

	/**
	 * Método principal que inicia a aplicação Spring Boot.
	 *
	 * @param args argumentos da linha de comando
	 */
	public static void main(String[] args) {
		SpringApplication.run(PasswordValidatorApplication.class, args);
	}

}
