package com.password_validator_bff.password_validator.service;

import com.password_validator_bff.password_validator.dto.PasswordResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PasswordValidatorService {
    final Set<Character> SpecialCharacters = Set.of('!', '@', '#', '$', '%', '^', '&', '*', '(',')', '-', '+');

    public PasswordResponse validate(String password) {
        List<String> messages;
        boolean isValid = false;

        messages = CheckForValidPasswordAndReturnErrors(password);
        if(messages.isEmpty()) isValid = true;

        return new PasswordResponse(isValid, messages);
    }

    private List<String> CheckForValidPasswordAndReturnErrors(String password){

        List<String> errors = new ArrayList<>();

        if(password.length() < 9) errors.add("A senha deve conter pelo menos 9 caracteres.");
        if(!password.matches(".*\\d.*")) errors.add("A senha deve conter ao menos um dígito.");
        if(!password.matches(".*[a-z].*")) errors.add("A senha deve conter ao menos uma letra minúscula.");
        if(!password.matches(".*[A-Z].*")) errors.add("A senha deve conter ao menos uma letra maiúscula.");
        if(!password.matches(".*[A-Z].*")) errors.add("A senha deve conter ao menos uma letra maiúscula.");
        if(password.contains(" ")) errors.add("A senha não deve conter espaços em branco.");
        if(!CheckForSpecialCharacters(password)) errors.add("A senha deve conter ao menos um caractere especial (" + GetSpecialCharactersToString() + ").");
        if(CheckForDuplicateCharacters(password)) errors.add("A senha não deve conter caracteres repetidos.");

        return errors;
    }

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

    private boolean CheckForDuplicateCharacters(String password) {
        Set<Character> passwordUniqueCharacters = new HashSet<>();
        boolean hasDuplicates = true;

        for(char character : password.toCharArray()) passwordUniqueCharacters.add(character);
        if(passwordUniqueCharacters.size() == password.length()) hasDuplicates = false;

        return hasDuplicates;
    }

    private String GetSpecialCharactersToString() {
        return SpecialCharacters.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }


}
