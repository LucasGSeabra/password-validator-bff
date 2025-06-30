package com.password_validator_bff.password_validator.service;

import com.password_validator_bff.password_validator.dto.PasswordResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Serviço responsável pela validação de senhas de acordo com critérios de segurança específicos.
 *
 * <p>Esta classe implementa as regras de negócio para validação de senhas, verificando
 * múltiplos critérios de segurança conforme especificado nos requisitos do sistema.</p>
 *
 * <p>Critérios de validação implementados:</p>
 * <ul>
 *   <li>Mínimo de 9 caracteres</li>
 *   <li>Pelo menos 1 dígito numérico</li>
 *   <li>Pelo menos 1 letra minúscula</li>
 *   <li>Pelo menos 1 letra maiúscula</li>
 *   <li>Pelo menos 1 caractere especial (!@#$%^&*()-+)</li>
 *   <li>Não deve conter caracteres repetidos</li>
 *   <li>Não deve conter espaços em branco</li>
 * </ul>
 *
 * @author Sistema de Validação de Senhas
 * @version 1.0
 * @since 1.0
 */
@Service
public class PasswordValidatorService {

    /**
     * Conjunto de caracteres especiais permitidos na senha.
     *
     * <p>Caracteres aceitos: !@#$%^&*()-+</p>
     */
    final Set<Character> SpecialCharacters = Set.of('!', '@', '#', '$', '%', '^', '&', '*', '(',')', '-', '+');

    /**
     * Valida uma senha de acordo com os critérios de segurança estabelecidos.
     *
     * <p>Este método verifica se a senha atende a todos os critérios de segurança
     * e retorna uma resposta detalhada com o resultado da validação e eventuais
     * mensagens de erro.</p>
     *
     * @param password a senha a ser validada (não pode ser null)
     * @return {@link PasswordResponse} contendo o resultado da validação e lista de mensagens de erro
     * @throws IllegalArgumentException se a senha for null
     */
    public PasswordResponse validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("A senha não pode ser nula");
        }

        List<String> messages;
        boolean isValid = false;

        messages = CheckForValidPasswordAndReturnErrors(password);
        if(messages.isEmpty()) isValid = true;

        return new PasswordResponse(isValid, messages);
    }

    /**
     * Verifica todos os critérios de validação da senha e retorna lista de erros encontrados.
     *
     * <p>Este método interno executa todas as validações necessárias e coleta
     * as mensagens de erro correspondentes aos critérios não atendidos.</p>
     *
     * @param password a senha a ser validada
     * @return lista de mensagens de erro, vazia se a senha for válida
     */
    private List<String> CheckForValidPasswordAndReturnErrors(String password){

        List<String> errors = new ArrayList<>();

        if(password.length() < 9) errors.add("A senha deve conter pelo menos 9 caracteres.");
        if(!password.matches(".*\\d.*")) errors.add("A senha deve conter ao menos um dígito.");
        if(!password.matches(".*[a-z].*")) errors.add("A senha deve conter ao menos uma letra minúscula.");
        if(!password.matches(".*[A-Z].*")) errors.add("A senha deve conter ao menos uma letra maiúscula.");
        if(password.contains(" ")) errors.add("A senha não deve conter espaços em branco.");
        if(!CheckForSpecialCharacters(password)) errors.add("A senha deve conter ao menos um caractere especial (" + GetSpecialCharactersToString() + ").");
        if(CheckForDuplicateCharacters(password)) errors.add("A senha não deve conter caracteres repetidos.");

        return errors;
    }

    /**
     * Verifica se a senha contém pelo menos um caractere especial válido.
     *
     * <p>Percorre todos os caracteres da senha verificando se algum deles
     * está presente no conjunto de caracteres especiais permitidos.</p>
     *
     * @param password a senha a ser verificada
     * @return true se a senha contém pelo menos um caractere especial, false caso contrário
     */
    private boolean CheckForSpecialCharacters(String password) {

        boolean hasSpecialCharacter = false;

        for(char character : password.toCharArray()) {
            if(SpecialCharacters.contains(character)) {
                hasSpecialCharacter = true;
                break;
            }
        }

        return hasSpecialCharacter;
    }

    /**
     * Verifica se a senha possui caracteres duplicados.
     *
     * <p>Utiliza um Set para armazenar caracteres únicos e compara o tamanho
     * do Set com o comprimento da senha original para detectar duplicatas.</p>
     *
     * @param password a senha a ser verificada
     * @return true se a senha contém caracteres duplicados, false caso contrário
     */
    private boolean CheckForDuplicateCharacters(String password) {
        Set<Character> passwordUniqueCharacters = new HashSet<>();
        boolean hasDuplicates = true;

        for(char character : password.toCharArray()) passwordUniqueCharacters.add(character);
        if(passwordUniqueCharacters.size() == password.length()) hasDuplicates = false;

        return hasDuplicates;
    }

    /**
     * Converte o conjunto de caracteres especiais para uma string formatada.
     *
     * <p>Utilizado para incluir a lista de caracteres especiais válidos
     * nas mensagens de erro retornadas ao usuário.</p>
     *
     * @return string contendo todos os caracteres especiais concatenados
     */
    private String GetSpecialCharactersToString() {
        return SpecialCharacters.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }


}
