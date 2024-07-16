package com.alura.ForoHub.domain.respuesta;

import jakarta.validation.constraints.NotNull;

public record DatosRespuesta(
        @NotNull
        String mensaje,
        @NotNull
        String autor
) {
    public DatosRespuesta(Respuesta respuesta) {
        this(respuesta.getMensaje(), respuesta.getAutor());
    }
}