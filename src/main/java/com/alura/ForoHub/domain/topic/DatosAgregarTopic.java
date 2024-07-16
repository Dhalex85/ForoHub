package com.alura.ForoHub.domain.topic;

import jakarta.validation.constraints.NotNull;

public record DatosAgregarTopic(
        @NotNull
        String titulo,
        @NotNull
        String autor,
        @NotNull
        String mensaje,
        @NotNull
        Curso curso
) {
}
