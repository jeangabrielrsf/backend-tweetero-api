package com.tweetero.tweetero.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
    @NotBlank
    @Size(max = 100, message = "Tamanho máximo de username é de 100 caracteres!")
    private String username;

    @NotBlank
    private String avatar;
}
