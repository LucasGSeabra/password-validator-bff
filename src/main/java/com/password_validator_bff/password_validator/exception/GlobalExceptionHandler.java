package com.password_validator_bff.password_validator.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Manipulador global de exceções para a aplicação.
 *
 * <p>Esta classe centraliza o tratamento de exceções que podem ocorrer
 * durante o processamento de requisições HTTP, fornecendo respostas
 * padronizadas e adequadas para diferentes tipos de erros.</p>
 *
 * <p>Tipos de exceções tratadas:</p>
 * <ul>
 *   <li>MethodArgumentNotValidException - Erros de validação de dados de entrada</li>
 * </ul>
 *
 * <p>O uso desta classe garante que os clientes recebam respostas consistentes
 * e informativas mesmo quando ocorrem erros durante o processamento.</p>
 *
 * @author Sistema de Validação de Senhas
 * @version 1.0
 * @since 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Trata exceções de validação de argumentos de métodos.
     *
     * <p>Este método é invocado automaticamente quando ocorrem erros de
     * validação em dados enviados nas requisições HTTP (como campos
     * obrigatórios não preenchidos ou dados em formato inválido).</p>
     *
     * <p>A resposta retornada contém um mapeamento dos campos que falharam
     * na validação junto com suas respectivas mensagens de erro.</p>
     *
     * <p><strong>Exemplo de resposta:</strong></p>
     * <pre>
     * HTTP 400 Bad Request
     * {
     *   "password": "É obrigatório informar uma senha"
     * }
     * </pre>
     *
     * @param exception exceção de validação capturada automaticamente pelo Spring
     * @return {@link ResponseEntity} com status 400 (Bad Request) e mapa de erros
     *         onde a chave é o nome do campo e o valor é a mensagem de erro
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException exception){
        Map<String, String> errors = new HashMap<>();

        // Extrai todos os erros de campo da exceção
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        return ResponseEntity.badRequest().body(errors);
    }
}
