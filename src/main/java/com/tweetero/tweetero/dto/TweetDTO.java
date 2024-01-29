package com.tweetero.tweetero.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TweetDTO {
    @NotNull
    private Long userId;

    @NotBlank
    @Size(max = 280, message = "Tamanho máximo de 280 caracteres foi excedido!")
    private String text;
}
