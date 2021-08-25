package br.com.boticario.cashback.config.error;

import lombok.Data;

@Data
public class FormErrorDto {

    private String field;
    private String error;

    public FormErrorDto(String field, String error) {
        this.field = field;
        this.error = error;
    }
}
